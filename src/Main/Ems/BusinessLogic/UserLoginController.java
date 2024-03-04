package src.Main.Ems.BusinessLogic;

import src.Main.Ems.DataAccess.IUserDao;
import src.Main.Ems.DataAccess.LoginResult;
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


    public LoginResult logInUser(Credentials credentials)
    {
        LoginResult result = userDao.getUser(credentials);
        if(result.success)
            Session.instance().getTeam().addRescuer(result.user);
        return result;
    }

    //TODO error management
    public void recoverPassword(String email) throws IllegalArgumentException
    {
        userDao.recoverPassword(email);
    }

    public void changePassword(Credentials credentials, String newPsw)
    {
        this.userDao.changePassword(credentials, newPsw);
    }
}
