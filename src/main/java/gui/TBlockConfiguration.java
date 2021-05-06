package gui;

import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class TBlockConfiguration {
    private JPanel panel;
    private JCheckBox camelCaseCheckBox;
    private JCheckBox snakeCaseCheckBox;
    private JCheckBox kebabCaseCheckBox;
    private JPanel TBlockForm;
    private JComboBox langComboBox;
    private JLabel CasesLabel;


    public boolean isSnakeCase() {
        return snakeCaseCheckBox.isSelected();
    }

    public boolean isCamelCase() {
        return camelCaseCheckBox.isSelected();
    }

    public boolean isKebabCase() {
        return kebabCaseCheckBox.isSelected();
    }

    public String getDestinationLang() {
        return (String) langComboBox.getSelectedItem();
    }

    public JPanel getPanel() {
        return TBlockForm;
    }
}
