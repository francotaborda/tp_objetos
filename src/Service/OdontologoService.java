package Service;

import java.util.*;

import DAO.OdontologoDAO;
import imp.Odontologo;

/**
 * 
 */
public class OdontologoService {
	OdontologoDAO odont = new OdontologoDAO();
	public void guardar(Odontologo odontologo) {
		odont.guardar(odontologo);
	
	}

	public void eliminar(long id) {
		odont.eliminar(id);
	}

	public Odontologo recuperar(long id){
		return odont.recuperar(id);
	}

	public ArrayList<Odontologo> listar() {
    return odont.listar();
		}
	}