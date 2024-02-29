package src.Main.Ems.Domain.Mission;

public class GraphicalDataPair extends DataPair
{
    private IImage image;
    public GraphicalDataPair(Object key)
    {
        super(key);
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
