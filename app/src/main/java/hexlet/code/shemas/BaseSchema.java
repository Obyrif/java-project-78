package hexlet.code.shemas;

public class BaseSchema {
    public boolean isRequired;
    public boolean isValid(Object value) {
        return false;
    }
}
