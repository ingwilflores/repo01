/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.logistica.entity;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

/**
 *
 * @author asycuda
 */
@Entity
@Table(name = "plan_detalle")
@NamedQueries({
    @NamedQuery(name = "PlanDetalle.findAll", query = "SELECT p FROM PlanDetalle p"),
    @NamedQuery(name = "PlanDetalle.findByIdPlanDetalle", query = "SELECT p FROM PlanDetalle p WHERE p.idPlanDetalle = :idPlanDetalle"),
    @NamedQuery(name = "PlanDetalle.findByPrecioNormal", query = "SELECT p FROM PlanDetalle p WHERE p.precioNormal = :precioNormal"),
    @NamedQuery(name = "PlanDetalle.findByPorcentajeDescuentoAplicado", query = "SELECT p FROM PlanDetalle p WHERE p.porcentajeDescuentoAplicado = :porcentajeDescuentoAplicado"),
    @NamedQuery(name = "PlanDetalle.findByDescuentoAplicado", query = "SELECT p FROM PlanDetalle p WHERE p.descuentoAplicado = :descuentoAplicado")})
public class PlanDetalle implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_plan_detalle")
    private Long idPlanDetalle;
    @Basic(optional = false)
    @NotNull
    @Column(name = "precio_normal")
    private double precioNormal;
    @Basic(optional = false)
    @NotNull
    @Column(name = "porcentaje_descuento_aplicado")
    private double porcentajeDescuentoAplicado;
    @Basic(optional = false)
    @NotNull
    @Column(name = "descuento_aplicado")
    private double descuentoAplicado;
    @NotNull
    @JoinColumn(name = "id_plan", referencedColumnName = "id_plan")
    @ManyToOne(optional = false)
    private Plan idPlan;

    public PlanDetalle() {
    }

    public PlanDetalle(Long idPlanDetalle) {
        this.idPlanDetalle = idPlanDetalle;
    }

    public PlanDetalle(Long idPlanDetalle, double precioNormal, double porcentajeDescuentoAplicado, double descuentoAplicado) {
        this.idPlanDetalle = idPlanDetalle;
        this.precioNormal = precioNormal;
        this.porcentajeDescuentoAplicado = porcentajeDescuentoAplicado;
        this.descuentoAplicado = descuentoAplicado;
    }

    public Long getIdPlanDetalle() {
        return idPlanDetalle;
    }

    public void setIdPlanDetalle(Long idPlanDetalle) {
        this.idPlanDetalle = idPlanDetalle;
    }

    public double getPrecioNormal() {
        return precioNormal;
    }

    public void setPrecioNormal(double precioNormal) {
        this.precioNormal = precioNormal;
    }

    public double getPorcentajeDescuentoAplicado() {
        return porcentajeDescuentoAplicado;
    }

    public void setPorcentajeDescuentoAplicado(double porcentajeDescuentoAplicado) {
        this.porcentajeDescuentoAplicado = porcentajeDescuentoAplicado;
    }

    public double getDescuentoAplicado() {
        return descuentoAplicado;
    }

    public void setDescuentoAplicado(double descuentoAplicado) {
        this.descuentoAplicado = descuentoAplicado;
    }

    public Plan getIdPlan() {
        return idPlan;
    }

    public void setIdPlan(Plan idPlan) {
        this.idPlan = idPlan;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idPlanDetalle != null ? idPlanDetalle.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PlanDetalle)) {
            return false;
        }
        PlanDetalle other = (PlanDetalle) object;
        if ((this.idPlanDetalle == null && other.idPlanDetalle != null) || (this.idPlanDetalle != null && !this.idPlanDetalle.equals(other.idPlanDetalle))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.logistica.entity.PlanDetalle[ idPlanDetalle=" + idPlanDetalle + " ]";
    }
    
}
