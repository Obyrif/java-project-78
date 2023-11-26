package hexlet.code.schemas;

import java.util.function.Predicate;

public abstract class BaseSchema {
    protected Predicate<Object> predicate;

    public BaseSchema() {
        this.predicate = value -> true;
    }

    /**
     * Проверяет, соответствует ли переданное значение условиям схемы.
     * @param value Значение для проверки.
     * @return true, если значение соответствует условиям схемы, иначе false.
     */
    public boolean isValid(Object value) {
        return predicate.test(value);
    }

    /**
     * Устанавливает обязательное условие для значения схемы.
     * @return текущий объект схемы для цепочечных вызовов.
     */
    public BaseSchema required() {
        this.predicate = this.predicate.and(value -> value != null);
        return this;
    }

    /**
     * Добавляет условие для проверки значения схемы.
     * @param condition Условие для добавления.
     * @return текущий объект схемы для цепочечных вызовов.
     */
    protected void addCondition(Predicate<Object> condition) {
        predicate = predicate.and(condition);
    }
}
