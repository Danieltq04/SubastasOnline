$(document).on('click', '.busqueda', function () {
    var codigoPostal = document.getElementById("input-texto").value;
    let url
    if(codigoPostal){
        url = "http://localhost:8088/api/OfferController/getByPostalCode/"+codigoPostal;
    }
    else {
        url = "http://localhost:8088/api/OfferController/";
    }
    return fetch(url, {
        method:"GET",
        headers: {
            'Content-Type': 'application/json',
        },
    })
        .then(response => {
            return response.json()
        })
        .then(json => {
            CargarOfertas(json);
        })
        .catch(err => console.log('ERROR: ' + err))


});
function CargarOfertas(Libro) {
    var i = 0;
    $('.contenedor-tarjetas').empty();
    var main = $('#contenedor-tarjetas');
    Libro.forEach(libro => {
        var card = `
        <button id="tarjeta" value = '${i}'>
              <div class="trabajo">
                <div class="descripcion-trabajo">${libro.description}</div>
              </div>
              <div class="titulo">Ubicación</div>
              <div class="detalles-dos">
                <div class="zona">${libro.zone}</div>
                <div class="codigo-postal">C. P.: ${libro.postalCode}</div>
              </div>
              <div class="titulo">Ofertante</div>
              <div class="detalles-uno">
                <div class="nombre">Daniel</div>
              </div>
              <div class="titulo">Precio</div>
              <div class="detalles-uno">
                <div class="precio">Valor: ${libro.price}$</div>
              </div>
            </button>
        `
        main.append(card);
        //console.log(libro.id);
        i++;
    })
}