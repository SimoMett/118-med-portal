package src.Main.Ems.DataAccess;

import src.Main.Ems.Domain.RescueTeam.User;

public class LoginResult
{
    public User user;
    public String message;
    public boolean passwordChangeRequired;
    public boolean success;
}
