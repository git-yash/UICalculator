import org.jetbrains.annotations.NotNull;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class ButtonBuilder {
    JTextField textField;
    Calculator calculator = new Calculator();

    public ButtonBuilder(JTextField textField) {
        this.textField = textField;
    }

    public ArrayList<JButton> createButtons() {
        ArrayList<JButton> buttons = new ArrayList<>();

        buttons.add(createCommandButton(ButtonOption.Clear));
        buttons.add(createCommandButton(ButtonOption.Square_Root));
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

        return buttons;
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

    private @NotNull JButton createButton(ButtonOption command, Color buttonColor) {
        JButton button = new JButton();

        button.setSize(61, 100);
        button.setText(command.getCommand());
        button.setFont(new Font("Arial Black", Font.BOLD, 14));
        button.setForeground(Color.white);
        button.setBackground(buttonColor);
        button.setBorderPainted(false);
        button.addActionListener(actionEvent -> {
            if (command.isSpecial()) {
                calculator.setSpecialCommand(command);
                if (command.equals(ButtonOption.Equal)) {
                    String answer = String.valueOf(calculator.calculate());
                    if(answer.endsWith(".0")){
                        answer = answer.substring(0, answer.length() - 2);
                    }
                    textField.setText(answer);
                } else {
                    textField.setText("");
                }
            } else if (command.isNumber()) {
                String newText = command.getText(textField.getText());
                textField.setText(newText);
                calculator.setValue(newText);
            }
        });

        button.addMouseListener(new java.awt.event.MouseAdapter() {
            Color currentBackgroundColor;
            Color currentForegroundColor;

            public void mouseEntered(java.awt.event.MouseEvent evt) {
                currentForegroundColor = button.getForeground();
                currentBackgroundColor = button.getBackground();
                if (button.getForeground() != Color.red) {
                    button.setBackground(Color.white);
                    button.setForeground(Color.black);
                }
            }

            public void mouseExited(java.awt.event.MouseEvent evt) {
                button.setForeground(currentForegroundColor);
                button.setBackground(currentBackgroundColor);
            }
        });

        return button;
    }
}
