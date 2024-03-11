package src.Test.Organization.DummyDao;

import src.Main.Organization.VehiclesManagement.DataAccess.IVehicleDao;
import src.Main.Organization.VehiclesManagement.Domain.Vehicle;
import src.Main.Organization.VehiclesManagement.Domain.VehiclesRegistry;
import src.Main.Organization.VehiclesManagement.VehicleInfo;

import java.util.ArrayList;

public class DummyVehicleDao implements IVehicleDao
{
    private final VehiclesRegistry vehiclesRegistry = new VehiclesRegistry();
    @Override
    public Vehicle registerNewVehicle(VehicleInfo vehicleInfo)
    {
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
    public boolean updateVehicleData(Vehicle vehicle, Object key, Object val)
    {
        return false;
    }

    @Override
    public boolean deleteVehicle(Vehicle vehicle)
    {
        return false;
    }

    @Override
    public VehiclesRegistry getVehiclesRegistry()
    {
        return vehiclesRegistry;
    }
}
