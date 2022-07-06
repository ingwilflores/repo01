package com.logistica.repository;

import com.logistica.entity.Modalidad;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface ModalidadRepository extends JpaRepository<Modalidad, Long> {

}