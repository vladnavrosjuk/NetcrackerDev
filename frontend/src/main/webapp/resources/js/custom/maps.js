

function initMap() {
    var latlng = new google.maps.LatLng(59.9386300,30.3141300);
    var options = {
        zoom: 15,
        center: latlng,

    };

    map = new google.maps.Map(document.getElementById("map"), options);

}

$(document).ready(function() {
    var latmarker = null;
    var lngmarker = null;


    var a = null;
    var b = null;
    var marker;

    google.maps.event.addListener(map, 'click', function(event) {

        placeMarker(event.latLng);

    });

    function placeMarker(location) {
         latmarker = location.lat();
         lngmarker = location.lng();

        if (marker == null)
        {
            marker = new google.maps.Marker({
                position: location,
                map: map
            }); } else {   marker.setPosition(location); } }




   $('.jsClickSearch').click(function (event) {
       var googleGeocoder = new GeocoderJS.createGeocoder({'provider': 'google'});
       googleGeocoder.geocode($('.jsSearchInMap').val(), function(result) {


           b = result[0].longitude;
           a = result[0].latitude;
           map.setCenter(new google.maps.LatLng(a,b));

       });








   })
    $('.jsAddCoordinate').click(function (event) {
        var ids =  $.map($( ".jsRequestsTable " ).bootstrapTable('getSelections'), function (row) {
            return row.idRequest;});
        var obj = {   lat: latmarker,
            lan: lngmarker,
            idRequestList :ids
        }

        $.ajax({
            url: '/saveRequestCoordinate',
            type: 'POST',
            contentType: "application/json",
            dataType: 'text',
            mimeType: 'application/json',
            data: JSON.stringify(obj
            ),
            success: function (xhr) {


            },

        });

    });






});


/*
function initMap() {

    var search = document.getElementById('idSearchMapa');
    search.addListener('click', function(e) {
        // 3 seconds after the center of the map has changed, pan back to the
        // marker.
        alert("lol");
    });
}*/
