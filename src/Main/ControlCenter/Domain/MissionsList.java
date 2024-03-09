package src.Main.ControlCenter.Domain;

import java.util.HashMap;

public class MissionsList
{
    //Static:
    private static MissionsList INSTANCE = new MissionsList();
    public static MissionsList getInstance()
    {
        return INSTANCE;
    }

    //attributes
    private final HashMap<String, Mission> missions;

    //methods
    public void addMission(Mission mission)
    {
        missions.put(mission.getId(), mission);
    }

    public Mission getMission(String id)
    {
        return missions.get(id);
    }

    private MissionsList()
    {
        this.missions = new HashMap<>();
    }
}
