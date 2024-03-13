package src.Test.Organization;

import org.junit.Before;
import org.junit.Test;
import src.Main.Organization.UsersManagement.BusinessLogic.SearchFilters.SearchFilters;
import src.Main.Organization.UsersManagement.BusinessLogic.UserController;
import src.Main.Organization.UsersManagement.BusinessLogic.UserRegistrationController;
import src.Main.Organization.UsersManagement.Domain.User;
import src.Main.Organization.UsersManagement.Domain.UsersRegistry;
import src.Main.Organization.UsersManagement.UserInfo;
import src.Main.Organization.VehiclesManagement.BusinessLogic.VehicleController;
import src.Main.Organization.VehiclesManagement.BusinessLogic.VehicleRegistrationController;
import src.Main.Organization.VehiclesManagement.Domain.Vehicle;
import src.Main.Organization.VehiclesManagement.Domain.VehiclesRegistry;
import src.Main.Organization.VehiclesManagement.VehicleInfo;
import src.Test.Organization.DummyDao.DummyUserDao;
import src.Test.Organization.DummyDao.DummyVehicleDao;

import java.util.ArrayList;
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

    UsersRegistry usersRegistry = new UsersRegistry();
    DummyUserDao userDao = new DummyUserDao(usersRegistry);
    UserController userController = new UserController(userDao);

    @Before
    @Test
    public void userRegistrationTest()
    {
        UserRegistrationController userRegistrationController = new UserRegistrationController(userDao);

        User u = userRegistrationController.registerNewUser(new UserInfo("Mario Rossi", "asadwjfe2", "09/08/1985"));
        userRegistrationController.registerNewUser(new UserInfo("Giacomo Verdi", "fgsg332g", "13/08/1986"));
        userRegistrationController.registerNewUser(new UserInfo("Leonardo Da Vinci", "fwf3834f", "03/05/1987"));
        userRegistrationController.registerNewUser(new UserInfo("Raffaele Sanzio", "afnwje28", "02/08/1989"));
        userRegistrationController.registerNewUser(new UserInfo("Vincenzo Verdi", "fndjfim394", "16/09/1984"));
    }

    @Test
    public void userControllerTests()
    {
        //get info test
        User u = new User(new UserInfo("Mario Rossi", "asadwjfe2", "09/08/1985"));
        int uId = usersRegistry.getUserId(u);
        assert uId != -1;
        System.out.println(userController.getUserInfo(uId));
        assert userController.getUserInfo(uId)!=null;

        //search test
        ArrayList<User> results = userController.searchUser(SearchFilters.BY_NAME, "Verdi");
        assert !results.isEmpty();

        //delete user test
        userController.deleteUser(uId);
    }

    @Test(expected = RuntimeException.class)
    public void deleteInvalidUser()
    {
        //delete invalid user test
        userController.deleteUser(new User(new UserInfo("Tonio Trussardi", "tnattrue", "28/07/1970")));
    }
}
