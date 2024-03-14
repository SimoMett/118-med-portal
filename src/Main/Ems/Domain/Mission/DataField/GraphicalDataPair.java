package src.Main.Ems.Domain.Mission.DataField;

public class GraphicalDataPair extends DataField
{
    private IImageAdapter imageAdapter;
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
        this.imageAdapter = newImage;
    }

    public IImageAdapter getImage()
    {
        return imageAdapter;
    }
}
