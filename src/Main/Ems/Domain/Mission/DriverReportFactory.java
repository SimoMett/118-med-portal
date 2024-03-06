package src.Main.Ems.Domain.Mission;

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
    private static void populate(MissionReport missionReport)
    {
        missionReport.initField(DriverFields.DATE.name(), new SimpleDataField(""));
        missionReport.initField(DriverFields.LOCATION.name(), new SimpleDataField(""));
        missionReport.initField(DriverFields.REFERENCE.name(), new SimpleDataField(""));
        missionReport.initField(DriverFields.VEHICLE_PLATE.name(), new SimpleDataField(""));
        missionReport.initField(DriverFields.VEHICLE_CLASS.name(), new SimpleDataField(""));
        missionReport.initField(DriverFields.IS_DEPARTING_FROM_HQ.name(), new SimpleDataField(""));
        missionReport.initField(DriverFields.KM_AT_START.name(), new SimpleDataField(""));
        missionReport.initField(DriverFields.KM_AT_END.name(), new SimpleDataField(""));
        missionReport.initField(DriverFields.TIME_MISSION_START.name(), new SimpleDataField(""));
        missionReport.initField(DriverFields.TIME_TARGET_REACHED.name(), new SimpleDataField(""));
        missionReport.initField(DriverFields.TIME_TARGET_DEPARTURE.name(), new SimpleDataField(""));
        missionReport.initField(DriverFields.TIME_RENDEZ_VOUS.name(), new SimpleDataField(""));
        missionReport.initField(DriverFields.TIME_DESTINATION_REACHED.name(), new SimpleDataField(""));
        missionReport.initField(DriverFields.TIME_MISSION_END.name(), new SimpleDataField(""));
        missionReport.initField(DriverFields.TIME_RETURN_TO_HQ.name(), new SimpleDataField(""));
        missionReport.initField(DriverFields.OUTCOME.name(), new SimpleDataField(""));
        missionReport.initField(DriverFields.DESTINATION.name(), new SimpleDataField(""));
        missionReport.initField(DriverFields.DESTINATION_UNIT.name(), new SimpleDataField(""));
    }

    @Override
    public MissionReport createReportModel(String missionId)
    {
        MissionReport missionReport = new MissionReport(missionId, MissionReport.ReportType.DRIVER);

        populate(missionReport);

        return missionReport;
    }
}
