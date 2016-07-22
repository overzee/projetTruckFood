create table foodTruck (
    id int primary key
  , name text
  , description text
  , fromdate date
  , heureDebut text
  , heureFin text
  , lieu text
  , camion text
  , truckId text
  , longitude text
  , latitude text
);

insert into foodTruck(id,name,description,fromdate,heureDebut,heureFin,lieu,camion
,truckId,longitude,latitude) values (1,'ethienne','je suis le meilleur','2016-12-08','10:00','20:00','Repentigny','mon camion','123091823nadf','45.755446','-73.481597');

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