package academia.modelo.dao;

import java.util.ArrayList;

import academia.modelo.pojo.Curso;
import academia.modelo.pojo.Usuario;

public interface CursoDAO {
/**
 * Método que lista todos los cursos
 * @return listado de todos los cursos
 * @throws Exception
 */
	public ArrayList<Curso>listar() throws Exception;
	/**
	 * Método que lista los cursos de un profesor
	 * @param id id del profesor
	 * @return listado de cursos
	 * @throws Exception
	 */
	public ArrayList<Curso>listarPorProfesor(int id) throws Exception;
	
	/**
	 * Método que retorna un curso dada una id de curso
	 * @param id
	 * @return el curso buscado
	 * @throws Exception
	 */
	public Curso getById(int id)throws Exception;
	/**
	 * Método que elimina un curso dada un id de curso
	 * @param id el id del curso a borrar
	 * @return el curso eliminado
	 * @throws Exception
	 */
	public Curso delete(int id)throws Exception;
	
	/**
	 * Método que inserta un curso en la BBDD
	 * @param curso
	 * @return el curso insertado
	 */
	public Curso insert(Curso curso)throws Exception;
	
	/**
	 * Método que retorna un listado de cursos en los que el alumno esta matriculado 
	 * o no 
	 * @param id
	 * @param apuntado 
	 * @return Listado de cursos en los que el usuario esta matriculado si apuntado=TRUE
	 * Retorna el listado de cursos en los que NO esta matriculado si apuntado=FALSE
	 * @throws Exception
	 */
	public ArrayList<Curso> getByIdAlumno(int id,boolean apuntado)throws Exception;
	
	/**
	 * Método que inscribe un alumno(id) en un curso (idCurso)
	 * @param idCurso
	 * @param id el id del usuario
	 * @return 
	 * @throws Exception
	 */
	public int inscribirCurso(int idCurso, int id)throws Exception;

	

	
}
