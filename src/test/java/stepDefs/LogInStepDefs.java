package stepDefs;

import baseFunc.BaseFunc;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.LogInPage;

public class LogInStepDefs {
    private BaseFunc baseFunc = new BaseFunc();
    private LogInPage logInPage;


    @Given("log in page with url (.*)")
    public void open_page(String url) {
        baseFunc.openPage(url);
        logInPage = new LogInPage(baseFunc);
    }

    @When("enter username (.*)")
    public void enter_username(String username) {
        logInPage.fillUsername(username);
    }

    @When("enter full name (.*)")
    public void enter_full_name(String fullName) {
        logInPage.fillFullName(fullName);
    }

    @When("enter password (.*)")
    public void enter_password(String password) {
        logInPage.fillPassword(password);
    }

    @When("push log in button")
    public void press_btn() {
        logInPage.pushLogInBtn();
    }

    @Then("receive status")
    public void receive_status() {
        logInPage.getStatus();
    }

    @Then("check submit information")
    public void receive_info() {
        logInPage.checkStatus();
    }
}

