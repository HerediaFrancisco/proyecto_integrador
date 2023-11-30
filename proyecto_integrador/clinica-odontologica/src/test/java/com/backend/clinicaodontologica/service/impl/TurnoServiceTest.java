package com.backend.clinicaodontologica.service.impl;

import com.backend.clinicaodontologica.dto.salida.turno.TurnoSalidaDto;
import com.backend.clinicaodontologica.exceptions.ResourceNotFoundException;
import org.junit.Test;
import org.junit.jupiter.api.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class TurnoServiceTest {
    @Autowired
    private TurnoService turnoService;

    @Test
    @Order(1)
    void alIntentarCancelarTurnoNoExistente_deberiaLanzarUnaResourceNotFoundException() {
        assertThrows(ResourceNotFoundException.class, () -> turnoService.eliminarTurno(100L));
    }

    @Test
    @Order(2)
    void alIntentarEliminarUnTurnoConId1YaEliminado_deberiaLanzarUnaResourceNotFoundException(){

        try{
            turnoService.eliminarTurno(1L);
        } catch (Exception exception){
            exception.printStackTrace();
        }

        assertThrows(ResourceNotFoundException.class, () -> turnoService.eliminarTurno(1L));
    }

    @Test
    @Order(3)
    void deberiaDevolverUnaListaVaciaDeTurnos(){

        List<TurnoSalidaDto> turnosDto = turnoService.listarTurnos();
        assertTrue(turnosDto.isEmpty());

    }
}