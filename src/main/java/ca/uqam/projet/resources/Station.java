package ca.uqam.projet.resources;

public class Station
{
    private String id;

    private String terminalName;

    private String nbBikes;

    private String publicxml;

    private String installDate;

    private String nbEmptyDocks;

    private String removalDate;

    private String installed;

    private String lastUpdateTime;

    private String name;

    private String temporary;

    private String lastCommWithServer;

    private String locked;

    private String lat;

    private String longi;

    public String getId ()
    {
        return id;
    }

    public void setId (String id)
    {
        this.id = id;
    }

    public String getTerminalName ()
    {
        return terminalName;
    }

    public void setTerminalName (String terminalName)
    {
        this.terminalName = terminalName;
    }

    public String getNbBikes ()
    {
        return nbBikes;
    }

    public void setNbBikes (String nbBikes)
    {
        this.nbBikes = nbBikes;
    }

    public String getPublicxml ()
    {
        return publicxml;
    }

    public void setPublicxml (String publicxml)
    {
        this.publicxml = publicxml;
    }

    public String getInstallDate ()
    {
        return installDate;
    }

    public void setInstallDate (String installDate)
    {
        this.installDate = installDate;
    }

    public String getNbEmptyDocks ()
    {
        return nbEmptyDocks;
    }

    public void setNbEmptyDocks (String nbEmptyDocks)
    {
        this.nbEmptyDocks = nbEmptyDocks;
    }

    public String getRemovalDate ()
    {
        return removalDate;
    }

    public void setRemovalDate (String removalDate)
    {
        this.removalDate = removalDate;
    }

    public String getInstalled ()
    {
        return installed;
    }

    public void setInstalled (String installed)
    {
        this.installed = installed;
    }

    public String getLastUpdateTime ()
    {
        return lastUpdateTime;
    }

    public void setLastUpdateTime (String lastUpdateTime)
    {
        this.lastUpdateTime = lastUpdateTime;
    }

    public String getName ()
    {
        return name;
    }

    public void setName (String name)
    {
        this.name = name;
    }

    public String getTemporary ()
    {
        return temporary;
    }

    public void setTemporary (String temporary)
    {
        this.temporary = temporary;
    }

    public String getLastCommWithServer ()
    {
        return lastCommWithServer;
    }

    public void setLastCommWithServer (String lastCommWithServer)
    {
        this.lastCommWithServer = lastCommWithServer;
    }

    public String getLocked ()
    {
        return locked;
    }

    public void setLocked (String locked)
    {
        this.locked = locked;
    }

    public String getLat ()
    {
        return lat;
    }

    public void setLat (String lat)
    {
        this.lat = lat;
    }

    public String getLongi ()
    {
        return longi;
    }

    public void setLongi (String longi)
    {
        this.longi = longi;
    }
    
    public void sizeOfStation(){
    
    }

    @Override
    public String toString()
    {
        return "ClassPojo [id = "+id+", terminalName = "+terminalName+", nbBikes = "+nbBikes+", publicxml = "+publicxml+", installDate = "+installDate+", nbEmptyDocks = "+nbEmptyDocks+", removalDate = "+removalDate+", installed = "+installed+", lastUpdateTime = "+lastUpdateTime+", name = "+name+", temporary = "+temporary+", lastCommWithServer = "+lastCommWithServer+", locked = "+locked+", lat = "+lat+", longi = "+longi+"]";
    }
}
			
			