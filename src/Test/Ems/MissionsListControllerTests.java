package src.Test.Ems;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import src.Main.Ems.BusinessLogic.MissionsListController;
import src.Main.Ems.Domain.Session;
import src.Test.Ems.DummyDao.DummyMissionDao;

public class MissionsListControllerTests
{
    private final DummyMissionDao missionDao = new DummyMissionDao();
    private MissionsListController missionsListController;

    @Before
    public void init()
    {
        Session.init(Session.Mode.DRIVER);
        missionsListController = new MissionsListController(missionDao,Session.instance().getMissionsList());
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
