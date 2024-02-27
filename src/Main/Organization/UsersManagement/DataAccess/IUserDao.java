package src.Main.Organization.UsersManagement.DataAccess;

import src.Main.Organization.UsersManagement.UserInfo;
import src.Main.Organization.UsersManagement.Domain.User;
import src.Main.Organization.UsersManagement.Domain.UsersRegistry;

import java.util.ArrayList;

public interface IUserDao
{
    User registerUser(UserInfo userInfo);
    boolean updateInfo(User user, Object key, Object val);
    Object getUserCertificates(User user);
    ArrayList<User> searchUser(Object how);
    boolean deleteUser(User user);
    UsersRegistry getUsersRegistry();
}
