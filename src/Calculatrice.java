import javax.swing.*;
import java.awt.*;

public class Calculatrice {
    public static void main(String[] args) {
        // Création de la fenêtre principale (la "racine graphique").
        JFrame frame = new JFrame("Calculatrice");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Indique à Swing d'arrêter le programme quand on ferme la fenêtre.
        frame.setSize(500, 600); // Impose la taille initiale de la fenêtre (elle peut quand même être redimensionnée).

        if (args.length == 2) {
            // Place la fenêtre à un endroit spécifique de l'écran (utile pour les démonstrations en classe).
            frame.setLocation(Integer.parseInt(args[0]), Integer.parseInt(args[1]));
        }

        frame.setJMenuBar(createMenuBar()); // Ajout de la barre de menu
        frame.add(createResultField(), BorderLayout.NORTH); // Ajout de la barre des résultats

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
}
