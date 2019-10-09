import business.User;
import business.service.UserService;
import business.validation.PasswordValidator;
import business.validation.ValidationError;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import peristance.IUserRepository;
import peristance.InMemoryUserRepository;

import java.util.Optional;

public class UserTest {
    private User user = new User();
    private UserService userService = new UserService();
    private PasswordValidator passwordValidator = new PasswordValidator();
    private IUserRepository userRepository = new InMemoryUserRepository();

    private String loginName = "Alex";
    private String fullName = "Aleksandrs Tolkacovs";
    private String password = "Password1";
    private String emptyPwd = "";
    private String incorrectPwd = "8556";

    @Test
    public void unitTests() {
        checkUser();
        checkFields();
        checkFields();
        checkSetUser();
        checkIncorrectPassword();
        checkUserList();
        checkPasswordValidation();
        checkEmptyPassword();
        complexityRules();
    }

    @Test
    public void checkUser() {
        userService.setUserRepository(userRepository);
        String response = userService.addUser(loginName, fullName, password);
        Assertions.assertEquals(response, "user " + loginName + " was created");
    }

    @Test
    public void checkFields() {
        Optional<ValidationError> response = userService.validateFields("asp", "a p", "pasw1");
        Assertions.assertEquals(Optional.empty(), response);
    }

    @Test
    public void checkSetUser() {
        user.setUserLogInName(loginName);
        user.setFullUserName(fullName);
        user.setPassword(password);
        Assertions.assertEquals(user.getUserLogInName(), loginName);
        Assertions.assertEquals(user.getFullUserName(), fullName);
        Assertions.assertEquals(user.getPassword(), password);
    }

    @Test
    public void checkUserList() {
        Assertions.assertFalse(userService.getUserInfoList().isEmpty(), "User List is empty");
    }

    @Test
    public void checkPasswordValidation() {
        Optional<ValidationError> response = passwordValidator.validate(password);
        Assertions.assertEquals(response, passwordValidator.validate(password));
    }

    @Test
    public void checkIncorrectPassword() {
        Optional<ValidationError> response = passwordValidator.validate(incorrectPwd);
        Assertions.assertEquals(response.get().getErrorMessage(), "Password does not conform rules");
    }

    @Test
    public void checkEmptyPassword() {
        Optional<ValidationError> response = passwordValidator.validate(emptyPwd);
        Assertions.assertEquals(response.get().getErrorMessage(), "Password cannot be empty");
    }

    @Test
    public void complexityRules() {
        Assertions.assertTrue(passwordValidator.doesConformToComplexityRules(password));
    }
}
