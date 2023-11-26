package hexlet.code.schemas;

import java.util.function.Predicate;

public abstract class BaseSchema {
    protected Predicate<Object> predicate;

    public BaseSchema() {
        this.predicate = value -> true;
    }

    /**
     * Checks if the given value satisfies the schema conditions.
     * @param value The value to check.
     * @return true if the value satisfies the schema conditions, otherwise false.
     */
    public boolean isValid(Object value) {
        return predicate.test(value);
    }

    /**
     * Sets a required condition for the schema value.
     * @return The current schema object for chaining calls.
     */
    public BaseSchema required() {
        this.predicate = this.predicate.and(value -> value != null);
        return this;
    }

    /**
     * Adds a condition for checking the schema value.
     * @param condition The condition to add.
     * @return The current schema object for chaining calls.
     */
    protected BaseSchema addCondition(Predicate<Object> condition) {
        predicate = predicate.and(condition);
        return this;
    }
}
