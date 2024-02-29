package src.Main.Ems.Domain.Mission;

public class BLSReportFactory implements IMissionReportFactory
{
    private static final MissionReport reportPrototype = new MissionReport();

    @Override
    public MissionReport createReportModel(Object missionId)
    {
        //TODO return a clone of reportPrototype with missionId
        return null;
    }
}
