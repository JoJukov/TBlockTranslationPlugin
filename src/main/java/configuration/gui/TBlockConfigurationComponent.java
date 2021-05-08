package configuration.gui;

import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class TBlockConfigurationComponent {

    private JCheckBox camelCaseCheckBox;
    private JCheckBox snakeCaseCheckBox;
    private JCheckBox kebabCaseCheckBox;
    private JPanel TBlockForm;
    private JComboBox<String> langComboBox;
    private JLabel CasesLabel;
    private JLabel langLabel;

//    public static TBlockConfigurationComponent getInstance() {
//        if (instance == null) {
//            instance = new TBlockConfigurationComponent();
//        }
//        return instance;
//    }
//
//    private TBlockConfigurationComponent() {
//
//    }

    public JPanel getPanel() {
        return TBlockForm;
    }

    public JCheckBox getCamelCaseCheckBox() {
        return camelCaseCheckBox;
    }

//    public void setCamelCaseCheckBox(boolean b) {
//        this.camelCaseCheckBox.setSelected(b);
//    }

    public JCheckBox getSnakeCaseCheckBox() {
        return snakeCaseCheckBox;
    }

//    public void setSnakeCaseCheckBox(boolean b) {
//        this.snakeCaseCheckBox.setSelected(b);
//    }

    public JCheckBox getKebabCaseCheckBox() {
        return kebabCaseCheckBox;
    }

//    public void setKebabCaseCheckBox(boolean b) {
//        this.kebabCaseCheckBox.setSelected(b);
//    }

    public JComboBox<String> getLangComboBox() {
        return langComboBox;
    }

//    public void setLangComboBox(String lang) {
//        this.langComboBox.setSelectedItem(lang);
//    }
}
