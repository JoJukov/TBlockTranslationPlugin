package configuration.gui;

import javax.swing.*;

public class TBlockConfigurationComponent {

    private JCheckBox camelCaseCheckBox;
    private JCheckBox snakeCaseCheckBox;
    private JCheckBox kebabCaseCheckBox;
    private JPanel TBlockForm;
    private JComboBox<String> langComboBox;
    private JLabel CasesLabel;
    private JLabel langLabel;

    public JPanel getPanel() {
        return TBlockForm;
    }

    public JCheckBox getCamelCaseCheckBox() {
        return camelCaseCheckBox;
    }

    public JCheckBox getSnakeCaseCheckBox() {
        return snakeCaseCheckBox;
    }

    public JCheckBox getKebabCaseCheckBox() {
        return kebabCaseCheckBox;
    }

    public JComboBox<String> getLangComboBox() {
        return langComboBox;
    }
}
