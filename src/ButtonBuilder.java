import org.jetbrains.annotations.NotNull;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class ButtonBuilder {
    JTextField textField;
    Calculator calculator = new Calculator();
    ArrayList<JButton> buttons = new ArrayList<>();

    public ButtonBuilder(JTextField textField) {
        this.textField = textField;
        setButtons();
    }

    public ArrayList<JButton> getButtons() {
        return this.buttons;
    }

    private void setButtons() {
        buttons.add(createCommandButton(ButtonOption.ClearAll));
        buttons.add(createCommandButton(ButtonOption.Clear));
        buttons.add(createCommandButton(ButtonOption.Delete));
        buttons.add(createCommandButton(ButtonOption.Division));

        buttons.add(createButton(ButtonOption.One));
        buttons.add(createButton(ButtonOption.Two));
        buttons.add(createButton(ButtonOption.Three));
        buttons.add(createCommandButton(ButtonOption.Multiply));

        buttons.add(createButton(ButtonOption.Four));
        buttons.add(createButton(ButtonOption.Five));
        buttons.add(createButton(ButtonOption.Six));
        buttons.add(createCommandButton(ButtonOption.Plus));

        buttons.add(createButton(ButtonOption.Seven));
        buttons.add(createButton(ButtonOption.Eight));
        buttons.add(createButton(ButtonOption.Nine));
        buttons.add(createCommandButton(ButtonOption.Minus));

        buttons.add(createButton(ButtonOption.Positive_Negative));
        buttons.add(createButton(ButtonOption.Zero));
        buttons.add(createButton(ButtonOption.Decimal));
        buttons.add(createEqualButton());
    }

    private @NotNull JButton createEqualButton() {
        return this.createButton(ButtonOption.Equal, Color.red);
    }

    private @NotNull JButton createCommandButton(ButtonOption command) {
        return this.createButton(command, Color.darkGray);
    }

    private @NotNull JButton createButton(ButtonOption command) {
        return this.createButton(command, Color.black);
    }

    private void resetButtonHighlight() {
        this.getButtons().forEach(button -> button.setForeground(Color.white));
    }

    private void setButtonHighlight(@NotNull JButton button) {
        resetButtonHighlight();
        button.setForeground(Color.red);
    }

    private String getTextInputText() {
        String text = textField.getText();
        return text.isEmpty() ? "0" : text;
    }

    private @NotNull Double getTextInputValue() {
        String text = getTextInputText();
        return Double.parseDouble(text);
    }

    private void setTextField(@NotNull String value) {
        if (!value.isEmpty()) {
            value = String.valueOf(Double.parseDouble(value) * 1);
        }

        if (value.endsWith(".0")) {
            value = value.substring(0, value.length() - 2);
        }
        textField.setText(value);
        calculator.setValue(value);
    }

    private void equalOperation() {
        String answer = String.valueOf(calculator.calculate());
        getTextInputValue();
        setTextField(answer);
        resetButtonHighlight();
    }

    private void clearAllOperation() {
        calculator.reset();
        setTextField("");
        resetButtonHighlight();
    }

    private void clearOperation() {
        calculator.setValue("");
        setTextField("");
    }

    private void numberOperation(ButtonOption command) {
        String newText;
        if (command == ButtonOption.Positive_Negative) {
            newText = String.valueOf(getTextInputValue() * -1);
        } else {
            newText = command.getText(getTextInputText());
        }
        setTextField(newText);
    }

    private void onButtonPress(@NotNull ButtonOption command, JButton button) {
        if (command.isSpecial()) {
            calculator.setSpecialCommand(command);
            if (command.equals(ButtonOption.Equal)) {
                equalOperation();
            } else if (command.equals(ButtonOption.Delete)) {
                String currentText = getTextInputText();
                currentText = currentText.substring(0, currentText.length() - 1);
                setTextField(currentText);
            } else if (command.equals(ButtonOption.ClearAll)) {
                clearAllOperation();
            } else if (command.equals(ButtonOption.Clear)) {
                clearOperation();
            } else {
                setTextField("");
                setButtonHighlight(button);
            }
        } else if (command.isNumber()) {
            numberOperation(command);
        }
    }

    private @NotNull JButton createButton(@NotNull ButtonOption command, Color buttonColor) {
        JButton button = new JButton();

        button.setSize(61, 100);
        button.setText(command.getCommand());
        button.setFont(new Font("Arial Black", Font.BOLD, 14));
        button.setForeground(Color.white);
        button.setBackground(buttonColor);
        button.setBorderPainted(false);
        button.addActionListener(actionEvent -> onButtonPress(command, button));

//        button.addMouseListener(new java.awt.event.MouseAdapter() {
//            Color currentBackgroundColor;
//            Color currentForegroundColor;
//
//            public void mouseEntered(java.awt.event.MouseEvent evt) {
//                currentForegroundColor = button.getForeground();
//                currentBackgroundColor = button.getBackground();
//                if (button.getForeground() != Color.red) {
//                    button.setBackground(Color.white);
//                    button.setForeground(Color.black);
//                }
//            }
//
//            public void mouseExited(java.awt.event.MouseEvent evt) {
//                button.setForeground(currentForegroundColor);
//                button.setBackground(currentBackgroundColor);
//            }
//        });

        return button;
    }
}
