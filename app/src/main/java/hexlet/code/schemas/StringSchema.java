package hexlet.code.schemas;

public class StringSchema extends BaseSchema {
    private boolean isRequired;
    private int minLengthField;
    private String containsField;

    /**
     * Marks the string as required, i.e., it should not be empty or null.
     *
     * @return The current StringSchema object for method chaining.
     */
    public StringSchema required() {
        this.isRequired = true;
        this.predicate = value ->
                value instanceof String && (!((String) value).isEmpty());
        return this;
    }

    /**
     * Sets the minimum length required for the string.
     *
     * @param minLength The minimum length required for the string.
     * @return The current StringSchema object for method chaining.
     */
    public StringSchema minLength(int minLength) {
        this.minLengthField = minLength;
        this.predicate = this.predicate.and(value ->
                value instanceof String && ((String) value).length() >= minLengthField);
        return this;
    }

    /**
     * Sets the substring that the string must contain.
     *
     * @param contains The substring that the string must contain.
     * @return The current StringSchema object for method chaining.
     */
    public StringSchema contains(String contains) {
        this.containsField = contains;
        this.predicate = this.predicate.and(value ->
                value instanceof String && ((String) value).contains(containsField));
        return this;
    }
}
