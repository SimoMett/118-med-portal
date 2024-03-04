package src.Main.Ems.DataAccess;

import src.Main.Ems.Domain.RescueTeam.User;

public interface IUserDao
{
    //if credentials are correct, return user
    // otherwise throw exceptions
    User getUser(Object credentials) throws Exception;

    //if credentials are correct, change password with newPsw
    boolean changePassword(Object credentials, String newPsw);

    // if there's an user with such email
    // set a random password and send it to the user email
    boolean recoverPassword(String email);
}
