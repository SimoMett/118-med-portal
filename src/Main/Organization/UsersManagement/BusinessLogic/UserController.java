package src.Main.Organization.UsersManagement.BusinessLogic;

import src.Main.Organization.UsersManagement.BusinessLogic.SearchFilters.SearchFilter;
import src.Main.Organization.UsersManagement.DataAccess.IUserDao;
import src.Main.Organization.UsersManagement.Domain.User;
import src.Main.Organization.UsersManagement.Domain.UsersRegistry;
import src.Main.Organization.UsersManagement.UserInfo;

import java.util.ArrayList;

public class UserController
{
    private final UsersRegistry usersRegistry;
    private final IUserDao userDao;

    public UserController(IUserDao userDao)
    {
        this.userDao = userDao;
        usersRegistry = userDao.getUsersRegistry();
    }

    public UserInfo getUserInfo(int id) throws NullPointerException
    {
        return usersRegistry.getUser(id).getInfo();
    }

    public Object getUserCertificates(int id) throws NullPointerException
    {
        User u = usersRegistry.getUser(id);
        Object certificates = u.getCertificates();
        if(certificates == null)
        {
            certificates = userDao.getUserCertificates(u);
            if (certificates != null)
                u.storeCertificates(certificates);
        }
        return certificates;
    }

    public void updateUserInfo(int id, String key, String val) throws RuntimeException
    {
        User u = usersRegistry.getUser(id);
        if(userDao.updateInfo(u, key, val))
            u.updateInfo(key, val);
        else
            throw new RuntimeException("UserDao failed data access");
    }

    public void deleteUser(int id) throws RuntimeException
    {
        User u = usersRegistry.getUser(id);
        deleteUser(u);
    }

    public final void deleteUser(User u) throws RuntimeException
    {
        if(userDao.deleteUser(u))
            usersRegistry.deleteUser(u);
        else
            throw new RuntimeException("UserDao failed data access");
    }

    public ArrayList<User> searchUser(SearchFilter how, String param) { return userDao.searchUser(how, param); }
}
