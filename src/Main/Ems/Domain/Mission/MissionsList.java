package src.Main.Ems.Domain.Mission;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MissionsList
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

    public List<MissionReport> getAll()
    {
        return Collections.unmodifiableList(list);
    }
}
