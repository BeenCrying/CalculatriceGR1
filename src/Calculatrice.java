import javax.swing.*;
import java.awt.*;

public class Calculatrice {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Calculatrice");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(380, 600);
        frame.setLocationRelativeTo(null);
        frame.setJMenuBar(createMenu());

        JTextField textField = new JTextField("0.0", 0);
        textField.setPreferredSize(new Dimension(380, 50));
        textField.setFont(new Font("Arial", Font.PLAIN, 24));
        textField.setHorizontalAlignment(JTextField.RIGHT);

        JPanel buttonPanel = new JPanel(new BorderLayout());
        JPanel functionPanel = new JPanel(new GridLayout(1, 3));
        functionPanel.add(new JButton("Backspace"));
        functionPanel.add(new JButton("CE"));
        functionPanel.add(new JButton("C"));

        JPanel memoryPanel = new JPanel(new GridLayout(4, 1));
        memoryPanel.add(new JButton("MC"));
        memoryPanel.add(new JButton("MR"));
        memoryPanel.add(new JButton("MS"));
        memoryPanel.add(new JButton("M+"));

        buttonPanel.add(memoryPanel, BorderLayout.WEST);
        buttonPanel.add(functionPanel, BorderLayout.NORTH);
        buttonPanel.add(createNumberPanel(), BorderLayout.CENTER);

        frame.add(buttonPanel, BorderLayout.CENTER);
        frame.add(textField, BorderLayout.NORTH);
        frame.setVisible(true);
    }

    public static JMenuBar createMenu() {
        JMenuBar menuBar = new JMenuBar();
        menuBar.add(createMenu("Edit", "Copy", "Paste"));
        menuBar.add(createMenu("View", "Standard", "Scientific", "Digit Grouping"));
        menuBar.add(createMenu("Help", "Help Topics", "About Calculator"));
        return menuBar;
    }

    public static JMenu createMenu(String title, String... items) {
        JMenu menu = new JMenu(title);
        for (String item : items) {
            menu.add(new JMenuItem(item));
        }
        return menu;
    }

    public static JPanel createNumberPanel() {
        JPanel numberPanel = new JPanel(new GridLayout(4, 3));
        for (int i = 7; i >= 1; i -= 3) {
            for (int j = 0; j < 3; j++) {
                numberPanel.add(new JButton(String.valueOf(i + j)));
            }
        }
        numberPanel.add(new JButton("0"));
        return numberPanel;
    }
}