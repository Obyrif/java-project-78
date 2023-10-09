package hexlet.code;

public abstract class StringSchema extends BaseSchema{
    private boolean isRequired = false;
    private int minLengthMethod = 0;
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
