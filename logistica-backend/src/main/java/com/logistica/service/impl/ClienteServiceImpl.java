/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.logistica.service.impl;

import com.logistica.entity.Cliente;
import com.logistica.exeption.ResourceNotFoundException;
import com.logistica.repository.ClienteRepository;
import com.logistica.service.ClienteService;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

/**
 *
 * @author Administrador
 */
@Service
public class ClienteServiceImpl implements ClienteService{
    @Autowired
    ClienteRepository repositoryPrincipal;
    
    @Override
    public List<Cliente> findAll(){
        return repositoryPrincipal.findAll(Sort.by(Sort.Direction.ASC, "idCliente"));
    }
    
    @Override
    public Optional<Cliente> findById(Long id){
        return repositoryPrincipal.findById(id);
    }
    
    @Override
    public Cliente create(Cliente request){
        Cliente s = repositoryPrincipal.save(request);
        return s;
    }
        
    @Override
    public Cliente update(Long id, Cliente request){
        Cliente obj  = repositoryPrincipal.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("No se encontro el registro con id = " + id));
        obj.setNombres(request.getNombres());
        obj.setApellidos(request.getApellidos());        
        obj.setCorreo(request.getCorreo());
        obj.setEstado(request.getEstado());
        return repositoryPrincipal.save(obj);
    }
    
    @Override
    public void delete(Long id){
        System.out.println("--id---"+id);
        repositoryPrincipal.deleteById(id);
        System.out.println("ELIMINADO");
    }
}
