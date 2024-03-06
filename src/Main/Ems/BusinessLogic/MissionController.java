package src.Main.Ems.BusinessLogic;

import src.Main.Ems.DataAccess.IMissionDao;
import src.Main.Ems.Domain.Mission.DataField;
import src.Main.Ems.Domain.Mission.MissionReport;
import src.Main.Ems.Domain.RescueTeam.RescueTeam;

public class MissionController
{
    private final MissionReport report;
    private final IMissionDao missionDao;

    public MissionController(IMissionDao missionDao, MissionReport report)
    {
        this.missionDao = missionDao;
        this.report = report;
    }

    public boolean updateData(String key, Object val) throws IllegalAccessException
    {
        //Update data locally (in the domain model) and remotely (via data access).
        //If data access fails (eg: lost connection) at least we have a local mission report to work with
        //In such case the user can trigger manually the synchronization with remote via 'saveReport()'
        this.report.updateData(key, val);
        return this.missionDao.updateMissionData(report, key, val);
    }

    public DataField get(String key) throws IllegalArgumentException
    {
        //Get data from domain model
        return this.report.getData(key);
    }

    public boolean saveReport()
    {
        return missionDao.sendMissionReport(report);
    }

    public void syncPatientData(RescueTeam receivingTeam)
    {
        //TODO send patient data to the receivingTeam via data access
    }

    public void closeMission()
    {
        report.close();
        //TODO close mission via data access
    }

    public void invokeExternalFunctionality(Object func) throws RuntimeException
    {
        //TODO
        //external functionalities like camera, tax ID decoder ...
        //func.invoke
    }
}
