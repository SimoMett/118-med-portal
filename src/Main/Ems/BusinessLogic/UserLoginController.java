package src.Main.Ems.BusinessLogic;

import src.Main.Ems.DataAccess.UserDao;

public class UserLoginController
{
    //attributes
    private final UserDao userDao;
    //methods
    public UserLoginController(UserDao userDao)
    {
        this.userDao = userDao;
    }

    //TODO error management
    public LoginResult logInUser(Object credentials)
    {

        return null;
    }


    public void recoverPassword(String email)
    {
        userDao.recoverPassword(email);
    }

    public void changePassword(Object credentials, String newPsw)
    {
        this.changePassword(credentials, newPsw);
    }
}
