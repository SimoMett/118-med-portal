package src.Test.Organization;

import org.junit.Test;
import src.Main.Organization.VehiclesManagement.BusinessLogic.VehicleController;
import src.Main.Organization.VehiclesManagement.BusinessLogic.VehicleRegistrationController;
import src.Main.Organization.VehiclesManagement.Domain.Vehicle;
import src.Main.Organization.VehiclesManagement.VehicleInfo;
import src.Test.Organization.DummyDao.DummyVehicleDao;

import java.util.List;

public class ControllerTests
{
    @Test
    public void vehicleControllersTests()
    {
        final DummyVehicleDao vehicleDao = new DummyVehicleDao();
        final VehicleRegistrationController vehicleRegistrationController = new VehicleRegistrationController(vehicleDao);

        //vehicle registration test
        Vehicle v = vehicleRegistrationController.registerNewVehicle(new VehicleInfo("4157", "AA111AA", "112857"));
        final VehicleController vehicleController = new VehicleController(vehicleDao);
        List<Vehicle> vehicleList = vehicleController.getAllVehicles();
        assert vehicleList.contains(v);

        //get vehicle info test
        VehicleInfo vInfo = vehicleController.getVehicleInfo(vehicleList.indexOf(v));
        System.out.println(vInfo);
        assert vInfo.equals(new VehicleInfo("4157", "AA111AA", "112857"));

        //update info test
        vehicleController.updateVehicleInfo(vehicleList.indexOf(v), "radioid", "113857");
    }

    public void userControllersTests()
    {

    }

    public void reportsControllerTests()
    {

    }
}
