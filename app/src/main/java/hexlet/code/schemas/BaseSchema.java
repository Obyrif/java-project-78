package hexlet.code.schemas;

import java.util.ArrayList;
import java.util.function.Predicate;
import java.util.List;


public abstract class BaseSchema {
    protected List<Predicate<Object>> predicates;
    protected boolean required;

    public BaseSchema() {
        this.predicates = new ArrayList<>();
    }

    /**
     * Checks if the given value satisfies the schema conditions.
     *
     * @param value The value to check.
     * @return true if the value satisfies the schema conditions, otherwise false.
     */
    public boolean isValid(Object value) {
        if (!required) {
            return true;
        }
        return predicates.stream().allMatch(predicate -> predicate.test(value));
    }

    /**
     * Adds a condition for checking the schema value.
     *
     * @param condition The condition to add.
     */
    protected void addCondition(Predicate<Object> condition) {
        if (predicates == null) {
            predicates = new ArrayList<>();
        }
        predicates.add(condition);
    }
}
