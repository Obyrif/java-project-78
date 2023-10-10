package hexlet.code;

import java.util.HashMap;
import java.util.Map;

public abstract class MapSchema extends BaseSchema {
    private Map<String, String> requiredKeys;
    private int expectedSize;

    public MapSchema required() {
        requiredKeys = new HashMap<>();
        return this;
    }

    public MapSchema sizeof(int size) {
        expectedSize = size;
        return this;
    }

    public boolean isValid(Map<String, String> data) {
        for (Map.Entry<String, String> entry : data.entrySet()) {
            if (requiredKeys.containsKey(entry.getKey()) && entry.getValue() == null) {
                return false;
            }
        }

        if (data.size() != expectedSize) {
            return false;
        }
        return true;
    }
}

