package com.backend.clinicaodontologica.service.impl;



import com.backend.clinicaodontologica.dao.IDao;
import com.backend.clinicaodontologica.dto.entrada.paciente.PacienteEntradaDto;
import com.backend.clinicaodontologica.dto.salida.paciente.PacienteSalidaDto;
import com.backend.clinicaodontologica.model.Paciente;
import com.backend.clinicaodontologica.service.IPacienteService;
import com.backend.clinicaodontologica.utils.JsonPrinter;
import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PacienteService implements IPacienteService {

    private final Logger LOGGER = LoggerFactory.getLogger(PacienteService.class);

    private IDao<Paciente> pacienteIDao;
    private ModelMapper modelMapper;

    public PacienteService(IDao<Paciente> pacienteIDao, ModelMapper modelMapper) {
        this.pacienteIDao = pacienteIDao;
        this.modelMapper = modelMapper;
        configureMapping();
    }
    @Override
    public PacienteSalidaDto registrarPaciente(PacienteEntradaDto paciente){
        //convertimos mediante el mapper de dtoEntrada a entidad
        LOGGER.info("PacienteEntradaDto: " + JsonPrinter.toString(paciente));
        Paciente pacienteEntidad = modelMapper.map(paciente, Paciente.class);

        //mandamos a persistir a la capa dao y obtenemos una entidad
        Paciente pacienteAPersistir = pacienteIDao.registrar(pacienteEntidad);
        //transformamos la entidad obtenida en salidaDto
        PacienteSalidaDto pacienteSalidaDto = modelMapper.map(pacienteAPersistir, PacienteSalidaDto.class);
        LOGGER.info("PacienteSalidaDto: " + JsonPrinter.toString(pacienteSalidaDto));
        return pacienteSalidaDto;
    }
    @Override
    public List<PacienteSalidaDto> listarPacientes(){
        List<PacienteSalidaDto> pacientesSalidaDto = pacienteIDao.listarTodos()
                .stream()
                .map(paciente -> modelMapper.map(paciente, PacienteSalidaDto.class))
                .toList();
        
        LOGGER.info("Listado de todos los pacientes: {}", pacientesSalidaDto);
        return pacientesSalidaDto;
    }

    @Override
    public PacienteSalidaDto buscarPacientePorId(int id) {
        Paciente pacienteBuscado = pacienteIDao.buscarPorId(id);
        PacienteSalidaDto pacienteEncontrado = null;

        if(pacienteBuscado != null){
            pacienteEncontrado =  modelMapper.map(pacienteBuscado, PacienteSalidaDto.class);
            LOGGER.info("Paciente encontrado: {}", pacienteEncontrado);
        } else LOGGER.error("El id no se encuentra registrado en la base de datos");

        return pacienteEncontrado;
    }

    @Override
    public Paciente actualizarPaciente(Paciente paciente) {
        return pacienteIDao.actualizar(paciente);
    }

    @Override
    public Paciente eliminarPacientePorId(int id) {
        return null;
    }


    private void configureMapping(){
        modelMapper.typeMap(PacienteEntradaDto.class, Paciente.class)
                .addMappings(modelMapper -> modelMapper.map(PacienteEntradaDto::getDomicilioEntradaDto, Paciente::setDomicilio));
        modelMapper.typeMap(Paciente.class, PacienteSalidaDto.class)
                .addMappings(modelMapper -> modelMapper.map(Paciente::getDomicilio, PacienteSalidaDto::setDomicilioSalidaDto));

    }
}
