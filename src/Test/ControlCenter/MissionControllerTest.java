package src.Test.ControlCenter;

import org.junit.Before;
import org.junit.Test;
import src.Main.ControlCenter.BusinessLogic.MissionController;
import src.Main.ControlCenter.DataAccess.IMissionDao;
import src.Main.ControlCenter.DataAccess.IRescueTeamsDao;
import src.Main.ControlCenter.Domain.Mission;
import src.Main.ControlCenter.Domain.MissionsList;
import src.Main.ControlCenter.Domain.RescueTeam;
import src.Test.ControlCenter.DummyDao.DummyMissionDao;
import src.Test.ControlCenter.DummyDao.DummyRescueTeamsDao;

public class MissionControllerTest
{
    IMissionDao missionDao = new DummyMissionDao();
    IRescueTeamsDao rescueTeamsDao = new DummyRescueTeamsDao();
    MissionController missionController = new MissionController(missionDao, rescueTeamsDao);

    Mission mission;
    @Before
    @Test
    public void createMission()
    {
        String missionId = missionController.createNewMission("test dispatch");
        mission = MissionsList.getInstance().getMission(missionId);
        assert mission!=null;
    }

    @Test
    public void assignMissionNoError()
    {
        RescueTeam team = new RescueTeam(3450);
        missionController.assignTeam(mission, team, "KC02G");
    }

    @Test(expected = RuntimeException.class)
    public void assignMissionTeamBusy()
    {
        RescueTeam team = new RescueTeam(3450);
        missionController.assignTeam(mission, team, "KC02G");
        missionController.assignTeam(new Mission("03/23/1999", "dispatch2"), team, "KC02G");
    }

    @Test
    public void updateDispatch()
    {
        RescueTeam team = new RescueTeam(3450);
        missionController.assignTeam(mission, team, "KC02G");
        missionController.updateDispatch(mission, "test dispatch2");
        assert mission.getDispatch().equals("test dispatch2");
    }
}
