import javax.swing.*;
import java.awt.*;

public class UIBuilder {
    JTextField textField = new JTextField();

    public void createFrame() {
        ButtonBuilder buttonBuilder = new ButtonBuilder(textField);
        JFrame frame = new JFrame("Calculator");
        JPanel panel = new JPanel();

        buttonBuilder.createButtons().forEach(panel::add);

        textField.setFont(new Font("Arial Black", Font.BOLD, 20));
        textField.setHorizontalAlignment(JTextField.RIGHT);
        textField.setBounds(10, 10, 245, 50);
        textField.setEditable(false);

        panel.setLayout(new GridLayout(5, 4, 5, 5));
        panel.setBounds(10, 75, 245, 310);
        panel.setBackground(Color.gray);

        frame.setVisible(true);
        frame.setLayout(null);
        frame.setResizable(false);
        frame.setSize(280, 435);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(textField);
        frame.add(panel);
        frame.getContentPane().setBackground(Color.gray);
    }
}
