/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.logistica.service;

import com.logistica.entity.Cliente;
import java.util.List;
import java.util.Optional;

/**
 *
 * @author Administrador
 */
public interface ClienteService {
    List<Cliente> findAll();
    Optional<Cliente> findById(Long id);
    Cliente create(Cliente request);
    Cliente update(Long id, Cliente request);
    void delete(Long id);
}
