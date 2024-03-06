package src.Main.Ems.Domain.Mission;

public class SimpleDataField extends DataField<String>
{
    public SimpleDataField(String initialValue)
    {
        super(initialValue);
    }

    @Override
    public void setValue(String newVal) throws IllegalAccessException
    {
        if(!canModify() || isImmutable())
            throw new IllegalAccessException("Data field is locked or immutable");
        this.value = newVal;
    }

    public String getValue()
    {
        return value;
    }
}
