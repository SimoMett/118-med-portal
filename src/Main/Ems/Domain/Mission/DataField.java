package src.Main.Ems.Domain.Mission;

public abstract class DataField<T>
{
    protected T value;
    private boolean isLocked; //DataField marked as "locked" can be still modified by calling allowEdit(true) first
    private boolean isImmutable; //DataField marked as immutable cannot be modified in any way

    protected DataField(T value)
    {
        this.value = value;
        this.isImmutable = false;
    }

    public boolean canModify()
    {
        return !isLocked;
    }

    protected void allowEdit(boolean allow)
    {
        isLocked=!allow;
    }

    protected void setImmutable()
    {
        isLocked = true;
        isImmutable = true;
    }

    public final boolean isImmutable()
    {
        return isImmutable;
    }

    public abstract void setValue(T newValue) throws IllegalAccessException;
}
