package hexlet.code.schemas;

import java.util.function.Predicate;

public abstract class BaseSchema {
    protected Predicate<Object> predicate;

    public BaseSchema() {
        this.predicate = value -> true;
    }

    /**
     * Проверяет, соответствует ли переданное значение условиям схемы.
     *
     * @param value Значение для проверки.
     * @return true, если значение соответствует условиям схемы, иначе false.
     */
    public boolean isValid(Object value) {
        return predicate.test(value);
    }

    /**
     * Проверяет, удовлетворяет ли переданное значение обязательному условию схемы.
     *
     * @return true, если значение удовлетворяет обязательному условию, иначе false.
     */
    public BaseSchema required() {
        this.predicate = this.predicate.and(value -> value != null);
        return this;
    }

    /**
     * Добавляет условие для проверки значения схемы.
     *
     * @param condition Условие для добавления.
     * @return текущий объект схемы для цепочечных вызовов.
     */
    protected void addCondition(Predicate<Object> condition) {
        predicate = predicate.and(condition);
    }
}
