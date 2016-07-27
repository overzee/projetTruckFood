function displayMap() {
    // .accessToken = 'pk.eyJ1IjoiZXRocm95IiwiYSI6ImNpcGlybTFoejAxc2N0bG5qdnF0dGlhdmMifQ.RHRRzwl4iOS3X54tjJ3cTQ';
    L.accessToken = 'pk.eyJ1IjoiZXRocm95IiwiYSI6ImNpcGlybTFoejAxc2N0bG5qdnF0dGlhdmMifQ.RHRRzwl4iOS3X54tjJ3cTQ';
    var map = L.map('map').setView([45.509562, -73.567948], 9);
    L.tileLayer('http://{s}.tile.osm.org/{z}/{x}/{y}.png', {}).addTo(map);
    map.invalidateSize();
    displayPinPoint(map);
}

function displayPinPoint(_map) {
    var markerLocation = new L.LatLng(45.509562, -73.567948);
    var marker = new L.Marker(markerLocation);
    _map.addLayer(marker);
    var popup = L.popup()
    .setContent("<b>Hello world!</b><br>I am a popup. What if i'm adding a lot of text ? <br> Is it going to be a little ugly ?");

    marker.bindPopup(popup).openPopup();
}

function search() {
    console.log("je suis dans le search");
    pattern = new RegExp(/(\d{4})[-\/](\d{2})[-\/](\d{2})/);
    var userStart = document.forms['searchForm']["startDate"].value;
    var userEnd = document.forms['searchForm']["endDate"].value;
    if (userStart !== "" && userEnd !== "" && validDates(userStart, userEnd)) {
        if (!isValidDate(userStart) && !isValidDate(userEnd) && !validDates(userStart, userEnd)) {
            window.alert("failed");
        } else {
            // req.open('GET', "http://localhost:8080/getTrucks?du=" + userStart + "&au=" + userEnd, false); 
            console.log('Je suis dans le else');
            var url = "http://localhost:8080/getTrucks?du=" + userStart + "&au=" + userEnd;
            var representationOfDesiredState = "The cheese is old and moldy, where is the bathroom?";

            var client = new XMLHttpRequest();

            client.open("GET", url, false);

            client.setRequestHeader("Content-Type", "text/json");

            client.send(representationOfDesiredState);

            if (client.status == 200)
                alert("The request succeeded!\n\nThe response representation was:\n\n" + client.responseText)
            else
                alert("The request did not succeed!\n\nThe response status was: " + client.status + " " + client.statusText + ".");
        }

    } else {
        window.alert("Be sure your dates are well formed and start is before end.")
    }
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

var getJSON = function(url, successHandler, errorHandler) {
    var xhr = typeof XMLHttpRequest != 'undefined'
    ? new XMLHttpRequest()
    : new ActiveXObject('Microsoft.XMLHTTP');
    xhr.open('get', url, true);
    xhr.onreadystatechange = function() {
        var status;
        var data;
        // https://xhr.spec.whatwg.org/#dom-xmlhttprequest-readystate
        if (xhr.readyState == 4) { // `DONE`
            status = xhr.status;
            if (status == 200) {
                data = JSON.parse(xhr.responseText);
                successHandler && successHandler(data);
            } else {
                errorHandler && errorHandler(status);
            }
        }
    };
    xhr.send();
};




function isValidDate(dateString) {
    var regEx = /^\d{4}-\d{2}-\d{2}$/;
    return dateString.match(regEx) != null;
}

