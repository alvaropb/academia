package academia.modelo.dao;

import academia.modelo.pojo.Usuario;

public interface UsuarioDAO {
	public Usuario buscarUsuario(String nombre, String password)throws Exception;

}
