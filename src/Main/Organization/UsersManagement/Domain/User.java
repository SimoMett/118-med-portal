package src.Main.Organization.UsersManagement.Domain;

import src.Main.Organization.UsersManagement.UserInfo;

import java.util.HashMap;

public class User
{
    private final HashMap<String, String> attributesMap;
    private UserInfo info;
    private Object certificates;
    public User(UserInfo info)
    {
        this.attributesMap = new HashMap<>();
        this.info = info;
        attributesMap.put("name", info.name());
        attributesMap.put("registryCode", info.registryCode());
        attributesMap.put("dateOfBirth", info.dateOfBirth());
        this.certificates = null;
    }
    public UserInfo getInfo()
    {
        return info;
    }

    public Object getCertificates()
    {
        return null;
    }

    public void updateInfo(String key, String val) throws RuntimeException
    {
        attributesMap.replace(key, val);
        info = new UserInfo(attributesMap.get("name"), attributesMap.get("registryCode"), attributesMap.get("dateOfBirth"));
    }

    public void storeCertificates(Object certificates)
    {

    }
}
