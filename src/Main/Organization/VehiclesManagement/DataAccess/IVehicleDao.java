package src.Main.Organization.VehiclesManagement.DataAccess;

import src.Main.Organization.VehiclesManagement.BusinessLogic.VehicleInfo;
import src.Main.Organization.VehiclesManagement.Domain.Vehicle;
import src.Main.Organization.VehiclesManagement.Domain.VehiclesRegistry;

public interface IVehicleDao
{
    public Vehicle registerNewVehicle(VehicleInfo vehicleInfo);
    public VehicleInfo getVehicleInfo(Vehicle vehicle);
    public boolean updateVehicleData(Vehicle vehicle, Object key, Object val);//FIXME types
    public boolean deleteVehicle(Vehicle vehicle);
    public VehiclesRegistry getVehiclesRegistry();
}
