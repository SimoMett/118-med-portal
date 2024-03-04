package src.Main.Ems.DataAccess;

import src.Main.Ems.Domain.Mission.IMissionReportFactory;
import src.Main.Ems.Domain.Mission.MissionReport;
import src.Main.Ems.Domain.RescueTeam.User;

import java.util.List;

public interface IMissionDao
{
    MissionReport getReceivedMission(IMissionReportFactory factory);
    List<MissionReport> getAllActiveMissionsOfUser(User user);
    boolean updateMissionData(MissionReport missionReport, Object key, Object val);
    boolean closeMission(MissionReport missionReport);
    boolean sendMissionReport(MissionReport missionReport);
}
