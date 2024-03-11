package src.Main.Organization.VehiclesManagement.BusinessLogic;

import src.Main.Organization.VehiclesManagement.DataAccess.IVehicleDao;
import src.Main.Organization.VehiclesManagement.Domain.Vehicle;
import src.Main.Organization.VehiclesManagement.Domain.VehiclesRegistry;
import src.Main.Organization.VehiclesManagement.VehicleInfo;

import java.util.List;

public class VehicleController
{
    private final IVehicleDao vehicleDao;
    private final VehiclesRegistry vehiclesRegistry;

    public VehicleController(IVehicleDao vehicleDao)
    {
        this.vehicleDao = vehicleDao;
        this.vehiclesRegistry = vehicleDao.getVehiclesRegistry();
    }

    public VehicleInfo getVehicleInfo(int id) throws NullPointerException
    {
        return this.vehiclesRegistry.getVehicle(id).getInfo();
    }
    public void updateVehicleInfo(int id, String key, String val) throws RuntimeException
    {
        Vehicle v = this.vehiclesRegistry.getVehicle(id);
        if(!this.vehicleDao.updateVehicleData(v, key, val))
            throw new RuntimeException("Dao error");
    }
    public void deleteVehicle(int id) throws RuntimeException
    {
        Vehicle v = vehiclesRegistry.getVehicle(id);
        if(!this.vehicleDao.deleteVehicle(v))
            throw new RuntimeException("Dao error");
    }
    public List<Vehicle> getAllVehicles()
    {
        return this.vehiclesRegistry.getAllVehicles();
    }
}
