package com.zhuvar.tblock.configuration.state;

import com.intellij.openapi.components.PersistentStateComponent;
import com.intellij.openapi.components.ServiceManager;
import com.intellij.openapi.components.State;
import com.intellij.openapi.components.Storage;
import com.intellij.util.xmlb.XmlSerializerUtil;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@State(name = "com.zhuvar.tblock.configuration.state",
        storages = {@Storage("TBlockSettingPlugin.xml")})
public class TBlockSettingsState implements PersistentStateComponent<TBlockSettingsState> {

    private boolean isCamelCase = true;
    private boolean isKebabCase = false;
    private boolean isSnakeCase = false;
    private String destLang = "Ru";


    public static TBlockSettingsState getInstance() {
        return ServiceManager.getService(TBlockSettingsState.class);
    }

    @Override
    public @Nullable TBlockSettingsState getState() {
        return this;
    }

    @Override
    public void loadState(@NotNull TBlockSettingsState state) {
        XmlSerializerUtil.copyBean(state, this);
    }

    public boolean isCamelCase() {
        return isCamelCase;
    }

    public void setCamelCase(boolean camelCase) {
        isCamelCase = camelCase;
    }

    public boolean isKebabCase() {
        return isKebabCase;
    }

    public void setKebabCase(boolean kebabCase) {
        isKebabCase = kebabCase;
    }

    public boolean isSnakeCase() {
        return isSnakeCase;
    }

    public void setSnakeCase(boolean snakeCase) {
        isSnakeCase = snakeCase;
    }

    public String getDestLang() {
        return destLang;
    }

    public void setDestLang(String destLang) {
        this.destLang = destLang;
    }
}
