package src.Main.Organization.VehiclesManagement.Domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class VehiclesRegistry
{
    private final ArrayList<Vehicle> vehicles;

    public VehiclesRegistry()
    {
        this.vehicles = new ArrayList<>();
    }
    public void addVehicle(Vehicle vehicle)
    {
        if(!vehicles.contains(vehicle))
            vehicles.add(vehicle);
    }
    public Vehicle getVehicle(int id) throws NullPointerException
    {
        return vehicles.get(id);
    }

    public List<Vehicle> getAllVehicles()
    {
        return Collections.unmodifiableList(vehicles);
    }

    public void updateInfo(int id, String key, String val) throws NullPointerException
    {
        vehicles.get(id).updateInfo(key, val);
    }

    public void deleteVehicle(int id)
    {
        this.vehicles.remove(id);
    }

    public void deleteVehicle(Vehicle vehicle)
    {
        this.vehicles.remove(vehicle);
    }
}
