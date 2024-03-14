package src.Main.ControlCenter.BusinessLogic;

import src.Main.ControlCenter.DataAccess.IRescueTeamsDao;
import src.Main.ControlCenter.Domain.Mission;
import src.Main.ControlCenter.Domain.RescueTeam;

import java.util.List;

public class RescueTeamController
{
    private final IRescueTeamsDao rescueTeamsDao;

    public RescueTeamController(IRescueTeamsDao rescueTeamsDao)
    {
        this.rescueTeamsDao = rescueTeamsDao;
    }

    public void abortCurrentMission(RescueTeam rescueTeam) throws RuntimeException
    {
        rescueTeamsDao.abortMission(rescueTeam);
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

    public List<RescueTeam> getAllTeams()
    {
        return rescueTeamsDao.getRescueTeamsList().getAll();
    }
}
