package hexlet.code;

import java.util.HashMap;
import java.util.Map;

public abstract class MapSchema extends BaseSchema {
    private boolean isShape;
    private int expectedSize;
    private Map<String, BaseSchema> schemas = new HashMap<>();

    public MapSchema required() {
        isRequired = true;
        return this;
    }

    public MapSchema shape(Map<String, BaseSchema> schemas) {
        this.schemas.putAll(schemas);
        isShape = true;
        return this;
    }

    public MapSchema sizeof(int size) {
        expectedSize = size;
        return this;
    }

    public boolean isValid(Map<String, Object> data) {
        if (data == null) {
            return !isRequired;
        }

        for (Map.Entry<String, Object> entry : data.entrySet()) {
            String key = entry.getKey();
            Object value = entry.getValue();

            if (isRequired && value == null) {
                return false;
            }

            if (schemas.containsKey(key)) {
                BaseSchema schema = schemas.get(key);
                if (schema != null && !schema.isValid(value)) {
                    return false;
                }
            }
        }

        if (expectedSize >= 0 && data.size() != expectedSize) {
            return false;
        }

        if (isShape) {
            return data.keySet().containsAll(schemas.keySet());
        }

        return true;
    }

    public abstract boolean isValid();
}
