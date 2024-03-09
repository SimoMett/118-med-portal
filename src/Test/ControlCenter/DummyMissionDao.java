package src.Test.ControlCenter;

import src.Main.ControlCenter.DataAccess.IMissionDao;
import src.Main.ControlCenter.Domain.Mission;

public class DummyMissionDao implements IMissionDao
{
    @Override
    public Mission createMission(String dispatch)
    {
        Mission mission = new Mission(dispatch);
        //add to dbms
        return mission;
    }

    @Override
    public boolean updateMission(Mission mission, Object newInfo)
    {
        return false;
    }
}
