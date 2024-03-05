package src.Main.Ems.Domain.Mission;

import java.sql.Timestamp;
import java.util.Date;
import java.util.HashMap;

public class MissionReport
{
    public enum ReportType
    {
        DRIVER,
        BLS,
        ALS
    }

    //attributes
    public final ReportType reportType;
    private final String missionId;
    private Date dateOfCreation;
    private String dispatch;
    private Timestamp lastEdit;
    private boolean isActive;
    private HashMap<String, Object> dataPairs;

    //methods
    public MissionReport(String missionId, ReportType type)
    {
        this.missionId = missionId;
        this.reportType = type;
        //TODO init dateOfCreation
        this.dataPairs = new HashMap<>();
    }

    public String getDispatch()
    {
        return dispatch;
    }

    public void updateData(String key, Object value)
    {
        dataPairs.replace(key, value);
    }
}
