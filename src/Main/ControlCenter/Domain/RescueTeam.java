package src.Main.ControlCenter.Domain;

public class RescueTeam
{
    private final Integer id;
    private Object status;

    private Mission currentMission;
    private String currentActivationCode;

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

    public void changeCurrentMission(Mission newMission, String activationCode) throws RuntimeException
    {
        if(currentMission!=null && newMission != null)
            throw new RuntimeException("Rescue team already doing a mission. Cannot activate");

        currentMission = newMission;
        currentActivationCode = activationCode;
    }

    public Mission getCurrentMission()
    {
        return currentMission;
    }
}
