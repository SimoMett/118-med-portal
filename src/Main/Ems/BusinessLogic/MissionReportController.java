package src.Main.Ems.BusinessLogic;

import src.Main.Ems.DataAccess.MissionDao;
import src.Main.Ems.Domain.Mission.MissionReport;
import src.Main.Ems.Domain.RescueTeam.RescueTeam;

public class MissionReportController
{
    private final MissionReport report;
    private final MissionDao missionDao;

    public MissionReportController(MissionDao missionDao, MissionReport report)
    {
        this.missionDao = missionDao;
        this.report = report;
    }

    public void updateData(Object key, Object val)
    {
        this.report.updateData(key, val);
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
