package src.Main.Organization.UsersManagement.BusinessLogic;

import src.Main.Organization.UsersManagement.DataAccess.IUserDao;
import src.Main.Organization.UsersManagement.Domain.User;
import src.Main.Organization.UsersManagement.Domain.UsersRegistry;
import src.Main.Organization.UsersManagement.UserInfo;

public class UserRegistrationController
{
    private final UsersRegistry usersRegistry;
    private final IUserDao userDao;

    public UserRegistrationController(IUserDao userDao)
    {
        this.userDao = userDao;
        this.usersRegistry = userDao.getUsersRegistry();
    }

    public User registerNewUser(UserInfo userInfo)
    {
        User user = userDao.registerUser(userInfo);
        if(user!=null)
            usersRegistry.addUser(user);
        else
            throw new RuntimeException("UserDao failed data access");
        return user;
    }
}
