package academia.modelo.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import academia.modelo.ConnectionManager;
import academia.modelo.pojo.Curso;
import academia.modelo.pojo.Profesor;

public class CursoDAOImpl implements CursoDAO {
private static final String SQL_LISTAR_CURSOS="SELECT\n" + 
									" 		c.id as 'id_curso',\n" + 
									" 		c.horas,\n" + 
									" 		c.curso as 'nombre_curso',\n" + 
									" 		c.identificador ,\n" + 
									" 		p.id as 'id_profesor',\n" + 
									" 		p.nombre as 'nombre_profesor',\n" + 
									" 		p.apellidos \n" + 
									" 	FROM cursos c \n" + 
									" 	INNER JOIN profesores p ON c.idProfesor =p.id ;";
	
	@Override
	public ArrayList<Curso> listar() {
		ArrayList<Curso> cursos=new ArrayList<Curso>();
		
		try (Connection conn=ConnectionManager.getConnection();
				PreparedStatement pst= conn.prepareStatement(SQL_LISTAR_CURSOS);
				ResultSet rs=pst.executeQuery()){
				while (rs.next()) {
					
					Curso c=new Curso();
					c.setHoras(rs.getInt("horas"));
					c.setId(rs.getInt("id_curso"));
					c.setIdentificador(rs.getString("identificador"));
					c.setNombre(rs.getString("nombre_curso"));
					
					
					Profesor p=new Profesor();
					p.setId(rs.getInt("id_profesor"));
					p.setNombre(rs.getString("nombre_profesor"));
					p.setApellidos(rs.getString("apellidos"));
					
					c.setProfesor(p);
					cursos.add(c);		
					
				}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		return cursos;
	}

}
