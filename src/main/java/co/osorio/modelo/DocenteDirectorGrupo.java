/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.osorio.modelo;

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
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Usuario
 */
@Entity
@Table(name = "docente_director_grupo")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "DocenteDirectorGrupo.findAll", query = "SELECT d FROM DocenteDirectorGrupo d")})
public class DocenteDirectorGrupo implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_Registro")
    private Integer idRegistro;
    @Column(name = "estado")
    private Boolean estado;
    @JoinColumn(name = "docente", referencedColumnName = "codigo_docente")
    @ManyToOne(optional = false)
    private Docente docente;
    @JoinColumn(name = "curso", referencedColumnName = "id_curso")
    @ManyToOne(optional = false)
    private Curso curso;

    public DocenteDirectorGrupo() {
    }

    public DocenteDirectorGrupo(Integer idRegistro) {
        this.idRegistro = idRegistro;
    }

    public Integer getIdRegistro() {
        return idRegistro;
    }

    public void setIdRegistro(Integer idRegistro) {
        this.idRegistro = idRegistro;
    }

    public Boolean getEstado() {
        return estado;
    }

    public void setEstado(Boolean estado) {
        this.estado = estado;
    }

    public Docente getDocente() {
        return docente;
    }

    public void setDocente(Docente docente) {
        this.docente = docente;
    }

    public Curso getCurso() {
        return curso;
    }

    public void setCurso(Curso curso) {
        this.curso = curso;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idRegistro != null ? idRegistro.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof DocenteDirectorGrupo)) {
            return false;
        }
        DocenteDirectorGrupo other = (DocenteDirectorGrupo) object;
        if ((this.idRegistro == null && other.idRegistro != null) || (this.idRegistro != null && !this.idRegistro.equals(other.idRegistro))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.osorio.modelo.DocenteDirectorGrupo[ idRegistro=" + idRegistro + " ]";
    }
    
}
