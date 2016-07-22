function displayMap(){
    // .accessToken = 'pk.eyJ1IjoiZXRocm95IiwiYSI6ImNpcGlybTFoejAxc2N0bG5qdnF0dGlhdmMifQ.RHRRzwl4iOS3X54tjJ3cTQ';
    L.accessToken = 'pk.eyJ1IjoiZXRocm95IiwiYSI6ImNpcGlybTFoejAxc2N0bG5qdnF0dGlhdmMifQ.RHRRzwl4iOS3X54tjJ3cTQ';
    var map = L.map('map').setView([45.509562,-73.567948], 9);
    L.tileLayer('http://{s}.tile.osm.org/{z}/{x}/{y}.png', {
    }).addTo(map);
    map.invalidateSize();
    displayPinPoint(map);
}

function displayPinPoint(_map){
    var markerLocation = new L.LatLng(45.509562,-73.567948);
    var marker = new L.Marker(markerLocation);
    _map.addLayer(marker);
    var popup = L.popup()
        .setContent("<b>Hello world!</b><br>I am a popup. What if i'm adding a lot of text ? <br> Is it going to be a little ugly ?");

    marker.bindPopup(popup).openPopup();
}

function search () {
    pattern = new RegExp(/(\d{4})[-\/](\d{2})[-\/](\d{2})/);
    var userStart = document.forms['searchForm']["startDate"].value;
    var userEnd = document.forms['searchForm']["endDate"].value;
    if (userStart !== "" && userEnd !== "" && validDates(userStart,userEnd)) {
        if (!isValidDate(userStart)  && !isValidDate(userEnd) && !validDates(userStart,userEnd)) {
            window.alert("failed");
        } else {
            $(document).ready(function() {
                var data = "";
                $.ajax({
                    type:'GET',
                    contentType: "application/json; charset=utf-8",
                    dataType: "json",
                    url: "http://localhost:8080/getTrucks?du="+userStart+"&au="+userEnd,
                    data:JSON.stringify(data),
                    success:function(data){
                        console.log(data.value());
                    },
                    fail:function (err) {
                        console.log(err.value());

                    }
                });
            });
        }
    } else {
        window.alert("Be sure your dates are well formed and start is before end.")
    }
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

