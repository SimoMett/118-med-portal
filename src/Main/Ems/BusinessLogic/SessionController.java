package src.Main.Ems.BusinessLogic;

import src.Main.Ems.Domain.Session;

public class SessionController
{
    private final Session.Mode sessionMode;
    public SessionController(Session.Mode sessionMode)
    {
        this.sessionMode = sessionMode;
    }
    public void openSession()
    {
        Session.init(sessionMode);
    }

    public void quitSession()
    {
        Session.destroy();
    }
}
