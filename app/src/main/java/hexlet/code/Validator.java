package hexlet.code;

import hexlet.code.schemas.MapSchema;
import hexlet.code.schemas.NumberSchema;
import hexlet.code.schemas.StringSchema;

public class Validator {
    public Validator() {
    }

    /**
     * Creates a new StringSchema for string validation.
     *
     * @return A new instance of StringSchema.
     */
    public StringSchema string() {
        return new StringSchema();
    }

    /**
     * Creates a new NumberSchema for number validation.
     *
     * @return A new instance of NumberSchema.
     */
    public NumberSchema number() {
        return new NumberSchema();
    }

    /**
     * Creates a new MapSchema for map validation.
     *
     * @return A new instance of MapSchema.
     */
    public MapSchema map() {
        return new MapSchema();
    }
}
