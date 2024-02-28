package src.Main.ControlCenter.DataAccess;

import src.Main.ControlCenter.Domain.Mission;
import src.Main.ControlCenter.Domain.RescueTeam;
import src.Main.ControlCenter.Domain.RescueTeamsList;

public class RescueTeamsDao
{
    public RescueTeamsList getAllTeams()
    {
        RescueTeamsList rescueTeamsList = new RescueTeamsList();
        //TODO populate with operating teams
        return rescueTeamsList;
    }
    /*public Object getTeamStatus(RescueTeam rescueTeam)
    {
        return null;
    }*/
    public void setTeamStatus(RescueTeam rescueTeam, Object status){}
    public void assignMission(RescueTeam rescueTeam, Mission mission){}
    public void abortMission(RescueTeam rescueTeam) {}
    public Object getTeamPosition(RescueTeam rescueTeam){return null;}
}
