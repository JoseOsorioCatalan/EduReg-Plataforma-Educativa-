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
@Table(name = "curso")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Curso.findAll", query = "SELECT c FROM Curso c")})
public class Curso implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_curso")
    private Integer idCurso;
    @Size(max = 15)
    @Column(name = "curso")
    private String curso;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "cursoAsignado")
    private List<Estudiante> estudianteList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "curso")
    private List<CursoTieneLogro> cursoTieneLogroList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "curso")
    private List<DocenteDirectorGrupo> docenteDirectorGrupoList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "curso")
    private List<Asignacionesasignaturas> asignacionesasignaturasList;
    @JoinColumn(name = "grado", referencedColumnName = "id_grado")
    @ManyToOne(optional = false)
    private Grado grado;

    public Curso() {
    }

    public Curso(Integer idCurso) {
        this.idCurso = idCurso;
    }

    public Integer getIdCurso() {
        return idCurso;
    }

    public void setIdCurso(Integer idCurso) {
        this.idCurso = idCurso;
    }

    public String getCurso() {
        return curso;
    }

    public void setCurso(String curso) {
        this.curso = curso;
    }

    @XmlTransient
    public List<Estudiante> getEstudianteList() {
        return estudianteList;
    }

    public void setEstudianteList(List<Estudiante> estudianteList) {
        this.estudianteList = estudianteList;
    }

    @XmlTransient
    public List<CursoTieneLogro> getCursoTieneLogroList() {
        return cursoTieneLogroList;
    }

    public void setCursoTieneLogroList(List<CursoTieneLogro> cursoTieneLogroList) {
        this.cursoTieneLogroList = cursoTieneLogroList;
    }

    @XmlTransient
    public List<DocenteDirectorGrupo> getDocenteDirectorGrupoList() {
        return docenteDirectorGrupoList;
    }

    public void setDocenteDirectorGrupoList(List<DocenteDirectorGrupo> docenteDirectorGrupoList) {
        this.docenteDirectorGrupoList = docenteDirectorGrupoList;
    }

    @XmlTransient
    public List<Asignacionesasignaturas> getAsignacionesasignaturasList() {
        return asignacionesasignaturasList;
    }

    public void setAsignacionesasignaturasList(List<Asignacionesasignaturas> asignacionesasignaturasList) {
        this.asignacionesasignaturasList = asignacionesasignaturasList;
    }

    public Grado getGrado() {
        return grado;
    }

    public void setGrado(Grado grado) {
        this.grado = grado;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idCurso != null ? idCurso.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Curso)) {
            return false;
        }
        Curso other = (Curso) object;
        if ((this.idCurso == null && other.idCurso != null) || (this.idCurso != null && !this.idCurso.equals(other.idCurso))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.osorio.modelo.Curso[ idCurso=" + idCurso + " ]";
    }
    
}
