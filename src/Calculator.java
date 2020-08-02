import org.jetbrains.annotations.NotNull;

public class Calculator {
    private Double firstValue, secondValue;
    private ButtonOption specialCommand = ButtonOption.Empty;

    public Double calculate() {
        if (firstValue == null || secondValue == null) {
            return null;
        }

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

    public void reset() {
        firstValue = null;
        secondValue = null;
        specialCommand = ButtonOption.Empty;
    }

    public void setValue(String value) {
        if (this.specialCommand.equals(ButtonOption.Empty)) {
            setFirstValue(value);
        } else {
            setSecondValue(value);
        }
    }

    private void setFirstValue(String value) {
        if (value.isEmpty()) {
            this.firstValue = null;
        } else {
            this.firstValue = Double.parseDouble(value);
        }
    }

    private void setSecondValue(String value) {
        if (value.isEmpty()) {
            this.secondValue = null;
        } else {
            this.secondValue = Double.parseDouble(value);
        }
    }

    public void setSpecialCommand(@NotNull ButtonOption command) {
        if (command.isTwoValueCalculationCommand()) {
            this.specialCommand = command;
        }
    }
}