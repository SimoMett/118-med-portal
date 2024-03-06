package src.Main.Ems.BusinessLogic;

import src.Main.Ems.DataAccess.IMissionDao;
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

    public void updateData(String key, Object val)
    {
        this.report.updateData(key, val);
        this.missionDao.updateMissionData(report, key, val);
    }

    public Object get(String key)
    {
        return this.missionDao.getMissionData(report, key);
    }

    public void saveReport()
    {
        //TODO
    }

    public void syncPatientData(RescueTeam receivingTeam)
    {
//TODO
    }

    public void closeMission()
    {
//TODO
    }

    public void invokeExternalFunctionality(Object func) throws RuntimeException
    {
        //TODO
        //external functionalities like camera, tax ID decoder ...
        //func.invoke
    }
}
