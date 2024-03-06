package src.Main.Ems.Domain.Mission;

public class ALSReportFactory implements IMissionReportFactory
{
    public enum ALSFields
    {
        //TODO
    }

    private static void populate(MissionReport missionReport)
    {

    }

    @Override
    public MissionReport createReportModel(String missionId)
    {
        MissionReport missionReport = new MissionReport(missionId, MissionReport.ReportType.ALS);

        populate(missionReport);

        return missionReport;
    }
}
