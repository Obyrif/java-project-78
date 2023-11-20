package hexlet.code.schemas;

public class StringSchema extends BaseSchema {
    private int minLengthMethod;
    private String containsMethod = "";

    public StringSchema required() {
        isRequired = true;
        return this;
    }

    public StringSchema minLength(int minLength) {
        minLengthMethod = minLength;
        return this;
    }

    public StringSchema contains(String s) {
        containsMethod = s;
        return this;
    }

    public boolean isValid(Object data) {

        if (data == null) {
            return !isRequired;
        }

        if (data instanceof String) {
            String strData = (String) data;

            if (isRequired && (strData == null || strData.isEmpty())) {
                return false;
            }

            if (minLengthMethod > 0 && (strData == null || strData.length() < minLengthMethod)) {
                return false;
            }

            if (!containsMethod.isEmpty() && (strData == null || !strData.contains(containsMethod))) {
                return false;
            }

            return true;
        } else {
            return false;
        }
    }
}
