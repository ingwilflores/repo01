/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.logistica.service;

import com.logistica.entity.PlanDetalle;
import java.util.List;
import java.util.Optional;

/**
 *
 * @author Administrador
 */
public interface PlanDetalleService {
    List<PlanDetalle> findAll();
    Optional<PlanDetalle> findById(Long id);
    PlanDetalle create(PlanDetalle request);
    PlanDetalle update(Long id, PlanDetalle request);
    void delete(Long id);
}
