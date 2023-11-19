package com.backend.clinicaodontologica.Repository;

import com.backend.clinicaodontologica.entity.Odontologo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OdontologoRepository extends JpaRepository<Odontologo, Long> {

    Odontologo findById(int id);
}
