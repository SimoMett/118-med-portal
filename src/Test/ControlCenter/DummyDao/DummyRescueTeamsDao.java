package src.Test.ControlCenter.DummyDao;

import src.Main.ControlCenter.DataAccess.IRescueTeamsDao;
import src.Main.ControlCenter.Domain.Mission;
import src.Main.ControlCenter.Domain.RescueTeam;
import src.Main.ControlCenter.Domain.RescueTeamsList;
import src.Main.ControlCenter.MissionStatus;

public class DummyRescueTeamsDao implements IRescueTeamsDao
{
    @Override
    public RescueTeamsList getRescueTeamsList()
    {
        RescueTeamsList rescueTeamsList = new RescueTeamsList();
        rescueTeamsList.add(new RescueTeam("BRAVO3450"));
        rescueTeamsList.add(new RescueTeam("BRAVO3451"));
        rescueTeamsList.add(new RescueTeam("BRAVO3452"));
        rescueTeamsList.add(new RescueTeam("INDIA01"));
        rescueTeamsList.add(new RescueTeam("ALFA07"));
        return rescueTeamsList;
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
    public Object getTeamPosition(RescueTeam rescueTeam) { return null; }

    protected void updateTeamMissionStatus(RescueTeam rescueTeam)
    {
        //TODO get current team status
        MissionStatus nearlyReceivedStatus = null;

        if(rescueTeam.getStatus() == MissionStatus.MISSION_END)
            rescueTeam.changeCurrentMission(null, null);
        rescueTeam.updateStatus(nearlyReceivedStatus);
    }
}
