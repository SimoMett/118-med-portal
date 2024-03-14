package src.Test.Ems;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import src.Main.Ems.BusinessLogic.Credentials;
import src.Main.Ems.BusinessLogic.TeamController;
import src.Main.Ems.BusinessLogic.UserLoginController;
import src.Main.Ems.ORM.LoginResult;
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

    private static final int DRIVER_INDEX = 0;
    private static final int LEADER_INDEX = 2;
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
        User user = members.get(LEADER_INDEX);
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
        User user = members.get(DRIVER_INDEX);
        System.out.println("Picked "+user.toString());
        Session.instance().getTeam().setDriver(user);

        assert dummyTeamDao.getRemoteTeam().getDriver().equals(user);
    }

    @Test
    public void logoutUser()
    {
        //first set driver and leader as in the previous tests
        List<User> members = Session.instance().getTeam().getMembers();
        Session.instance().getTeam().setDriver(members.get(DRIVER_INDEX));
        Session.instance().getTeam().setLeader(members.get(LEADER_INDEX));

        //print all logged users

        System.out.println("Members of the rescue team:");
        for (User u : members)
            System.out.println("\t"+u.toString());

        //logout all users one at the time
        User user = Session.instance().getTeam().getDriver();
        Session.instance().getTeam().removeRescuer(user);
        assert !dummyTeamDao.getRemoteTeam().getMembers().contains(user);
        assert dummyTeamDao.getRemoteTeam().getDriver() == null;

        user = Session.instance().getTeam().getLeader();
        Session.instance().getTeam().removeRescuer(user);
        assert !dummyTeamDao.getRemoteTeam().getMembers().contains(user);
        assert dummyTeamDao.getRemoteTeam().getLeader() == null;

        user = Session.instance().getTeam().getMembers().get(0);
        Session.instance().getTeam().removeRescuer(user);
        assert !dummyTeamDao.getRemoteTeam().getMembers().contains(user);

        user = Session.instance().getTeam().getMembers().get(0);
        Session.instance().getTeam().removeRescuer(user);
        assert !dummyTeamDao.getRemoteTeam().getMembers().contains(user);

    }

    @After
    public void stopSession()
    {
        Session.destroy();
    }
}
