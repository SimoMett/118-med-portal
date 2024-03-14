package src.Main.Ems.Domain.Mission.Factory;

import src.Main.Ems.Domain.Mission.MissionReport;
import src.Main.Ems.Domain.Mission.DataField.SimpleDataField;

public class ALSReportFactory implements IMissionReportFactory
{
    public enum ALSFields
    {
        //TODO
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
    }

    @Override
    public MissionReport createReportModel(String missionId)
    {
        MissionReport missionReport = new MissionReport(missionId, MissionReport.ReportType.ALS);

        populate(missionReport);

        return missionReport;
    }
}
