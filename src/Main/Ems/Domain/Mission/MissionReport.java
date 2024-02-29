package src.Main.Ems.Domain.Mission;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;

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
    private final Object missionId;
    private Date dateOfCreation;
    private String dispatch;
    private Timestamp lastEdit;
    private boolean isActive;
    private ArrayList<DataPair> dataPairs;

    //methods
    public MissionReport(Object missionId, ReportType type)
    {
        this.missionId = missionId;
        this.reportType = type;
        //TODO init dateOfCreation
        this.dataPairs = new ArrayList<>();
    }

    public String getDispatch()
    {
        return dispatch;
    }

    public void updateData(Object key, Object value)
    {

    }
}
