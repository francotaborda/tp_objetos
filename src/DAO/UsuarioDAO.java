package DAO;

import java.util.*;

import imp.Adminstrador;
import imp.Usuario;

/**
 * 
 */
public class UsuarioDAO {
	public void guardar(Usuario usuario) {
	       Archivo archivo = new Archivo("Usuario.txt");
	       ArrayList<Usuario> lista = archivo.listar();
	       long max = 0;

	       if(usuario.getId() == 0) {
	           for(Object objeto: lista)
	           {
	               if(((Usuario) objeto).getId() > max)
	                   max = ((Usuario) objeto).getId();
	           }
	           usuario.setId(max + 1);
	           lista.add(usuario);
	       }
	       else{
	           for(Object objeto : lista){
	        	   Usuario ca = (Usuario) objeto;
	               if(ca.getId() == usuario.getId()){
	                   lista.remove(ca);
	                   lista.add(usuario);
	               }
	           }
	       }

	       archivo.guardar(lista);
	    }

	public Usuario recuperar(Long id) {
	        ArrayList<Usuario> usuario = this.listar();
	        Usuario resultado = null;

	        for(Usuario ad : usuario) {
	            if (ad.getId() == id)
	                resultado = ad;
	        }

	        return resultado;

	    }
	    //para tipo de Usuario

	    public void eliminar(Long id) {
	        Archivo archivo = new Archivo("Usuario.txt");
	        ArrayList<Usuario> lista = archivo.listar();

	        int index = 0;
	        int i = 0;
	        for(Object objeto:lista)
	        {
	            if(((Usuario)objeto).getId() == id)
	                index = i;
	            i++;
	        }
	        lista.remove(index);
	        archivo.guardar(lista);

	    }

	    public ArrayList<Usuario> listar() {
	        Archivo archivo = new Archivo("Usuario.txt");
	        ArrayList lista = archivo.listar();
	        ArrayList<Usuario> usu = new ArrayList<>();

	        for(Object obj: lista)
	        	usu.add((Usuario) obj);

	        return usu;
	    }
	    public Usuario validarUsuario(String usuario, String pass) {
	    	ArrayList<Usuario> usu = this.listar();
	        Usuario resultado = null;
	        for(Usuario ad : usu) {
	        	if(ad.getUsuario() != null) {
	        	if (ad.getUsuario().equals(usuario) && ad.getPass().equals(pass)) {
	        		resultado = ad;
	        	}
	        	}

					}
			return resultado;
	       
}
	    public long recuperarId(String usuario) {
	    	ArrayList<Usuario> usu = this.listar();
	        long resultado=0;
	        for(Usuario ad : usu) {
	        	if (ad.getUsuario().equals(usuario)) 
	        		resultado = ad.getId();

					}
			return resultado;
	       
}
}