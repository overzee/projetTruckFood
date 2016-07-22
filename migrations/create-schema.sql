create table foodTruck (
    truckId text primary key
  , name text
  , description text
  , fromdate date
  , heureDebut text
  , heureFin text
  , lieu text
  , camion text
  , longitude text
  , latitude text
);

insert into foodTruck(truckId,name,description,fromdate,heureDebut,heureFin,lieu,camion
,longitude,latitude) values ('123091823nadf','ethienne','je suis le meilleur','2016-12-08','10:00','20:00','Repentigny','mon camion','45.755446','-73.481597');

create table bixi(
	id int primary key
	, name text
	, terminalName text
	, lastCommWithServer int
	, latitude text
	, longitude text
	, installed boolean
	, locked boolean
	, installDate date
	, removalDate date
	, temporary boolean
	, public boolean
	, nbBikes int 
	, nbEmptyDocks int
	, lastUpdateTime int
);