package src.Main.ControlCenter.Domain;

public class RescueTeamsList
{
    private static RescueTeamsList INSTANCE = new RescueTeamsList();

    public static RescueTeamsList getInstance()
    {
        return INSTANCE;
    }

    private RescueTeamsList(){}
}
