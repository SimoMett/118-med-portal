package src.Test.Ems;

import org.junit.Test;
import src.Main.Ems.BusinessLogic.Credentials;
import src.Main.Ems.BusinessLogic.UserLoginController;
import src.Main.Ems.DataAccess.LoginResult;
import src.Main.Ems.Domain.Session;

public class LoginTests
{
    @Test
    public void successfulLogin()
    {
        Session.init(Session.Mode.BLS);
        DummyUserDao userDao = new DummyUserDao();
        Credentials credentials = new Credentials("mariorossi24", "RossiM123");
        UserLoginController userLoginController = new UserLoginController(userDao);
        LoginResult result = userLoginController.logInUser(credentials);
        assert result.success;
    }

    @Test
    public void wrongPasswordLogin()
    {
        Session.init(Session.Mode.BLS);
        DummyUserDao userDao = new DummyUserDao();
        Credentials credentials = new Credentials("mariorossi24", "abcd");
        UserLoginController userLoginController = new UserLoginController(userDao);
        LoginResult result = userLoginController.logInUser(credentials);
        assert !result.success;
        System.out.println(result.message);
    }

    @Test
    public void noUsernameLogin()
    {
        Session.init(Session.Mode.BLS);
        DummyUserDao userDao = new DummyUserDao();
        Credentials credentials = new Credentials("carlo27", "abcd");
        UserLoginController userLoginController = new UserLoginController(userDao);
        LoginResult result = userLoginController.logInUser(credentials);
        assert !result.success;
        System.out.println(result.message);
    }
}
