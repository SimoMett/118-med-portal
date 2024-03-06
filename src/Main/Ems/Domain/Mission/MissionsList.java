package src.Main.Ems.Domain.Mission;

import src.Main.Ems.Domain.RescueTeam.ITeamObserver;
import src.Main.Ems.Domain.RescueTeam.RescueTeam;

import java.util.ArrayList;

public class MissionsList implements ITeamObserver
{
    private final ArrayList<MissionReport> list = new ArrayList<>();
    public void add(MissionReport mission)
    {
        list.add(mission);
    }

    public MissionReport get(String missionId)
    {
        for(MissionReport m : list)
        {
            if(m.getId().equals(missionId))
                return m;
        }
        return null;
    }

    @Override
    public void onRescueTeamChange(RescueTeam team)
    {

    }
}
