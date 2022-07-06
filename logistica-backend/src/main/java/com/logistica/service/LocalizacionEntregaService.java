/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.logistica.service;

import com.logistica.entity.LocalizacionEntrega;
import java.util.List;
import java.util.Optional;

/**
 *
 * @author Administrador
 */
public interface LocalizacionEntregaService {
    List<LocalizacionEntrega> findAll();
    Optional<LocalizacionEntrega> findById(Long id);
    LocalizacionEntrega create(LocalizacionEntrega request);
    LocalizacionEntrega update(Long id, LocalizacionEntrega request);
    void delete(Long id);
}
