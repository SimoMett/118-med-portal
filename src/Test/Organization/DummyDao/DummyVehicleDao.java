package src.Test.Organization.DummyDao;

import src.Main.Organization.VehiclesManagement.DataAccess.IVehicleDao;
import src.Main.Organization.VehiclesManagement.Domain.Vehicle;
import src.Main.Organization.VehiclesManagement.Domain.VehiclesRegistry;
import src.Main.Organization.VehiclesManagement.VehicleInfo;


public class DummyVehicleDao implements IVehicleDao
{
    private final VehiclesRegistry vehiclesRegistry;

    public DummyVehicleDao(VehiclesRegistry vehiclesRegistry)
    {
        this.vehiclesRegistry = vehiclesRegistry;
    }
    @Override
    public Vehicle registerNewVehicle(VehicleInfo vehicleInfo)
    {
        //create vehicle in database (assuming successful)
        Vehicle v = new Vehicle(vehicleInfo);
        vehiclesRegistry.addVehicle(v);
        return v;
    }

    @Override
    public VehicleInfo getVehicleInfo(Vehicle vehicle)
    {
        return null;
    }

    @Override
    public boolean updateVehicleData(Vehicle vehicle, String key, String val)
    {
        // update info in database (assuming vehicle is present)
        vehiclesRegistry.updateInfo(vehiclesRegistry.getAllVehicles().indexOf(vehicle), key, val);
        return true;
    }

    @Override
    public boolean deleteVehicle(Vehicle vehicle)
    {
        //removing vehicle from database (assuming successful)
        vehiclesRegistry.deleteVehicle(vehicle);
        return true;
    }

    @Override
    public VehiclesRegistry getVehiclesRegistry()
    {
        return vehiclesRegistry;
    }
}
