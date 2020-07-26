import org.jetbrains.annotations.NotNull;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class ButtonBuilder {
    JTextField textField;
    public ButtonBuilder(JTextField textField) {
        this.textField = textField;
    }

    public ArrayList<JButton> createButtons() {
        ArrayList<JButton> buttons = new ArrayList<>();

        buttons.add(createCommandButton("CE"));
        buttons.add(createCommandButton("√"));
        buttons.add(createCommandButton("del"));
        buttons.add(createCommandButton("/"));

        buttons.add(createButton("1"));
        buttons.add(createButton("2"));
        buttons.add(createButton("3"));
        buttons.add(createCommandButton("x"));

        buttons.add(createButton("4"));
        buttons.add(createButton("5"));
        buttons.add(createButton("6"));
        buttons.add(createCommandButton("+"));

        buttons.add(createButton("7"));
        buttons.add(createButton("8"));
        buttons.add(createButton("9"));
        buttons.add(createCommandButton("-"));

        buttons.add(createButton("+/-"));
        buttons.add(createButton("0"));
        buttons.add(createButton("."));
        buttons.add(createEqualButton());

        return buttons;
    }

    private @NotNull JButton createEqualButton() {
        return this.createButton("=", Color.red);
    }

    private @NotNull JButton createCommandButton(String text) {
        return this.createButton(text, Color.darkGray);
    }

    private @NotNull JButton createButton(String text) {
        return this.createButton(text, Color.black);
    }

    private @NotNull JButton createButton(String text, Color buttonColor) {
        JButton button = new JButton();

        button.setSize(61, 100);
        button.setText(text);
        button.setFont(new Font("Arial Black", Font.BOLD, 14));
        button.setForeground(Color.white);
        button.setBackground(buttonColor);
        button.setBorderPainted(false);
        button.addActionListener(actionEvent -> {
            textField.setText(textField.getText() + button.getText());
        });

        button.addMouseListener(new java.awt.event.MouseAdapter() {
            Color currentBackgroundColor;
            Color currentForegroundColor;

            public void mouseEntered(java.awt.event.MouseEvent evt) {
                currentForegroundColor = button.getForeground();
                currentBackgroundColor = button.getBackground();
                button.setBackground(Color.white);
                button.setForeground(Color.black);
            }

            public void mouseExited(java.awt.event.MouseEvent evt) {
                button.setForeground(currentForegroundColor);
                button.setBackground(currentBackgroundColor);
            }
        });

        return button;
    }
}
