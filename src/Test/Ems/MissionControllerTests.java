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
import src.Test.Ems.DummyDao.DummyMissionDao;

import src.Main.Ems.Domain.Mission.Factory.BLSReportFactory.BLSFields;

public class MissionControllerTests
{
    private final DummyMissionDao missionDao = new DummyMissionDao();
    private MissionReport report;
    private MissionController missionController;

    @Before
    public void init() throws IllegalAccessException
    {
        Session.init(Session.Mode.BLS);
        IMissionReportFactory reportFactory = Session.instance().getReportFactory();
        report = reportFactory.createReportModel("03/24/1");
        missionController = new MissionController(missionDao, report);
        Session.instance().setCurrentMission(report);
        missionController.updateData(BLSFields.SKIN_COLOR.name(), "pale");
    }

    @Test
    public void correctKeyUpdateData() throws InvalidTypeException, IllegalAccessException
    {
        missionController.updateData(BLSFields.CHEST_PAIN.name(), String.valueOf(true));
        DataField data = missionDao.getMissionData(report, BLSFields.CHEST_PAIN.name());
        if(data instanceof SimpleDataField simpleData)
            assert simpleData.getValue().equals(String.valueOf(true));
        else
            throw new InvalidTypeException(BLSFields.CHEST_PAIN.name()+" attribute is not a string");
    }

    @Test(expected = IllegalArgumentException.class)
    public void invalidKeyUpdateData() throws IllegalAccessException
    {
        missionController.updateData("INVALID_KEY", String.valueOf(true));
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
        SimpleDataField data = (SimpleDataField) missionController.get(BLSFields.SKIN_COLOR.name());
        assert data.getValue().equals("pale");
    }

    @Test(expected = IllegalAccessException.class)
    public void editingClosedMission() throws IllegalAccessException
    {
        missionController.closeMission();
        missionController.updateData(BLSFields.SKIN_COLOR.name(), "reddish");
    }

    @Test
    public void saveReport()
    {
        assert missionController.saveReport();
    }

    @Test(expected = NullPointerException.class)
    public void patientDataSharingException()
    {
        //should throw exception because the receivingTeam has not been assign to the mission, therefore cannot receive patient data

        assert missionController.sendPatientData("3451");
    }

    @Test
    public void patientDataSharing()
    {
        //fake stuff
        DummyMissionDao.FakeSession receivingTeamSession = new DummyMissionDao.FakeSession(Session.Mode.BLS, new DummyMissionDao());
        receivingTeamSession.setCurrentMission(report);
        DummyMissionDao.fakeSession = receivingTeamSession;
        //

        assert missionController.sendPatientData(receivingTeamSession.getTeamId());
    }

    @After
    public void stopSession()
    {
        Session.destroy();
    }
}
