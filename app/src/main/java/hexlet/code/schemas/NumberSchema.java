package hexlet.code.schemas;

import java.util.Objects;

public class NumberSchema extends BaseSchema {

    public NumberSchema() {
        addCondition(Objects::nonNull);
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
        addCondition(value -> value instanceof Number && ((Number) value).intValue() > 0);
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
        addCondition(value -> ((Number) value).intValue() >= min && ((Number) value).intValue() <= max);
        return this;
    }
}
