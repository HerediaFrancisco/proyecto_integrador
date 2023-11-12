package com.backend.clinicaodontologica.service;

import com.backend.clinicaodontologica.dto.entrada.paciente.OdontologoEntradaDto;
import com.backend.clinicaodontologica.dto.salida.paciente.OdontologoSalidaDto;
import com.backend.clinicaodontologica.model.Odontologo;


import java.util.List;

public interface IOdontologoService {

    OdontologoSalidaDto guardarOdontologo(OdontologoEntradaDto odontologo);

    List<OdontologoSalidaDto> listarOdontologos();
    OdontologoSalidaDto buscarOdontologoPorId(int id);


}
