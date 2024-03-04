package src.Main.Ems.BusinessLogic;

import src.Main.Ems.DataAccess.IUserDao;
import src.Main.Ems.Domain.RescueTeam.User;
import src.Main.Ems.Domain.Session;

public class UserLoginController
{
    //attributes
    private final IUserDao userDao;
    //methods
    public UserLoginController(IUserDao userDao)
    {
        this.userDao = userDao;
    }


    public LoginResult logInUser(Object credentials)
    {
        LoginResult result = new LoginResult();

        try
        {
            User user = userDao.getUser(credentials);
            Session.instance().getTeam().addRescuer(user);
            result.user = user;
        }
        catch (Exception e)
        {
            result.message = e.getMessage();
        }
        return result;
    }

    //TODO error management
    public void recoverPassword(String email)
    {
        userDao.recoverPassword(email);
    }

    public void changePassword(Object credentials, String newPsw)
    {
        this.userDao.changePassword(credentials, newPsw);
    }
}
