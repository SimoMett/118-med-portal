package src.Main.ControlCenter.BusinessLogic;

import src.Main.ControlCenter.ORM.IRescueTeamsDao;
import src.Main.ControlCenter.Domain.Mission;
import src.Main.ControlCenter.Domain.RescueTeam;
import src.Main.ControlCenter.MissionStatus;

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

    public MissionStatus getTeamMissionStatus(RescueTeam rescueTeam)
    {
        return rescueTeam.getStatus();
    }

    public Mission getCurrentMission(RescueTeam rescueTeam)
    {
        return rescueTeam.getCurrentMission();
    }

    public List<RescueTeam> getAllTeams()
    {
        return rescueTeamsDao.getRescueTeamsList().getAll();
    }

    public Object getTeamPosition(RescueTeam rescueTeam) { return rescueTeamsDao.getTeamPosition(rescueTeam); }
}
