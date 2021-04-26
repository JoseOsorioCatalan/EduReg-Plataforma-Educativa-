package co.osorio.operaciones;

import co.osorio.DAOs.CursoDAO;
import co.osorio.modelo.Curso;
import co.osorio.modelo.Docente;
import co.osorio.modelo.Asignacionesasignaturas; 
import java.util.List;
import javax.persistence.Query;

public class OperacionesCurso implements CursoDAO {

    Conexion conectando;

    public OperacionesCurso() {
        conectando = new Conexion();
    }

    @Override
    public void registrar(Curso ob) throws Exception {

    }

    @Override
    public void modificar(Curso ob) throws Exception {

    }

    @Override
    public void eliminar(Curso ob) throws Exception {

    }

    @Override
    public List<Curso> listarTodos() throws Exception {
        String SQL = "select c from Curso c ";
        return conectando.getEm().createQuery(SQL).getResultList();
    }

    @Override
    public Curso Buscar(Integer dato) throws Exception {
        return conectando.getEm().find(Curso.class, dato);
    }
    
    public List<Curso> ListarCursosNoElegidosAteriormente()
    {
       
        final String  SQL= "SELECT * FROM curso WHERE `id_curso` NOT IN (SELECT curso FROM Docente_Director_Grupo where `estado`= 1)";
        Query Nativequery= conectando.getEm().createNativeQuery(SQL,Curso.class);
        
        return   (List<Curso>)  Nativequery.getResultList();
    }
    
    
   

    @Override
    public Curso BuscarPorCurso(String curso) {
        Curso cursoEncontrado = new Curso();
        String SQL;
        SQL = " SELECT p FROM Curso p WHERE p.curso= :curso";
        Query query = conectando.getEm().createQuery(SQL);
        query.setParameter("curso", curso);
        try {
            cursoEncontrado = (Curso) query.getSingleResult();
            return cursoEncontrado;
        } catch (Exception e) {
            return cursoEncontrado;
        }

    }
    
    
  

    
    

}
