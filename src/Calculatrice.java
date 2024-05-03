import javax.swing.*;
import java.awt.*;

public class Calculatrice {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Calculatrice");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500, 600);
        frame.setLocation(3200, 100);

        frame.setJMenuBar(creerMenu());

        JTextField resultField = new JTextField("0.0");
        frame.add(resultField, BorderLayout.NORTH);
        Font textFont = resultField.getFont();
        resultField.setFont(textFont.deriveFont(40.0f));

        JButton buttonBackspace = new JButton("Backspace");
        frame.add(buttonBackspace);

        frame.setVisible(true);
    }

    public static JMenuBar creerMenu() {
        JMenuBar menuBar = new JMenuBar();

        JMenu menuEdit = new JMenu("Edit");
        menuEdit.add(new JMenuItem("Copy"));
        menuEdit.add(new JMenuItem("Paste"));
        menuBar.add(menuEdit);

        JMenu menuView = new JMenu("View");
        ButtonGroup groupeMode = new ButtonGroup();

        JMenuItem itemStandard = new JRadioButtonMenuItem("Standard");
        itemStandard.setSelected(true);
        groupeMode.add(itemStandard);
        menuView.add(itemStandard);

        JMenuItem itemScientific = new JRadioButtonMenuItem("Scientific");
        groupeMode.add(itemScientific);
        menuView.add(itemScientific);

        menuView.addSeparator();
        JMenuItem itemDigits = new JCheckBoxMenuItem("Digit Grouping");
        menuView.add(itemDigits);
        menuBar.add(menuView);

        JMenu menuHelp = new JMenu("Help");
        menuHelp.add(new JMenuItem("Help Topics"));
        menuHelp.add(new JMenuItem("About Calculator"));
        menuBar.add(menuHelp);

        return menuBar;
    }
}
