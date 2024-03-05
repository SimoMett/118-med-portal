package src.Main.Ems.Domain;

import src.Main.Ems.Domain.RescueTeam.Vehicle;

import java.util.ArrayList;
import java.util.Iterator;

public class VehiclesList implements Iterable<Vehicle>
{
    private ArrayList<Vehicle> vehiclesList;

    public VehiclesList()
    {
        this.vehiclesList = new ArrayList<>();
    }

    public void drop()
    {
        vehiclesList = new ArrayList<>();
    }

    public int size()
    {
        return vehiclesList.size();
    }

    public void add(Vehicle vehicle)
    {
        vehiclesList.add(vehicle);
    }

    public Vehicle get(int index)
    {
        return vehiclesList.get(index);
    }

    @Override
    public Iterator<Vehicle> iterator()
    {
        return vehiclesList.iterator();
    }
}
