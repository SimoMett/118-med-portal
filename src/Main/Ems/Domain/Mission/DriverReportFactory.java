package src.Main.Ems.Domain.Mission;

import java.util.ArrayList;

public class DriverReportFactory implements IMissionReportFactory
{
    public enum DriverFields
    {
        DATE,
        LOCATION,
        REFERENCE,

        //Vehicle info
        VEHICLE_PLATE,
        VEHICLE_CLASS,

        //Departure
        IS_DEPARTING_FROM_HQ,
        KM_AT_START,
        KM_AT_END,

        //Timestamps
        TIME_MISSION_START,
        TIME_TARGET_REACHED,
        TIME_TARGET_DEPARTURE,
        TIME_RENDEZ_VOUS,
        TIME_DESTINATION_REACHED,
        TIME_MISSION_END,
        TIME_RETURN_TO_HQ,

        //Outcome
        OUTCOME,
        DESTINATION,
        DESTINATION_UNIT,
    }
    private static final ArrayList<DataField<DriverFields>> reportDataPairs = new ArrayList<>();

    @Override
    public MissionReport createReportModel(String missionId)
    {
        MissionReport missionReport = new MissionReport(missionId, MissionReport.ReportType.DRIVER);
        for(DriverFields key : DriverFields.values())
        {
            missionReport.updateData(key.name(), null);
        }
        return null;
    }
}
