package src.Main.Organization.UsersManagement.Domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

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
        return users.get(id);
    }

    public int getUserId(User u)
    {
        for(int i=0; i<users.size(); i++)
        {
            if(users.get(i).getInfo().equals(u.getInfo()))
                return i;
        }
        return -1;
    }

    public void updateUserInfo(int id, String key, String val)
    {
        User u = users.get(id);
        u.updateInfo(key, val);
    }

    public void updateUserInfo(User user, String key, String val) throws RuntimeException
    {
        if(users.contains(user))
            user.updateInfo(key, val);
        else
            throw new RuntimeException("Unknown user");
    }

    public void deleteUser(int id)
    {
        users.remove(id);
    }

    public List<User> getAllUsers()
    {
        return Collections.unmodifiableList(users);
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
