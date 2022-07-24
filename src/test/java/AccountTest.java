import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

@RunWith(Parameterized.class)
public class AccountTest {
    private final String initials;
    private final boolean expected;

    public AccountTest(String initials, boolean expected){
        this.initials = initials;
        this.expected = expected;
    }

    @Parameterized.Parameters(name = "Тестовые данные: имя фамилия (количество символов) {0}, ожидаемый результат {1}")
    public static Object[][] getAccountData() {
        return new Object[][]{
                {"  ", false},      //0 0 0
                {" ", false},       //0 0 1
                {"", false},        //0 1 0
                {" Daniil ", false},   //1 0 0
                                    //ОТСУТСВУЕТ 0 1 1
                {" Daniil", false},      //1 0 1
                {"Daniil", false},     //1 1 0
                {"Daniil Bolko", true},    //1 1 1
        };
    }

    @Test
    public void checkNameToEmbossReturnsExpectedBoolean(){
        Account account = new Account(initials);
        Assert.assertEquals("Вернулось неправильное логическое значение", expected, account.checkNameToEmboss());
    }
}