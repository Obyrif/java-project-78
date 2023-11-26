package hexlet.code.schemas;

import java.util.function.Predicate;

public abstract class BaseSchema {
    protected Predicate<Object> predicate;

    public BaseSchema() {
        this.predicate = value -> true;
    }

    public boolean isValid(Object value) {
        return predicate.test(value);
    }

    public BaseSchema required() {
        this.predicate = this.predicate.and(value -> value != null);
        return this;
    }

    protected void addCondition(Predicate<Object> condition) {
        predicate = predicate.and(condition);
    }
}
