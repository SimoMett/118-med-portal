package src.Main.ControlCenter.Domain;

import java.util.ArrayList;

public class MissionsList
{
    //Static:
    private static MissionsList INSTANCE = new MissionsList();
    public static MissionsList getInstance()
    {
        return INSTANCE;
    }

    //attributes
    private final ArrayList<Mission> missions;

    //methods
    public void addMission(Mission mission)
    {
        missions.add(mission);
    }

    public Mission getMission(Object id)
    {
        //get the mission with the given ID. (ID structure still to be defined)
        return null;
    }

    private MissionsList()
    {
        this.missions = new ArrayList<>();
    }
}
