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

create table arceau(
	inv_id int primary key
	, inv_no text
	, anc_num int
	, inv_catl_no int
	, catl_modele text
	, marq text
	, date_inspection date
	, ce_no  int
	, element text
	, categorie text
	, couleur text
	, materiau text
	, condition text
	, intervention text
	, empl_x text
	, empl_y text
	, empl_z text
	, territoire text
	, statut text
	, base text
	, ancrage text
	, parc text
	, aire text
	, empl_id int
	, ordre_affichage int
	, long text
	, lat text
);