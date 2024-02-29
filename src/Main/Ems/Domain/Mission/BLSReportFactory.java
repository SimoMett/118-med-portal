package src.Main.Ems.Domain.Mission;

import java.util.ArrayList;

public class BLSReportFactory implements IMissionReportFactory
{
    private static final ArrayList<DataPair> reportDataPairs = new ArrayList<>();

    @Override
    public MissionReport createReportModel(Object missionId)
    {
        //TODO create a MissionReport with missionId and the DataPairs from reportDataPairs
        return null;
    }
}
