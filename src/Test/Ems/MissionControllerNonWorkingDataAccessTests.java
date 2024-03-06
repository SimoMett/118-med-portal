package src.Test.Ems;

import com.sun.jdi.InvalidTypeException;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import src.Main.Ems.BusinessLogic.MissionController;
import src.Main.Ems.Domain.Mission.*;
import src.Main.Ems.Domain.Session;
import src.Test.Ems.DummyDao.NonWorkingMissionDao;

import src.Main.Ems.Domain.Mission.BLSReportFactory.BLSFields;

public class MissionControllerNonWorkingDataAccessTests
{
    private final NonWorkingMissionDao missionDao = new NonWorkingMissionDao();
    private MissionReport report;
    private MissionController missionController;

    @Before
    public void init() throws IllegalAccessException
    {
        Session.init(Session.Mode.BLS);
        IMissionReportFactory reportFactory = new BLSReportFactory();
        report = reportFactory.createReportModel("03/24/1");
        missionController = new MissionController(missionDao, report);
        missionController.updateData(BLSFields.SKIN_COLOR.name(), "pale");
    }

    @Test
    public void correctKeyUpdateData() throws InvalidTypeException, IllegalAccessException
    {
        missionController.updateData(BLSFields.CHEST_PAIN.name(), "true");
        DataField data = missionDao.getMissionData(report, BLSFields.CHEST_PAIN.name());
        if(data instanceof SimpleDataField)
            throw new InvalidTypeException(BLSFields.CHEST_PAIN.name()+" attribute somehow is initialized");
        data = missionController.get(BLSFields.CHEST_PAIN.name());
        assert data.getValue().equals("true");

    }

    @Test(expected = IllegalArgumentException.class)
    public void invalidKeyUpdateData() throws IllegalAccessException
    {
        missionController.updateData("INVALID_KEY", "true");
    }

    @Test(expected = IllegalArgumentException.class)
    public void accessInvalidKey()
    {
        missionController.get("INVALID_KEY");
    }

    @Test
    public void accessingClosedMission()
    {
        missionController.closeMission();
        SimpleDataField data = (SimpleDataField) missionController.get(BLSReportFactory.BLSFields.SKIN_COLOR.name());
        assert data.getValue().equals("pale");
    }

    @Test(expected = IllegalAccessException.class)
    public void editingClosedMission() throws IllegalAccessException
    {
        missionController.closeMission();
        missionController.updateData(BLSReportFactory.BLSFields.SKIN_COLOR.name(), "reddish");
    }

    @Test
    public void saveReport()
    {
        assert !missionController.saveReport();
    }

    @After
    public void stopSession()
    {
        Session.destroy();
    }
}
