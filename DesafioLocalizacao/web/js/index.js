$(document).ready(function () {
    $('[data-toggle="tooltip"]').tooltip();
    $(".select2").select2();
    window.dispatchEvent(new Event('resize'));
});

$(window).resize(function () {
    $("tbody").height($(window).height() - 290);
    $("#mapa").height($(window).height() - 300);
});

function myFunction() {
    // Declare variables 
    var input, filter, table, tr, td, i;
    input = document.getElementById("myInput");
    filter = input.value.toUpperCase();
    table = document.getElementById("myTable");
    tr = table.getElementsByTagName("tr");

    // Loop through all table rows, and hide those who don't match the search query
    for (i = 0; i < tr.length; i++) {
        td = tr[i].getElementsByTagName("td")[1];
        if (td) {
            if (td.innerHTML.toUpperCase().indexOf(filter) > -1) {
                tr[i].style.display = "";
            } else {
                tr[i].style.display = "none";
            }
        }
    }
}

var mapa;
var markerAtendente;
var markerLoja;

var atendenteIcon = new L.Icon({
    iconUrl: 'images/marker-icon-2x-green.png',
    shadowUrl: 'images/marker-shadow.png',
    iconSize: [25, 41],
    iconAnchor: [12, 41],
    popupAnchor: [1, -34],
    shadowSize: [41, 41]
});

var lojaIcon = new L.Icon({
    iconUrl: 'images/marker-icon-2x-violet.png',
    shadowUrl: 'images/marker-shadow.png',
    iconSize: [25, 41],
    iconAnchor: [12, 41],
    popupAnchor: [1, -34],
    shadowSize: [41, 41]
});

function criacaoDoMapa() {
    mapa = L.map('mapa').setView([-27.584534, -48.500346], 11);

    L.tileLayer('https://api.tiles.mapbox.com/v4/{id}/{z}/{x}/{y}.png?access_token={accessToken}', {
        attribution: 'Map data &copy; <a href="https://www.openstreetmap.org/">OpenStreetMap</a>, Imagery © <a href="https://www.mapbox.com/">Mapbox</a>',
        maxZoom: 18,
        id: 'mapbox.streets',
        accessToken: 'pk.eyJ1IjoibDNuZmVycyIsImEiOiJjanA0cDNkenAwMmttM3BxZDYwd3NzcGw0In0.j4ijMVLCmP3_u8G22n3I6g'
    }).addTo(mapa);

    L.control.scale().addTo(mapa);
}

function mostrarPonto(latAtendente, lonAtendente, latLoja, lonLoja, nomeAtendente, nomeLoja) {
    if (markerAtendente) {
        mapa.removeLayer(markerAtendente);
    }
    if (markerLoja) {
        mapa.removeLayer(markerLoja);
    }

    markerAtendente = new L.marker([latAtendente, lonAtendente], {icon: atendenteIcon}).bindPopup("<b>Atendente</b><br />" + nomeAtendente).addTo(mapa);
    markerLoja = new L.marker([latLoja, lonLoja], {icon: lojaIcon}).bindPopup("<b>Loja</b><br />" + nomeLoja).addTo(mapa);

    mapa.fitBounds([
        [latAtendente, lonAtendente],
        [latLoja, lonLoja]
    ], {maxZoom: 15});
}