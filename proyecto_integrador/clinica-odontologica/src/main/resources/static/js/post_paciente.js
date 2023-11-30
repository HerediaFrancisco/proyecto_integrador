window.addEventListener('load', function () {


    const formulario = document.querySelector('#add_new_paciente');
    
    const nombre = document.querySelector('#nombre');
    const apellido = document.querySelector('#apellido');
    const dni = document.querySelector('#dni');
    const fechaIngreso = document.querySelector('#fechaIngreso');
    const calle = document.querySelector('#calle');
    const numero = document.querySelector('#numero');
    const localidad = document.querySelector('#localidad');
    const provincia = document.querySelector('#provincia');
    const url = "http://localhost:8082";

    
    formulario.addEventListener('submit', function (event) {
        event.preventDefault()

        const payload = {
            nombre: nombre.value,
            apellido: apellido.value,
            dni: dni.value,
            fechaIngreso: fechaIngreso.value,
            domicilioEntradaDto: {
                    calle: calle.value,
                    numero: numero.value,
                    localidad: localidad.value,
                    provincia: provincia.value,
            }
        };

        console.log(payload);


        const settings = {
            method: 'POST',
            body: JSON.stringify(payload),
            headers: {
                'Content-Type': 'application/json',
            }
            
        }

        console.log("Lanzar la consulta a la API...");


        fetch(`${url}/pacientes/registrar`, settings)
            
            .then(response => response.json())
            .then(data => {

                 let successAlert = '<div class="alert alert-success alert-dismissible">' +
                     '<button type="button" class="close" data-dismiss="alert">&times;</button>' +
                     '<strong></strong> Paciente agregado </div>'

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
        document.querySelector('#nombre').value = "";
        document.querySelector('#apellido').value = "";
        document.querySelector('#dni').value = "";
        document.querySelector('#fechaIngreso').value = "";
        document.querySelector('#calle').value = "";
        document.querySelector('#numero').value = "";
        document.querySelector('#localidad').value = "";
        document.querySelector('#provincia').value = "";

    }

    
});