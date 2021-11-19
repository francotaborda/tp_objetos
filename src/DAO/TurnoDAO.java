package DAO;

import java.util.*;

import imp.Adminstrador;
import imp.Turno;

/**
 * 
 */
public class TurnoDAO {
    public void guardar(Turno turno) {
        Archivo archivo = new Archivo("Turno.txt");
        ArrayList<Turno> lista = archivo.listar();
        long max = 0;

        if(turno.getId() == 0) {
            for(Object objeto: lista)
            {
                if(((Turno) objeto).getId() > max)
                    max = ((Turno) objeto).getId();
            }
            turno.setId(max + 1);
            lista.add(turno);
        }
        else{
            for(Object objeto : lista){
            	Turno ca = (Turno) objeto;
                if(ca.getId() == turno.getId()){
                    lista.remove(ca);
                    lista.add(turno);
                }
            }
        }

        archivo.guardar(lista);
     }

     public Turno recuperar(Long id) {
         ArrayList<Turno> turno = this.listar();
         Turno resultado = null;

         for(Turno ad : turno) {
             if (ad.getId() == id)
                 resultado = ad;
         }

         return resultado;

     }

     public void eliminar(Long id) {
         Archivo archivo = new Archivo("Turno.txt");
         ArrayList<Turno> lista = archivo.listar();

         int index = 0;
         int i = 0;
         for(Object objeto:lista)
         {
             if(((Turno)objeto).getId() == id)
                 index = i;
             i++;
         }
         lista.remove(index);
         archivo.guardar(lista);

     }

     public ArrayList<Turno> listar() {
         Archivo archivo = new Archivo("Turno.txt");
         ArrayList lista = archivo.listar();
         ArrayList<Turno> turn = new ArrayList<>();

         for(Object obj: lista)
        	 turn.add((Turno) obj);

         return turn;
     }

 }