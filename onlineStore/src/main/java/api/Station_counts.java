package api;

public class Station_counts
{
    private String total;

    private Fuels fuels;

    public String getTotal ()
    {
        return total;
    }

    public void setTotal (String total)
    {
        this.total = total;
    }

    public Fuels getFuels ()
    {
        return fuels;
    }

    public void setFuels (Fuels fuels)
    {
        this.fuels = fuels;
    }

    @Override
    public String toString()
    {
        return "ClassPojo [total = "+total+", fuels = "+fuels+"]";
    }
}
			
			