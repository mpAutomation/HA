package api;

public class ELEC
{
    private String total;

    private Stations stations;

    public String getTotal ()
    {
        return total;
    }

    public void setTotal (String total)
    {
        this.total = total;
    }

    public Stations getStations ()
    {
        return stations;
    }

    public void setStations (Stations stations)
    {
        this.stations = stations;
    }

    @Override
    public String toString()
    {
        return "ClassPojo [total = "+total+", stations = "+stations+"]";
    }
}
			
			
