package hexlet.code;

import java.util.HashMap;
import java.util.Map;

public class App {
    public static void main(String[] args) {
        Validator v = new Validator();
        MapSchema schema = v.map();

        System.out.println(schema.isValid(null)); // true

        schema.required();

        System.out.println(schema.isValid(null)); // false
        System.out.println(schema.isValid(new HashMap())); // true

        Map<String, String> data = new HashMap<>();
        data.put("key1", "value1");

        System.out.println(schema.isValid(data)); // true

        schema.sizeof(2);

        System.out.println(schema.isValid(data)); // false
        data.put("key2", "value2");
        System.out.println(schema.isValid(data)); // true
    }
}
