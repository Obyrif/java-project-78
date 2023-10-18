package hexlet.code;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class StringSchemaTest {
    private StringSchema schema;
    private NumberSchema numberSchema;
    private MapSchema mapSchema;

    @BeforeEach
    public void beforeEach() {
        schema = new StringSchema() {
            @Override
            public boolean isValid() {
                return false;
            }
        };
        numberSchema = new NumberSchema() {
            @Override
            public boolean isValid() {
                return false;
            }
        };
        mapSchema = new MapSchema() {
            @Override
            public boolean isValid() {
                return false;
            }
        };
    }

    @Test
    public void testMap() {
        assertTrue(mapSchema.isValid((Map<String, String>) null));
        mapSchema.required();
        assertFalse(mapSchema.isValid((Map<String, String>) null));
    }
    @Test
    public void testValidationNumber() {
        assertTrue(numberSchema.positive().isValid(null));
        assertTrue(numberSchema.isValid(null));
        numberSchema.required();
        assertFalse(numberSchema.isValid(null));
        assertFalse(numberSchema.isValid("5"));
        assertTrue(numberSchema.isValid(10));
        assertFalse(numberSchema.isValid(-10));
        numberSchema.range(5, 10);
        assertTrue(numberSchema.isValid(5));
    }

    @Test
    public void testValidations() {
        assertTrue(schema.isValid(""));
        schema.required()
                .contains("sug");
        assertTrue(schema.isValid("suggestion"));
    }

    @Test
    public void testValidation() {
        schema.minLength(6);
        assertTrue(schema.isValid("suggestion"));
    }

    @Test
    public void testCombinedValidations() {
        schema.required()
                .minLength(5)
                .contains("hex");

        assertFalse(schema.isValid(null));
        assertFalse(schema.isValid(""));
        assertFalse(schema.isValid("1234"));
        assertFalse(schema.isValid("what"));
        assertFalse(schema.isValid("some text"));
        assertTrue(schema.isValid("contains hex"));
    }
}
