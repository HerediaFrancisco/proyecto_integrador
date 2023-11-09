package com.backend.clinicaodontologica.service;

import com.backend.clinicaodontologica.model.Odontologo;


import java.util.List;

public interface IOdontologoService {

    Odontologo guardarOdontologo(Odontologo odontologo);

    List<Odontologo> listarOdontologos();
    Odontologo buscarOdontologoPorId(int id);


}
