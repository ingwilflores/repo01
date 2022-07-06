/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.logistica.service;

import com.logistica.entity.Modalidad;
import java.util.List;
import java.util.Optional;

/**
 *
 * @author Administrador
 */
public interface ModalidadService {
    List<Modalidad> findAll();
    Optional<Modalidad> findById(Long id);
    Modalidad update(Long id, Modalidad request);
    Modalidad create(Modalidad request);
}
