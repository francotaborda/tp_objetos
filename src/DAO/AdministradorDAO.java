package DAO;


import java.util.ArrayList;
import imp.Adminstrador;



public class AdministradorDAO {
    public void guardar(Adminstrador adminsitrador) {
       Archivo archivo = new Archivo("Administrador.txt");
       ArrayList<Adminstrador> lista = archivo.listar();
       long max = 0;

       if(adminsitrador.getId() == 0) {
           for(Object objeto: lista)
           {
               if(((Adminstrador) objeto).getId() > max)
                   max = ((Adminstrador) objeto).getId();
           }
           adminsitrador.setId(max + 1);
           lista.add(adminsitrador);
       }
       else{
           for(Object objeto : lista){
        	   Adminstrador ca = (Adminstrador) objeto;
               if(ca.getId() == adminsitrador.getId()){
                   lista.remove(ca);
                   lista.add(adminsitrador);
               }
           }
       }

       archivo.guardar(lista);
    }

    public Adminstrador recuperar(Long id) {
        ArrayList<Adminstrador> adminsitrador = this.listar();
        Adminstrador resultado = null;

        for(Adminstrador ad : adminsitrador) {
            if (ad.getId() == id)
                resultado = ad;
        }

        return resultado;

    }

    public void eliminar(Long id) {
        Archivo archivo = new Archivo("Administrador.txt");
        ArrayList<Adminstrador> lista = archivo.listar();

        int index = 0;
        int i = 0;
        for(Object objeto:lista)
        {
            if(((Adminstrador)objeto).getId() == id)
                index = i;
            i++;
        }
        lista.remove(index);
        archivo.guardar(lista);

    }

    public ArrayList<Adminstrador> listar() {
        Archivo archivo = new Archivo("Administrador.txt");
        ArrayList lista = archivo.listar();
        ArrayList<Adminstrador> admin = new ArrayList<>();

        for(Object obj: lista)
        	admin.add((Adminstrador) obj);

        return admin;
    }

}
