package src.Test.Ems;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import src.Main.Ems.BusinessLogic.Credentials;
import src.Main.Ems.BusinessLogic.UserLoginController;
import src.Main.Ems.DataAccess.LoginResult;
import src.Main.Ems.Domain.Session;

public class LoginTests
{
    UserLoginController userLoginController = new UserLoginController(new DummyUserDao());

    @Before
    public void initSession()
    {
        Session.init(Session.Mode.BLS);
    }

    @Test
    public void successfulLogin()
    {
        Credentials credentials = new Credentials("mariorossi24", "RossiM123");
        LoginResult result = userLoginController.logInUser(credentials);
        assert result.success;
    }

    @Test
    public void wrongPasswordLogin()
    {
        Credentials credentials = new Credentials("mariorossi24", "abcd");
        LoginResult result = userLoginController.logInUser(credentials);
        assert !result.success;

        System.out.println(result.message);
    }

    @Test
    public void noUsernameLogin()
    {
        Credentials credentials = new Credentials("carlo27", "RossiM123");
        LoginResult result = userLoginController.logInUser(credentials);
        assert !result.success;

        System.out.println(result.message);
    }

    @After
    public void stopSession()
    {
        Session.destroy();
    }
}
