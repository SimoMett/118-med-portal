package src.Main.ControlCenter.DataAccess;

import src.Main.ControlCenter.Domain.Mission;

public interface IMissionDao
{
    Mission createMission(String dispatch);

    //update mission on dbms with newInfo
    //I don't want to update here the mission in the domain model: it's not MissionDao's responsibility.
    boolean updateMission(Mission mission, Object newInfo);

    boolean updateDispatch(Mission mission, String newDispatch);
}
