package src.Main.Ems.ORM;

import src.Main.Ems.Domain.RescueTeam.ITeamObserver;
import src.Main.Ems.Domain.RescueTeam.RescueTeam;

public interface ITeamDao extends ITeamObserver
{
    // fetch all the opened missions of every member of the team
    boolean fetchAllOpenedMission(RescueTeam team);
}
