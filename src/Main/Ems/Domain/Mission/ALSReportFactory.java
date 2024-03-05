package src.Main.Ems.Domain.Mission;

import java.util.ArrayList;

public class ALSReportFactory implements IMissionReportFactory
{
    enum ALSFields
    {
        //TODO
    }
    private static final ArrayList<DataPair<ALSFields>> reportDataPairs = new ArrayList<>();

    @Override
    public MissionReport createReportModel(String missionId)
    {
        //TODO create a MissionReport with missionId and the DataPairs from reportDataPairs
        return null;
    }
}
