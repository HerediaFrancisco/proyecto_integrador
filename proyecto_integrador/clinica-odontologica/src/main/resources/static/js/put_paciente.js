/*window.addEventListener('load', function () {



    const formulario = document.querySelector('#update_odontologo_form');

    formulario.addEventListener('submit', function (event) {
        let pacienteId = document.querySelector('#paciente_id').value;


        const formData = {
            id: document.querySelector('#paciente_id').value,
            nombre: document.querySelector('#nombre').value,
            apellido: document.querySelector('#apellido').value,
            dni: document.querySelector('#dni').value,
            fechaIngreso: document.querySelector('#fechaIngreso').value,
            email: document.querySelector('#email').value = paciente.email;
            calle: document.querySelector('#calle').value = paciente.domicilio.calle;
            numero: document.querySelector('#numero').value = paciente.domicilio.numero;
            localidad: document.querySelector('#localidad').value = paciente.domicilio.localidad;
            provincia: document.querySelector('#provincia').value = paciente.domicilio.provincia;

        };


        const url = '/paciente';
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
          const url = '/paciente'+"/"+id;
          const settings = {
              method: 'GET'
          }
          fetch(url,settings)
          .then(response => response.json())
          .then(data => {
              let paciente = data;
              document.querySelector('#paciente_id').value = paciente.id;
              document.querySelector('#nombre').value = paciente.matricula;
              document.querySelector('#apellido').value = paciente.nombre;
              document.querySelector('#dni').value = paciente.apellido;
              document.querySelector('#fechaIngreso').value = paciente.fechaIngreso;
              document.querySelector('#email').value = paciente.email;
              document.querySelector('#calle').value = paciente.domicilio.calle;
              document.querySelector('#numero').value = paciente.domicilio.numero;
              document.querySelector('#localidad').value = paciente.domicilio.localidad;
              document.querySelector('#provincia').value = paciente.domicilio.provincia;

              document.querySelector('#div_paciente_updating').style.display = "block";
          }).catch(error => {
              alert("Error: " + error);
          })
      }
      */