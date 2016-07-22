drop table foodTruck;
create table foodTruck ( 
    truckId text primary key
  , description text
  , fromdate date
  , heureDebut text
  , heureFin text
  , lieu text
  , name text
  , camion text
  , longitude text
  , latitude text
);

insert into foodTruck(truckId,description,fromdate,heureDebut,heureFin,lieu,name
,camion,longitude,latitude) values ('T00120010','je suis le meilleur','2016-12-08','10:00','20:00','Repentigny','ethienne','mon camion','45.755446','-73.481597');

drop table bixi;
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