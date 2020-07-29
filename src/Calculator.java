public class Calculator {
    private Double firstValue, secondValue;
    private ButtonOption specialCommand = ButtonOption.Empty;

    public Double calculate() {
        switch (specialCommand) {
            case Plus:
                return firstValue + secondValue;
            case Minus:
                return firstValue - secondValue;
            case Multiply:
                return firstValue * secondValue;
            case Division:
                return firstValue / secondValue;
            default:
                return null;
        }
    }

    public void setValue(String value) {
        if (this.specialCommand.equals(ButtonOption.Empty)) {
            setFirstValue(value);
        } else {
            setSecondValue(value);
        }
    }

    private void setFirstValue(String value) {
        this.firstValue = Double.parseDouble(value);
    }

    private void setSecondValue(String value) {
        this.secondValue = Double.parseDouble(value);
    }

    public void setSpecialCommand(ButtonOption command) {
        if(!command.equals(ButtonOption.Equal)) {
            this.specialCommand = command;
        }
    }
}
