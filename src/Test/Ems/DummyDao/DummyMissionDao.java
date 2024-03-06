package src.Test.Ems.DummyDao;

import src.Main.Ems.DataAccess.IMissionDao;
import src.Main.Ems.Domain.Mission.DataField;
import src.Main.Ems.Domain.Mission.IMissionReportFactory;
import src.Main.Ems.Domain.Mission.MissionReport;
import src.Main.Ems.Domain.RescueTeam.User;

import java.util.List;
import java.util.Random;

public class DummyMissionDao implements IMissionDao
{

    @Override
    public MissionReport getReceivedMission(IMissionReportFactory factory)
    {
        Random random = new Random();
        MissionReport report = factory.createReportModel("03/24/"+random.nextInt(10000,90000));
        report.updateDispatch("Male, 65, chest pain, several heart deseases. First floor of grand mall");
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
    public boolean sendMissionReport(MissionReport missionReport) {
        return false;
    }
}
