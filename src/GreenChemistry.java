/**
 * 
 * Main Method for Green Chemistry Tool
 * @author Daniel Strilets
 * @version 1.0.0
 */

public class GreenChemistry {
    public static void main(String[] args) {
        javax.swing.SwingUtilities.invokeLater(() -> {
            GreenChemistryGui advisorApp = new GreenChemistryGui();
            advisorApp.setVisible(true);
        });
    }
}
