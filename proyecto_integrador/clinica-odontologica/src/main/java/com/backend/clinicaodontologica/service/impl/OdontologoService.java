package com.backend.clinicaodontologica.service.impl;

import com.backend.clinicaodontologica.dao.IDao;
import com.backend.clinicaodontologica.dto.entrada.paciente.OdontologoEntradaDto;
import com.backend.clinicaodontologica.dto.salida.paciente.OdontologoSalidaDto;
import com.backend.clinicaodontologica.model.Odontologo;
import com.backend.clinicaodontologica.service.IOdontologoService;
import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OdontologoService implements IOdontologoService {
    private final Logger LOGGER = LoggerFactory.getLogger(PacienteService.class);
    private IDao<Odontologo> odontologoIDao;
    private ModelMapper modelMapper;

    public OdontologoService(IDao<Odontologo> odontologoIDao, ModelMapper modelMapper) {
        this.odontologoIDao = odontologoIDao;
        this.modelMapper = modelMapper;
        configureMapping();
    }
    @Override
    public OdontologoSalidaDto guardarOdontologo(OdontologoEntradaDto odontologo) {

        Odontologo odontologoEntidad = modelMapper.map(odontologo, Odontologo.class);

        Odontologo odontologoAPersistir = odontologoIDao.registrar(odontologoEntidad);

        OdontologoSalidaDto odontologoSalidaDto = modelMapper.map(odontologoAPersistir, OdontologoSalidaDto.class);

        return odontologoSalidaDto;
    }
    @Override
    public List<OdontologoSalidaDto> listarOdontologos() {

        List<OdontologoSalidaDto> odontologoSalidaDto = odontologoIDao.listarTodos().stream().map(odontologo -> modelMapper.map(odontologo, OdontologoSalidaDto.class)).toList();
        return odontologoSalidaDto;
    }

    @Override
    public OdontologoSalidaDto buscarOdontologoPorId(int id) {
        Odontologo odontologoBuscado = odontologoIDao.buscarPorId(id);
        OdontologoSalidaDto odontologoEncontrado = null;

        if(odontologoBuscado != null){
            odontologoEncontrado = modelMapper.map(odontologoBuscado, OdontologoSalidaDto.class);
        }else{
            LOGGER.error("El id no se encuentra registrado en la base de datos");
        }
        return odontologoEncontrado;
    }


    private void configureMapping(){
        modelMapper.typeMap(OdontologoEntradaDto.class, Odontologo.class);
        modelMapper.typeMap(Odontologo.class, OdontologoSalidaDto.class);
    }

}
