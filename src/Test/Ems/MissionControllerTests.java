package src.Test.Ems;

import org.junit.Before;
import org.junit.Test;
import src.Main.Ems.BusinessLogic.MissionController;
import src.Main.Ems.Domain.Mission.BLSReportFactory;
import src.Main.Ems.Domain.Mission.IMissionReportFactory;
import src.Main.Ems.Domain.Mission.MissionReport;
import src.Main.Ems.Domain.Mission.SimpleDataField;
import src.Test.Ems.DummyDao.DummyMissionDao;

import src.Main.Ems.Domain.Mission.BLSReportFactory.BLSFields;

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
        missionController.updateData(BLSFields.SKIN_COLOR.name(), new SimpleDataField("pale"));
    }

    @Test
    public void correctKeyUpdateData()
    {
        missionController.updateData(BLSFields.CHEST_PAIN.name(), new SimpleDataField(String.valueOf(true)));
        SimpleDataField data = (SimpleDataField) missionDao.getMissionData(report, BLSFields.CHEST_PAIN.name());
        assert data.getValue().equals(String.valueOf(true));
    }

    @Test(expected = IllegalArgumentException.class)
    public void invalidKeyUpdateData()
    {
        missionController.updateData("INVALID_KEY", new SimpleDataField(String.valueOf(true)));
    }

    @Test(expected = IllegalArgumentException.class)
    public void accessInvalidKey()
    {
        missionDao.getMissionData(report, "INVALID_KEY");
    }

    @Test
    public void accessingClosedMission()
    {
        missionController.closeMission();
        SimpleDataField data = (SimpleDataField) missionController.get(BLSFields.SKIN_COLOR.name());
        assert data.getValue().equals("pale");
    }

    @Test(expected = Exception.class)
    public void editingClosedMission()
    {
        missionController.closeMission();
        missionController.updateData(BLSFields.SKIN_COLOR.name(), new SimpleDataField("reddish"));
    }
}
