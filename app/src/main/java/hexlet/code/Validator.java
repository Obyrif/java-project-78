package hexlet.code;

public class Validator {
    StringSchema schema = new StringSchema() {
        @Override
        public boolean isValid() {
            return false;
        }
    };
    NumberSchema numberSchema = new NumberSchema() {
        @Override
        public boolean isValid() {
            return false;
        }
    };
    MapSchema mapSchema = new MapSchema() {
        @Override
        public boolean isValid() {
            return false;
        }
    };

    public StringSchema string() {
        return schema;
    }
    public NumberSchema number() {
        return numberSchema;
    }
    public MapSchema map() {
        return mapSchema;
    }
}
