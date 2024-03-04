package src.Main.Ems.BusinessLogic;

import src.Main.Ems.DataAccess.IMissionDao;

public class MissionsListController
{
    private final IMissionDao missionDao;

    public MissionsListController(IMissionDao missionDao)
    {
        this.missionDao = missionDao;
    }

    //public Object openMission() {}
}
