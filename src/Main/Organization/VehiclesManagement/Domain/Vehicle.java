package src.Main.Organization.VehiclesManagement.Domain;

import src.Main.Organization.VehiclesManagement.VehicleInfo;

import java.util.HashMap;

public class Vehicle
{
    private final HashMap<String, String> attributesMap;
    private VehicleInfo info;
    public Vehicle(VehicleInfo info)
    {
        this.info = info;
        this.attributesMap = new HashMap<>();
        this.attributesMap.put("id", String.valueOf(info.id()));
        this.attributesMap.put("numberPlate", info.numberPlate());
        this.attributesMap.put("radioId", String.valueOf(info.radioId()));
    }

    public VehicleInfo getInfo()
    {
        return info;
    }
    public void updateInfo(String key, String val) throws RuntimeException
    {
        attributesMap.replace(key, val);
        info = new VehicleInfo(attributesMap.get("id"), attributesMap.get("numberPlate"), attributesMap.get("radioId"));
    }
}
