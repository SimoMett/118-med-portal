package src.Main.Ems.DataAccess;

import src.Main.Ems.Domain.Mission.DataField.DataField;
import src.Main.Ems.Domain.Mission.Factory.IMissionReportFactory;
import src.Main.Ems.Domain.Mission.MissionReport;
import src.Main.Ems.Domain.RescueTeam.User;

import java.util.List;

public interface IMissionDao
{
    MissionReport getReceivedMission(IMissionReportFactory factory);
    List<MissionReport> getAllActiveMissionsOfUser(User user);
    boolean updateMissionData(MissionReport missionReport, String key, Object val);
    DataField getMissionData(MissionReport missionReport, String key);
    boolean closeMission(MissionReport missionReport);
    boolean sendMissionReport(MissionReport missionReport);
    boolean sendPatientData(String teamId, DataField patientData);
    boolean acceptPatientData(String patientData);
}
