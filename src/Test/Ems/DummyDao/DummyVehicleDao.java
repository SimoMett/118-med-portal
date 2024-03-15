package src.Test.Ems.DummyDao;

import src.Main.Ems.DataAccess.IVehicleDao;
import src.Main.Ems.Domain.RescueTeam.Vehicle;
import src.Main.Ems.Domain.VehiclesList;

public class DummyVehicleDao implements IVehicleDao
{
    @Override
    public void updateVehiclesList(VehiclesList vehiclesList)
    {
        vehiclesList.drop();
        vehiclesList.add(new Vehicle("AA111AA", "BRAVO4157", "112857", "MSB"));
        vehiclesList.add(new Vehicle("BB222BB", "BRAVO4158", "112858", "MSB"));
        vehiclesList.add(new Vehicle("CC333CC", "BRAVO4159", "112859", "MSB"));
        vehiclesList.add(new Vehicle("DD444DD", "BRAVO4156", "112856", "MSB"));
        vehiclesList.add(new Vehicle("EE555EE", "INDIA01", "123456", "MSI"));
    }
}
