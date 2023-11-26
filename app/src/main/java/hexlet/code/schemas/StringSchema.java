package hexlet.code.schemas;

public class StringSchema extends BaseSchema {
    private boolean isRequired;
    private int minLengthField;
    private String containsField;

    public StringSchema required() {
        this.isRequired = true;
        this.predicate = value ->
                value instanceof String && (!((String) value).isEmpty());
        return this;
    }

    public StringSchema minLength(int minLength) {
        this.minLengthField = minLength;
        this.predicate = this.predicate.and(value ->
                value instanceof String && ((String) value).length() >= minLengthField);
        return this;
    }

    public StringSchema contains(String contains) {
        this.containsField = contains;
        this.predicate = this.predicate.and(value ->
                value instanceof String && ((String) value).contains(containsField));
        return this;
    }
}
