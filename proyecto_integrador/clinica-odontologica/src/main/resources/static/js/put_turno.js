window.addEventListener('load', function () {



    const formulario = document.querySelector('#update_turno_form');

    formulario.addEventListener('submit', function (event) {
        let turnoId = document.querySelector('#turno_id').value;


        const formData = {
            id: document.querySelector('#turno_id').value,
            fechaTurno: document.querySelector('#fechaTurno').value,
            horaTurno: document.querySelector('#horaTurno').value,
            pacienteId: document.querySelector('#pacienteId').value,
            odontologoId: document.querySelector('#odontologoId').value
        };


        const url = '/turno';
        const settings = {
            method: 'PUT',
            headers: {
                'Content-Type': 'application/json',
            },
            body: JSON.stringify(formData)
        }
          fetch(url,settings)
          .then(response => response.json())

    })
 })


    function findBy(id) {
          const url = '/turno'+"/"+id;
          const settings = {
              method: 'GET'
          }
          fetch(url,settings)
          .then(response => response.json())
          .then(data => {
              let paciente = data;
              document.querySelector('#turno_id').value = turno.id;
              document.querySelector('#fechaTurno').value = turno.fechaTurno;
              document.querySelector('#horaTurno').value = turno.horaTurno;
              document.querySelector('#pacienteId').value = turno.pacienteId;
              document.querySelector('#odontologoId').value = turno.odontologoId;

              document.querySelector('#div_turno_updating').style.display = "block";
          }).catch(error => {
              alert("Error: " + error);
          })
      }