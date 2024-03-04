package src.Test.Ems;

import src.Main.Ems.BusinessLogic.Credentials;
import src.Main.Ems.DataAccess.IUserDao;
import src.Main.Ems.DataAccess.LoginResult;
import src.Main.Ems.Domain.RescueTeam.User;

import java.util.ArrayList;

public class DummyUserDao implements IUserDao
{
    private final ArrayList<Credentials> userDb;

    public DummyUserDao()
    {
        userDb = new ArrayList<>(4);
        userDb.add(new Credentials("mariorossi24", "RossiM123"));
        userDb.add(new Credentials("giacomoverdi1", "giacomino"));
        userDb.add(new Credentials("leonardo3", "leonardo123"));
        userDb.add(new Credentials("raffaele29", "raffaele92"));
    }

    @Override
    public LoginResult getUser(Credentials credentials)
    {
        LoginResult result = new LoginResult();
        result.message = "Unknown";
        if(userDb.contains(credentials))
        {
            result.user = new User(credentials.username());
            result.success = true;
        }
        else
        {
            result.success = false;
            result.message = "Username not found";
            for(Credentials cred : userDb)
            {
                if(cred.username().equals(credentials.username()))
                {
                    result.message = "Wrong password";
                    break;
                }
            }
        }
        return result;
    }

    @Override
    public boolean changePassword(Credentials credentials, String newPsw)
    {
        return false;
    }

    @Override
    public boolean recoverPassword(String email)
    {
        return false;
    }
}
