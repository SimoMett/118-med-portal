package src.Test.Organization.DummyDao;

import src.Main.Organization.UsersManagement.DataAccess.IUserDao;
import src.Main.Organization.UsersManagement.Domain.User;
import src.Main.Organization.UsersManagement.Domain.UsersRegistry;
import src.Main.Organization.UsersManagement.UserInfo;

import java.util.ArrayList;

public class DummyUserDao implements IUserDao
{
    private final UsersRegistry usersRegistry;
    public DummyUserDao(UsersRegistry registry)
    {
        this.usersRegistry = registry;
    }

    @Override
    public User registerUser(UserInfo userInfo)
    {
        //create user in database (assuming successful)
        User u = new User(userInfo);
        usersRegistry.addUser(u);
        return u;
    }

    @Override
    public boolean updateInfo(User user, String key, String val)
    {
        // update info in database (assuming vehicle is present)
        usersRegistry.updateUserInfo(user, key, val);
        return true;
    }

    @Override
    public Object getUserCertificates(User user)
    {
        return null;
    }

    @Override
    public ArrayList<User> searchUser(Object how)
    {
        return null;
    }

    @Override
    public boolean deleteUser(User user)
    {
        //removing user from database (assuming successful)
        return false;
    }

    @Override
    public UsersRegistry getUsersRegistry()
    {
        return usersRegistry;
    }
}
