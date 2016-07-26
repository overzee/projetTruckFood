create table foodTruck (
    truckId text primary key
  , name text
  , description text
  , fromdate text
  , heureDebut text
  , heureFin text
  , lieu text
  , camion text
  , longitude text
  , latitude text
);

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