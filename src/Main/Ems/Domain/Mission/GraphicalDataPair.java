package src.Main.Ems.Domain.Mission;

public class GraphicalDataPair extends DataField
{
    private IImage image;
    public GraphicalDataPair(Object key)
    {
        super(key);
    }

    @Override
    public void setValue(Object newValue)
    {

    }

    public void updateImage(IImage newImage)
    {
        this.image = newImage;
    }

    public IImage getImage()
    {
        return image;
    }
}
