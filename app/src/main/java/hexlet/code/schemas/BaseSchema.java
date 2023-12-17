package hexlet.code.schemas;

import java.util.function.Predicate;

import java.util.ArrayList;
import java.util.List;


public abstract class BaseSchema {
    protected List<Predicate<Object>> predicates;
    protected boolean required;

    public BaseSchema() {
        this.predicates = new ArrayList<>();
        this.required = false;
        addCondition(value -> !required || value != null);
    }

    /**
     * Checks if the given value satisfies the schema conditions.
     *
     * @param value The value to check.
     * @return true if the value satisfies the schema conditions, otherwise false.
     */
    public boolean isValid(Object value) {
        return predicates.stream().allMatch(predicate -> predicate.test(value));
    }

    /**
     * Sets a required condition for the schema value.
     *
     * @return The current schema object for chaining calls.
     */
    public BaseSchema required() {
        this.required = true;
        return this;
    }

    /**
     * Adds a condition for checking the schema value.
     *
     * @param condition The condition to add.
     * @return The current schema object for chaining calls.
     */
    protected BaseSchema addCondition(Predicate<Object> condition) {
        predicates.add(condition);
        return this;
    }
}
