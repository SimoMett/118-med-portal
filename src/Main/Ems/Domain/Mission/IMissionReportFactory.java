package src.Main.Ems.Domain.Mission;

public interface IMissionReportFactory
{
    MissionReport createReportModel(Object missionId);//missionId should be put into the MissionReport
}
