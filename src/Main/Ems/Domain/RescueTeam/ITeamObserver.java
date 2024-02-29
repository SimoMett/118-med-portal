package src.Main.Ems.Domain.RescueTeam;

import src.Main.Ems.Domain.RescueTeam.RescueTeam;

public interface ITeamObserver
{
    void onRescueTeamChange(RescueTeam team);
    default void watchRescueTeam(RescueTeam team)
    {
        team.addObserver(this);
    }
}
