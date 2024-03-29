package src.Main.Ems.Domain.RescueTeam;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class RescueTeam
{
    //attributes
    private final ArrayList<User> members;
    private User driver;
    private User leader;
    private Vehicle vehicle;
    private ArrayList<ITeamObserver> teamObservers;

    public RescueTeam()
    {
        int MAX_COUNT_OF_MEMBERS = 4;
        this.members = new ArrayList<>(MAX_COUNT_OF_MEMBERS);
        this.teamObservers = new ArrayList<>(2);
    }
    public void addRescuer(User user) throws RuntimeException
    {
        if(members.size() >= 4)
            throw new RuntimeException("Max members count of rescue team has been reached");
        members.add(user);
        notifyObservers();
    }

    public void setDriver(User user)
    {
        if(!members.contains(user))
            throw new RuntimeException("Cannot set user as driver: user not belonging to rescue team");
        driver = user;
        notifyObservers();
    }

    public User getDriver()
    {
        return driver;
    }

    public void setLeader(User user)
    {
        if(!members.contains(user))
            throw new RuntimeException("Cannot set user as leader: user not belonging to rescue team");
        leader = user;
        notifyObservers();
    }

    public User getLeader()
    {
        return leader;
    }

    public void removeRescuer(User user)
    {
        if(driver != null && driver.equals(user))
            driver = null;

        if(leader != null && leader.equals(user))
            leader = null;

        members.remove(user);
        notifyObservers();
    }

    public List<User> getMembers()
    {
        return Collections.unmodifiableList(members);
    }

    public void setVehicle(Vehicle vehicle)
    {
        this.vehicle = vehicle;
        notifyObservers();
    }

    public Vehicle getVehicle()
    {
        return vehicle;
    }

    public void addObserver(ITeamObserver observer)
    {
        teamObservers.add(observer);
    }

    private void notifyObservers()
    {
        for(ITeamObserver observer : teamObservers)
        {
            observer.onRescueTeamChange(this);
        }
    }
}
