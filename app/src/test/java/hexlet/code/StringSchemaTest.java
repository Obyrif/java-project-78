package hexlet.code;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class StringSchemaTest {
    @Test
    public void testValidations() {
        StringSchema schema = new StringSchema();
        assertTrue(schema.isValid(""));
        schema.required()
                .contains("sug");
        assertTrue(schema.isValid("suggestion"));
    }

    @Test
    public void testValidation() {
        StringSchema schema = new StringSchema()
                .minLength(6);
        assertTrue(schema.isValid("suggestion"));
    }

    @Test
    public void testCombinedValidations() {
        StringSchema schema = new StringSchema()
                .required()
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
