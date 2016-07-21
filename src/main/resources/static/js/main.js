// document.getElementById("btnSubmit").onclick = search();
function displayMap(){
    // .accessToken = 'pk.eyJ1IjoiZXRocm95IiwiYSI6ImNpcGlybTFoejAxc2N0bG5qdnF0dGlhdmMifQ.RHRRzwl4iOS3X54tjJ3cTQ';
    L.accessToken = 'pk.eyJ1IjoiZXRocm95IiwiYSI6ImNpcGlybTFoejAxc2N0bG5qdnF0dGlhdmMifQ.RHRRzwl4iOS3X54tjJ3cTQ';
    // var map = L.map({
    //     container: 'map', // container id
    //     style: 'mapbox.streets', //stylesheet location
    //     center: [45.509562,-73.567948], // starting position
    //     zoom: 9 // starting zoom
    // });
    var map = L.map('map').setView([45.509562,-73.567948], 9);

    L.tileLayer('http://{s}.tile.osm.org/{z}/{x}/{y}.png', {
        // attribution: '&copy; <a href="http://osm.org/copyright">OpenStreetMap</a> contributors'
    }).addTo(map);

    map.invalidateSize();
    displayPinPoint(map);
}
function markerOnClick(e)
{
    alert("hi. you clicked the marker at " + e.latlng);
}
function displayPinPoint(_map){
    var markerLocation = new L.LatLng(45.509562,-73.567948);
    var marker = new L.Marker(markerLocation);
    _map.addLayer(marker);
    var popup = L.popup()
        .setContent("<b>Hello world!</b><br>I am a popup. What if i'm adding a lot of text ? <br> Is it going to be a little ugly ?");

    marker.bindPopup(popup).openPopup();
}



// function () {
//     console.log('ca fonctionne');
//     displayPinPoint();
// }

function search () {
    // console.log(document.forms['searchForm']["startDate"].value);
    pattern = new RegExp(/(\d{4})[-\/](\d{2})[-\/](\d{2})/);
    //separer la date obtenu dans le textField avec exec. faire la verification manuellement....

    if (document.forms['searchForm']["startDate"].value !== "" && document.forms['searchForm']["endDate"].value !== "") {

        if (!pattern.test(document.forms['searchForm']["startDate"].value)) {
            window.alert("failed");
        } else {
            window.alert("passed! ");
        }
    } else {
        window.alert("You have to fill the textbox with dates idiot -_- ")
    }
}

/*
* dates are passed from user.
*
 */
function getTrucks(start,end){
    
}


