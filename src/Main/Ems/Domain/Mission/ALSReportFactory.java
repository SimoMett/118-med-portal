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
        MissionReport missionReport = new MissionReport(missionId, MissionReport.ReportType.ALS);
        for(ALSFields key : ALSFields.values())
        {
            missionReport.updateData(key.name(), null);
        }
        return null;
    }
}
