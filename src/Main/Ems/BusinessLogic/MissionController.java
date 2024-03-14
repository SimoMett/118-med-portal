package src.Main.Ems.BusinessLogic;

import src.Main.Ems.DataAccess.IMissionDao;
import src.Main.Ems.Domain.Mission.DataField.DataField;
import src.Main.Ems.Domain.Mission.MissionReport;
import src.Main.Ems.Domain.Session;

public class MissionController
{
    private final MissionReport report;
    private final IMissionDao missionDao;

    public MissionController(IMissionDao missionDao, MissionReport report)
    {
        this.missionDao = missionDao;
        this.report = report;
    }

    public void updateData(String key, Object val) throws RuntimeException, IllegalAccessException
    {
        //Update data locally (in the domain model) and remotely (via data access).
        //If data access fails (eg: lost connection) at least we have a local mission report to work with
        //In such case the user can trigger manually the synchronization with remote via 'saveReport()'
        report.updateData(key, val);
        if(!missionDao.updateMissionData(report, key, val))
            throw new RuntimeException("MissionDao failed data access");
    }

    public DataField get(String key) throws IllegalArgumentException
    {
        //Get data from domain model
        return this.report.getData(key);
    }

    public void saveReport()
    {
        if(!missionDao.sendMissionReport(report))
            throw new RuntimeException("MissionDao failed data access");
    }

    public void sendPatientData(String receivingTeamId) throws RuntimeException
    {
        if(!missionDao.sendPatientData(receivingTeamId, report.getPatientData()))
            throw new RuntimeException("MissionDao failed data access");
    }

    public void closeMission()
    {
        //Set report immutable
        report.close();

        //If this report is the current mission
        //      set current mission to null
        if(Session.instance().getCurrentMission() != null && Session.instance().getCurrentMission().equals(report))
            Session.instance().setCurrentMission(null);

        //Close mission via data access
        if(!missionDao.closeMission(report))
            throw new RuntimeException("MissionDao failed data access");
    }

    public void invokeExternalFunctionality(Object func) throws RuntimeException
    {
        //external functionalities like camera, tax ID decoder ...
        //func.invoke
    }
}
