package hexlet.code;

import org.junit.jupiter.api.BeforeEach;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class Test {
    private Validator v = new Validator();
    private StringSchema schema;
    private NumberSchema numberSchema;
    private MapSchema mapSchema;

    @BeforeEach
    public void beforeEach() {
        schema = v.string();
        numberSchema = v.number();
        mapSchema = v.map();
    }

    @org.junit.jupiter.api.Test
    public void testMap() {
        assertTrue(mapSchema.isValid(null));
        mapSchema.required();
        assertFalse(mapSchema.isValid(null));
        assertTrue(mapSchema.isValid(new HashMap()));
        Map<String, String> data = new HashMap<>();
        data.put("key1", "value1");
        assertFalse(mapSchema.isValid(data));
        mapSchema.sizeof(2);
        assertFalse(mapSchema.isValid(data));
        data.put("key2", "value2");
        assertTrue(mapSchema.isValid(data));
    }
    @org.junit.jupiter.api.Test
    public void testNumber() {
        assertTrue(numberSchema.isValid(null));
        assertTrue(numberSchema.positive().isValid(null));
        numberSchema.required();
        assertFalse(numberSchema.isValid(null));
        assertFalse(numberSchema.isValid("5"));
        assertTrue(numberSchema.isValid(10));
        assertFalse(numberSchema.isValid(-10));
        assertFalse(schema.isValid(0));
        numberSchema.range(5, 10);
        assertTrue(numberSchema.isValid(5));
        assertTrue(numberSchema.isValid(10));
        assertFalse(numberSchema.isValid(4));
        assertFalse(numberSchema.isValid(11));
    }

    @org.junit.jupiter.api.Test
    public void testString() {
        assertTrue(schema.isValid(""));
        assertTrue(schema.isValid(null));
        schema.required();
        assertFalse(schema.isValid(null));
        assertFalse(schema.isValid(""));
        assertFalse(schema.isValid(5));
        assertTrue(schema.isValid("what does the fox say"));
        assertTrue(schema.isValid("hexlet"));
        assertTrue(schema.contains("wh").isValid("what does the fox say"));
        assertTrue(schema.contains("what").isValid("what does the fox say"));
        assertFalse(schema.contains("whatthe").isValid("what does the fox say"));
        assertFalse(schema.isValid("what does the fox say"));
    }
}
