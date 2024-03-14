package src.Main.Ems.Domain.Mission.Factory;

import src.Main.Ems.Domain.Mission.DataField.GraphicalDataPair;
import src.Main.Ems.Domain.Mission.MissionReport;
import src.Main.Ems.Domain.Mission.DataField.SimpleDataField;

public class BLSReportFactory implements IMissionReportFactory
{
    public enum BLSFields
    {
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
        missionReport.initField(CommonFields.DATE.name(), new SimpleDataField(""));
        missionReport.initField(CommonFields.LOCATION.name(), new SimpleDataField(""));
        missionReport.initField(CommonFields.REFERENCE.name(), new SimpleDataField(""));
        missionReport.initField(CommonFields.TAX_ID.name(), new SimpleDataField(""));
        missionReport.initField(CommonFields.NAME.name(), new SimpleDataField(""));
        missionReport.initField(CommonFields.SURNAME.name(), new SimpleDataField(""));
        missionReport.initField(CommonFields.GENRE.name(), new SimpleDataField(""));
        missionReport.initField(CommonFields.AGE.name(), new SimpleDataField(""));
        missionReport.initField(CommonFields.DATE_OF_BIRTH.name(), new SimpleDataField(""));
        missionReport.initField(CommonFields.PLACE_OF_BIRTH.name(), new SimpleDataField(""));
        missionReport.initField(CommonFields.RESIDENCE_STREET.name(), new SimpleDataField(""));
        missionReport.initField(CommonFields.CITY.name(), new SimpleDataField(""));
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
