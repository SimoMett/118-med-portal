package src.Test.Ems.DummyDao;

import src.Main.Ems.DataAccess.IMissionDao;
import src.Main.Ems.Domain.Mission.DataField;
import src.Main.Ems.Domain.Mission.IMissionReportFactory;
import src.Main.Ems.Domain.Mission.MissionReport;
import src.Main.Ems.Domain.RescueTeam.User;

import java.util.List;

public class DummyMissionDao implements IMissionDao
{

    @Override
    public MissionReport getReceivedMission(IMissionReportFactory factory) {
        return null;
    }

    @Override
    public List<MissionReport> getAllActiveMissionsOfUser(User user) {
        return null;
    }

    @Override
    public boolean updateMissionData(MissionReport missionReport, String key, Object val)
    {
        return false;
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
        return false;
    }

    @Override
    public boolean sendMissionReport(MissionReport missionReport) {
        return false;
    }
}
