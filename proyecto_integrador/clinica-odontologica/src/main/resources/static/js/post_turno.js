window.addEventListener('load', function () {


    const formulario = document.querySelector('#add_new_turno');
    const fechaYHora = document.querySelector('#fechaTurno');
    const odontologo_id = document.querySelector('#odontologoId');
    const paciente_id = document.querySelector('#pacienteId');
    const url = "http://localhost:8082";

    formulario.addEventListener('submit', function (event) {
        event.preventDefault()

        const payload = {
            fechaYHora: fechaYHora.value.replace('T',' ')+":00",
            odontologo_id: odontologo_id.value,
            paciente_id: paciente_id.value,
        };
        console.log(fechaYHora);
        console.log(payload);

        const settings = {
            method: 'POST',
            body: JSON.stringify(payload),
            headers: {
                'Content-Type': 'application/json',
            }
        }

        

        fetch(`${url}/turnos/registrar`, settings)
            .then(response => response.json())
            .then(data => {

                 let successAlert = '<div class="alert alert-success alert-dismissible">' +
                     '<button type="button" class="close" data-dismiss="alert">&times;</button>' +
                     '<strong></strong> Turno agregado </div>'

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
        document.querySelector('#fechaTurno').value = "";
        document.querySelector('#pacienteId').value = "";
        document.querySelector('#odontologoId').value = "";

    }

});