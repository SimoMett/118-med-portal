package src.Test.Ems.DummyDao;

import src.Main.Ems.ORM.IMissionDao;
import src.Main.Ems.Domain.Mission.DataField.DataField;
import src.Main.Ems.Domain.Mission.Factory.IMissionReportFactory;
import src.Main.Ems.Domain.Mission.MissionReport;
import src.Main.Ems.Domain.RescueTeam.User;
import src.Main.Ems.Domain.Session;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import static src.Test.TestsConstants.DEFAULT_DISPATCH;

public class DummyMissionDao implements IMissionDao
{
    private final ArrayList<MissionReport> storage = new ArrayList<>(1);
    @Override
    public MissionReport getReceivedMission(IMissionReportFactory factory)
    {
        Random random = new Random();
        MissionReport report = factory.createReportModel("03/24/"+random.nextInt(10000,90000));
        report.updateDispatch(DEFAULT_DISPATCH);
        //TODO update patient data if available
        return report;
    }

    @Override
    public List<MissionReport> getAllActiveMissionsOfUser(User user)
    {
        return null;
    }

    @Override
    public boolean updateMissionData(MissionReport missionReport, String key, Object val)
    {
        return true;
    }

    @Override
    public DataField getMissionData(MissionReport missionReport, String key)
    {
        return missionReport.getData(key);
    }

    @Override
    public boolean closeMission(MissionReport missionReport)
    {
        missionReport.close();
        return true;
    }

    @Override
    public boolean sendMissionReport(MissionReport missionReport)
    {
        return storage.add(missionReport);
    }

    public static class FakeSession extends Session
    {
        private IMissionDao missionDao;
        public FakeSession(Mode mode, IMissionDao fakeMissionDao)
        {
            super(mode);
            this.missionDao = fakeMissionDao;
        }

        public IMissionDao getMissionDao()
        {
            return missionDao;
        }

        public String getTeamId()
        {
            return "3451";
        }
    }
    public static FakeSession fakeSession;

    @Override
    public boolean sendPatientData(String teamId, DataField patientData)
    {
        //for sake of simplicity, send patient data to the device of the team with such teamId
        //i.e. somehow invoke their IMissionDao.acceptPatientData(patientData)
        return fakeSession.getMissionDao().acceptPatientData(patientData.toString());
    }

    @Override
    public boolean acceptPatientData(String patientData)
    {
        boolean success = false;
        try
        {
            fakeSession.getCurrentMission().updateData(IMissionReportFactory.CommonFields.TAX_ID.name(), patientData);
            success = true;
        }
        catch (IllegalAccessException e)
        {
            e.printStackTrace();
        }
        return success;
    }
}
