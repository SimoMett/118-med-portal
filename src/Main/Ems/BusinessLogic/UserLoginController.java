package src.Main.Ems.BusinessLogic;

import src.Main.Ems.ORM.IUserDao;
import src.Main.Ems.ORM.LoginResult;
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
        // instead of throwing exception
        // I'm using a LoginResult object to store result and possible error messages
        LoginResult result = userDao.getUser(credentials);
        if(result.success)
            Session.instance().getTeam().addRescuer(result.user);
        return result;
    }

    public void recoverPassword(String email) throws IllegalArgumentException
    {
        //weak email format checking
        if(email.split("@").length != 2)
            throw new IllegalArgumentException("Invalid email");

        if(!userDao.recoverPassword(email))
            throw new IllegalArgumentException("Unknown email");
    }

    public void changePassword(Credentials credentials, String newPsw) throws RuntimeException
    {
        if(!userDao.changePassword(credentials, newPsw))
            throw new RuntimeException("UserDao failed data access");
    }
}
