package ca.uqam.projet.resources;

import java.util.List;


public class Bixi
{
    private List<Station> stations;

    public List<Station> getStations ()
    {
        return stations;
    }

    public void setStation (List<Station> stations)
    {
        this.stations = stations;
    }
    
    public void addStation(Station station){
        stations.add(station);
    }
    
    public Station getStationFromStations(List<Station> stations, int index){
        return stations.get(index);
    }
    
    public int sizeOfStations(){
        return stations.size();
    }

    @Override
    public String toString()
    {
        return "ClassPojo [station = "+stations+"]";
    }
}
