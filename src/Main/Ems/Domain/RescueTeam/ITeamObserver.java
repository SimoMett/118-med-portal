package src.Main.Ems.Domain.RescueTeam;

import src.Main.ControlCenter.Domain.RescueTeam;

public interface ITeamObserver
{
    void onRescueTeamChange(RescueTeam team);
    void watchRescueTeam(RescueTeam team);
}
