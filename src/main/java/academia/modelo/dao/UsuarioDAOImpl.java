package academia.modelo.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.apache.log4j.Logger;

import academia.modelo.ConnectionManager;
import academia.modelo.pojo.Usuario;

public class UsuarioDAOImpl implements UsuarioDAO {
	private final static Logger LOG = Logger.getLogger(UsuarioDAOImpl.class);

	
	//singleton
    private static final UsuarioDAOImpl INSTANCE = new UsuarioDAOImpl();

    private UsuarioDAOImpl() {}

    public static UsuarioDAOImpl getInstance() {
        return INSTANCE;
    }
	
	
	
	private static final String SQL_BUSCAR_USUARIO=" SELECT u.id 'id_usuario',\n" + 
							" 		u.nombre ,\n" + 
							" 		u.apellidos, \n" + 
							" 		u.password ,\n" + 
							" 		u.rol \n" + 
							"		FROM usuarios u WHERE u.nombre =? AND u.password =MD5(?);";

	@Override
	public Usuario buscarUsuario(String nombre, String password)throws Exception {
		Usuario usuario=null;
		
		try(Connection conn=ConnectionManager.getConnection();
				PreparedStatement pst= conn.prepareStatement(SQL_BUSCAR_USUARIO)){
			
			pst.setString(1, nombre);
			pst.setString(2, password);
			LOG.trace(pst);
			 try(ResultSet rs=pst.executeQuery()) {
				 if (rs.next()) {
					usuario=mapper(rs);
				}
				
			}
			
		}
		
		
		return usuario;
	}

	private Usuario mapper(ResultSet rs) throws SQLException {
		Usuario usu=new Usuario();
		usu.setApellidos(rs.getString("apellidos"));
		usu.setId(rs.getInt("id_usuario"));
		usu.setNombre(rs.getString("nombre"));
		usu.setPassword(rs.getString("password"));
		usu.setRol(rs.getInt("rol"));
		

		
		
		return usu;
	}

}
