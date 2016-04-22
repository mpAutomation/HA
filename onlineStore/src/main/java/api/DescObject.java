package api;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class DescObject
{
    private Precision precision;

    private List<Fuel_stations> fuel_stations;

    private String station_locator_url;

    private Station_counts station_counts;

    private String longitude;

    private String latitude;

    private String offset;

    private String total_results;

    public Precision getPrecision ()
    {
        return precision;
    }

    public void setPrecision (Precision precision)
    {
        this.precision = precision;
    }

    public List<Fuel_stations> getFuel_stations ()
    {
        return fuel_stations;
    }

    public void setFuel_stations (List<Fuel_stations> fuel_stations)
    {
        this.fuel_stations = fuel_stations;
    }

    public String getStation_locator_url ()
    {
        return station_locator_url;
    }

    public void setStation_locator_url (String station_locator_url)
    {
        this.station_locator_url = station_locator_url;
    }

    public Station_counts getStation_counts ()
    {
        return station_counts;
    }

    public void setStation_counts (Station_counts station_counts)
    {
        this.station_counts = station_counts;
    }

    public String getLongitude ()
    {
        return longitude;
    }

    public void setLongitude (String longitude)
    {
        this.longitude = longitude;
    }

    public String getLatitude ()
    {
        return latitude;
    }

    public void setLatitude (String latitude)
    {
        this.latitude = latitude;
    }

    public String getOffset ()
    {
        return offset;
    }

    public void setOffset (String offset)
    {
        this.offset = offset;
    }

    public String getTotal_results ()
    {
        return total_results;
    }

    public void setTotal_results (String total_results)
    {
        this.total_results = total_results;
    }

    @Override
    public String toString()
    {
        return "ClassPojo [precision = "+precision+", fuel_stations = "+fuel_stations+", station_locator_url = "+station_locator_url+", station_counts = "+station_counts+", longitude = "+longitude+", latitude = "+latitude+", offset = "+offset+", total_results = "+total_results+"]";
    }
}
			
			