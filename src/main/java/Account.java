

public class Account {
    private final String name;
    public Account(String name) {
        this.name = name;
    }
    public boolean checkNameToEmboss() {
        /*
             Этот метод должен проверять, что сохранённая через конструктор строка соответствует требованиям.
             Если строка удовлетворяет условиям, метод возвращает true, иначе — false.
         */
        return checkNameLength(name) && checkNameStartsEndsWithSpace(name) && checkNameHasOnlyOneSpace(name);
        }

    public boolean checkNameLength(String name) {
        return name.length() >= 3 && name.length() <= 19;
    }

    public boolean checkNameStartsEndsWithSpace(String name) {
        return !name.startsWith(" ") && !name.endsWith(" ");
    }

    public boolean checkNameHasOnlyOneSpace(String name) {
        int i = name.indexOf(" ");
        int amount = 0;
        while (i != -1 && amount < 2) {
            i = name.indexOf(" ", i + 1);
            amount += 1;
        }
        return amount == 1;
    }
}
