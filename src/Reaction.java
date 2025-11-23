public class Reaction {
    private String original;
    private String alternative;
    private String rationale;

    public Reaction(String original, String alternative, String rationale) {
        this.original = original;
        this.alternative = alternative;
        this.rationale = rationale;
    }

    public String getOriginal() {
        return original;
    }

    public String getAlternative() {
        return alternative;
    }

    public String getRationale() {
        return rationale;
    }

    @Override
    public String toString() {
        return "Replace \"" + original + "\" with \"" + alternative + "\" — " + rationale;
    }
}
