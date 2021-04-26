/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.osorio.modelo;

import java.io.Serializable;
import java.util.List;
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
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Usuario
 */
@Entity
@Table(name = "asignatura")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Asignatura.findAll", query = "SELECT a FROM Asignatura a")})
public class Asignatura implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_asignatura")
    private Integer idAsignatura;
    @Size(max = 70)
    @Column(name = "nombre_asignatura")
    private String nombreAsignatura;
    @JoinColumn(name = "area", referencedColumnName = "id_area")
    @ManyToOne(optional = false)
    private Area area;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "asignatura")
    private List<Logro> logroList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "asignatura")
    private List<Asignacionesasignaturas> asignacionesasignaturasList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "asignatura")
    private List<EstudianteCursaAsignatura> estudianteCursaAsignaturaList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "asignatura")
    private List<Nota> notaList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "asignatura")
    private List<Observacion> observacionList;

    public Asignatura() {
    }

    public Asignatura(Integer idAsignatura) {
        this.idAsignatura = idAsignatura;
    }

    public Integer getIdAsignatura() {
        return idAsignatura;
    }

    public void setIdAsignatura(Integer idAsignatura) {
        this.idAsignatura = idAsignatura;
    }

    public String getNombreAsignatura() {
        return nombreAsignatura;
    }

    public void setNombreAsignatura(String nombreAsignatura) {
        this.nombreAsignatura = nombreAsignatura;
    }

    public Area getArea() {
        return area;
    }

    public void setArea(Area area) {
        this.area = area;
    }

    @XmlTransient
    public List<Logro> getLogroList() {
        return logroList;
    }

    public void setLogroList(List<Logro> logroList) {
        this.logroList = logroList;
    }

    @XmlTransient
    public List<Asignacionesasignaturas> getAsignacionesasignaturasList() {
        return asignacionesasignaturasList;
    }

    public void setAsignacionesasignaturasList(List<Asignacionesasignaturas> asignacionesasignaturasList) {
        this.asignacionesasignaturasList = asignacionesasignaturasList;
    }

    @XmlTransient
    public List<EstudianteCursaAsignatura> getEstudianteCursaAsignaturaList() {
        return estudianteCursaAsignaturaList;
    }

    public void setEstudianteCursaAsignaturaList(List<EstudianteCursaAsignatura> estudianteCursaAsignaturaList) {
        this.estudianteCursaAsignaturaList = estudianteCursaAsignaturaList;
    }

    @XmlTransient
    public List<Nota> getNotaList() {
        return notaList;
    }

    public void setNotaList(List<Nota> notaList) {
        this.notaList = notaList;
    }

    @XmlTransient
    public List<Observacion> getObservacionList() {
        return observacionList;
    }

    public void setObservacionList(List<Observacion> observacionList) {
        this.observacionList = observacionList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idAsignatura != null ? idAsignatura.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Asignatura)) {
            return false;
        }
        Asignatura other = (Asignatura) object;
        if ((this.idAsignatura == null && other.idAsignatura != null) || (this.idAsignatura != null && !this.idAsignatura.equals(other.idAsignatura))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.osorio.modelo.Asignatura[ idAsignatura=" + idAsignatura + " ]";
    }
    
}
