package src.Test.Ems;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import src.Main.Ems.BusinessLogic.MissionsListController;
import src.Main.Ems.Domain.Mission.MissionReport;
import src.Main.Ems.Domain.Session;
import src.Test.Ems.DummyDao.DummyMissionDao;

public class MissionsListControllerTests
{
    private final DummyMissionDao missionDao = new DummyMissionDao();
    private MissionsListController missionsListController;
    private static String MISSION_ID = "03/24/888";

    @Before
    public void init()
    {
        Session.init(Session.Mode.DRIVER);
        missionsListController = new MissionsListController(missionDao,Session.instance().getMissionsList());
        Session.instance().getMissionsList().add(new MissionReport(MISSION_ID, MissionReport.ReportType.DRIVER));
    }

    @Test
    public void openMission()
    {
        assert missionsListController.openMission(MISSION_ID)!=null;
    }

    @Test
    public void receiveMission()
    {
        assert missionsListController.openReceivedMission()!=null;
    }

    @After
    public void stopSession()
    {
        Session.destroy();
    }
}
