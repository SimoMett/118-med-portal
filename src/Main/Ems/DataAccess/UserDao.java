package src.Main.Ems.DataAccess;

import src.Main.Ems.Domain.RescueTeam.User;

public class UserDao
{
    //methods
    public User getUser(Object credentials) throws Exception
    {
        //TODO if credentials are correct, return user
        // otherwise throw exceptions
        return null;
    }

    public boolean changePassword(Object credentials, String newPsw)
    {
        //TODO if credentials are correct, change password with newPsw
        return false;
    }

    public boolean recoverPassword(String email)
    {
        //TODO
        // if there's an user with such email
        // set a random password and send it to the user email
        return false;
    }
}
