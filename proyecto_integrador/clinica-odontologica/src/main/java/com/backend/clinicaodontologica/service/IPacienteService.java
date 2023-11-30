package com.backend.clinicaodontologica.service;

import com.backend.clinicaodontologica.dto.entrada.paciente.PacienteEntradaDto;
import com.backend.clinicaodontologica.dto.modificacion.PacienteModificacionEntradaDto;
import com.backend.clinicaodontologica.dto.salida.paciente.PacienteSalidaDto;
import com.backend.clinicaodontologica.exceptions.ResourceNotFoundException;
import org.springframework.web.bind.MethodArgumentNotValidException;

import java.util.List;

public interface IPacienteService {
    PacienteSalidaDto registrarPaciente(PacienteEntradaDto paciente) throws MethodArgumentNotValidException;

    List<PacienteSalidaDto> listarPacientes();

    PacienteSalidaDto buscarPacientePorId(Long id);

    PacienteSalidaDto actualizarPaciente(PacienteModificacionEntradaDto paciente) throws MethodArgumentNotValidException;

    void eliminarPaciente(Long id) throws ResourceNotFoundException;


}
