package src.Main.Ems.Domain.Mission;

public class BLSReportFactory implements IMissionReportFactory
{
    public enum BLSFields
    {
        DATE,
        LOCATION,
        REFERENCE,

        //Patient data
        TAX_ID,
        NAME,
        SURNAME,
        GENRE,
        AGE,
        DATE_OF_BIRTH,
        PLACE_OF_BIRTH,
        RESIDENCE_STREET,
        CITY,

        //Medical parameters
        CONSCIOUSNESS,
        AIRWAYS,
        BREATHING,
        BREATH_FRQ,
        DYSPNEA,
        NOISES,
        SPO2,
        SPO2_WITH_OXYGEN,
        O2_FLOW,
        BLOOD_PRESSURE_MAX,
        BLOOD_PRESSURE_MIN,
        HEART_RATE,
        HEMORRHAGE,
        PULSE_PRESENT,
        PULSE_REGULAR,
        SKIN_COLOR,
        SWEAT,
        CHEST_PAIN,
        CHEST_PAIN_TIME,
        AVPU,
        AVPU_SYNTOMS_TIME,
        FACE_SIMMETRY,
        ARMS_SIMMETRY,
        SPEECH_QUALITY,
        PATIENT_POSITION,
        PATHOLOGIES,
        ALLERGIES,
        CURRENT_THERAPY,
        SCENE_DYNAMIC,
        INJURIES,
        PERFORMED_MANEUVERS,
        PAIN_SCALE,

        //Outcome
        ALS,
        PATHOLOGY_CLASS,
        OUTCOME,
        RETURN_CODE,
        PATIENT_SIGNATURE
    }

    private static void populate(MissionReport missionReport)
    {
        missionReport.initField(BLSFields.DATE.name(), new SimpleDataField(""));
        missionReport.initField(BLSFields.LOCATION.name(), new SimpleDataField(""));
        missionReport.initField(BLSFields.REFERENCE.name(), new SimpleDataField(""));
        missionReport.initField(BLSFields.TAX_ID.name(), new SimpleDataField(""));
        missionReport.initField(BLSFields.NAME.name(), new SimpleDataField(""));
        missionReport.initField(BLSFields.SURNAME.name(), new SimpleDataField(""));
        missionReport.initField(BLSFields.GENRE.name(), new SimpleDataField(""));
        missionReport.initField(BLSFields.AGE.name(), new SimpleDataField(""));
        missionReport.initField(BLSFields.DATE_OF_BIRTH.name(), new SimpleDataField(""));
        missionReport.initField(BLSFields.PLACE_OF_BIRTH.name(), new SimpleDataField(""));
        missionReport.initField(BLSFields.RESIDENCE_STREET.name(), new SimpleDataField(""));
        missionReport.initField(BLSFields.CITY.name(), new SimpleDataField(""));
        missionReport.initField(BLSFields.CONSCIOUSNESS.name(), new SimpleDataField(""));
        missionReport.initField(BLSFields.AIRWAYS.name(), new SimpleDataField(""));
        missionReport.initField(BLSFields.BREATHING.name(), new SimpleDataField(""));
        missionReport.initField(BLSFields.BREATH_FRQ.name(), new SimpleDataField(""));
        missionReport.initField(BLSFields.DYSPNEA.name(), new SimpleDataField(""));
        missionReport.initField(BLSFields.NOISES.name(), new SimpleDataField(""));
        missionReport.initField(BLSFields.SPO2.name(), new SimpleDataField(""));
        missionReport.initField(BLSFields.SPO2_WITH_OXYGEN.name(), new SimpleDataField(""));
        missionReport.initField(BLSFields.O2_FLOW.name(), new SimpleDataField(""));
        missionReport.initField(BLSFields.BLOOD_PRESSURE_MAX.name(), new SimpleDataField(""));
        missionReport.initField(BLSFields.BLOOD_PRESSURE_MIN.name(), new SimpleDataField(""));
        missionReport.initField(BLSFields.HEART_RATE.name(), new SimpleDataField(""));
        missionReport.initField(BLSFields.HEMORRHAGE.name(), new SimpleDataField(""));
        missionReport.initField(BLSFields.PULSE_PRESENT.name(), new SimpleDataField(""));
        missionReport.initField(BLSFields.PULSE_REGULAR.name(), new SimpleDataField(""));
        missionReport.initField(BLSFields.SKIN_COLOR.name(), new SimpleDataField(""));
        missionReport.initField(BLSFields.SWEAT.name(), new SimpleDataField(""));
        missionReport.initField(BLSFields.CHEST_PAIN.name(), new SimpleDataField(""));
        missionReport.initField(BLSFields.CHEST_PAIN_TIME.name(), new SimpleDataField(""));
        missionReport.initField(BLSFields.AVPU.name(), new SimpleDataField(""));
        missionReport.initField(BLSFields.AVPU_SYNTOMS_TIME.name(), new SimpleDataField(""));
        missionReport.initField(BLSFields.FACE_SIMMETRY.name(), new SimpleDataField(""));
        missionReport.initField(BLSFields.ARMS_SIMMETRY.name(), new SimpleDataField(""));
        missionReport.initField(BLSFields.SPEECH_QUALITY.name(), new SimpleDataField(""));
        missionReport.initField(BLSFields.PATIENT_POSITION.name(), new SimpleDataField(""));
        missionReport.initField(BLSFields.PATHOLOGIES.name(), new SimpleDataField(""));
        missionReport.initField(BLSFields.ALLERGIES.name(), new SimpleDataField(""));
        missionReport.initField(BLSFields.CURRENT_THERAPY.name(), new SimpleDataField(""));
        missionReport.initField(BLSFields.SCENE_DYNAMIC.name(), new SimpleDataField(""));
        missionReport.initField(BLSFields.INJURIES.name(), new SimpleDataField(""));
        missionReport.initField(BLSFields.PERFORMED_MANEUVERS.name(), new SimpleDataField(""));
        missionReport.initField(BLSFields.PAIN_SCALE.name(), new SimpleDataField(""));
        missionReport.initField(BLSFields.ALS.name(), new SimpleDataField(""));
        missionReport.initField(BLSFields.PATHOLOGY_CLASS.name(), new SimpleDataField(""));
        missionReport.initField(BLSFields.OUTCOME.name(), new SimpleDataField(""));
        missionReport.initField(BLSFields.RETURN_CODE.name(), new SimpleDataField(""));
        missionReport.initField(BLSFields.PATIENT_SIGNATURE.name(), new GraphicalDataPair(""));
    }

    @Override
    public MissionReport createReportModel(String missionId)
    {
        MissionReport missionReport = new MissionReport(missionId, MissionReport.ReportType.BLS);

        populate(missionReport);

        return missionReport;
    }
}
