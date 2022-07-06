/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.logistica.service.impl;

import com.logistica.entity.LocalizacionEntrega;
import com.logistica.exeption.ResourceNotFoundException;
import com.logistica.repository.LocalizacionEntregaRepository;
import com.logistica.service.LocalizacionEntregaService;
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
public class LocalizacionEntregaServiceImpl implements LocalizacionEntregaService{
    @Autowired
    LocalizacionEntregaRepository repositoryPrincipal;
    
    @Override
    public List<LocalizacionEntrega> findAll(){
        return repositoryPrincipal.findAll(Sort.by(Sort.Direction.ASC, "idLocalizacionEntrega"));
    }

    @Override
    public Optional<LocalizacionEntrega> findById(Long id){
        return repositoryPrincipal.findById(id);
    }
    
    @Override
    public LocalizacionEntrega create(LocalizacionEntrega request){
        LocalizacionEntrega s = repositoryPrincipal.save(request);
        return s;
    }
        
    @Override
    public LocalizacionEntrega update(Long id, LocalizacionEntrega request){
        LocalizacionEntrega obj  = repositoryPrincipal.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("No se encontro el registro con id = " + id));
        obj.setCodigo(request.getCodigo());
        obj.setNombre(request.getNombre());
        obj.setDescripcion(request.getDescripcion());
        obj.setIdModalidad(request.getIdModalidad());
        return repositoryPrincipal.save(obj);
    }
    
    @Override
    public void delete(Long id){
        System.out.println("--id---"+id);
        repositoryPrincipal.deleteById(id);
        System.out.println("ELIMINADO");
    }
}
