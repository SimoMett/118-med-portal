package src.Main.Ems.Domain.Mission;

public interface IMissionReportFactory
{
    MissionReport createReportModel(String missionId);//missionId should be put into the MissionReport
}
