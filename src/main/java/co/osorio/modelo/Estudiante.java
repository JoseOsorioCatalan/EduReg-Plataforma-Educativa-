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
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Usuario
 */
@Entity
@Table(name = "estudiante")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Estudiante.findAll", query = "SELECT e FROM Estudiante e")})
public class Estudiante implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "codigo_estudiante")
    private Integer codigoEstudiante;
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_estudiante")
    private long idEstudiante;
    @Size(max = 55)
    @Column(name = "primer_nombre")
    private String primerNombre;
    @Size(max = 55)
    @Column(name = "segundo_nombre")
    private String segundoNombre;
    @Size(max = 55)
    @Column(name = "primer_apellido")
    private String primerApellido;
    @Size(max = 55)
    @Column(name = "segundo_apellido")
    private String segundoApellido;
    @Size(max = 50)
    @Column(name = "fecha_de_nacimiento")
    private String fechaDeNacimiento;
    @Size(max = 30)
    @Column(name = "tipo_documento")
    private String tipoDocumento;
    @Size(max = 12)
    @Column(name = "genero")
    private String genero;
    @Size(max = 50)
    @Column(name = "departamento_nacimiento")
    private String departamentoNacimiento;
    @Size(max = 70)
    @Column(name = "municipio_nacimiento")
    private String municipioNacimiento;
    @Size(max = 30)
    @Column(name = "acudiente")
    private String acudiente;
    @Size(max = 70)
    @Column(name = "direccion")
    private String direccion;
    @Size(max = 20)
    @Column(name = "telefono")
    private String telefono;
    @Size(max = 50)
    @Column(name = "departamento_actual")
    private String departamentoActual;
    @Size(max = 70)
    @Column(name = "municipio_actual")
    private String municipioActual;
    @Size(max = 40)
    @Column(name = "barrio")
    private String barrio;
    @Size(max = 50)
    @Column(name = "sitio_poblacional")
    private String sitioPoblacional;
    @Size(max = 100)
    @Column(name = "sede")
    private String sede;
    @Size(max = 5)
    @Column(name = "nuevo")
    private String nuevo;
    @Size(max = 9)
    @Column(name = "ano_vigente")
    private String anoVigente;
    @Size(max = 5)
    @Column(name = "pagar_matricula")
    private String pagarMatricula;
    @Column(name = "estado")
    private Boolean estado;
    @JoinColumn(name = "cursoAsignado", referencedColumnName = "id_curso")
    @ManyToOne(optional = false)
    private Curso cursoAsignado;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "estudiante")
    private List<EstudianteCursaAsignatura> estudianteCursaAsignaturaList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "estudiante")
    private List<Nota> notaList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "estudiante")
    private List<Observacion> observacionList;

    public Estudiante() {
    }

    public Estudiante(Integer codigoEstudiante) {
        this.codigoEstudiante = codigoEstudiante;
    }

    public Estudiante(Integer codigoEstudiante, long idEstudiante) {
        this.codigoEstudiante = codigoEstudiante;
        this.idEstudiante = idEstudiante;
    }

    public Integer getCodigoEstudiante() {
        return codigoEstudiante;
    }

    public void setCodigoEstudiante(Integer codigoEstudiante) {
        this.codigoEstudiante = codigoEstudiante;
    }

    public long getIdEstudiante() {
        return idEstudiante;
    }

    public void setIdEstudiante(long idEstudiante) {
        this.idEstudiante = idEstudiante;
    }

    public String getPrimerNombre() {
        return primerNombre;
    }

    public void setPrimerNombre(String primerNombre) {
        this.primerNombre = primerNombre;
    }

    public String getSegundoNombre() {
        return segundoNombre;
    }

    public void setSegundoNombre(String segundoNombre) {
        this.segundoNombre = segundoNombre;
    }

    public String getPrimerApellido() {
        return primerApellido;
    }

    public void setPrimerApellido(String primerApellido) {
        this.primerApellido = primerApellido;
    }

    public String getSegundoApellido() {
        return segundoApellido;
    }

    public void setSegundoApellido(String segundoApellido) {
        this.segundoApellido = segundoApellido;
    }

    public String getFechaDeNacimiento() {
        return fechaDeNacimiento;
    }

    public void setFechaDeNacimiento(String fechaDeNacimiento) {
        this.fechaDeNacimiento = fechaDeNacimiento;
    }

    public String getTipoDocumento() {
        return tipoDocumento;
    }

    public void setTipoDocumento(String tipoDocumento) {
        this.tipoDocumento = tipoDocumento;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public String getDepartamentoNacimiento() {
        return departamentoNacimiento;
    }

    public void setDepartamentoNacimiento(String departamentoNacimiento) {
        this.departamentoNacimiento = departamentoNacimiento;
    }

    public String getMunicipioNacimiento() {
        return municipioNacimiento;
    }

    public void setMunicipioNacimiento(String municipioNacimiento) {
        this.municipioNacimiento = municipioNacimiento;
    }

    public String getAcudiente() {
        return acudiente;
    }

    public void setAcudiente(String acudiente) {
        this.acudiente = acudiente;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getDepartamentoActual() {
        return departamentoActual;
    }

    public void setDepartamentoActual(String departamentoActual) {
        this.departamentoActual = departamentoActual;
    }

    public String getMunicipioActual() {
        return municipioActual;
    }

    public void setMunicipioActual(String municipioActual) {
        this.municipioActual = municipioActual;
    }

    public String getBarrio() {
        return barrio;
    }

    public void setBarrio(String barrio) {
        this.barrio = barrio;
    }

    public String getSitioPoblacional() {
        return sitioPoblacional;
    }

    public void setSitioPoblacional(String sitioPoblacional) {
        this.sitioPoblacional = sitioPoblacional;
    }

    public String getSede() {
        return sede;
    }

    public void setSede(String sede) {
        this.sede = sede;
    }

    public String getNuevo() {
        return nuevo;
    }

    public void setNuevo(String nuevo) {
        this.nuevo = nuevo;
    }

    public String getAnoVigente() {
        return anoVigente;
    }

    public void setAnoVigente(String anoVigente) {
        this.anoVigente = anoVigente;
    }

    public String getPagarMatricula() {
        return pagarMatricula;
    }

    public void setPagarMatricula(String pagarMatricula) {
        this.pagarMatricula = pagarMatricula;
    }

    public Boolean getEstado() {
        return estado;
    }

    public void setEstado(Boolean estado) {
        this.estado = estado;
    }

    public Curso getCursoAsignado() {
        return cursoAsignado;
    }

    public void setCursoAsignado(Curso cursoAsignado) {
        this.cursoAsignado = cursoAsignado;
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
        hash += (codigoEstudiante != null ? codigoEstudiante.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Estudiante)) {
            return false;
        }
        Estudiante other = (Estudiante) object;
        if ((this.codigoEstudiante == null && other.codigoEstudiante != null) || (this.codigoEstudiante != null && !this.codigoEstudiante.equals(other.codigoEstudiante))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.osorio.modelo.Estudiante[ codigoEstudiante=" + codigoEstudiante + " ]";
    }
    
}
