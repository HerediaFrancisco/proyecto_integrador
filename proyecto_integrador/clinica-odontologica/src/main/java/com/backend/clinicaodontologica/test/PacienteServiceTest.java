package com.backend.clinicaodontologica.test;


import com.backend.clinicaodontologica.dao.impl.PacienteDaoH2;
import com.backend.clinicaodontologica.model.Domicilio;
import com.backend.clinicaodontologica.model.Paciente;
import com.backend.clinicaodontologica.service.impl.PacienteService;
import org.junit.Test;

import java.time.LocalDate;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;


class PacienteServiceTest {
    private PacienteService pacienteService = new PacienteService(new PacienteDaoH2());

    /*

    @BeforeAll
    static void doBefore() {
        Connection connection = null;
        try {
            Class.forName("org.h2.Driver");
            connection = DriverManager.getConnection("jdbc:h2:~/c1Clinica;INIT=RUNSCRIPT FROM 'create.sql'", "sa", "sa");

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                connection.close();
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
    }*/


    @Test
    void deberiaAgregarUnPaciente(){

        Paciente paciente = new Paciente("Nombre", "Apellido", 123456, LocalDate.of(2023, 05, 02), new Domicilio("Calle", 13, "Localidad", "Provincia"));

        Paciente pacienteRegistrado = pacienteService.registrarPaciente(paciente);

       assertTrue(pacienteRegistrado.getId() != 0);

    }

    @Test
    void deberiaRetornarUnaListaNoVacia(){

        assertFalse(pacienteService.listarPacientes().isEmpty());

    }
}