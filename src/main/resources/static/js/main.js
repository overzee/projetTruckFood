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
    var userStart = document.forms['searchForm']["startDate"].value;
    var userEnd = document.forms['searchForm']["endDate"].value;
    if (userStart !== "" && userEnd !== "" && validDates(userStart,userEnd)) {

        if (!isValidDate(userStart)  && !isValidDate(userEnd) && !validDates(userStart,userEnd)) {
            window.alert("failed");
        } else {
            $(document).ready(function() {
                $.ajax({
                    url: "http://localhost:8080/getTrucks?du="+userStart+"&au="+userEnd
                }).then(function(data) {
                    console.log("allo calvaire");
                    // $('.greeting-id').append(data.id);
                    // $('.greeting-content').append(data.content);
                });
            });        }
    } else {
        window.alert("Be sure your dates are well formed and start is before end.")
    }
}

/*
* dates are passed from user.
*
 */
function getTrucks(start,end){
    
}

function validDates(start,end){
    var date1 = new Date(start);
    var date2 = new Date(end);
    console.log(date1 < date2);
    if(date1 < date2){
        return true;
    }else{
        return false;
    }

}


function isValidDate(dateString) {
    var regEx = /^\d{4}-\d{2}-\d{2}$/;
    return dateString.match(regEx) != null;
}

