var map;
function displayMap() {
    // .accessToken = 'pk.eyJ1IjoiZXRocm95IiwiYSI6ImNpcGlybTFoejAxc2N0bG5qdnF0dGlhdmMifQ.RHRRzwl4iOS3X54tjJ3cTQ';
    L.accessToken = 'pk.eyJ1IjoiZXRocm95IiwiYSI6ImNpcGlybTFoejAxc2N0bG5qdnF0dGlhdmMifQ.RHRRzwl4iOS3X54tjJ3cTQ';
    map = L.map('map').setView([45.509562, -73.567948], 9);
    L.tileLayer('http://{s}.tile.osm.org/{z}/{x}/{y}.png', {}).addTo(map);
    map.invalidateSize();
}

function displayMarkerOnMap(header,ondate, arr,depart,lat,long) {
    var markerLocation = new L.LatLng(lat, long);
    var marker = new L.Marker(markerLocation);
    map.addLayer(marker);
    var popup = L.popup()
    .setContent("<h3>"+header+"</h3> On date: " + ondate +"<br>Arrival time: " + arr + "<br>Departure time:" + depart);
    marker.bindPopup(popup).openPopup();
}

function search() {
    pattern = new RegExp(/(\d{4})[-\/](\d{2})[-\/](\d{2})/);
    var userStart = document.forms['searchForm']["startDate"].value;
    var userEnd = document.forms['searchForm']["endDate"].value;
    if (userStart !== "" && userEnd !== "" && validDates(userStart, userEnd)) {
        if (!isValidDate(userStart) && !isValidDate(userEnd) && !validDates(userStart, userEnd)) {
            window.alert("failed");
        } else {
            // req.open('GET', "http://localhost:8080/getTrucks?du=" + userStart + "&au=" + userEnd, false); 
            var url = "http://localhost:8080/getTrucks?du=" + userStart + "&au=" + userEnd;
            var representationOfDesiredState = "The cheese is old and moldy, where is the bathroom?";

            var client = new XMLHttpRequest();

            client.open("GET", url, false);

            client.setRequestHeader("Content-Type", "text/json");

            client.send(representationOfDesiredState);

            if (client.status == 200){
                // alert("The request succeeded!\n\nThe response representation was:\n\n" + client.responseText)
                doSomethingWithData(client.responseText);
            }
            else{
                alert("The request did not succeed!\n\nThe response status was: " + client.status + " " + client.statusText + ".");
            }
        }

    } else {
        window.alert("Be sure your dates are well formed and start is before end.")
    }

    return false;
}

/* 
    Function that translate json to object
*/
function doSomethingWithData(json){
    var truckList = JSON.parse(json);
    var table = document.getElementById('truckTable');
    truckList.forEach(function(entry){
        var row = table.insertRow(table.rows.length);
        var camionCell = row.insertCell(0);
        var truckIdCell = row.insertCell(1);
        var lieuCell = row.insertCell(2);
        camionCell.innerHTML = entry.camion;
        truckIdCell.innerHTML = entry.truckid;
        lieuCell.innerHTML = entry.lieu;
        
        // for each truck, we want a marker on map
        displayMarkerOnMap(entry.camion,entry.date, entry.heureDebut,entry.heureFin ,entry.latitude,entry.longitude)

        return false;
    });



    return false;
}


function validDates(start, end) {
    var date1 = new Date(start);
    var date2 = new Date(end);
    if (date1 < date2) {
        return true;
    } else {
        return false;
    }

}

function isValidDate(dateString) {
    var regEx = /^\d{4}-\d{2}-\d{2}$/;
    return dateString.match(regEx) != null;
}

/*
//***********************************************************************************************
//B2 show bixi marker when click on foodtruck marker (onMarkerClick function added to food marker)
//***********************************************************************************************
function onMarkerClick(header,lati, longi, nomStation) {
    var markerLocationBixi = new L.LatLng(lat, long);
    var markerBixi = new L.Marker(markerLocationBixi);
    var popupBixi = L.popup()
    .setContent("<h3>"+header+"</h3> Latitude: " + lati +"<br>Longitude: " + longi + "<br>Nom de la station:" + nomStation);
    markerBixi.bindPopup(popupBixi).openPopup();
}

function searchBixi(){
	
	// req.open('GET', "http://localhost:8080/getBixi?latitude=" + lati + "&longitude=" + longi, false); 
            var url = "http://localhost:8080/getBixi?latitude=" + lati + "&longitude=" + longi;
            
            var client = new XMLHttpRequest();

            client.open("GET", url, false);

            client.setRequestHeader("Content-Type", "text/json");

            client.send(representationOfDesiredState);

            if (client.status == 200){
                // alert("The request succeeded!\n\nThe response representation was:\n\n" + client.responseText)
                doSomethingWithData(client.responseText);
            }
            else{
                alert("The request did not succeed!\n\nThe response status was: " + client.status + " " + client.statusText + ".");
            }
}

function doSomethingWithDataBixi(json){
    var bixiList = JSON.parse(json);
    var table = document.getElementById('bixiTable');
    bixiList.forEach(function(entry){
        var row = table.insertRow(table.rows.length);
        var nameCell = row.insertCell(0);
        var idCell = row.insertCell(1);
        nameCell.innerHTML = entry.name;
        idCell.innerHTML = entry.id;
        
        
        // for each truck, we want a marker on map
        onMarkerClick(entry.name, entry.latitude, entry.longitude, entry.name);

        return false;
    });
    */
