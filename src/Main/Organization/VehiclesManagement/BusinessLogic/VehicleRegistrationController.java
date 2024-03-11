package src.Main.Organization.VehiclesManagement.BusinessLogic;

import src.Main.Organization.VehiclesManagement.DataAccess.IVehicleDao;
import src.Main.Organization.VehiclesManagement.Domain.Vehicle;
import src.Main.Organization.VehiclesManagement.Domain.VehiclesRegistry;
import src.Main.Organization.VehiclesManagement.VehicleInfo;

public class VehicleRegistrationController
{
    private final IVehicleDao vehicleDao;
    private final VehiclesRegistry vehiclesRegistry;
    public VehicleRegistrationController(IVehicleDao vehicleDao)
    {
        this.vehicleDao = vehicleDao;
        this.vehiclesRegistry = vehicleDao.getVehiclesRegistry();
    }
    public Vehicle registerNewVehicle(VehicleInfo vehicleInfo)
    {
        Vehicle v = vehicleDao.registerNewVehicle(vehicleInfo);
        if(v != null)
            vehiclesRegistry.addVehicle(v);
        return v;
    }
}
