package academia.modelo.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
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
private static final String SQL_LISTAR_CURSOS_PROFESOR = " 	SELECT\n" + 
				" 		c.id as 'id_curso',\n" + 
				" 		c.horas,\n" + 
				" 		c.curso as 'nombre_curso',\n" + 
				" 		c.identificador ,\n" + 
				" 		p.id as 'id_profesor',\n" + 
				" 		p.nombre as 'nombre_profesor',\n" + 
				" 		p.apellidos ,\n" + 
				" 		p.rol as 'id_rol',\n" + 
				" 		p.password as 'password'\n" + 
				" 	FROM cursos c \n" + 
				" 	INNER JOIN usuarios p ON c.idProfesor =p.id \n" + 
				" 	WHERE c.idProfesor =?;";
private static final String GET_CURSO_BY_ID = " 	SELECT \n" + 
		"				 		c.id as 'id_curso',  \n" + 
		"				 		c.horas,\n" + 
		"				 		c.curso as 'nombre_curso', \n" + 
		"				 		c.identificador ,\n" + 
		"				 		p.id as 'id_profesor', \n" + 
		"				 		p.nombre as 'nombre_profesor', \n" + 
		"				 		p.apellidos ,\n" + 
		"				 		p.rol as 'id_rol', \n" + 
		"				 		p.password as 'password' \n" + 
		"				 	FROM cursos c \n" + 
		"				 	INNER JOIN usuarios p ON c.idProfesor =p.id  \n" + 
		"				 	WHERE c.id =?;";
private static final String DELETE_CURSO_BY_ID = "DELETE FROM cursos WHERE id=?";
private static final String SQL_INSERT_CURSO = "INSERT INTO cursos (curso,identificador,horas,idProfesor) VALUES(?,?,?,?);";
	

	@Override
	public ArrayList<Curso> listar() throws Exception {
		ArrayList<Curso> cursos=new ArrayList<Curso>();
		
		try (Connection conn=ConnectionManager.getConnection();
				PreparedStatement pst= conn.prepareStatement(SQL_LISTAR_CURSOS);
				ResultSet rs=pst.executeQuery()){
				while (rs.next()) {
					
					Curso c=new Curso();
					c=mapper(rs);
					cursos.add(c);		
					
				}
			
		} 
		
		
		return cursos;
	}



	@Override
	public ArrayList<Curso> listarPorProfesor(int id) throws Exception {
		ArrayList<Curso>cursos=new ArrayList<Curso>();
		try(Connection conn=ConnectionManager.getConnection();
				PreparedStatement pst=conn.prepareStatement(SQL_LISTAR_CURSOS_PROFESOR);) {
			pst.setInt(1, id);
			try (ResultSet rs=pst.executeQuery()){
				while (rs.next()) {
					
					Curso c=new Curso();
					c=mapper(rs);
					cursos.add(c);
				}
				
			}
		}
		
		
		return cursos;
	}

	
	@Override
	public Curso getById(int id) throws Exception {
		Curso curso=new Curso();
		
		try(Connection conn=ConnectionManager.getConnection();
				PreparedStatement pst=conn.prepareStatement(GET_CURSO_BY_ID)) {
			
			pst.setInt(1, id);
			
			try (ResultSet rs=pst.executeQuery();){
				if (rs.next()) {
					curso=mapper(rs);
				}
				
			}
		}
		
		return curso;
	}
	@Override
	public Curso delete(int id) throws Exception{
		Curso curso=new Curso();
		try (Connection conn=ConnectionManager.getConnection();
				PreparedStatement pst=conn.prepareStatement(DELETE_CURSO_BY_ID)){
			pst.setInt(1, id);
			// recuperar antes de borrar			
			curso=getById(id);
			
			pst.executeUpdate();
			
		}
		
		return curso;
	}

	
	@Override
	public Curso insert(Curso curso) throws Exception {
		try(Connection conn=ConnectionManager.getConnection();
				PreparedStatement pst=conn.prepareStatement(SQL_INSERT_CURSO,Statement.RETURN_GENERATED_KEYS);) {
			//curso,identificador,horas,idProfesor
			pst.setString(1, curso.getNombre());
			pst.setString(2, curso.getIdentificador());
			pst.setInt(3, curso.getHoras());
			pst.setInt(4, curso.getProfesor().getId());
			
			pst.executeUpdate();
			try (ResultSet rs=pst.getGeneratedKeys();){
				if (rs.next()) {
					curso.setId(rs.getInt(1));
				}

			}
		} 
		
		
		return curso;
	}
	
	/**
	 * Método para mapear un curso desde un result set
	 * @param rs
	 * @return El curso mapeado
	 * @throws SQLException
	 */
	private Curso mapper(ResultSet rs) throws SQLException {
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
		return c;
	}











}
