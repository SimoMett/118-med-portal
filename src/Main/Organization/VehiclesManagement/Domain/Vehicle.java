package src.Main.Organization.VehiclesManagement.Domain;

import src.Main.Organization.VehiclesManagement.VehicleInfo;

import java.util.HashMap;

public class Vehicle
{
    private final HashMap<Object, Object> attributesMap;
    public Vehicle()
    {
        this.attributesMap = new HashMap<>();
    }

    public VehicleInfo getInfo()
    {
        return null;//
    }
    public void updateInfo(Object key, Object val)
    {
        attributesMap.put(key, val);
    }
}
