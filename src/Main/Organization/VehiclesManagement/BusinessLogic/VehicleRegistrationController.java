package src.Main.Organization.VehiclesManagement.BusinessLogic;

import src.Main.Organization.VehiclesManagement.ORM.IVehicleDao;
import src.Main.Organization.VehiclesManagement.Domain.Vehicle;
import src.Main.Organization.VehiclesManagement.Domain.VehiclesRegistry;
import src.Main.Organization.VehiclesManagement.VehicleInfo;

public class VehicleRegistrationController
{
    private final IVehicleDao vehicleDao;
    private final VehiclesRegistry vehiclesRegistry;

    public VehicleRegistrationController(IVehicleDao vehicleDao, VehiclesRegistry vehiclesRegistry)
    {
        this.vehicleDao = vehicleDao;
        this.vehiclesRegistry = vehiclesRegistry;
    }

    public Vehicle registerNewVehicle(VehicleInfo vehicleInfo)
    {
        Vehicle v = vehicleDao.registerNewVehicle(vehicleInfo);
        if(v != null)
            vehiclesRegistry.addVehicle(v);
        else
            throw new RuntimeException("VehicleDao failed data access");
        return v;
    }
}
