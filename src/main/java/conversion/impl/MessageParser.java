package conversion.impl;

public class MessageParser {

    public String convert(String s) {
        return fromCamelCaseToNormalCase(
                fromKebabCaseToNormalCase(
                        fromSnakeCaseToNormalCase(s)));
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