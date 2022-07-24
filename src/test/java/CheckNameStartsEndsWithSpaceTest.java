import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

@RunWith(Parameterized.class)
public class CheckNameStartsEndsWithSpaceTest {
    private final String initials;
    private final boolean expected;

    public CheckNameStartsEndsWithSpaceTest(String initials, boolean expected){
        this.initials = initials;
        this.expected = expected;
    }

    @Parameterized.Parameters(name = "Тестовые данные: имя фамилия {0}, ожидаемый результат {1}")
    public static Object[][] getData() {
        return new Object[][]{
                {"initials", true},
                {" initials", false},
                {"initials ", false},
                {"ini tials", true}
        };
    }

    @Test
    public void checkNameStartsNEndsWithSpaceReturnsExpectedBoolean(){
        Account account = new Account(initials);
        Assert.assertEquals("Вернулось неправильное логическое значение", expected, account.checkNameStartsEndsWithSpace(initials));
    }
}
