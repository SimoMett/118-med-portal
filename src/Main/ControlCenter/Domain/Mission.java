package src.Main.ControlCenter.Domain;

import java.util.ArrayList;

public class Mission
{
    private final String id;
    private String dispatch;
    private ArrayList<RescueTeam> assignedTeams;

    public Mission(String id, String dispatch)
    {
        this.id = id;
        this.dispatch = dispatch;
        this.assignedTeams = new ArrayList<>();
    }

    public String getId() { return id; }

    public String getDispatch()
    {
        return dispatch;
    }

    public void updateDispatch(String newDispatch)
    {
        dispatch = newDispatch;
    }

    public void updateInfo(Object newInfo)
    {

    }

    public void assignToTeam(RescueTeam team) throws RuntimeException
    {
        if(assignedTeams.contains(team))
            throw new RuntimeException("Rescue team already assigned to this mission");

        assignedTeams.add(team);
    }
}
