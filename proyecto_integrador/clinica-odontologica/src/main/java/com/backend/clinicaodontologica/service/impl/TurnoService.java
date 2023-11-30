package com.backend.clinicaodontologica.service.impl;

import com.backend.clinicaodontologica.Repository.TurnoRepository;
import com.backend.clinicaodontologica.dto.entrada.turno.TurnoEntradaDto;
import com.backend.clinicaodontologica.dto.modificacion.TurnoModificacionEntradaDto;
import com.backend.clinicaodontologica.dto.salida.odontologo.OdontologoSalidaDto;
import com.backend.clinicaodontologica.dto.salida.paciente.PacienteSalidaDto;
import com.backend.clinicaodontologica.dto.salida.turno.TurnoSalidaDto;
import com.backend.clinicaodontologica.entity.Odontologo;
import com.backend.clinicaodontologica.entity.Turno;
import com.backend.clinicaodontologica.exceptions.BadRequestException;
import com.backend.clinicaodontologica.exceptions.ResourceNotFoundException;
import com.backend.clinicaodontologica.service.ITurnoService;
import com.backend.clinicaodontologica.utils.JsonPrinter;
import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import java.util.List;


@Service
public class TurnoService implements ITurnoService {

    private final Logger LOGGER = LoggerFactory.getLogger(TurnoService.class);
    private final TurnoRepository turnoRepository;
    private final OdontologoService odontologoService;
    private final PacienteService pacienteService;
    private final ModelMapper modelMapper;

    public TurnoService(TurnoRepository turnoRepository, OdontologoService odontologoService, PacienteService pacienteService, ModelMapper modelMapper) {
        this.turnoRepository = turnoRepository;
        this.odontologoService = odontologoService;
        this.pacienteService = pacienteService;
        this.modelMapper = modelMapper;
        configureMapping();
    }

    @Override
    public TurnoSalidaDto registrarTurno(TurnoEntradaDto turno) throws BadRequestException {


        OdontologoSalidaDto odontologo = odontologoService.buscarOdontologoPorId(turno.getOdontologo());
        PacienteSalidaDto paciente = pacienteService.buscarPacientePorId(turno.getPaciente());

        if (odontologo == null && paciente == null) {
            throw new BadRequestException("No se encuentra ni un odontólogo ni un paciente con los ID proporcionados.");
        } else if (odontologo == null) {
            throw new BadRequestException("No se encuentra un odontólogo con el ID proporcionado.");
        } else if (paciente == null) {
            throw new BadRequestException("No se encuentra un paciente con el ID proporcionado.");
        }


        Turno turnoEntidad = modelMapper.map(turno, Turno.class);
        LOGGER.info("Entidad: " + JsonPrinter.toString(turnoEntidad));


        Turno turnoAPersistir = turnoRepository.save(turnoEntidad);
        LOGGER.info("Turno a persistir: " + JsonPrinter.toString(turnoAPersistir));

        TurnoSalidaDto turnoSalidaDto = modelMapper.map(turnoAPersistir, TurnoSalidaDto.class);
        LOGGER.info("TurnoSalidaDto: " + JsonPrinter.toString(turnoSalidaDto));


        turnoSalidaDto.setOdontologo(turno.getOdontologo());
        turnoSalidaDto.setPaciente(turno.getPaciente());

        return turnoSalidaDto;
    }

    @Override
    public List<TurnoSalidaDto> listarTurnos() {


        List<TurnoSalidaDto> turnoSalidaDto = turnoRepository.findAll()
                .stream()
                .map(turno -> modelMapper.map(turno, TurnoSalidaDto.class))
                .toList();



        if (LOGGER.isInfoEnabled()) {

            LOGGER.info("Listado de todos los turnos: {}", JsonPrinter.toString(turnoSalidaDto));
        }


        return turnoSalidaDto;
    }

    @Override
    public TurnoSalidaDto buscarTurnoPorId(Long id) {
        Turno turnoBuscado = turnoRepository.findById(id).orElse(null);

        TurnoSalidaDto turnoEncontrado = null;

        if(turnoBuscado != null){
            turnoEncontrado = modelMapper.map(turnoBuscado, TurnoSalidaDto.class);
            LOGGER.info("Turno encontrado: {}", JsonPrinter.toString(turnoEncontrado));
        }else{
            LOGGER.error("El id no se encuentra registrado en la base de datos");
        }

        return turnoEncontrado;
    }

    @Override
    public TurnoSalidaDto actualizarTurno(TurnoModificacionEntradaDto turno) {
        Turno turnoRecibido = modelMapper.map(turno, Turno.class);
        Turno turnoAActalizar = turnoRepository.findById(turnoRecibido.getId()).orElse(null);

        TurnoSalidaDto turnoSalidaDto = null;

        if(turnoAActalizar != null){
            turnoAActalizar = turnoRecibido;
            turnoRepository.save(turnoAActalizar);

            turnoSalidaDto = modelMapper.map(turnoAActalizar, TurnoSalidaDto.class);
            LOGGER.warn("Turno actualizado: {}", JsonPrinter.toString(turnoSalidaDto));
        }else {
            LOGGER.error("No fue posible actualizar el turno porque no se encuentra en nuestra base de datos");
        }

        return turnoSalidaDto;
    }

    @Override
    public void eliminarTurno(Long id) throws ResourceNotFoundException {
        if(turnoRepository.findById(id).orElse(null) !=null){
            turnoRepository.deleteById(id);
            LOGGER.warn("Se ha eliminado el turno con id: {}", id);
        }
        else {
            LOGGER.error("No se ha encontrado el turno con id {}", id);
            throw new ResourceNotFoundException("No se ha encontrado el turno con id " + id);
        }
    }

    private void configureMapping(){
        modelMapper.typeMap(TurnoEntradaDto.class, Turno.class)
                .addMappings(modelMapper -> modelMapper.map(TurnoEntradaDto::getOdontologo, Turno::setOdontologo))
                .addMappings(modelMapper -> modelMapper.map(TurnoEntradaDto::getPaciente, Turno::setPaciente));
        modelMapper.typeMap(Turno.class, TurnoSalidaDto.class)
                .addMappings(modelMapper -> modelMapper.map(Turno::getOdontologo, TurnoSalidaDto::setOdontologo))
                .addMappings(modelMapper -> modelMapper.map(Turno::getPaciente, TurnoSalidaDto::setPaciente));

        modelMapper.typeMap(TurnoModificacionEntradaDto.class, Turno.class)
                .addMappings(modelMapper -> modelMapper.map(TurnoModificacionEntradaDto::getOdontologo, Turno::setOdontologo))
                .addMappings(modelMapper -> modelMapper.map(TurnoModificacionEntradaDto::getPaciente, Turno::setPaciente));
    }
}
