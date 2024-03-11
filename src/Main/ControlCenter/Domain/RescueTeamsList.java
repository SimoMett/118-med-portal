package src.Main.ControlCenter.Domain;

import java.util.HashMap;
import java.util.List;

public class RescueTeamsList
{
    private final HashMap<String, RescueTeam> rescueTeamHashMap;
    public RescueTeamsList()
    {
        this.rescueTeamHashMap = new HashMap<>();
    }

    public void add(RescueTeam e)
    {
        rescueTeamHashMap.put(e.getId(), e);
    }

    public RescueTeam getTeam(String id)
    {
        return rescueTeamHashMap.get(id);
    }

    public List<RescueTeam> getAll()
    {
        return rescueTeamHashMap.values().stream().toList();
    }
}
