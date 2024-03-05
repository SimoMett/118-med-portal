package src.Main.Ems.Domain.Mission;

public abstract class DataPair<T>
{
    private final T key;
    private boolean isLocked;

    protected DataPair(T key)
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
