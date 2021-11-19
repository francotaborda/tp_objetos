package DAO;

import java.util.*;
import imp.Odontologo;

/**
 * 
 */
public class OdontologoDAO {
	public void guardar(Odontologo odontologo) {
	       Archivo archivo = new Archivo("Odontologo.txt");
	       ArrayList<Odontologo> lista = archivo.listar();
	       long max = 0;

	       if(odontologo.getId() == 0) {
	           for(Object objeto: lista)
	           {
	               if(((Odontologo) objeto).getId() > max)
	                   max = ((Odontologo) objeto).getId();
	           }
	           odontologo.setId(max + 1);
	           lista.add(odontologo);
	       }
	       else{
	           for(Object objeto : lista){
	        	   Odontologo ca = (Odontologo) objeto;
	               if(ca.getId() == odontologo.getId()){
	                   lista.remove(ca);
	                   lista.add(odontologo);
	               }
	           }
	       }

	       archivo.guardar(lista);
	    }

	    public Odontologo recuperar(Long id) {
	        ArrayList<Odontologo> odontologo = this.listar();
	        Odontologo resultado = null;

	        for(Odontologo ad : odontologo) {
	            if (ad.getId() == id)
	                resultado = ad;
	        }

	        return resultado;

	    }

	    public void eliminar(Long id) {
	        Archivo archivo = new Archivo("Odontologo.txt");
	        ArrayList<Odontologo> lista = archivo.listar();

	        int index = 0;
	        int i = 0;
	        for(Object objeto:lista)
	        {
	            if(((Odontologo)objeto).getId() == id)
	                index = i;
	            i++;
	        }
	        lista.remove(index);
	        archivo.guardar(lista);

	    }

	    public ArrayList<Odontologo> listar() {
	        Archivo archivo = new Archivo("Odontologo.txt");
	        ArrayList lista = archivo.listar();
	        ArrayList<Odontologo> usu = new ArrayList<>();

	        for(Object obj: lista)
	        	usu.add((Odontologo) obj);

	        return usu;
	    }

}