package src.Main.Ems.BusinessLogic;

import src.Main.Ems.DataAccess.MissionDao;

public class MissionsListController
{
    private final MissionDao missionDao;

    public MissionsListController(MissionDao missionDao)
    {
        this.missionDao = missionDao;
    }

    //public Object openMission() {}
}
