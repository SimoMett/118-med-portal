package src.Main.ControlCenter.DataAccess;

import src.Main.ControlCenter.Domain.Mission;

public class MissionDao
{
    public Mission createMission(String info)
    {
        Mission mission = new Mission(info);
        //add to dbms
        return mission;
    }
    public boolean updateMission(Mission mission, Object newInfo)
    {
        //update mission on dbms with newInfo
        //I don't want to update here the mission in the domain model: it's not MissionDao's responsibility.
        return true;
    }
}
