package src.Main.Ems.Domain.Mission;

public class SimpleDataPair extends DataPair
{
    private Object value;
    public SimpleDataPair(Object key)
    {
        super(key);
    }

    public void updateValue(Object newValue)
    {
        this.value = newValue;
    }

    public Object getValue()
    {
        return value;
    }

}
