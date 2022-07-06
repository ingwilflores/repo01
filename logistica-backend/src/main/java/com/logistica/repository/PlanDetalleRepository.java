package com.logistica.repository;

import com.logistica.entity.PlanDetalle;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;



@Repository
public interface PlanDetalleRepository extends JpaRepository<PlanDetalle, Long> {
//    List<LocalizacionEntrega> buscarTodos(String username);
//    @Query("SELECT p FROM LocalizacionEntrega p WHERE LOWER(p.lastName) = LOWER(:lastName)")
//    public List<LocalizacionEntrega> find(@Param("lastName") String lastName);
}