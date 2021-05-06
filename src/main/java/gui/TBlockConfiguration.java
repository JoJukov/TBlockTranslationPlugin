package gui;

import javax.swing.*;

public class TBlockConfiguration {
    private JCheckBox camelCaseCheckBox;
    private JCheckBox snakeCaseCheckBox;
    private JCheckBox kebabCaseCheckBox;
    private JPanel TBlockForm;
    private JComboBox langComboBox;
    private JLabel CasesLabel;
    private JLabel langLabel;

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
