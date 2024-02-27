package src.Main.Organization.UsersManagement.Domain;

import java.util.ArrayList;

public class UsersRegistry
{
    private final ArrayList<User> users;

    public UsersRegistry()
    {
        this.users = new ArrayList<>();
    }
    public void addUser(User user)
    {
        if(!users.contains(user))
            users.add(user);
    }

    public User getUser(int id)
    {
        //TODO error management
        return users.get(id);
    }

    public void updateUserInfo(int id, Object key, Object val)
    {
        User u = users.get(id);
        u.updateInfo(key, val);
    }

    public void deleteUser(int id)
    {
        users.remove(id);
    }

    public ArrayList<User> searchUserByFilter(Object filter)
    {
        return null;
    }

    //not in uml
    public void deleteUser(User user)
    {
        users.remove(user);
    }
}
