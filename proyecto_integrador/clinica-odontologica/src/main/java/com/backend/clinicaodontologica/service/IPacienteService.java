package com.backend.clinicaodontologica.service;

import com.backend.clinicaodontologica.model.Paciente;

import java.util.List;

public interface IPacienteService {
    Paciente registrarPaciente(Paciente paciente);

    List<Paciente> listarPacientes();
    Paciente buscarPacientePorId(int id);
    Paciente actualizarPaciente(Paciente paciente);
    Paciente eliminarPacientePorId(int id);
}
