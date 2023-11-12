package com.backend.clinicaodontologica.controller;

import com.backend.clinicaodontologica.dto.entrada.paciente.PacienteEntradaDto;
import com.backend.clinicaodontologica.dto.salida.paciente.PacienteSalidaDto;
import com.backend.clinicaodontologica.model.Paciente;
import com.backend.clinicaodontologica.service.IPacienteService;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/pacientes")
public class PacienteController {


    private IPacienteService pacienteService;

    public PacienteController(IPacienteService pacienteService) {
        this.pacienteService = pacienteService;
    }
    @PostMapping("/registrar")
    public ResponseEntity<PacienteSalidaDto> registrarPaciente(@RequestBody @Valid PacienteEntradaDto paciente){
        return new ResponseEntity<>(pacienteService.registrarPaciente(paciente), HttpStatus.CREATED);
    }


    //GET
    @GetMapping("{id}")
    public ResponseEntity<PacienteSalidaDto> obtenerPacientePorId(@PathVariable int id){
        return new ResponseEntity<>(pacienteService.buscarPacientePorId(id), HttpStatus.OK);
    }

    @GetMapping("/listar")
    public ResponseEntity<List<PacienteSalidaDto>> listarPacientes(){
        return new ResponseEntity<>(pacienteService.listarPacientes(), HttpStatus.OK);
    }

    //PUT
    @PutMapping("/actualizar")
    public Paciente actualizarPaciente(@RequestBody Paciente paciente){
        return pacienteService.actualizarPaciente(paciente);
    }

    @DeleteMapping("/eliminar/{id}")
    public Paciente eliminarPacientePorId(@PathVariable int id){

        return pacienteService.eliminarPacientePorId(id);
    }

    /* TODO LO QUE SEA "ELIMINAR PACIENTE" TANTO EN "PACIENTE SERVICE", "IPACIENTESERVICE" Y "PACIENTEDAOH2" DEBE SER ELIMINADO.
    *   TAMBIEN DEBE SER ELIMINADOS DE DOMICILIODAOH2 Y DE ODONTOLOGODAOH2*/

}
