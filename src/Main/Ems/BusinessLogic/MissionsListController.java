package src.Main.Ems.BusinessLogic;

import src.Main.Ems.DataAccess.IMissionDao;
import src.Main.Ems.Domain.Mission.*;
import src.Main.Ems.Domain.Session;

public class MissionsListController
{
    private final IMissionDao missionDao;
    private final MissionsList missionsList;

    public MissionsListController(IMissionDao missionDao, MissionsList missionsList)
    {
        this.missionDao = missionDao;
        this.missionsList = missionsList;
    }

    public MissionReport openReceivedMission()
    {
        IMissionReportFactory factory;
        switch (Session.instance().getMode())
        {
            case BLS -> factory = new BLSReportFactory();
            case ALS -> factory = new ALSReportFactory();
            default -> factory = new DriverReportFactory();
        }
        return missionDao.getReceivedMission(factory);
    }
}
