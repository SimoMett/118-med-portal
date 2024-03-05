package src.Test.Ems;

import org.junit.Before;
import org.junit.Test;
import src.Main.Ems.BusinessLogic.MissionController;
import src.Main.Ems.Domain.Mission.BLSReportFactory;
import src.Main.Ems.Domain.Mission.IMissionReportFactory;
import src.Main.Ems.Domain.Mission.MissionReport;
import src.Test.Ems.DummyDao.DummyMissionDao;

public class MissionControllerTests
{
    private final DummyMissionDao missionDao = new DummyMissionDao();
    private MissionReport report;
    private MissionController missionController;

    @Before
    public void init()
    {
        IMissionReportFactory reportFactory = new BLSReportFactory();
        report = reportFactory.createReportModel("03/24/1");
        missionController = new MissionController(missionDao, report);
    }

    @Test
    public void updateData()
    {

    }
}
