package src.Main.Ems.Domain.Mission;

public interface IMissionReportFactory
{
    enum CommonFields
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
        CITY
    }
    MissionReport createReportModel(String missionId);//missionId should be put into the MissionReport
}
