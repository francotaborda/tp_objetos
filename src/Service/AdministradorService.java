package Service;


import java.util.*;
import DAO.AdministradorDAO;
import imp.Adminstrador;
/**
 * 
 */
public class AdministradorService {
		AdministradorDAO admin = new AdministradorDAO();
    public void guardar(Adminstrador administrador) {
    	admin.guardar(administrador);
    	
    }

    public void eliminar(long id) {
        admin.eliminar(id);
    }

    public Adminstrador recuperar(long id){
        return admin.recuperar(id);
    }

    public ArrayList<Adminstrador> listar() {
        return admin.listar();
    }
}