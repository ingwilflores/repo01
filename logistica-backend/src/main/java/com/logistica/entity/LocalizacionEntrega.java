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
@Table(name = "localizacion_entrega")
@NamedQueries({
    @NamedQuery(name = "LocalizacionEntrega.findAll", query = "SELECT l FROM LocalizacionEntrega l"),
    @NamedQuery(name = "LocalizacionEntrega.findByIdLocalizacionEntrega", query = "SELECT l FROM LocalizacionEntrega l WHERE l.idLocalizacionEntrega = :idLocalizacionEntrega"),
    @NamedQuery(name = "LocalizacionEntrega.findByCodigo", query = "SELECT l FROM LocalizacionEntrega l WHERE l.codigo = :codigo"),
    @NamedQuery(name = "LocalizacionEntrega.findByNombre", query = "SELECT l FROM LocalizacionEntrega l WHERE l.nombre = :nombre"),
    @NamedQuery(name = "LocalizacionEntrega.findByDescripcion", query = "SELECT l FROM LocalizacionEntrega l WHERE l.descripcion = :descripcion"),
    @NamedQuery(name = "LocalizacionEntrega.findByValidoDesde", query = "SELECT l FROM LocalizacionEntrega l WHERE l.validoDesde = :validoDesde"),
    @NamedQuery(name = "LocalizacionEntrega.findByValidoHasta", query = "SELECT l FROM LocalizacionEntrega l WHERE l.validoHasta = :validoHasta")})
public class LocalizacionEntrega implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_localizacion_entrega")
    private Long idLocalizacionEntrega;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 5)
    @Column(name = "codigo")
    private String codigo;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "nombre")
    private String nombre;
    @Size(max = 100)
    @Column(name = "descripcion")
    private String descripcion;
    @Basic(optional = false)
    @Column(name = "valido_desde", nullable = false, updatable = false)
    @CreationTimestamp
    @Temporal(TemporalType.DATE)
    private Date validoDesde;
    @Column(name = "valido_hasta")
    @Temporal(TemporalType.DATE)
    private Date validoHasta;
    @NotNull
    @JoinColumn(name = "id_modalidad", referencedColumnName = "id_modalidad")
    @ManyToOne(optional = false)
    private Modalidad idModalidad;
    @OneToMany(mappedBy = "idLocalizacionEntrega")
    @JsonIgnore
    private Collection<Plan> planCollection;

    public LocalizacionEntrega() {
    }

    public LocalizacionEntrega(Long idLocalizacionEntrega) {
        this.idLocalizacionEntrega = idLocalizacionEntrega;
    }

    public LocalizacionEntrega(Long idLocalizacionEntrega, String codigo, String nombre, Date validoDesde) {
        this.idLocalizacionEntrega = idLocalizacionEntrega;
        this.codigo = codigo;
        this.nombre = nombre;
        this.validoDesde = validoDesde;
    }

    public Long getIdLocalizacionEntrega() {
        return idLocalizacionEntrega;
    }

    public void setIdLocalizacionEntrega(Long idLocalizacionEntrega) {
        this.idLocalizacionEntrega = idLocalizacionEntrega;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Date getValidoDesde() {
        return validoDesde;
    }

    public void setValidoDesde(Date validoDesde) {
        this.validoDesde = validoDesde;
    }

    public Date getValidoHasta() {
        return validoHasta;
    }

    public void setValidoHasta(Date validoHasta) {
        this.validoHasta = validoHasta;
    }

    public Modalidad getIdModalidad() {
        return idModalidad;
    }

    public void setIdModalidad(Modalidad idModalidad) {
        this.idModalidad = idModalidad;
    }

    public Collection<Plan> getPlanCollection() {
        return planCollection;
    }

    public void setPlanCollection(Collection<Plan> planCollection) {
        this.planCollection = planCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idLocalizacionEntrega != null ? idLocalizacionEntrega.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof LocalizacionEntrega)) {
            return false;
        }
        LocalizacionEntrega other = (LocalizacionEntrega) object;
        if ((this.idLocalizacionEntrega == null && other.idLocalizacionEntrega != null) || (this.idLocalizacionEntrega != null && !this.idLocalizacionEntrega.equals(other.idLocalizacionEntrega))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.logistica.entity.LocalizacionEntrega[ idLocalizacionEntrega=" + idLocalizacionEntrega + " ]";
    }
    
}
