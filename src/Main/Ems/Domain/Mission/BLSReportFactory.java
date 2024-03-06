package src.Main.Ems.Domain.Mission;

import java.util.ArrayList;

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
        PATIENT_SIGNATURE,
        WITNESS_SIGNATURE
    }

    @Override
    public MissionReport createReportModel(String missionId)
    {
        MissionReport missionReport = new MissionReport(missionId, MissionReport.ReportType.BLS);
        for(BLSFields key : BLSFields.values())
        {
            missionReport.updateData(key.name(), null);
        }
        return missionReport;
    }
}
