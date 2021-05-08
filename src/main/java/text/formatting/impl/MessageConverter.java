package text.formatting.impl;

import text.formatting.Converter;

public class MessageConverter implements Converter {
    private boolean isConvertFromSnakeCaseToNormalCase;
    private boolean isConvertFromCamelCaseToNormalCase;
    private boolean isConvertFromKebabCaseToNormalCase;

    public MessageConverter() {
        isConvertFromSnakeCaseToNormalCase = false;
        isConvertFromCamelCaseToNormalCase = false;
        isConvertFromKebabCaseToNormalCase = false;
    }

    @Override
    public String convert(String s) {
        s = isConvertFromCamelCaseToNormalCase ? fromCamelCaseToNormalCase(s) : s;
        s = isConvertFromKebabCaseToNormalCase ? fromKebabCaseToNormalCase(s) : s;
        s = isConvertFromSnakeCaseToNormalCase ? fromSnakeCaseToNormalCase(s) : s;
        return s;
    }

    public boolean isConvertFromSnakeCaseToNormalCase() {
        return isConvertFromSnakeCaseToNormalCase;
    }

    public void setConvertFromSnakeCaseToNormalCase(boolean convertFromSnakeCaseToNormalCase) {
        isConvertFromSnakeCaseToNormalCase = convertFromSnakeCaseToNormalCase;
    }

    public boolean isConvertFromCamelCaseToNormalCase() {
        return isConvertFromCamelCaseToNormalCase;
    }

    public void setConvertFromCamelCaseToNormalCase(boolean convertFromCamelCaseToNormalCase) {
        isConvertFromCamelCaseToNormalCase = convertFromCamelCaseToNormalCase;
    }

    public boolean isConvertFromKebabCaseToNormalCase() {
        return isConvertFromKebabCaseToNormalCase;
    }

    public void setConvertFromKebabCaseToNormalCase(boolean convertFromKebabCaseToNormalCase) {
        isConvertFromKebabCaseToNormalCase = convertFromKebabCaseToNormalCase;
    }

    private String fromSnakeCaseToNormalCase(String s) {
        return deleteExtraSpaces(s.replaceAll("([^ ])_+([^ ])", "$1 $2").replaceAll("([^ ])_+([^ ])", "$1 $2"));
    }

    private String fromKebabCaseToNormalCase(String s) {
        return deleteExtraSpaces(s.replaceAll("([^ ])-+([^ ])", "$1 $2").replaceAll("([^ ])-+([^ ])", "$1 $2"));
    }

    private String fromCamelCaseToNormalCase(String s) {
        return deleteExtraSpaces(s.replaceAll(
                String.format("%s|%s",
                        "(?<=[A-Z])(?=[A-Z][a-z])",
                        "(?<=[^A-Z])(?=[A-Z])"
                ),
                " "
        ));
    }

    private String deleteExtraSpaces(String s) {
        return s.replaceAll("[ ]+", " ");
    }


}