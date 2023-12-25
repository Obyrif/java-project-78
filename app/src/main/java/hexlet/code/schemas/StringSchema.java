package hexlet.code.schemas;

public class StringSchema extends BaseSchema {

    public StringSchema() {
        addCondition(value -> value instanceof String && !((String) value).isEmpty());
    }

    /**
     * Marks the string as required, i.e., it should not be empty or null.
     *
     * @return The current StringSchema object for method chaining.
     */
    public StringSchema required() {
        required = true;
        return this;
    }

    /**
     * Sets the minimum length required for the string.
     *
     * @param minLength The minimum length required for the string.
     * @return The current StringSchema object for method chaining.
     */
    public StringSchema minLength(int minLength) {
        addCondition(value ->
                value instanceof String && ((String) value).length() >= minLength);
        return this;
    }

    /**
     * Sets the substring that the string must contain.
     *
     * @param contains The substring that the string must contain.
     * @return The current StringSchema object for method chaining.
     */
    public StringSchema contains(String contains) {
        addCondition(value ->
                value instanceof String && ((String) value).contains(contains));
        return this;
    }
}

