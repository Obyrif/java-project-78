package hexlet.code;

import java.util.HashMap;
import java.util.Map;

public class MapSchema extends BaseSchema {
    private int expectedSize;

    public MapSchema required() {
        isRequired = true;
        return this;
    }

    public MapSchema sizeof(int size) {
        expectedSize = size;
        return this;
    }

    @Override
    public boolean isValid(Object value) {
        Map<String, Object> map = (Map<String, Object>) value;

        for (Map.Entry<String, Object> map1: map.entrySet()) {
            Object value1 = map1.getValue();

            if (isRequired && value1 == null) {
                return false;
            }
        }

        if (expectedSize >= 0 && map.size() != expectedSize) {
            return false;
        }

        return true;
    }
}
