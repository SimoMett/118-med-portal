package src.Main.Ems.Domain.Mission;

import java.sql.Timestamp;
import java.time.Instant;
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
    private final Timestamp dateOfCreation;
    private String dispatch;
    private Timestamp lastEdit;
    private boolean isActive;
    private final HashMap<String, Object> dataPairs;

    //methods
    public MissionReport(String missionId, ReportType type)
    {
        this.missionId = missionId;
        this.reportType = type;
        this.dateOfCreation = Timestamp.from(Instant.now());
        this.dataPairs = new HashMap<>();
        this.isActive = true;
    }

    public String getDispatch()
    {
        return dispatch;
    }

    public void updateDispatch(String newDispatch)
    {
        this.dispatch = newDispatch;
    }

    public void updateData(String key, Object value)
    {
        dataPairs.replace(key, value);
        lastEdit = Timestamp.from(Instant.now());
    }

    public Object getData(String key) throws IllegalArgumentException
    {
        if(!dataPairs.containsKey(key))
            throw new IllegalArgumentException("Provided invalid key for "+reportType.name()+" report: "+key);
        return dataPairs.get(key);
    }
}
