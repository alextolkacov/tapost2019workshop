package pages;

import baseFunc.BaseFunc;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;

public class LogInPage {
    private BaseFunc baseFunc;
    private final By USERNAME_FIELD = By.xpath(".//input[@id = 'username']");
    private final By FULL_NAME_FIELD = By.xpath(".//input[@id = 'name']");
    private final By PASSWORD_FIELD = By.xpath(".//input[@id = 'password']");
    private final By LOG_IN_BTN = By.xpath(".//input[@id = 'submit']");
    private final By STATUS = By.xpath(".//font[@id = 'status']");
    private final By CONFIRMATION = By.xpath(".//p[@id = 'users']");

    public LogInPage(BaseFunc baseFunc) {
        this.baseFunc = baseFunc;
    }

    public void fillUsername(String userName) {
        baseFunc.getElement(USERNAME_FIELD).sendKeys(userName);
    }

    public void fillFullName(String fullName) {
        baseFunc.getElement(FULL_NAME_FIELD).sendKeys(fullName);
    }

    public void fillPassword(String password) {
        baseFunc.getElement(PASSWORD_FIELD).sendKeys(password);
    }

    public void pushLogInBtn() {
        baseFunc.getElement(LOG_IN_BTN).click();
    }

    public String getStatus() {
        Assertions.assertTrue(baseFunc.getElement(STATUS).getText().contains("was created"), "User is not created");
        return baseFunc.getElement(STATUS).getText();
    }

    public void checkStatus() {
        Assertions.assertTrue(baseFunc.getElement(CONFIRMATION).getText().contains("Name"));
    }
}
