public enum ButtonOption {
    One("1"),
    Two("2"),
    Three("3"),
    Four("4"),
    Five("5"),
    Six("6"),
    Seven("7"),
    Eight("8"),
    Nine("9"),
    Zero("0"),
    Decimal("."),
    Positive_Negative("+/-"),
    Division("/"),
    Multiply("x"),
    Plus("+"),
    Minus("-"),
    Clear("C"),
    ClearAll("CE"),
    Delete("del"),
    Equal("="),
    Empty("");

    private final String command;

    ButtonOption(String command) {
        this.command = command;
    }

    public String getCommand() {
        return this.command;
    }

    public boolean isTwoValueCalculationCommand() {
        switch (this) {
            case Division:
            case Multiply:
            case Plus:
            case Minus:
                return true;
            default:
                return false;
        }
    }

    public boolean isNumber() {
        switch (this) {
            case One:
            case Two:
            case Three:
            case Four:
            case Five:
            case Six:
            case Seven:
            case Eight:
            case Nine:
            case Zero:
            case Decimal:
            case Positive_Negative:
                return true;
            default:
                return false;
        }
    }

    public String getText(String currentText) {
        return currentText + command;
    }
}
