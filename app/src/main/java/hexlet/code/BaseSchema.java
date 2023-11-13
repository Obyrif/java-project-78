package hexlet.code;

public abstract class BaseSchema {
    public boolean isRequired;
    public abstract boolean isValid(Object value);
}
