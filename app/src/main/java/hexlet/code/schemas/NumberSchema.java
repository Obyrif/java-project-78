package hexlet.code.schemas;

public class NumberSchema extends BaseSchema {
    public NumberSchema positive() {
        this.predicate = value ->
                value == null || (value instanceof Number && ((Number) value).intValue() > 0);
        return this;
    }

    public NumberSchema range(int min, int max) {
        this.predicate = this.predicate.and(value ->
                value == null || (value instanceof Number
                                  && ((Number) value).intValue() >= min
                                  && ((Number) value).intValue() <= max)
        );
        return this;
    }
}
