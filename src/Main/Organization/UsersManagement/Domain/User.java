package src.Main.Organization.UsersManagement.Domain;

import src.Main.Organization.UsersManagement.BusinessLogic.UserInfo;

import java.util.HashMap;

public class User
{
    private final HashMap<Object, Object> attributesMap;
    private Object certificates;
    public User()
    {
        this.attributesMap = new HashMap<>();
        this.certificates = null;
    }
    public UserInfo getInfo()
    {
        return null;//TODO
    }

    public Object getCertificates()
    {
        return null;
    }

    public void updateInfo(Object key, Object val)
    {

    }

    public void storeCertificates(Object certificates)
    {

    }
}
