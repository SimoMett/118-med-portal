package src.Main.Ems.Domain.Mission.DataField;

public class GraphicalDataPair extends DataField
{
    private IImageAdapter image;
    public GraphicalDataPair(Object key)
    {
        super(key);
    }

    @Override
    public void setValue(Object newValue)
    {

    }

    public void updateImage(IImageAdapter newImage)
    {
        this.image = newImage;
    }

    public IImageAdapter getImage()
    {
        return image;
    }
}
