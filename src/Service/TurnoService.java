package Service;

import java.util.*;

import DAO.TurnoDAO;
import imp.Turno;

/**
 * 
 */
public class TurnoService {
	TurnoDAO t = new TurnoDAO();
    public void guardar(Turno turno) {
    	t.guardar(turno);
    	
    }

    public void eliminar(long id) {
        t.eliminar(id);
    }

    public Turno recuperar(long id){
        return t.recuperar(id);
    }

    public ArrayList<Turno> listar() {
        return t.listar();
    }
}