package src.Main.Ems.Domain.Mission;

public class SimpleDataField extends DataField<String>
{
    public SimpleDataField(String initialValue)
    {
        super(initialValue);
    }

    public void updateValue(String newValue) throws IllegalAccessException
    {
        if(!canModify() || isImmutable())
            throw new IllegalAccessException("Data field is locked or immutable");
        this.value = newValue;
    }

    @Override
    public void setValue(String newVal)
    {
        value = newVal;
    }

    public String getValue()
    {
        return value;
    }
}
