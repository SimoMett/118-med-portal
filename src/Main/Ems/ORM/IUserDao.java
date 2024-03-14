package src.Main.Ems.ORM;

import src.Main.Ems.BusinessLogic.Credentials;

public interface IUserDao
{
    //if credentials are correct, return user
    // otherwise throw exceptions
    LoginResult getUser(Credentials credentials);

    //if credentials are correct, change password with newPsw
    boolean changePassword(Credentials credentials, String newPsw);

    // if there's a user with such email
    // set a random password and send it to the user email
    boolean recoverPassword(String email);
}
