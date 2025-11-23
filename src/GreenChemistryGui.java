import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.File;
import java.net.URL;
import java.util.List;
import java.util.Set;
import java.util.ArrayList;

public class GreenChemistryGui extends JFrame {

    private JTextField searchField;
    private JLabel imageLabel;
    private JComboBox<String> suggestionDropdown;
    private JTextArea resultArea;
    private ReactionDatabase database;
    private Set<String> categories;

    public GreenChemistryGui() {
        /**
         * Gui Window
         */
        setTitle("Green Chemistry Reaction Advisor");
        setSize(1280, 720);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout(10, 10));

        database = new ReactionDatabase();
        categories = ReactionDatabase.getCategories();

        /**
         * Title
         */
        JLabel titleLabel = new JLabel("Green Chemistry Reaction Advisor", SwingConstants.CENTER);
        titleLabel.setFont(new Font("SansSerif", Font.BOLD, 22));
        titleLabel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        add(titleLabel, BorderLayout.NORTH);

        /**
         * Input Panel
         */
        JPanel inputPanel = new JPanel();
        inputPanel.setLayout(new BoxLayout(inputPanel, BoxLayout.Y_AXIS));
        inputPanel.setBorder(BorderFactory.createEmptyBorder(10, 20, 10, 20));

        /**
         * Images
         */
        imageLabel = new JLabel();
        imageLabel.setHorizontalAlignment(SwingConstants.CENTER);
        imageLabel.setBorder(BorderFactory.createTitledBorder("Mechanism Image (MasterOrganicChemistry.com)"));
        add(imageLabel, BorderLayout.SOUTH);

        /**
         * Search Panel
         */
        JPanel searchPanel = new JPanel(new FlowLayout(FlowLayout.LEFT, 10, 5));
        JLabel searchLabel = new JLabel("Enter reaction keyword:");
        searchField = new JTextField(20);
        suggestionDropdown = new JComboBox<>();
        suggestionDropdown.setPreferredSize(new Dimension(250, 25));

        searchPanel.add(searchLabel);
        searchPanel.add(searchField);
        searchPanel.add(suggestionDropdown);

        /**
         * Buttons
         */
        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.LEFT, 10, 5));
        JButton searchButton = new JButton("Search / Suggest Alternatives");
        JButton learnMoreButton = new JButton("Learn More");
        buttonPanel.add(searchButton);
        buttonPanel.add(learnMoreButton);
        inputPanel.add(searchPanel);
        inputPanel.add(buttonPanel);
        add(inputPanel, BorderLayout.NORTH);

        /**
         * Results line
         */
        resultArea = new JTextArea(12, 60);
        resultArea.setEditable(false);
        resultArea.setLineWrap(true);
        resultArea.setWrapStyleWord(true);
        resultArea.setFont(new Font("Monospaced", Font.PLAIN, 14));
        JScrollPane scrollPane = new JScrollPane(resultArea);
        scrollPane.setBorder(BorderFactory.createTitledBorder("Reaction Details"));
        add(scrollPane, BorderLayout.CENTER);

        searchField.addKeyListener(new KeyAdapter() {
            @Override
            public void keyReleased(KeyEvent e) {
                updateSuggestions(searchField.getText().trim());
            }
        });

        searchButton.addActionListener(e -> handleSuggestion());
        learnMoreButton.addActionListener(e -> showGreenChemistryInfo());
    }

    private void updateSuggestions(String text) {
        suggestionDropdown.removeAllItems();
        if (text.isEmpty()) return;

        text = text.toLowerCase();
        List<String> matches = new ArrayList<>();

        for (String category : categories) {
            List<String> reactions = ReactionDatabase.getReactionsInCategory(category);
            boolean categoryMatches = category.toLowerCase().contains(text);
            for (String r : reactions) {
                String rLower = r.toLowerCase();
                if (categoryMatches || rLower.contains(text)) {
                    matches.add(category + " → " + r);
                }
            }
        }

        matches = matches.stream().distinct()
                .sorted((a, b) -> Integer.compare(a.length(), b.length()))
                .toList();

        if (matches.isEmpty()) {
            suggestionDropdown.addItem("No matches found.");
        } else {
            for (String m : matches) suggestionDropdown.addItem(m);
            suggestionDropdown.setSelectedIndex(0);
        }
    }

    /**
     * "About Green Chemistry" Box
     */
    private void showGreenChemistryInfo() {
        JOptionPane.showMessageDialog(this,
                """
                🌱 Green Chemistry Principles 🌱
                
                1. Prevent waste.
                2. Use safer solvents and reagents.
                3. Design energy-efficient reactions.
                4. Use renewable feedstocks.
                5. Avoid persistent pollution.
                6. Maximize atom economy.
                7. Use catalysts, not stoichiometric reagents.
                8. Design for degradation.
                """,
                "About Green Chemistry",
                JOptionPane.INFORMATION_MESSAGE);
    }

    /**
     * Search handler
     */
    private void handleSuggestion() {
        String selected = (String) suggestionDropdown.getSelectedItem();
        if (selected == null || selected.equals("No matches found.")) {
            resultArea.setText("⚠️ Please select a valid reaction from the dropdown.");
            imageLabel.setIcon(null);
            imageLabel.setText("");
            return;
        }

        String[] parts = selected.split(" → ");
        if (parts.length != 2) {
            resultArea.setText("Invalid selection format.");
            return;
        }

        String category = parts[0];
        String reaction = parts[1];

        String suggestion = database.getSuggestion(category, reaction);
        resultArea.setText("Category: " + category + "\nReaction: " + reaction + "\n\n" + suggestion);

        String imgPath = database.getImagePath(category, reaction);
        displayImage(imgPath);
    }

    /** 
     * Image Loader Main
     */
    private void displayImage(String imagePath) {
        if (imagePath == null || imagePath.isEmpty()) {
            imageLabel.setText("No image available.");
            imageLabel.setIcon(null);
            return;
        }

        ImageIcon icon = null;

        URL imgURL = getClass().getResource(imagePath);
        if (imgURL != null) {
            icon = new ImageIcon(imgURL);
        } else {
            File f = new File(imagePath);
            if (f.exists()) icon = new ImageIcon(f.getAbsolutePath());
        }

        if (icon != null) {
            imageLabel.setText("");
            imageLabel.setIcon(icon);
        } else {
            imageLabel.setText("Image not found: " + imagePath);
            imageLabel.setIcon(null);
            System.err.println("DEBUG: Could not load image → " + imagePath);
        }
    }
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new GreenChemistryGui().setVisible(true));
    }
}
