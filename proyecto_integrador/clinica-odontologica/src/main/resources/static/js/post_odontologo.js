window.addEventListener('load', function () {


    const formulario = document.querySelector('#add_new_odontologo');
    const matricula = document.querySelector('#matricula');
    const nombre = document.querySelector('#nombre');
    const apellido = document.querySelector('#apellido');
    const url = "http://localhost:8082"

    formulario.addEventListener('submit', function (event) {
        event.preventDefault()

        const payload = {
            matricula: matricula.value,
            nombre: nombre.value,
            apellido: apellido.value,
        };

        console.log(payload);
        
        const settings = {
            method: 'POST',
            body: JSON.stringify(payload),
            headers: {
                'Content-Type': 'application/json'
            }
        }

        console.log("Lanzar la consulta a la API...");


        fetch(`${url}/odontologos/registrar`, settings)
            .then(response => response.json())
            .then(data => {

                console.log("funciono el fetch")
                
                 let successAlert = '<div class="alert alert-success alert-dismissible">' +
                     '<button type="button" class="close" data-dismiss="alert">&times;</button>' +
                     '<strong></strong> Odontologo agregado </div>'

                 document.querySelector('#response').innerHTML = successAlert;
                 document.querySelector('#response').style.display = "block";
                 resetUploadForm();

            })
            .catch(error => {

                    let errorAlert = '<div class="alert alert-danger alert-dismissible">' +
                                     '<button type="button" class="close" data-dismiss="alert">&times;</button>' +
                                     '<strong> Error intente nuevamente</strong> </div>'

                      document.querySelector('#response').innerHTML = errorAlert;
                      document.querySelector('#response').style.display = "block";

                     resetUploadForm();})
    });


    function resetUploadForm(){
        document.querySelector('#matricula').value = "";
        document.querySelector('#nombre').value = "";
        document.querySelector('#apellido').value = "";

    }

    
});