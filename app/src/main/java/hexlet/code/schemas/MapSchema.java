package hexlet.code.schemas;

import java.util.Map;
import java.util.function.Predicate;

public final class MapSchema extends BaseSchema {

    public MapSchema required() {
        addCondition(value -> value instanceof Map);
        return this;
    }

    public MapSchema sizeof(int number) {
        Predicate<Object> sizeCondition = x -> x instanceof Map && ((Map<?, ?>) x).size() == number;
        addCondition(sizeCondition);
        return this;
    }

    public MapSchema shape(Map<String, BaseSchema> map) {
        if (map == null) {
            throw new IllegalArgumentException("Map cannot be null");
        }

        map.forEach((key, value) -> addCondition(o -> {
            if (o instanceof Map) {
                Map<?, ?> actualMap = (Map<?, ?>) o;
                return actualMap.containsKey(key) && value.isValid(actualMap.get(key));
            }
            return false;
        }));
        return this;
    }
}
