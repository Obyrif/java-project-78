### Hexlet tests and linter status:
[![Actions Status](https://github.com/Obyrif/java-project-78/actions/workflows/hexlet-check.yml/badge.svg)](https://github.com/Obyrif/java-project-78/actions)
<a href="https://codeclimate.com/github/Obyrif/java-project-78/maintainability"><img src="https://api.codeclimate.com/v1/badges/c791ac5038eaac016298/maintainability" /></a>
<a href="https://codeclimate.com/github/Obyrif/java-project-78/test_coverage"><img src="https://api.codeclimate.com/v1/badges/c791ac5038eaac016298/test_coverage" /></a>


Валидатор данных – библиотека, с помощью которой можно проверять корректность любых данных. Подобных библиотек множество в каждом языке, так как практически все программы работают с внешними данными, которые нужно проверять на корректность. В первую очередь речь идет про данные форм заполняемых пользователями. За основу для проекта взята библиотека [yup]([url](https://github.com/jquense/yup)https://github.com/jquense/yup).

## Примеры использования:

### Валидация строк
<pre>
Validator v = new Validator();

StringSchema schema = v.string();

schema.isValid(""); // true
schema.isValid(null); // true

schema.required();

schema.isValid(null); // false
schema.isValid(""); // false
schema.isValid(5); // false
schema.isValid("what does the fox say"); // true
schema.isValid("hexlet"); // true

schema.contains("wh").isValid("what does the fox say"); // true
schema.contains("what").isValid("what does the fox say"); // true
schema.contains("whatthe").isValid("what does the fox say"); // false

schema.isValid("what does the fox say"); // false
// Здесь уже false, так как добавлена еще одна проверка contains("whatthe")
</pre>

### Валидация чисел
<pre>
Validator v = new Validator();

NumberSchema schema = v.number();

schema.isValid(null); // true
schema.positive().isValid(null); // true

schema.required();

schema.isValid(null); // false
schema.isValid("5"); // false
schema.isValid(10); // true

// Потому что ранее мы вызвали метод positive()
schema.isValid(-10); // false
//  Ноль — не положительное число
schema.isValid(0); // false

schema.range(5, 10);

schema.isValid(5); // true
schema.isValid(10); // true
schema.isValid(4); // false
schema.isValid(11); // false
</pre>

### Валидация объектов типа Map
<pre>
Validator v = new Validator();

MapSchema schema = v.map();

schema.isValid(null); // true

schema.required();

schema.isValid(null); // false
schema.isValid(new HashMap()); // true
Map<String, String> data = new HashMap<>();
data.put("key1", "value1");
schema.isValid(data); // true

schema.sizeof(2);

schema.isValid(data);  // false
data.put("key2", "value2");
schema.isValid(data); // true
</pre>

### Вложенная валидация
<pre>
Validator v = new Validator();

MapSchema schema = v.map();

// shape позволяет описывать валидацию для значений каждого ключа объекта Map
Map<String, BaseSchema> schemas = new HashMap<>();

schemas.put("name", v.string().required());
schemas.put("age", v.number().positive());
schema.shape(schemas);

Map<String, Object> human1 = new HashMap<>();
human1.put("name", "Kolya");
human1.put("age", 100);
schema.isValid(human1); // true

Map<String, Object> human2 = new HashMap<>();
human2.put("name", "Maya");
human2.put("age", null);
schema.isValid(human2); // true

Map<String, Object> human3 = new HashMap<>();
human3.put("name", "");
human3.put("age", null);
schema.isValid(human3); // false

Map<String, Object> human4 = new HashMap<>();
human4.put("name", "Valya");
human4.put("age", -5);
schema.isValid(human4); // false
</pre>



