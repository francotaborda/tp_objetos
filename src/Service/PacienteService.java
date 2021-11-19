package Service;

import java.util.*;

import DAO.PacienteDAO;
import DAO.UsuarioDAO;
import imp.Paciente;
import imp.Usuario;

/**
 * 
 */
public class PacienteService {
	
	PacienteDAO pac = new PacienteDAO();
	UsuarioDAO user = new UsuarioDAO();
	
    public void guardar(Paciente paciente) {
    	pac.guardar(paciente);
    	Usuario usuario = new Usuario();
    	usuario.setRol("paciente");
    	usuario.setPass(paciente.getPass());
    	usuario.setUsuario(paciente.getNombreUsuario());
    	user.guardar(usuario);
    }

    public void eliminar(long id) {
    	pac.eliminar(id);
    }

    public Paciente recuperar(long id){
        return pac.recuperar(id);
    }

    public ArrayList<Paciente> listar() {
        return pac.listar();
    }
    
    public boolean existePaciente(int DNI,String nombreUsuario){
    	return pac.existePaciente(DNI, nombreUsuario);
    }
}
   