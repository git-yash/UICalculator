import javax.swing.*;
import java.awt.*;

public class UIBuilder {

    public JFrame createFrame() {
        ButtonList buttons = new ButtonList();
        JFrame frame = new JFrame("Calculator");
        JPanel panel = new JPanel();
        JTextField textField = new JTextField();

        for (int i = 0; i < buttons.createButtons().size(); i++) {
            panel.add(buttons.createButtons().get(i));
        }

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

        return frame;
    }

}
