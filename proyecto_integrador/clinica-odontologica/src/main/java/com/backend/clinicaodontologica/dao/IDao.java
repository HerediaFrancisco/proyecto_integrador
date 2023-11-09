package com.backend.clinicaodontologica.dao;

import com.backend.clinicaodontologica.model.Paciente;

import java.util.List;

public interface IDao<T> {

    T registrar(T t);
    List<T> listarTodos();
    T buscarPorId(int id);

    Paciente eliminarPorId(int id);

    T actualizar(T t);
}
