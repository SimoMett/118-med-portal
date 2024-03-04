package src.Main.Ems.Domain;

import src.Main.Ems.Domain.Mission.MissionReport;
import src.Main.Ems.Domain.Mission.MissionsList;
import src.Main.Ems.Domain.RescueTeam.RescueTeam;

public class Session
{
    //static
    private static Session INSTANCE;
    public enum Mode
    {
        DRIVER,
        BLS,
        ALS
    }
    public static void init(Mode mode)
    {
        INSTANCE = new Session(mode);
    }

    public static void destroy()
    {
        INSTANCE = null;
    }

    public static Session instance() throws NullPointerException
    {
        if(INSTANCE == null)
            throw new NullPointerException("Session has not yet been initialized");
        return INSTANCE;
    }

    //attributes
    private final Mode mode;
    private final VehiclesList vehiclesList;
    private RescueTeam rescueTeam;
    private MissionsList missionsList;
    private MissionReport currentMission;

    //methods
    public Mode getMode()
    {
        return mode;
    }

    public RescueTeam getTeam()
    {
        return rescueTeam;
    }

    public MissionReport getCurrentMission()
    {
        return currentMission;
    }

    public Object getAllVehicles()
    {
        return null;
    }

    private Session(Mode mode)
    {
        this.mode = mode;
        this.vehiclesList = new VehiclesList();
        this.rescueTeam = new RescueTeam();
        this.missionsList = new MissionsList();
    }
}
