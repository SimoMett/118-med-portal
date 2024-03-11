package src.Test.Organization;

import org.junit.Test;
import src.Main.Organization.VehiclesManagement.BusinessLogic.VehicleController;
import src.Main.Organization.VehiclesManagement.BusinessLogic.VehicleRegistrationController;
import src.Main.Organization.VehiclesManagement.Domain.Vehicle;
import src.Main.Organization.VehiclesManagement.VehicleInfo;
import src.Test.Organization.DummyDao.DummyVehicleDao;

public class ControllerTests
{
    @Test
    public void vehicleControllersTests()
    {
        final DummyVehicleDao vehicleDao = new DummyVehicleDao();
        final VehicleRegistrationController vehicleRegistrationController = new VehicleRegistrationController(vehicleDao);

        Vehicle v = vehicleRegistrationController.registerNewVehicle(new VehicleInfo(4157, "AA111AA", 112857));

        final VehicleController vehicleController = new VehicleController(vehicleDao);
        assert vehicleController.getAllVehicles().contains(v);
    }

    public void userControllersTests()
    {

    }

    public void reportsControllerTests()
    {

    }
}
