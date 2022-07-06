/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.logistica.service;

import com.logistica.entity.Producto;
import java.util.List;
import java.util.Optional;

/**
 *
 * @author Administrador
 */
public interface ProductoService {
    List<Producto> findAll();
    Optional<Producto> findById(Long id);
    Producto create(Producto request);
    Producto update(Long id, Producto request);
    void delete(Long id);
}
