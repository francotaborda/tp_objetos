package Service;

import java.util.*;


import DAO.UsuarioDAO;
import imp.Usuario;

/**
 * 
 */
public class UsuarioService {
	UsuarioDAO usu = new UsuarioDAO();
    public void guardar(Usuario usuario) {
    	usu.guardar(usuario);
    	
    }

    public void eliminar(long id) {
        usu.eliminar(id);
    }

    public Usuario recuperar(long id){
        return usu.recuperar(id);
    }

    public ArrayList<Usuario> listar() {
        return usu.listar();
    }
    // para validar la exitencia 
    public Usuario validarUsuario(String usuario,String pass){
    	return usu.validarUsuario(usuario, pass);
 
    }
    public long recuperarId(String usuario) {
    	return usu.recuperarId(usuario);
    }
}