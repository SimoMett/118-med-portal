package src.Main.ControlCenter.DataAccess;

import src.Main.ControlCenter.Domain.Mission;
import src.Main.ControlCenter.Domain.RescueTeam;
import src.Main.ControlCenter.Domain.RescueTeamsList;

public class RescueTeamsDao
{
    public RescueTeamsList getAllTeams()//TODO revisit
    {
        RescueTeamsList rescueTeamsList = RescueTeamsList.getInstance();
        //TODO populate with operating teams
        return rescueTeamsList;
    }
    /*public Object getTeamStatus(RescueTeam rescueTeam)
    {
        return null;
    }*/
    public void setTeamStatus(RescueTeam rescueTeam, Object status){}
    public boolean assignMission(RescueTeam rescueTeam, Mission mission, Object activationCode){return false;}
    public void abortMission(RescueTeam rescueTeam) {}
    public Object getTeamPosition(RescueTeam rescueTeam){return null;}
}
