/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.logistica.service.impl;

import com.logistica.entity.Plan;
import com.logistica.exeption.ResourceNotFoundException;
import com.logistica.repository.PlanRepository;
import com.logistica.service.PlanService;
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
public class PlanServiceImpl implements PlanService{
    @Autowired
    PlanRepository repositoryPrincipal;
    
    @Override
    public List<Plan> findAll(){
        return repositoryPrincipal.findAll(Sort.by(Sort.Direction.ASC, "idPlan"));
    }
    
    @Override
    public Optional<Plan> findById(Long id){
        return repositoryPrincipal.findById(id);
    }
    
    @Override
    public Plan create(Plan request){
        Plan s = repositoryPrincipal.save(request);
        return s;
    }
        
    @Override
    public Plan update(Long id, Plan request){
        Plan obj  = repositoryPrincipal.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("No se encontro el registro con id = " + id));
        obj.setCantidad(request.getCantidad());
        obj.setEstado(request.getEstado());
        obj.setFechaEntrega(request.getFechaEntrega());
        obj.setIdCliente(request.getIdCliente());
        obj.setIdLocalizacionEntrega(request.getIdLocalizacionEntrega());
        obj.setMedioTransporte(request.getMedioTransporte());
        obj.setNumeroGuia(request.getNumeroGuia());
        obj.setPrecioEnvio(request.getPrecioEnvio());
        return repositoryPrincipal.save(obj);
    }
    
    @Override
    public void delete(Long id){
        System.out.println("--id---"+id);
        repositoryPrincipal.deleteById(id);
        System.out.println("ELIMINADO");
    }
}
