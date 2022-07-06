/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.logistica.service.impl;

import com.logistica.entity.Modalidad;
import com.logistica.exeption.ResourceNotFoundException;
import com.logistica.repository.ModalidadRepository;
import com.logistica.service.ModalidadService;
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
public class ModalidadServiceImpl implements ModalidadService{
    @Autowired
    ModalidadRepository repositoryPrincipal;
    
    @Override
    public List<Modalidad> findAll(){
        return repositoryPrincipal.findAll(Sort.by(Sort.Direction.ASC, "idModalidad"));
    }
    
    @Override
    public Optional<Modalidad> findById(Long id){
        return repositoryPrincipal.findById(id);
    }

    @Override
    public Modalidad update(Long id, Modalidad request){
        Modalidad obj  = repositoryPrincipal.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("No se encontro el registro con id = " + id));
        obj.setCodigo(request.getCodigo());
        obj.setNombre(request.getNombre());
        obj.setDescripcion(request.getDescripcion());
        obj.setCantidadMinimaDescuento(request.getCantidadMinimaDescuento());
        obj.setPorcentajeDescuento(request.getPorcentajeDescuento());
        return repositoryPrincipal.save(obj);
        
    }
    
    @Override
    public Modalidad create(Modalidad request){
        Modalidad s = repositoryPrincipal.save(request);
        return s;
    }
}
