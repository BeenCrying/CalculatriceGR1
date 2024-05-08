import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

public class Calculatrice {
    public static void main(String[] args) {
        // Création de la fenêtre principale (la "racine graphique").
        JFrame frame = new JFrame("Calculatrice");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Indique à Swing d'arrêter le programme quand on ferme la fenêtre.
        frame.setSize(500, 400); // Impose la taille initiale de la fenêtre (elle peut quand même être redimensionnée).

        if (args.length == 2) {
            // Place la fenêtre à un endroit spécifique de l'écran (utile pour les démonstrations en classe).
            frame.setLocation(Integer.parseInt(args[0]), Integer.parseInt(args[1]));
        }

        frame.setJMenuBar(createMenuBar()); // Ajout de la barre de menu (directement sous la barre de titre).
        frame.add(createResultField(), BorderLayout.NORTH); // Ajout de la barre des résultats, en haut.
        frame.add(createMemoryPanel(), BorderLayout.WEST); // Ajout du panneau de mémoire, à gauche.
        frame.add(createMainPanel(), BorderLayout.CENTER); // Ajout du panneau principal, au centre.

        frame.setVisible(true); // Étape finale pour afficher la fenêtre graphique une fois qu'elle est prête.
    }

    private static JMenuBar createMenuBar() {
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

    private static JTextField createResultField() {
        JTextField resultField = new JTextField("0.0");
        resultField.setFont(resultField.getFont().deriveFont(40.0f));
        resultField.setHorizontalAlignment(JTextField.RIGHT);
        return resultField;
    }

    private static JPanel createMemoryPanel() {
        JPanel panel = new JPanel(new GridLayout(5, 1, 10, 10));
        panel.setBorder(new EmptyBorder(10, 10, 10, 10));

        JTextField memoryField = new JTextField();
        memoryField.setEditable(false);
        memoryField.setFont(memoryField.getFont().deriveFont(20.0f));
        memoryField.setHorizontalAlignment(JTextField.CENTER);
        panel.add(memoryField);

        panel.add(createButton("MC"));
        panel.add(createButton("MR"));
        panel.add(createButton("MS"));
        panel.add(createButton("M+"));

        return panel;
    }

    private static JPanel createMainPanel() {
        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));
        mainPanel.setBorder(new EmptyBorder(10, 10, 10, 10));

        JPanel editPanel = createEditPanel();
        editPanel.setMaximumSize(new Dimension(1000, 50));
        editPanel.setBorder(new EmptyBorder(0, 0, 20, 0));

        mainPanel.add(editPanel);
        mainPanel.add(createNumberPanel());
        return mainPanel;
    }

    private static JPanel createEditPanel() {
        JPanel panel = new JPanel(new GridLayout(1, 3, 10, 10));
        panel.add(createButton("Backspace"));
        panel.add(createButton("CE"));
        panel.add(createButton("C"));
        return panel;
    }

    private static JPanel createNumberPanel() {
        String[] labels = {
                "7", "8", "9", "/", "sqrt",
                "4", "5", "6", "*", "%",
                "1", "2", "3", "-", "1/x",
                "0", "+/-", ".", "+", "="
        };

        JPanel panel = new JPanel(new GridLayout(4, 5, 10, 10));
        for (String label : labels)
            panel.add(createButton(label));
        return panel;
    }

    private static JPanel createPanel(LayoutManager layout) {
        JPanel panel = new JPanel(layout);
        panel.setBorder(new EmptyBorder(10, 10, 10, 10));
        return panel;
    }

    private static JButton createButton(String text) {
        JButton button = new JButton(text);
        button.setForeground(Color.BLUE);
        return button;
    }
}
