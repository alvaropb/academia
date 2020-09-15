package academia.modelo.dao;

import java.util.ArrayList;

import academia.modelo.pojo.Curso;
import academia.modelo.pojo.Usuario;

public interface CursoDAO {

	public ArrayList<Curso>listar() throws Exception;
	
}
