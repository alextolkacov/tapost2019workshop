import baseFunc.BaseFunc;
import org.junit.jupiter.api.Test;
import pages.LogInPage;

public class LoginTest {
    private BaseFunc baseFunc = new BaseFunc();
    private LogInPage logInPage;

    @Test
    public void checkLogInPage() {
        baseFunc.openPage("localhost:4567/index");
        logInPage = new LogInPage(baseFunc);
        logInPage.fillUsername("Tapost");
        logInPage.fillFullName("Tapost Tapost");
        logInPage.fillPassword("Password1");
        logInPage.pushLogInBtn();
        logInPage.getStatus();
        logInPage.checkStatus();
    }
}
