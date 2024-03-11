package src.Main.ControlCenter.DataAccess;

import src.Main.ControlCenter.Domain.Mission;
import src.Main.ControlCenter.Domain.RescueTeam;
import src.Main.ControlCenter.Domain.RescueTeamsList;

public interface IRescueTeamsDao
{
    RescueTeamsList getRescueTeamsList();
    /*public Object getTeamStatus(RescueTeam rescueTeam)
    {
        return null;
    }*/
    void setTeamStatus(RescueTeam rescueTeam, Object status);
    boolean assignMission(RescueTeam rescueTeam, Mission mission, String activationCode);
    void abortMission(RescueTeam rescueTeam);
    Object getTeamPosition(RescueTeam rescueTeam);
}
