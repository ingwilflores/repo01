/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.logistica.service;

import com.logistica.entity.Plan;
import java.util.List;
import java.util.Optional;

/**
 *
 * @author Administrador
 */
public interface PlanService {
    List<Plan> findAll();
    Optional<Plan> findById(Long id);
    Plan create(Plan request);
    Plan update(Long id, Plan request);
    void delete(Long id);
}
