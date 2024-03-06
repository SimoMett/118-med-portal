package src.Test.Ems;

import org.junit.Before;
import org.junit.Test;
import src.Main.Ems.Domain.Mission.*;
import src.Main.Ems.Domain.Session;
import src.Test.Ems.DummyDao.DummyMissionDao;

public class MissionsListController
{
    private final DummyMissionDao missionDao = new DummyMissionDao();

    @Before
    public void init()
    {
        Session.init(Session.Mode.DRIVER);
    }

    @Test
    public void receiveMission()
    {
        IMissionReportFactory factory;
        switch (Session.instance().getMode())
        {
            case BLS -> factory = new BLSReportFactory();
            case ALS -> factory = new ALSReportFactory();
            default -> factory = new DriverReportFactory();
        }
        MissionReport report = missionDao.getReceivedMission(factory);
        assert report!=null;
    }
}
