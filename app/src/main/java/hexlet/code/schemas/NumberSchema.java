package hexlet.code.schemas;

public class NumberSchema extends BaseSchema {

    public NumberSchema() {
        addCondition(value -> value != null);
    }

    /**
     * Marks the number as required, i.e., it should not be null.
     *
     * @return The current NumberSchema object for method chaining.
     */
    public NumberSchema required() {
        required = true;
        return this;
    }

    /**
     * Sets the condition that the number must be positive.
     *
     * @return The current NumberSchema object for method chaining.
     */
    public NumberSchema positive() {
        addCondition(value ->
                value == null || (value instanceof Number && ((Number) value).intValue() > 0));
        return this;
    }

    /**
     * Sets the range within which the number must fall.
     *
     * @param min The minimum value.
     * @param max The maximum value.
     * @return The current NumberSchema object for method chaining.
     */
    public NumberSchema range(int min, int max) {
        addCondition(value ->
                value == null || (value instanceof Number
                                  && ((Number) value).intValue() >= min
                                  && ((Number) value).intValue() <= max));
        return this;
    }
}
