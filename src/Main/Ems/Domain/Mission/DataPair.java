package src.Main.Ems.Domain.Mission;

public abstract class DataPair
{
    private final Object key;
    private boolean isLocked;

    protected DataPair(Object key)
    {
        this.key = key;
    }

    public boolean canModify()
    {
        return !isLocked;
    }

    public void allowEdit(boolean allow)
    {
        isLocked=!allow;
    }
}
