import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

@RunWith(Parameterized.class)
public class CheckNameLengthTest {
    private final String initials;
    private final boolean expected;

    public CheckNameLengthTest(String initials, boolean expected){
        this.initials = initials;
        this.expected = expected;
    }

    @Parameterized.Parameters(name = "Тестовые данные: имя фамилия (количество символов) {0}, ожидаемый результат {1}")
    public static Object[][] getData() {
        return new Object[][]{
                {"Da", false},
                {"Dan", true},
                {"Daniil", true},
                {"Daniil Bolko Daniil", true},
                {"Daniil Bolko Daniil Bolko", false}
        };
    }

    @Test
    public void checkNameLengthReturnsExpectedBoolean(){
        Account account = new Account(initials);
        Assert.assertEquals("Вернулось неправильное логическое значение", expected, account.checkNameLength(initials));
    }
}
