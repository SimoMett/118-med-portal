package src.Main.Organization.VehiclesManagement.BusinessLogic;

import src.Main.Organization.VehiclesManagement.DataAccess.IVehicleDao;
import src.Main.Organization.VehiclesManagement.Domain.Vehicle;
import src.Main.Organization.VehiclesManagement.Domain.VehiclesRegistry;
import src.Main.Organization.VehiclesManagement.VehicleInfo;

import java.util.ArrayList;

public class VehicleController
{
    private final IVehicleDao vehicleDao;
    private final VehiclesRegistry vehiclesRegistry;

    public VehicleController(IVehicleDao vehicleDao)
    {
        this.vehicleDao = vehicleDao;
        this.vehiclesRegistry = vehicleDao.getVehiclesRegistry();
    }

    public VehicleInfo getVehicleInfo(int index)
    {
        //TODO error management
        return this.vehiclesRegistry.getVehicle(index).getInfo();
    }
    public void updateVehicleInfo(int id, Object key, Object val)
    {
        //TODO error management
        Vehicle v = this.vehiclesRegistry.getVehicle(id);
        if(this.vehicleDao.updateVehicleData(v, key, val)) //   if updates on database is successful ...
            this.vehiclesRegistry.updateInfo(id, key, val); //      ... update domain model
    }
    public void deleteVehicle(int id)
    {
        //TODO error management
        Vehicle v = vehiclesRegistry.getVehicle(id);
        if(this.vehicleDao.deleteVehicle(v))
            vehiclesRegistry.deleteVehicle(id);
    }
    public void showAllVehicles()
    {
        //Dumb front-end
        ArrayList<Vehicle> vehiclesList = this.vehiclesRegistry.getAllVehicles();
        for (int i = 0; i < vehiclesList.size(); i++)
            System.out.println("[" + i + "] " + vehiclesList.get(i).getInfo().numberPlate());
    }
}
