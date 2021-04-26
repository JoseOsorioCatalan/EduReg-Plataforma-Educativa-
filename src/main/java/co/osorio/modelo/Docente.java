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
@Table(name = "docente")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Docente.findAll", query = "SELECT d FROM Docente d")})
public class Docente implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "codigo_docente")
    private Integer codigoDocente;
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_docente")
    private long idDocente;
    @Size(max = 30)
    @Column(name = "tipo_documento")
    private String tipoDocumento;
    @Size(max = 15)
    @Column(name = "genero")
    private String genero;
    @Size(max = 30)
    @Column(name = "fecha_nacimiento")
    private String fechaNacimiento;
    @Size(max = 70)
    @Column(name = "municipio_nacimiento")
    private String municipioNacimiento;
    @Size(max = 50)
    @Column(name = "departamento_nacimiento")
    private String departamentoNacimiento;
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
    @Size(max = 70)
    @Column(name = "especialidad")
    private String especialidad;
    @Column(name = "edad_docente")
    private Integer edadDocente;
    // @Pattern(regexp="[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?", message="Invalid email")//if the field contains email address consider using this annotation to enforce field validation
    @Size(max = 100)
    @Column(name = "email")
    private String email;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "rol")
    private String rol;
    @Column(name = "estado")
    private Boolean estado;
    @Size(max = 40)
    @Column(name = "usuario")
    private String usuario;
    @Size(max = 30)
    @Column(name = "contrasena")
    private String contrasena;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "docente")
    private List<DocenteDirectorGrupo> docenteDirectorGrupoList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "docenteAdministradorResponsable")
    private List<Eventos> eventosList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "docente")
    private List<Asignacionesasignaturas> asignacionesasignaturasList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "docente")
    private List<Nota> notaList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "docente")
    private List<Observacion> observacionList;

    public Docente() {
    }

    public Docente(Integer codigoDocente) {
        this.codigoDocente = codigoDocente;
    }

    public Docente(Integer codigoDocente, long idDocente, String rol) {
        this.codigoDocente = codigoDocente;
        this.idDocente = idDocente;
        this.rol = rol;
    }

    public Integer getCodigoDocente() {
        return codigoDocente;
    }

    public void setCodigoDocente(Integer codigoDocente) {
        this.codigoDocente = codigoDocente;
    }

    public long getIdDocente() {
        return idDocente;
    }

    public void setIdDocente(long idDocente) {
        this.idDocente = idDocente;
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

    public String getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(String fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public String getMunicipioNacimiento() {
        return municipioNacimiento;
    }

    public void setMunicipioNacimiento(String municipioNacimiento) {
        this.municipioNacimiento = municipioNacimiento;
    }

    public String getDepartamentoNacimiento() {
        return departamentoNacimiento;
    }

    public void setDepartamentoNacimiento(String departamentoNacimiento) {
        this.departamentoNacimiento = departamentoNacimiento;
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

    public String getEspecialidad() {
        return especialidad;
    }

    public void setEspecialidad(String especialidad) {
        this.especialidad = especialidad;
    }

    public Integer getEdadDocente() {
        return edadDocente;
    }

    public void setEdadDocente(Integer edadDocente) {
        this.edadDocente = edadDocente;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getRol() {
        return rol;
    }

    public void setRol(String rol) {
        this.rol = rol;
    }

    public Boolean getEstado() {
        return estado;
    }

    public void setEstado(Boolean estado) {
        this.estado = estado;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

    @XmlTransient
    public List<DocenteDirectorGrupo> getDocenteDirectorGrupoList() {
        return docenteDirectorGrupoList;
    }

    public void setDocenteDirectorGrupoList(List<DocenteDirectorGrupo> docenteDirectorGrupoList) {
        this.docenteDirectorGrupoList = docenteDirectorGrupoList;
    }

    @XmlTransient
    public List<Eventos> getEventosList() {
        return eventosList;
    }

    public void setEventosList(List<Eventos> eventosList) {
        this.eventosList = eventosList;
    }

    @XmlTransient
    public List<Asignacionesasignaturas> getAsignacionesasignaturasList() {
        return asignacionesasignaturasList;
    }

    public void setAsignacionesasignaturasList(List<Asignacionesasignaturas> asignacionesasignaturasList) {
        this.asignacionesasignaturasList = asignacionesasignaturasList;
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
        hash += (codigoDocente != null ? codigoDocente.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Docente)) {
            return false;
        }
        Docente other = (Docente) object;
        if ((this.codigoDocente == null && other.codigoDocente != null) || (this.codigoDocente != null && !this.codigoDocente.equals(other.codigoDocente))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.osorio.modelo.Docente[ codigoDocente=" + codigoDocente + " ]";
    }
    
}
