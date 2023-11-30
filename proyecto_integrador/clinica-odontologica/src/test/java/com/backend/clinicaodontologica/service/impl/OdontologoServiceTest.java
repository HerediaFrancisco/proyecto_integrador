package com.backend.clinicaodontologica.service.impl;

import com.backend.clinicaodontologica.dto.entrada.odontologo.OdontologoEntradaDto;
import com.backend.clinicaodontologica.dto.salida.odontologo.OdontologoSalidaDto;
import com.backend.clinicaodontologica.exceptions.ResourceNotFoundException;
import org.junit.Test;
import org.junit.jupiter.api.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class OdontologoServiceTest {
    @Autowired
    private OdontologoService odontologoService;

    @Test
    void alIntentarBuscarUnOdontologoInexistente_DeberiaLanzarUnaExcepcion(){

    }
/*
    @Test
    @Order(1)
    void deberiaActualizarInformacionDeOdontologoExistente() {
        OdontologoEntradaDto odontologoActualizadoDto = new OdontologoEntradaDto("Juan", "Lopez", "56789");
        OdontologoSalidaDto odontologoActualizado = odontologoService.actualizarOdontologo();

        assertNotNull(odontologoActualizado);
        assertEquals("Juan", odontologoActualizado.getNombre());
        assertEquals("Lopez", odontologoActualizado.getApellido());
    }

    @Test
    @Order(2)
    void alIntentarActualizarOdontologoNoExistente_deberiaLanzarUnaResourceNotFoundException() {
        OdontologoEntradaDto odontologoActualizadoDto = new OdontologoEntradaDto("Ana", "Gomez", "98765");

        assertThrows(ResourceNotFoundException.class, () -> odontologoService.actualizarOdontologo(100L, odontologoActualizadoDto));
    }

    @Test
    @Order(3)
    void deberiaDevolverUnaListaVaciaDeOdontologos(){

        List<OdontologoSalidaDto> odontologoDto = odontologoService.listarOdontologos();
        assertTrue(odontologoDto.isEmpty());

    }

 */

}

