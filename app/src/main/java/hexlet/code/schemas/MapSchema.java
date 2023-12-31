package hexlet.code.schemas;

import java.util.Map;
import java.util.function.Predicate;

public final class MapSchema extends BaseSchema {

    public MapSchema() {
        addCondition(value -> value instanceof Map);
    }

    public MapSchema required() {
        required = true;
        return this;
    }

    public MapSchema sizeof(int number) {
        Predicate<Object> sizeCondition = x -> ((Map<?, ?>) x).size() == number;
        addCondition(sizeCondition);
        return this;
    }

    public MapSchema shape(Map<String, BaseSchema> map) {
        if (map == null) {
            throw new IllegalArgumentException("Map cannot be null");
        }

        map.forEach((key, value) -> addCondition(o -> {
            if (o instanceof Map<?, ?> actualMap) {
                return actualMap.containsKey(key) && value.isValid(actualMap.get(key));
            }
            return false;
        }));
        return this;
    }
}
