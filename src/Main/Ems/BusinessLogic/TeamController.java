package src.Main.Ems.BusinessLogic;

import src.Main.Ems.Domain.RescueTeam.RescueTeam;
import src.Main.Ems.Domain.RescueTeam.User;
import src.Main.Ems.Domain.RescueTeam.Vehicle;

public class TeamController
{
    private final RescueTeam rescueTeam;
    public TeamController(RescueTeam rescueTeam)
    {
        this.rescueTeam = rescueTeam;
        //TODO invoke data access and synchronize
    }

    public void changeVehicle(Vehicle newVehicle)
    {
        rescueTeam.setVehicle(newVehicle);
    }

    public void setTeamLeader(User user)
    {
        rescueTeam.setLeader(user);
    }

    public void setTeamDriver(User user)
    {
        rescueTeam.setDriver(user);
    }

    public void logOutUser(User user)
    {
        rescueTeam.removeRescuer(user);
    }
}
