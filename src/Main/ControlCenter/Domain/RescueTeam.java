package src.Main.ControlCenter.Domain;

public class RescueTeam
{
    private final Integer id;
    private Object status;

    private Mission currentMission;

    public RescueTeam(Integer teamId)
    {
        this.id = teamId;
    }

    public Integer getId()
    {
        return id;
    }

    public void setStatus(Object newStatus)
    {
        status = newStatus;
    }

    public Object getStatus()
    {
        return status;
    }

    public void changeCurrentMission(Mission newMission, Object activationCode) throws RuntimeException
    {
        if(currentMission!=null)
            throw new RuntimeException("Rescue team already doing a mission. Cannot activate");

        currentMission = newMission;
    }

    public Mission getCurrentMission()
    {
        return currentMission;
    }
}