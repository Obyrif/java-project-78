package hexlet.code.schemas;

public class NumberSchema extends BaseSchema {
    private boolean positiveValue;
    private int rangeMin;
    private int rangeMax;

    public NumberSchema required() {
        isRequired = true;
        return this;
    }

    public NumberSchema positive() {
        positiveValue = true;
        return this;
    }

    public NumberSchema range(int min, int max) {
        rangeMin = min;
        rangeMax = max;
        return this;
    }

    public boolean isValid(Object value) {

        if (value == null) {
            return !isRequired;
        }

        if (value instanceof Integer) {
            int intValue = (Integer) value;

            if (isRequired && intValue == 0) {
                return false;
            }

            if (positiveValue && intValue < 0) {
                return false;
            }

            if ((rangeMin != 0 || rangeMax != 0) && (intValue < rangeMin || intValue > rangeMax)) {
                return false;
            }
        } else if (value instanceof String) {
            return false;
        }

        return true;
    }
}
