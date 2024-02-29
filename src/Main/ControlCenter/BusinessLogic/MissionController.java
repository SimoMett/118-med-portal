package src.Main.ControlCenter.BusinessLogic;

import src.Main.ControlCenter.DataAccess.MissionDao;
import src.Main.ControlCenter.DataAccess.RescueTeamsDao;
import src.Main.ControlCenter.Domain.Mission;
import src.Main.ControlCenter.Domain.MissionsList;
import src.Main.ControlCenter.Domain.RescueTeam;

public class MissionController
{
    private final MissionDao missionDao;
    private final RescueTeamsDao rescueTeamsDao;

    public MissionController(MissionDao missionDao, RescueTeamsDao rescueTeamsDao)
    {
        this.missionDao = missionDao;
        this.rescueTeamsDao = rescueTeamsDao;
    }

    public void createNewMission(String info)
    {
        Mission mission = this.missionDao.createMission(info);
        if(mission != null)
            MissionsList.getInstance().addMission(mission);
    }

    public void updateInfo(Mission mission, Object newInfo)
    {
        if(this.missionDao.updateMission(mission, newInfo))
            mission.updateInfo(newInfo);
    }

    public void assignTeam(Mission mission, RescueTeam team, Object activationCode) throws RuntimeException
    {
        if(rescueTeamsDao.assignMission(team, mission, activationCode))
            team.changeCurrentMission(mission, activationCode);
    }
}