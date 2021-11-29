
$(document).on('click', '#register', function () {

    var nombre = document.getElementById("nombre").value;
    var apellido = document.getElementById("apellido").value;
    var rol = document.getElementById("rol").value;
    var email = document.getElementById("email").value;
    var password = document.getElementById("password").value;


    var regExp = /^[a-zA-Z0-9.!#$%&'*+/=?^_`{|}~-]+@[a-zA-Z0-9-]+(?:\.[a-zA-Z0-9-]+)*$/;

    if (email == null || email == "" || !regExp.test(email)) {
        alert("Debe ingresar un mail válido");
    }
    else if (nombre == "" || apellido == "" || password == "" ){
        alert("Debe completar todos los campos");
    }
    else if(rol== "Seleccione"){
        alert("Ingrese una opción para el rol");
    }
});
window.onload = () => {
    console.log("A")
}
