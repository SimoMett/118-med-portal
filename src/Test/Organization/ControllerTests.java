package src.Test.Organization;

import org.junit.Test;
import src.Main.Organization.VehiclesManagement.BusinessLogic.VehicleController;
import src.Main.Organization.VehiclesManagement.BusinessLogic.VehicleRegistrationController;
import src.Main.Organization.VehiclesManagement.Domain.Vehicle;
import src.Main.Organization.VehiclesManagement.Domain.VehiclesRegistry;
import src.Main.Organization.VehiclesManagement.VehicleInfo;
import src.Test.Organization.DummyDao.DummyVehicleDao;

import java.util.List;

public class ControllerTests
{
    @Test
    public void vehicleControllersTests()
    {
        final VehiclesRegistry vehiclesRegistry = new VehiclesRegistry();
        final DummyVehicleDao vehicleDao = new DummyVehicleDao(vehiclesRegistry);
        final VehicleRegistrationController vehicleRegistrationController = new VehicleRegistrationController(vehicleDao, vehiclesRegistry);
        final VehicleController vehicleController = new VehicleController(vehicleDao);

        //vehicle registration test
        Vehicle v = vehicleRegistrationController.registerNewVehicle(new VehicleInfo("4157", "AA111AA", "112857"));
        List<Vehicle> vehicleList = vehicleController.getAllVehicles();
        assert vehicleList.contains(v);

        //get vehicle info test
        int vId = vehicleList.indexOf(v);
        VehicleInfo vInfo = vehicleController.getVehicleInfo(vId);
        System.out.println(vInfo);
        assert vInfo.equals(new VehicleInfo("4157", "AA111AA", "112857"));

        //update info test
        vehicleController.updateVehicleInfo(vId, "radioId", "113857");
        vInfo = vehicleController.getVehicleInfo(vId);
        assert vInfo.equals(new VehicleInfo("4157", "AA111AA", "113857"));

        //delete vehicle test
        vehicleController.deleteVehicle(vId);
        assert !vehicleList.contains(v);
    }

    public void userControllersTests()
    {

    }

    public void reportsControllerTests()
    {

    }
}
