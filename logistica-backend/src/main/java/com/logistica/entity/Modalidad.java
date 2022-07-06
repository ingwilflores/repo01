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
@Table(name = "modalidad")
@NamedQueries({
    @NamedQuery(name = "Modalidad.findAll", query = "SELECT m FROM Modalidad m"),
    @NamedQuery(name = "Modalidad.findByIdModalidad", query = "SELECT m FROM Modalidad m WHERE m.idModalidad = :idModalidad"),
    @NamedQuery(name = "Modalidad.findByCodigo", query = "SELECT m FROM Modalidad m WHERE m.codigo = :codigo"),
    @NamedQuery(name = "Modalidad.findByNombre", query = "SELECT m FROM Modalidad m WHERE m.nombre = :nombre"),
    @NamedQuery(name = "Modalidad.findByDescripcion", query = "SELECT m FROM Modalidad m WHERE m.descripcion = :descripcion"),
    @NamedQuery(name = "Modalidad.findByValidoDesde", query = "SELECT m FROM Modalidad m WHERE m.validoDesde = :validoDesde"),
    @NamedQuery(name = "Modalidad.findByValidoHasta", query = "SELECT m FROM Modalidad m WHERE m.validoHasta = :validoHasta"),
    @NamedQuery(name = "Modalidad.findByPorcentajeDescuento", query = "SELECT m FROM Modalidad m WHERE m.porcentajeDescuento = :porcentajeDescuento"),
    @NamedQuery(name = "Modalidad.findByCantidadMinimaDescuento", query = "SELECT m FROM Modalidad m WHERE m.cantidadMinimaDescuento = :cantidadMinimaDescuento")})
public class Modalidad implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_modalidad")
    private Long idModalidad;
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
    @Basic(optional = false)
    @NotNull
    @Column(name = "porcentaje_descuento")
    private double porcentajeDescuento;
    @Basic(optional = false)
    @NotNull
    @Column(name = "cantidad_minima_descuento")
    private int cantidadMinimaDescuento;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idModalidad")
    @JsonIgnore
    private Collection<LocalizacionEntrega> localizacionEntregaCollection;

    public Modalidad() {
    }

    public Modalidad(Long idModalidad) {
        this.idModalidad = idModalidad;
    }

    public Modalidad(Long idModalidad, String codigo, String nombre, Date validoDesde, double porcentajeDescuento, int cantidadMinimaDescuento) {
        this.idModalidad = idModalidad;
        this.codigo = codigo;
        this.nombre = nombre;
        this.validoDesde = validoDesde;
        this.porcentajeDescuento = porcentajeDescuento;
        this.cantidadMinimaDescuento = cantidadMinimaDescuento;
    }

    public Long getIdModalidad() {
        return idModalidad;
    }

    public void setIdModalidad(Long idModalidad) {
        this.idModalidad = idModalidad;
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

    public double getPorcentajeDescuento() {
        return porcentajeDescuento;
    }

    public void setPorcentajeDescuento(double porcentajeDescuento) {
        this.porcentajeDescuento = porcentajeDescuento;
    }

    public int getCantidadMinimaDescuento() {
        return cantidadMinimaDescuento;
    }

    public void setCantidadMinimaDescuento(int cantidadMinimaDescuento) {
        this.cantidadMinimaDescuento = cantidadMinimaDescuento;
    }

    public Collection<LocalizacionEntrega> getLocalizacionEntregaCollection() {
        return localizacionEntregaCollection;
    }

    public void setLocalizacionEntregaCollection(Collection<LocalizacionEntrega> localizacionEntregaCollection) {
        this.localizacionEntregaCollection = localizacionEntregaCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idModalidad != null ? idModalidad.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Modalidad)) {
            return false;
        }
        Modalidad other = (Modalidad) object;
        if ((this.idModalidad == null && other.idModalidad != null) || (this.idModalidad != null && !this.idModalidad.equals(other.idModalidad))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.logistica.entity.Modalidad[ idModalidad=" + idModalidad + " ]";
    }
    
}
