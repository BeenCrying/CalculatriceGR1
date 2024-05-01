import javax.swing.*;
import java.awt.event.KeyEvent;

public class Calculatrice {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Calculatrice");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500, 600);
        frame.setLocation(3200, 100);

        JMenuBar menuBar = new JMenuBar();
        frame.setJMenuBar(menuBar);

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

        frame.setVisible(true);
    }
}
