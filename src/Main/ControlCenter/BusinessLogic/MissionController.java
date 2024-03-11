package src.Main.ControlCenter.BusinessLogic;

import src.Main.ControlCenter.DataAccess.IMissionDao;
import src.Main.ControlCenter.DataAccess.IRescueTeamsDao;
import src.Main.ControlCenter.Domain.Mission;
import src.Main.ControlCenter.Domain.MissionsList;
import src.Main.ControlCenter.Domain.RescueTeam;

public class MissionController
{
    private final IMissionDao missionDao;
    private final IRescueTeamsDao rescueTeamsDao;

    public MissionController(IMissionDao missionDao, IRescueTeamsDao rescueTeamsDao)
    {
        this.missionDao = missionDao;
        this.rescueTeamsDao = rescueTeamsDao;
    }

    public Mission createNewMission(String dispatch)
    {
        Mission mission = this.missionDao.createMission(dispatch);
        if(mission != null)
            MissionsList.getInstance().addMission(mission);
        return mission;
    }

    public void updateInfo(Mission mission, Object newInfo)
    {
        if(missionDao.updateMission(mission, newInfo))
            mission.updateInfo(newInfo);
        else
            throw new RuntimeException("RescueTeamsDao failed data access");
    }

    public void assignTeam(Mission mission, RescueTeam team, String activationCode) throws RuntimeException
    {
        if(rescueTeamsDao.assignMission(team, mission, activationCode))
            team.changeCurrentMission(mission, activationCode);
        else
            throw new RuntimeException("RescueTeamsDao failed data access");
    }

    public void updateDispatch(Mission mission, String newDispatch) throws RuntimeException
    {
        if(missionDao.updateDispatch(mission, newDispatch))
            mission.updateDispatch(newDispatch);
        else
            throw new RuntimeException("RescueTeamsDao failed data access");
    }
}