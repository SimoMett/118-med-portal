package src.Main.Ems.DataAccess;

import src.Main.Ems.Domain.RescueTeam.ITeamObserver;
import src.Main.Ems.Domain.RescueTeam.RescueTeam;

public class TeamDao implements ITeamObserver
{

    @Override
    public void onRescueTeamChange(RescueTeam team)
    {
        //TODO fetch all the opened missions of every member of the team
    }
}
