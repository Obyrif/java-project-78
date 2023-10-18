package hexlet.code;

import java.util.HashMap;
import java.util.Map;

public abstract class MapSchema extends BaseSchema {
    private boolean isRequired;
    private boolean isShape;
    private int expectedSize;
    private Map<String, BaseSchema> schemas;

    public MapSchema required() {
        isRequired = true;
        return this;
    }

    public MapSchema shape(Map<String, BaseSchema> schemas) {
        this.schemas = schemas;
        isShape = true;
        return this;
    }

    public MapSchema sizeof(int size) {
        expectedSize = size;
        return this;
    }

    public boolean isValid(Map<String, String> data) {
        if (data == null) {
            return !isRequired;
        }

        for (Map.Entry<String, String> entry : data.entrySet()) {
            if (isRequired && entry.getValue() == null) {
            }
        }
        schemas = new HashMap<>();
        for(Map.Entry<String, BaseSchema> entry1: schemas.entrySet()) {
            if(isShape && entry1.getKey() == null) {
                return false;
            }
        }

        if (expectedSize >= 0 && data.size() != expectedSize) {
            return false;
        }
        return true;
    }
}

