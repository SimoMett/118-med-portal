package src.Main.ControlCenter.DataAccess;

import src.Main.ControlCenter.Domain.Mission;
import src.Main.ControlCenter.Domain.RescueTeam;
import src.Main.ControlCenter.Domain.RescueTeamsList;

public interface IRescueTeamsDao
{
    RescueTeamsList getAllTeams();//TODO revisit
    /*public Object getTeamStatus(RescueTeam rescueTeam)
    {
        return null;
    }*/
    void setTeamStatus(RescueTeam rescueTeam, Object status);
    boolean assignMission(RescueTeam rescueTeam, Mission mission, Object activationCode);
    void abortMission(RescueTeam rescueTeam);
    Object getTeamPosition(RescueTeam rescueTeam);
}
