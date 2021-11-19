package DAO;

import java.util.*;

import imp.Adminstrador;
import imp.Paciente;

/**
 * 
 */
public class PacienteDAO {
    public void guardar(Paciente paciente) {
        Archivo archivo = new Archivo("Paciente.txt");
        ArrayList<Paciente> lista = archivo.listar();
        long max = 0;

        if(paciente.getId() == 0) {
            for(Object objeto: lista)
            {
                if(((Paciente) objeto).getId() > max)
                    max = ((Paciente) objeto).getId();
            }
            paciente.setId(max + 1);
            lista.add(paciente);
        }
        else{
            for(Object objeto : lista){
            	Paciente ca = (Paciente) objeto;
                if(ca.getId() == paciente.getId()){
                    lista.remove(ca);
                    lista.add(paciente);
                }
            }
        }

        archivo.guardar(lista);
     }

     public Paciente recuperar(Long id) {
         ArrayList<Paciente> paciente = this.listar();
         Paciente resultado = null;

         for(Paciente ad : paciente) {
             if (ad.getId() == id)
                 resultado = ad;
         }

         return resultado;

     }

     public void eliminar(Long id) {
         Archivo archivo = new Archivo("Paciente.txt");
         ArrayList<Paciente> lista = archivo.listar();

         int index = 0;
         int i = 0;
         for(Object objeto:lista)
         {
             if(((Paciente)objeto).getId() == id)
                 index = i;
             i++;
         }
         lista.remove(index);
         archivo.guardar(lista);

     }

     public ArrayList<Paciente> listar() {
         Archivo archivo = new Archivo("Paciente.txt");
         ArrayList lista = archivo.listar();
         ArrayList<Paciente> pac = new ArrayList<>();

         for(Object obj: lista)
         	pac.add((Paciente) obj);

         return pac;
     }
     
     public boolean existePaciente(int DNI, String nombreUsuario) {
	    	ArrayList<Paciente> listaPacientes = this.listar();
	        boolean resultado = false;
	        for(Paciente pac : listaPacientes) {
	        	if (pac.getDNI()==DNI || pac.getNombreUsuario() == nombreUsuario) {
	        		resultado = true;
	        	}
				}
			return resultado;
     }
 }
