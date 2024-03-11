package src.Main.Organization.VehiclesManagement.Domain;

import src.Main.Organization.VehiclesManagement.VehicleInfo;

import java.util.HashMap;

public class Vehicle
{
    private final HashMap<Object, Object> attributesMap;
    private VehicleInfo info;
    public Vehicle(VehicleInfo info)
    {
        this.info = info;
        this.attributesMap = new HashMap<>();
    }

    public VehicleInfo getInfo()
    {
        return info;
    }
    public void updateInfo(Object key, Object val)
    {
        attributesMap.put(key, val);
    }

    /*private void recreateHashMapFromInfo()
    {

    }*/
}
