package src.Main.Ems.Domain.RescueTeam;

import java.util.ArrayList;

public class RescueTeam
{
    //attributes
    private ArrayList<User> members;
    private User driver;
    private User leader;
    private Vehicle vehicle;
    private ArrayList<ITeamObserver> teamObservers;

    public RescueTeam(Vehicle vehicle)
    {
        int MAX_COUNT_OF_MEMBERS = 4;
        this.members = new ArrayList<>(MAX_COUNT_OF_MEMBERS);
        this.vehicle = vehicle;
    }
    public void addRescuer(User user)
    {
        members.add(user);
    }

    public void setDriver(User user)
    {
        if(!members.contains(user))
            throw new RuntimeException("Cannot set user as driver: user not belonging to rescue team");
        driver = user;
    }

    public void setLeader(User user)
    {
        if(!members.contains(user))
            throw new RuntimeException("Cannot set user as leader: user not belonging to rescue team");
        leader = user;
    }

    public void removeRescuer(User user)
    {
        members.remove(user);
    }

    public void setVehicle(Vehicle vehicle)
    {
        this.vehicle = vehicle;
    }

    private void notifyObservers()
    {
        for(ITeamObserver observer : teamObservers)
        {
            observer.onRescueTeamChange(this);
        }
    }

    public void addObserver(ITeamObserver observer)
    {
        teamObservers.add(observer);
    }
}
