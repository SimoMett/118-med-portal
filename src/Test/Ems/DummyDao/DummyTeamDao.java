package src.Test.Ems.DummyDao;

import src.Main.Ems.DataAccess.ITeamDao;
import src.Main.Ems.Domain.RescueTeam.RescueTeam;

public class DummyTeamDao implements ITeamDao
{
    private RescueTeam remoteTeam;
    @Override
    public void onRescueTeamChange(RescueTeam team)
    {
        remoteTeam = team;
    }

    public RescueTeam getRemoteTeam()
    {
        return remoteTeam;
    }

    @Override
    public boolean fetchAllOpenedMission(RescueTeam team)
    {
        return false;
    }
}
