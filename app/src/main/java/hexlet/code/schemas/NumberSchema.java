package hexlet.code.schemas;

public class NumberSchema extends BaseSchema {
    /**
     * Устанавливает условие, что число должно быть положительным.
     * @return Текущий объект NumberSchema для цепочечных вызовов.
     */
    public NumberSchema positive() {
        this.predicate = value ->
                value == null || (value instanceof Number && ((Number) value).intValue() > 0);
        return this;
    }

    /**
     * Устанавливает диапазон, в пределах которого должно находиться число.
     * @param min Минимальное значение.
     * @param max Максимальное значение.
     * @return Текущий объект NumberSchema для цепочечных вызовов.
     */
    public NumberSchema range(int min, int max) {
        this.predicate = this.predicate.and(value ->
                value == null || (value instanceof Number
                                  && ((Number) value).intValue() >= min
                                  && ((Number) value).intValue() <= max)
        );
        return this;
    }
}
