package src.Test.Ems;

import com.sun.jdi.InvalidTypeException;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import src.Main.Ems.BusinessLogic.MissionController;
import src.Main.Ems.Domain.Mission.*;
import src.Main.Ems.Domain.Mission.DataField.DataField;
import src.Main.Ems.Domain.Mission.DataField.SimpleDataField;
import src.Main.Ems.Domain.Mission.Factory.BLSReportFactory;
import src.Main.Ems.Domain.Mission.Factory.IMissionReportFactory;
import src.Main.Ems.Domain.Session;
import src.Test.Ems.DummyDao.NonWorkingMissionDao;

import src.Main.Ems.Domain.Mission.Factory.BLSReportFactory.BLSFields;

public class MissionControllerNonWorkingDataAccessTests
{
    private final NonWorkingMissionDao missionDao = new NonWorkingMissionDao();
    private MissionReport report;
    private MissionController missionController;

    @Before
    public void init() throws IllegalAccessException
    {
        try
        {
            Session.init(Session.Mode.BLS);
            IMissionReportFactory reportFactory = Session.instance().getReportFactory();
            report = reportFactory.createReportModel("03/24/1");
            missionController = new MissionController(missionDao, report);
            missionController.updateData(BLSFields.SKIN_COLOR.name(), "pale");
        }
        catch (RuntimeException e)
        {
            if(e.getMessage().equals("MissionDao failed data access"))
                System.out.println("MissionDao failed data access during init, nothing to worry about");
        }
    }

    @Test(expected = RuntimeException.class)
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

    @Test(expected = RuntimeException.class)
    public void accessingClosedMission()
    {
        missionController.closeMission();
        SimpleDataField data = (SimpleDataField) missionController.get(BLSReportFactory.BLSFields.SKIN_COLOR.name());
        assert data.getValue().equals("pale");
    }

    @Test(expected = IllegalAccessException.class)
    public void editingClosedMission() throws IllegalAccessException
    {
        try
        {
            missionController.closeMission();
        }
        catch (RuntimeException e)
        {
            if(e.getMessage().equals("MissionDao failed data access"))
                System.out.println("MissionDao failed data access during while trying to close a mission, nothing to worry about");
        }
        missionController.updateData(BLSReportFactory.BLSFields.SKIN_COLOR.name(), "reddish");
    }

    @Test(expected = RuntimeException.class)
    public void saveReport()
    {
        missionController.saveReport();
    }

    @After
    public void stopSession()
    {
        Session.destroy();
    }
}
