package src.Main.Ems.Domain;

import src.Main.Ems.Domain.Mission.Factory.ALSReportFactory;
import src.Main.Ems.Domain.Mission.Factory.BLSReportFactory;
import src.Main.Ems.Domain.Mission.Factory.DriverReportFactory;
import src.Main.Ems.Domain.Mission.Factory.IMissionReportFactory;
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
        if(INSTANCE != null)
            throw new RuntimeException("Session has already been initialized");
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
    private final IMissionReportFactory reportFactory;
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

    public IMissionReportFactory getReportFactory() { return this.reportFactory; }

    public MissionReport getCurrentMission()
    {
        return currentMission;
    }

    public void setCurrentMission(MissionReport mission)
    {
        if(currentMission != null && mission != null)
            throw new RuntimeException("Current mission is not null");

        currentMission = mission;
    }

    public VehiclesList getAllVehicles()
    {
        return vehiclesList;
    }

    public MissionsList getMissionsList() { return missionsList; }

    protected Session(Mode mode)
    {
        this.mode = mode;
        this.vehiclesList = new VehiclesList();
        this.rescueTeam = new RescueTeam();
        this.missionsList = new MissionsList();
        switch (mode)
        {
            case DRIVER -> this.reportFactory = new DriverReportFactory();
            case BLS -> this.reportFactory = new BLSReportFactory();
            case ALS -> this.reportFactory = new ALSReportFactory();
            default -> throw new IllegalArgumentException("Unknown session mode provided");
        }
    }
}
