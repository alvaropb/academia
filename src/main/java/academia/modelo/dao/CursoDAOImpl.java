package academia.modelo.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import academia.modelo.ConnectionManager;
import academia.modelo.pojo.Curso;
import academia.modelo.pojo.Usuario;

public class CursoDAOImpl implements CursoDAO {
private static final String SQL_LISTAR_CURSOS=" 	SELECT\n" + 
				" 		c.id as 'id_curso',\n" + 
				" 		c.horas,\n" + 
				" 		c.curso as 'nombre_curso',\n" + 
				" 		c.identificador ,\n" + 
				" 		u.id as 'id_profesor',\n" + 
				" 		u.nombre as 'nombre_profesor',\n" + 
				" 		u.apellidos,\n" + 
				" 		u.rol as 'id_rol',\n" + 
				" 		u.password as 'password'\n" + 
				" 	FROM cursos c \n" + 
				" 	INNER JOIN usuarios u ON c.idProfesor =u.id ;";
	
	@Override
	public ArrayList<Curso> listar() throws Exception {
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
					
					
					
					Usuario p=new Usuario();
					p.setId(rs.getInt("id_profesor"));
					p.setNombre(rs.getString("nombre_profesor"));
					p.setApellidos(rs.getString("apellidos"));
					p.setRol(rs.getInt("id_rol"));
					p.setPassword(rs.getString("password"));
					
					c.setProfesor(p);
					cursos.add(c);		
					
				}
			
		} 
		
		
		return cursos;
	}



}
