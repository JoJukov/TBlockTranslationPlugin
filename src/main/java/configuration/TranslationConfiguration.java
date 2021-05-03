package configuration;

import com.intellij.ide.ui.UINumericRange;
import com.intellij.openapi.options.Configurable;
import com.intellij.openapi.options.ConfigurationException;
import com.intellij.openapi.ui.ComboBox;
import org.jetbrains.annotations.Nls;
import org.jetbrains.annotations.NonNls;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import javax.swing.*;

public class TranslationConfiguration implements Configurable {
    @Override
    @Nls(capitalization = Nls.Capitalization.Title)
    public String getDisplayName() {
        return "Translation Settings";
    }

    @Override
    public @Nullable
    @NonNls
    String getHelpTopic() {
        return Configurable.super.getHelpTopic();
    }

    @Override
    public boolean isModified(@NotNull JTextField textField, @NotNull String value) {
        return Configurable.super.isModified(textField, value);
    }

    @Override
    public boolean isModified(@NotNull JTextField textField, int value, @NotNull UINumericRange range) {
        return Configurable.super.isModified(textField, value, range);
    }

    @Override
    public boolean isModified(@NotNull JToggleButton toggleButton, boolean value) {
        return Configurable.super.isModified(toggleButton, value);
    }

    @Override
    public <T> boolean isModified(@NotNull ComboBox<T> comboBox, T value) {
        return Configurable.super.isModified(comboBox, value);
    }

    @Override
    public JComponent getPreferredFocusedComponent() {
        return Configurable.super.getPreferredFocusedComponent();
    }

    @Override
    public @Nullable JComponent createComponent() {
        return null;
    }

    @Override
    public boolean isModified() {
        return false;
    }

    @Override
    public void apply() throws ConfigurationException {

    }

    @Override
    public void reset() {
        Configurable.super.reset();
    }

    @Override
    public void disposeUIResources() {
        Configurable.super.disposeUIResources();
    }

    @Override
    public void cancel() {
        Configurable.super.cancel();
    }
}
