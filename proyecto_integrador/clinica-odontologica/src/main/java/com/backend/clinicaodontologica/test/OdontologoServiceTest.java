package com.backend.clinicaodontologica.test;




import com.backend.clinicaodontologica.dao.impl.OdontologoDaoH2;
import com.backend.clinicaodontologica.model.Odontologo;
import com.backend.clinicaodontologica.service.impl.OdontologoService;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;




class OdontologoServiceTest {

    private final OdontologoService odontologoService = new OdontologoService(new OdontologoDaoH2());

    /*
    @BeforeAll
    static void doBefore(){
        Connection connection = null;
        try {
            Class.forName("org.h2.Driver");
            connection = DriverManager.getConnection("jdbc:h2:~/c1Clinica;INIT=RUNSCRIPT FROM 'create.sql'", "sa", "sa");

        } catch (Exception e){
            e.printStackTrace();
        } finally {
            try {
                connection.close();
            } catch (Exception ex){
                ex.printStackTrace();
            }
        }
    }*/


    @Test
    public void deberiaAgregarUnOdontologo() {
        Odontologo odontologo = new Odontologo("12345", "Patricia", "Damiani");

        Odontologo odontologoTest = odontologoService.guardarOdontologo(odontologo);

        assertTrue(odontologoTest.getId() != 0);

    }

    @Test
    public void listarTodosLosOdontologos() {
        List<Odontologo> odontologoList = odontologoService.listarOdontologos();
        assertFalse(odontologoList.isEmpty());

    }


}