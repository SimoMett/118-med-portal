package src.Main.ControlCenter.Domain;

public class Mission
{
    private String dispatch;

    public Mission(String dispatch)
    {
        this.dispatch = dispatch;
    }

    public String getDispatch()
    {
        return dispatch;
    }

    public void updateDispatch(String newDispatch)
    {
        dispatch = newDispatch;
    }

    public void updateInfo(Object newInfo)
    {

    }
}
