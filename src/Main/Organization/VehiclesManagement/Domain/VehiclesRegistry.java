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
    public Vehicle getVehicle(int id)
    {
        //TODO error management
        return vehicles.get(id);
    }

    public List<Vehicle> getAllVehicles()
    {
        return Collections.unmodifiableList(vehicles);
    }

    public void updateInfo(int id, Object key, Object val)
    {
        //TODO error management
        Vehicle vehicle = vehicles.get(id);
        vehicle.updateInfo(key, val);
    }

    public void deleteVehicle(int id)
    {
        this.vehicles.remove(id);
    }
}
