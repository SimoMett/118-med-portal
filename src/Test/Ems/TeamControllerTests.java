package src.Test.Ems;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import src.Main.Ems.BusinessLogic.TeamController;
import src.Main.Ems.Domain.RescueTeam.Vehicle;
import src.Main.Ems.Domain.Session;
import src.Main.Ems.Domain.VehiclesList;
import src.Test.Ems.DummyDao.DummyTeamDao;
import src.Test.Ems.DummyDao.DummyVehicleDao;

public class TeamControllerTests
{
    @Before
    public void initSession()
    {
        Session.init(Session.Mode.BLS);
    }

    @Test
    public void changeVehicle()
    {
        TeamController teamController = new TeamController(Session.instance().getTeam());
        DummyVehicleDao dummyVehicleDao = new DummyVehicleDao();
        DummyTeamDao dummyTeamDao = new DummyTeamDao();
        Session.instance().getTeam().addObserver(dummyTeamDao);
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

    @After
    public void stopSession()
    {
        Session.destroy();
    }
}
