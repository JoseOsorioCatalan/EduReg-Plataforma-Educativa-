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
import javax.persistence.Lob;
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
@Table(name = "logro")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Logro.findAll", query = "SELECT l FROM Logro l")})
public class Logro implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_logro")
    private Integer idLogro;
    @Lob
    @Size(max = 65535)
    @Column(name = "logro")
    private String logro;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "logro")
    private List<CursoTieneLogro> cursoTieneLogroList;
    @JoinColumn(name = "periodo", referencedColumnName = "id_periodo")
    @ManyToOne(optional = false)
    private Periodo periodo;
    @JoinColumn(name = "asignatura", referencedColumnName = "id_asignatura")
    @ManyToOne(optional = false)
    private Asignatura asignatura;

    public Logro() {
    }

    public Logro(Integer idLogro) {
        this.idLogro = idLogro;
    }

    public Integer getIdLogro() {
        return idLogro;
    }

    public void setIdLogro(Integer idLogro) {
        this.idLogro = idLogro;
    }

    public String getLogro() {
        return logro;
    }

    public void setLogro(String logro) {
        this.logro = logro;
    }

    @XmlTransient
    public List<CursoTieneLogro> getCursoTieneLogroList() {
        return cursoTieneLogroList;
    }

    public void setCursoTieneLogroList(List<CursoTieneLogro> cursoTieneLogroList) {
        this.cursoTieneLogroList = cursoTieneLogroList;
    }

    public Periodo getPeriodo() {
        return periodo;
    }

    public void setPeriodo(Periodo periodo) {
        this.periodo = periodo;
    }

    public Asignatura getAsignatura() {
        return asignatura;
    }

    public void setAsignatura(Asignatura asignatura) {
        this.asignatura = asignatura;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idLogro != null ? idLogro.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Logro)) {
            return false;
        }
        Logro other = (Logro) object;
        if ((this.idLogro == null && other.idLogro != null) || (this.idLogro != null && !this.idLogro.equals(other.idLogro))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.osorio.modelo.Logro[ idLogro=" + idLogro + " ]";
    }
    
}
