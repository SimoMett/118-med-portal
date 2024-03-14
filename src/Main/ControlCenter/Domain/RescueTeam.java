package src.Main.ControlCenter.Domain;

import src.Main.ControlCenter.MissionStatus;

public class RescueTeam
{
    private final String id;
    private MissionStatus status;

    private Mission currentMission;
    private String currentActivationCode;

    public RescueTeam(String teamId)
    {
        this.id = teamId;
    }

    public String getId()
    {
        return id;
    }

    public void updateStatus(MissionStatus newStatus)
    {
        status = newStatus;
    }

    public MissionStatus getStatus()
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
