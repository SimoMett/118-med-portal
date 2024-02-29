package src.Main.Ems.Domain;

public class Session
{
    //static
    private static Session INSTANCE;
    enum Mode
    {
        DRIVER,
        BLS,
        ALS
    }
    public static void init(Mode mode)
    {
        INSTANCE = new Session(mode);
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

    //methods
    public Object getTeam()
    {
        return null;
    }

    public Object getAllVehicles()
    {
        return null;
    }

    private Session(Mode mode)
    {
        this.mode = mode;
        this.vehiclesList = new VehiclesList();
    }
}
