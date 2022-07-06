/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.logistica.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import org.hibernate.annotations.CreationTimestamp;

/**
 *
 * @author asycuda
 */
@Entity
@Table(name = "plan")
@NamedQueries({
    @NamedQuery(name = "Plan.findAll", query = "SELECT p FROM Plan p"),
    @NamedQuery(name = "Plan.findByIdPlan", query = "SELECT p FROM Plan p WHERE p.idPlan = :idPlan"),
    @NamedQuery(name = "Plan.findByCantidad", query = "SELECT p FROM Plan p WHERE p.cantidad = :cantidad"),
    @NamedQuery(name = "Plan.findByFechaRegistro", query = "SELECT p FROM Plan p WHERE p.fechaRegistro = :fechaRegistro"),
    @NamedQuery(name = "Plan.findByFechaEntrega", query = "SELECT p FROM Plan p WHERE p.fechaEntrega = :fechaEntrega"),
    @NamedQuery(name = "Plan.findByPrecioEnvio", query = "SELECT p FROM Plan p WHERE p.precioEnvio = :precioEnvio"),
    @NamedQuery(name = "Plan.findByNumeroGuia", query = "SELECT p FROM Plan p WHERE p.numeroGuia = :numeroGuia"),
    @NamedQuery(name = "Plan.findByMedioTransporte", query = "SELECT p FROM Plan p WHERE p.medioTransporte = :medioTransporte"),
    @NamedQuery(name = "Plan.findByEstado", query = "SELECT p FROM Plan p WHERE p.estado = :estado")})
public class Plan implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_plan")
    private Long idPlan;
    @Basic(optional = false)
    @NotNull
    @Column(name = "cantidad")
    private int cantidad;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fecha_registro", nullable = false, updatable = false)
    @CreationTimestamp
    @Temporal(TemporalType.DATE)
    private Date fechaRegistro;
    @Column(name = "fecha_entrega")
    @Temporal(TemporalType.DATE)
    private Date fechaEntrega;
    @Basic(optional = false)
    @NotNull
    @Column(name = "precio_envio")
    private double precioEnvio;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "numero_guia")
    private String numeroGuia;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 8)
    @Column(name = "medio_transporte")
    private String medioTransporte;
    @Basic(optional = false)
    @NotNull
    @Column(name = "estado")
    private int estado;
    @NotNull
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idPlan")
    @JsonIgnore
    private Collection<PlanDetalle> planDetalleCollection;
    @NotNull
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idPlan")
    @JsonIgnore
    private Collection<Producto> productoCollection;
    @NotNull
    @JoinColumn(name = "id_cliente", referencedColumnName = "id_cliente")
    @ManyToOne(optional = false)
    private Cliente idCliente;
    @NotNull
    @JoinColumn(name = "id_localizacion_entrega", referencedColumnName = "id_localizacion_entrega")
    @ManyToOne(optional = false)
    private LocalizacionEntrega idLocalizacionEntrega;

    public Plan() {
    }

    public Plan(Long idPlan) {
        this.idPlan = idPlan;
    }

    public Plan(Long idPlan, int cantidad, Date fechaRegistro, double precioEnvio, String numeroGuia, String medioTransporte, int estado) {
        this.idPlan = idPlan;
        this.cantidad = cantidad;
        this.fechaRegistro = fechaRegistro;
        this.precioEnvio = precioEnvio;
        this.numeroGuia = numeroGuia;
        this.medioTransporte = medioTransporte;
        this.estado = estado;
    }

    public Long getIdPlan() {
        return idPlan;
    }

    public void setIdPlan(Long idPlan) {
        this.idPlan = idPlan;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public Date getFechaRegistro() {
        return fechaRegistro;
    }

    public void setFechaRegistro(Date fechaRegistro) {
        this.fechaRegistro = fechaRegistro;
    }

    public Date getFechaEntrega() {
        return fechaEntrega;
    }

    public void setFechaEntrega(Date fechaEntrega) {
        this.fechaEntrega = fechaEntrega;
    }

    public double getPrecioEnvio() {
        return precioEnvio;
    }

    public void setPrecioEnvio(double precioEnvio) {
        this.precioEnvio = precioEnvio;
    }

    public String getNumeroGuia() {
        return numeroGuia;
    }

    public void setNumeroGuia(String numeroGuia) {
        this.numeroGuia = numeroGuia;
    }

    public String getMedioTransporte() {
        return medioTransporte;
    }

    public void setMedioTransporte(String medioTransporte) {
        this.medioTransporte = medioTransporte;
    }

    public int getEstado() {
        return estado;
    }

    public void setEstado(int estado) {
        this.estado = estado;
    }

    public Collection<PlanDetalle> getPlanDetalleCollection() {
        return planDetalleCollection;
    }

    public void setPlanDetalleCollection(Collection<PlanDetalle> planDetalleCollection) {
        this.planDetalleCollection = planDetalleCollection;
    }

    public Collection<Producto> getProductoCollection() {
        return productoCollection;
    }

    public void setProductoCollection(Collection<Producto> productoCollection) {
        this.productoCollection = productoCollection;
    }

    public Cliente getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(Cliente idCliente) {
        this.idCliente = idCliente;
    }

    public LocalizacionEntrega getIdLocalizacionEntrega() {
        return idLocalizacionEntrega;
    }

    public void setIdLocalizacionEntrega(LocalizacionEntrega idLocalizacionEntrega) {
        this.idLocalizacionEntrega = idLocalizacionEntrega;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idPlan != null ? idPlan.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Plan)) {
            return false;
        }
        Plan other = (Plan) object;
        if ((this.idPlan == null && other.idPlan != null) || (this.idPlan != null && !this.idPlan.equals(other.idPlan))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.logistica.entity.Plan[ idPlan=" + idPlan + " ]";
    }
    
}
