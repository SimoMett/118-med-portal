package src.Main.Organization.UsersManagement.BusinessLogic;

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

    public UserInfo getUserInfo(int id)
    {
        //TODO error management
        return usersRegistry.getUser(id).getInfo();
    }

    public Object getUserCertificates(int id)
    {
        //TODO error management
        User u = usersRegistry.getUser(id);
        Object certificates = u.getCertificates();
        if(certificates == null)
        {
            certificates = userDao.getUserCertificates(u);
            if (certificates != null)
                u.storeCertificates(certificates);
        }
        return null;
    }

    public void updateUserInfo(int id, Object key, Object val)
    {
        //TODO error management
        User u = usersRegistry.getUser(id);
        if(userDao.updateInfo(u, key, val))
            u.updateInfo(key, val);
    }

    public void deleteUser(int id)
    {
        //TODO error management
        User u = usersRegistry.getUser(id);
        if(userDao.deleteUser(u))
            usersRegistry.deleteUser(u);
    }
    public ArrayList<User> searchUser(Object how)
    {
        return null;
    }
}
