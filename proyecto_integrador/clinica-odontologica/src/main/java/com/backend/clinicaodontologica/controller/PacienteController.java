package com.backend.clinicaodontologica.controller;

import com.backend.clinicaodontologica.model.Paciente;
import com.backend.clinicaodontologica.service.IPacienteService;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/pacientes")
public class PacienteController {


    private IPacienteService pacienteService;

    public PacienteController(IPacienteService pacienteService) {
        this.pacienteService = pacienteService;
    }

    @PostMapping("/registrar")
    public Paciente registrarPaciente(@RequestBody Paciente paciente){
        return pacienteService.registrarPaciente(paciente);
    }

    //PUT
    @PutMapping("/actualizar")
    public Paciente actualizarPaciente( @RequestBody Paciente paciente){
        return pacienteService.actualizarPaciente(paciente);
    }


    @GetMapping("/{id}")
    public Paciente buscarPacientePorId(@PathVariable int id){
        return pacienteService.buscarPacientePorId(id);
    }

    @DeleteMapping("/eliminar/{id}")
    public Paciente eliminarPacientePorId(@PathVariable int id){

        return pacienteService.eliminarPacientePorId(id);
    }

    /* TODO LO QUE SEA "ELIMINAR PACIENTE" TANTO EN "PACIENTE SERVICE", "IPACIENTESERVICE" Y "PACIENTEDAOH2" DEBE SER ELIMINADO.
    *   TAMBIEN DEBE SER ELIMINADOS DE DOMICILIODAOH2 Y DE ODONTOLOGODAOH2*/

}
