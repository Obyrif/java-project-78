package hexlet.code.schemas;

public class BaseSchema {
    public boolean isRequired;
    public boolean isValid(Object value) {
        return false;
    }
}
