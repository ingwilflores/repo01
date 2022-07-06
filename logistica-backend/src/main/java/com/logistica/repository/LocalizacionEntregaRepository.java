package com.logistica.repository;

import com.logistica.entity.LocalizacionEntrega;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

@Repository
public interface LocalizacionEntregaRepository extends JpaRepository<LocalizacionEntrega, Long> {
//    List<LocalizacionEntrega> buscarTodos(String username);
//    @Query("SELECT p FROM LocalizacionEntrega p WHERE LOWER(p.lastName) = LOWER(:lastName)")
//    public List<LocalizacionEntrega> find(@Param("lastName") String lastName);
}