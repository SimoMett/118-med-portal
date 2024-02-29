package src.Main.Ems.Domain.RescueTeam;

import src.Main.Ems.Domain.RescueTeam.RescueTeam;

public interface ITeamObserver
{
    void onRescueTeamChange(RescueTeam team);
    void watchRescueTeam(RescueTeam team);
}
