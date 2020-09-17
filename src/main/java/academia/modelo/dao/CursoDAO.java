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
	
}
