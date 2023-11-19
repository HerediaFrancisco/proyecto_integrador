package com.backend.clinicaodontologica.dto.entrada.odontologo;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class OdontologoEntradaDto {

    @NotNull(message = "La matricula del odontologo no puede ser nulo")
    private String matricula;
    @NotNull(message = "El nombre del odontologo no puede ser nulo")
    @NotBlank(message = "Debe especificarse el nombre del odontologo")
    @Size(max = 50, message = "El nombre debe tener hasta 50 caracteres")
    private String nombre;
    @NotNull(message = "El nombre del odontologo no puede ser nulo")
    @NotBlank(message = "Debe especificarse el nombre del odontologo")
    @Size(max = 50, message = "El nombre debe tener hasta 50 caracteres")
    private String apellido;


    public OdontologoEntradaDto() {
    }

    public OdontologoEntradaDto(String nombre, String apellido, String matricula) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.matricula = matricula;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }
}
