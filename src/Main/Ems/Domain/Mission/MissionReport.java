package src.Main.Ems.Domain.Mission;

import src.Main.Ems.Domain.Mission.DataField.DataField;
import src.Main.Ems.Domain.Mission.Factory.IMissionReportFactory;

import java.sql.Timestamp;
import java.time.Instant;
import java.util.Collections;
import java.util.HashMap;
import java.util.Set;

public class MissionReport
{
    //static
    public enum ReportType
    {
        DRIVER,
        BLS,
        ALS
    }

    public static void throwIfInvalidMissionId(String id) throws NumberFormatException
    {
        String[] strings = id.split("/", 3);
        for(String s : strings)
            Integer.parseInt(s);
    }

    //attributes
    public final ReportType reportType;
    private final String missionId;
    private final Timestamp dateOfCreation;
    private String dispatch;
    private Timestamp lastEdit;
    private boolean isActive;
    private final HashMap<String, DataField> dataPairs;

    //methods
    public MissionReport(String missionId, ReportType type)
    {
        throwIfInvalidMissionId(missionId);
        this.missionId = missionId;
        this.reportType = type;
        this.dateOfCreation = Timestamp.from(Instant.now());
        this.dataPairs = new HashMap<>();
        this.isActive = true;
        this.lastEdit = Timestamp.from(Instant.now());
    }

    public String getId()
    {
        return missionId;
    }

    public String getDispatch()
    {
        return dispatch;
    }

    public void updateDispatch(String newDispatch)
    {
        this.dispatch = newDispatch;
    }

    public void initField(String key, DataField value)
    {
        if(dataPairs.containsKey(key))
            throw new RuntimeException("Key "+key+" has already been initialized");
        dataPairs.put(key, value);
    }

    public void updateData(String key, Object value) throws IllegalArgumentException, IllegalAccessException
    {
        if(!dataPairs.containsKey(key))
            throw new IllegalArgumentException("Provided invalid key for "+reportType.name()+" report: "+key);

        dataPairs.get(key).setValue(value);
        //FIXME a value can still be overwritten by replacing the entire DataField like in the line below
        //   -> dataPairs.replace(key, value);

        lastEdit = Timestamp.from(Instant.now());
    }

    public Set<String> getKeys()
    {
        return Collections.unmodifiableSet(dataPairs.keySet());
    }

    public DataField getData(String key) throws IllegalArgumentException
    {
        if(!dataPairs.containsKey(key))
            throw new IllegalArgumentException("Provided invalid key for "+reportType.name()+" report: "+key);
        return dataPairs.get(key);
    }

    public DataField getPatientData()
    {
        return this.getData(IMissionReportFactory.CommonFields.TAX_ID.name());
    }

    public void close()
    {
        isActive = false;
        dataPairs.forEach( (k, val) -> val.setImmutable());
    }
}
