/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.logistica.service;

import com.logistica.entity.TipoProducto;
import java.util.List;
import java.util.Optional;

/**
 *
 * @author Administrador
 */
public interface TipoProductoService {
    List<TipoProducto> findAll();
    Optional<TipoProducto> findById(Long id);
    TipoProducto create(TipoProducto request);
    TipoProducto update(Long id, TipoProducto request);
    void delete(Long id);
}
