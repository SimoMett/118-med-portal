package src.Main.ControlCenter.BusinessLogic;

import src.Main.ControlCenter.DataAccess.RescueTeamsDao;
import src.Main.ControlCenter.Domain.Mission;
import src.Main.ControlCenter.Domain.RescueTeam;
import src.Main.ControlCenter.Domain.RescueTeamsList;

public class RescueTeamController
{
    private final RescueTeamsDao rescueTeamsDao;
    public RescueTeamController(RescueTeamsDao rescueTeamsDao)
    {
        this.rescueTeamsDao = rescueTeamsDao;
    }

    public RescueTeamsList getAllTeams()
    {
        return rescueTeamsDao.getAllTeams();
    }
    public void abortCurrentMission(RescueTeam rescueTeam)
    {
        rescueTeamsDao.abortMission(rescueTeam);
    }
    public void setTeamStatus(RescueTeam rescueTeam, Object status)
    {
        rescueTeamsDao.setTeamStatus(rescueTeam, status);
    }
    public Object getTeamStatus(RescueTeam rescueTeam)
    {
        //By doing in this way, this controller misses all the updates regarding the current mission.
        //A proper way of doing should be that, anytime the current mission of a rescue team changes,
        // the DAO gets notified (in some way) and then updates the current mission via rescueTeam.changeCurrentMission()
        //return rescueTeamsDao.getTeamStatus(rescueTeam);
        return rescueTeam.getStatus();
    }
    public Object getTeamPosition(RescueTeam rescueTeam)
    {
        return rescueTeamsDao.getTeamPosition(rescueTeam);
    }
    public Mission getCurrentMission(RescueTeam rescueTeam)
    {
        //Same thing said in "getTeamStatus" applies here too
        return rescueTeam.getCurrentMission();
    }
}