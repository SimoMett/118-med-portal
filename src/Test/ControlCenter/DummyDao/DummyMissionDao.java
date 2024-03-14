package src.Test.ControlCenter.DummyDao;

import src.Main.ControlCenter.ORM.IMissionDao;
import src.Main.ControlCenter.Domain.Mission;

import java.util.Random;

public class DummyMissionDao implements IMissionDao
{
    @Override
    public Mission createMission(String dispatch)
    {
        Mission mission = new Mission("03/24/"+new Random().nextInt(1000,9000), dispatch);
        return mission;
    }

    @Override
    public boolean updateMission(Mission mission, Object newInfo)
    {
        return true;
    }

    @Override
    public boolean updateDispatch(Mission mission, String newDispatch)
    {
        return true;
    }
}
