package src.Test.Ems;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import src.Main.Ems.BusinessLogic.Credentials;
import src.Main.Ems.BusinessLogic.TeamController;
import src.Main.Ems.BusinessLogic.UserLoginController;
import src.Main.Ems.DataAccess.LoginResult;
import src.Main.Ems.Domain.RescueTeam.User;
import src.Main.Ems.Domain.RescueTeam.Vehicle;
import src.Main.Ems.Domain.Session;
import src.Main.Ems.Domain.VehiclesList;
import src.Test.Ems.DummyDao.DummyTeamDao;
import src.Test.Ems.DummyDao.DummyUserDao;
import src.Test.Ems.DummyDao.DummyVehicleDao;

import java.util.List;

public class TeamControllerTests
{
    UserLoginController userLoginController = new UserLoginController(new DummyUserDao());
    private TeamController teamController;
    private DummyTeamDao dummyTeamDao;
    @Before
    public void initSession()
    {
        Session.init(Session.Mode.BLS);
        teamController = new TeamController(Session.instance().getTeam());
        dummyTeamDao = new DummyTeamDao();
        Session.instance().getTeam().addObserver(dummyTeamDao);

        //login of users
        LoginResult result;
        result = userLoginController.logInUser(new Credentials("mariorossi24", "RossiM123"));
        assert result.success;
        result = userLoginController.logInUser(new Credentials("giacomoverdi1", "giacomino"));
        assert result.success;
        result = userLoginController.logInUser(new Credentials("leonardo3", "leonardo123"));
        assert result.success;
        result = userLoginController.logInUser(new Credentials("raffaele29", "raffaele92"));
        assert result.success;
    }

    @Test
    public void changeVehicle()
    {
        DummyVehicleDao dummyVehicleDao = new DummyVehicleDao();
        VehiclesList vehiclesList = Session.instance().getAllVehicles();
        dummyVehicleDao.updateVehiclesList(vehiclesList);

        //display all vehicles
        System.out.println("Available vehicles:");
        for(Object v : vehiclesList)
        {
            System.out.println("\t"+v.toString());
        }

        //pick one vehicle at random
        int index = 4;
        Vehicle newVehicle = vehiclesList.get(index);
        System.out.println("Picked "+newVehicle.toString());

        //change vehicle
        teamController.changeVehicle(newVehicle);

        assert dummyTeamDao.getRemoteTeam().getVehicle().equals(newVehicle);
    }

    @Test
    public void setTeamLeader()
    {
        //print all logged users
        List<User> members = Session.instance().getTeam().getMembers();
        System.out.println("Members of the rescue team:");
        for (User u : members)
        {
            System.out.println("\t"+u.toString());
        }

        //pick random user
        User user = members.get(2);
        System.out.println("Picked "+user.toString());
        Session.instance().getTeam().setLeader(user);

        assert dummyTeamDao.getRemoteTeam().getLeader().equals(user);
    }

    @Test
    public void setTeamDriver()
    {
        //print all logged users
        List<User> members = Session.instance().getTeam().getMembers();
        System.out.println("Members of the rescue team:");
        for (User u : members)
        {
            System.out.println("\t"+u.toString());
        }

        //pick random user
        User user = members.get(0);
        System.out.println("Picked "+user.toString());
        Session.instance().getTeam().setDriver(user);

        assert dummyTeamDao.getRemoteTeam().getDriver().equals(user);
    }

    @After
    public void stopSession()
    {
        Session.destroy();
    }
}
