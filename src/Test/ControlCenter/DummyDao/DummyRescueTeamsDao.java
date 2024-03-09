package src.Test.ControlCenter.DummyDao;

import src.Main.ControlCenter.DataAccess.IRescueTeamsDao;
import src.Main.ControlCenter.Domain.Mission;
import src.Main.ControlCenter.Domain.RescueTeam;
import src.Main.ControlCenter.Domain.RescueTeamsList;

public class DummyRescueTeamsDao implements IRescueTeamsDao
{
    @Override
    public RescueTeamsList getAllTeams()
    {
        RescueTeamsList rescueTeamsList = RescueTeamsList.getInstance();
        //TODO populate with operating teams
        return rescueTeamsList;
    }

    @Override
    public void setTeamStatus(RescueTeam rescueTeam, Object status) {

    }

    @Override
    public boolean assignMission(RescueTeam rescueTeam, Mission mission, String activationCode)
    {
        return true;
    }

    @Override
    public void abortMission(RescueTeam rescueTeam) throws RuntimeException
    {
        if(rescueTeam.getCurrentMission()==null)
            throw new RuntimeException("current mission is null");
        rescueTeam.changeCurrentMission(null, "");
    }

    @Override
    public Object getTeamPosition(RescueTeam rescueTeam) {
        return null;
    }
}
