import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

@RunWith(Parameterized.class)
public class CheckNameHasOnlyOneSpaceTest {
    private final String initials;
    private final boolean expected;

    public CheckNameHasOnlyOneSpaceTest(String initials, boolean expected){
        this.initials = initials;
        this.expected = expected;
    }

    @Parameterized.Parameters(name = "Тестовые данные: имя фамилия {0}, ожидаемый результат {1}")
    public static Object[][] getData() {
        return new Object[][]{
                {"initials", false},
                {"ini tials", true},
                {"ini tia ls", false}
        };
    }

    @Test
    public void checkNameHasOnlyOneSpaceReturnsExpectedBoolean(){
        Account account = new Account(initials);
        Assert.assertEquals("Вернулось неправильное логическое значение", expected, account.checkNameHasOnlyOneSpace(initials));
    }
}
