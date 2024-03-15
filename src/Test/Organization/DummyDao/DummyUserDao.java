package src.Test.Organization.DummyDao;

import src.Main.Organization.UsersManagement.BusinessLogic.SearchFilters.SearchFilter;
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
    public boolean updateCertificates(User user, Object certificates)
    {
        return true;
    }

    @Override
    public Object getUserCertificates(User user)
    {
        return new Object();
    }

    @Override
    public ArrayList<User> searchUser(SearchFilter searchFilter, String param)
    {
        ArrayList<User> results = new ArrayList<>();
        for(User u : usersRegistry.getAllUsers())
        {
            if(searchFilter.matches(u, param))
                results.add(u);
        }
        return results;
    }

    @Override
    public boolean deleteUser(User user)
    {
        //removing user from database (assuming successful)
        return usersRegistry.getAllUsers().contains(user);
    }

    @Override
    public UsersRegistry getUsersRegistry()
    {
        return usersRegistry;
    }
}
