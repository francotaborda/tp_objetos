package company;

import java.util.ArrayList;

import Service.AdministradorService;
import Service.OdontologoService;
import Service.PacienteService;
import Service.TurnoService;
import Service.UsuarioService;
import imp.Adminstrador;
import imp.Odontologo;
import imp.Paciente;
import imp.Turno;
import imp.Usuario;
import ui.PanelLogIn;
import ui.PanelManager;

import java.io.FileInputStream;

public class Main {

    public static void main(String[] args) {
    	/*
        System.out.println("DAO ADMIN");

        AdministradorService service = new AdministradorService();


        Adminstrador admins = new Adminstrador();
        admins.setId(0);
        admins.setPassword("admin1");
        admins.setNombreUsuario("admin1");
        service.guardar(admins);
       
        
        System.out.println("DAO USUARIO");
        UsuarioService usuServ= new UsuarioService();
        Usuario usu = new Usuario();
        usu.setUsuario("admin", "admin", "admin");
        usu.setId(0);
        usuServ.guardar(usu);
        
        System.out.println(admins.getId() + " " + admins.getUsuario()+ " " + admins.getRol()+" "+admins.getPass());*/

        /*AdministradorService service = new AdministradorService();

       
        Adminstrador admins = new Adminstrador();
        admins.setId(0);
        admins.setPassword("admin");
        admins.setNombreUsuario("admin");
        service.guardar(admins);
        
        ArrayList<Adminstrador> lista = service.listar();
        
        for(Adminstrador ca:lista)
            System.out.println(ca.getId()+" "+ca.getNombreUsuario()+" "+ca.getPassword() );
        
        System.out.println("DAO PACIENTE");
        PacienteService service1 = new PacienteService();

        
        Paciente pac = new Paciente();
        pac.setId(0);
        pac.setDNI(6169519);
        pac.setApellido("pepe");
        pac.setNombre("carlos");
        service1.guardar(pac);
        
        ArrayList<Paciente> lista1 = service1.listar();
        
        for(Paciente ca:lista1)
            System.out.println(ca.getId() + " " + ca.getDNI()+" "+ca.getApellido()+ca.getNombre());
       
        System.out.println("DAO USUARIO");
        Usuario usu = new Usuario();
        usu.setUsuario("999", "administrador", "asdf");
        usu.setId(0);
        
        usuServ.guardar(usu);
        UsuarioService usuServ= new UsuarioService();
        ArrayList<Usuario> lista22 = usuServ.listar();
        for(Usuario ca:lista22) {
            System.out.println(ca.getId() + " " + ca.getUsuario()+ " " + ca.getRol());}
        String usu = "";
        usu= usuServ.validarUsuario("porta");
        System.out.println(usu);
        

        System.out.println("DAO Truno");
        TurnoService serviceTruno = new TurnoService();

        
        Turno turn = new Turno();
        turn.setId(0);
        turn.setDisponible(true);
        turn.setOdontologo("pedro");
        turn.setId(0);
        serviceTruno.guardar(turn);
        
        ArrayList<Turno> listaturn = serviceTruno.listar();
        
        for(Turno ca:listaturn)
            System.out.println(ca.getId() + " " + ca.getDisponible()+" "+ca.getOdontologo());
        */
    	/*
    	Odontologo odontologo = new Odontologo();
    	odontologo.setId(0);
    	odontologo.setNombre("Julian");
    	odontologo.setApellido("Perez");
    	odontologo.setMatricula("25698741");
    	odonServ.guardar(odontologo);*/
    	/*OdontologoService odonServ = new OdontologoService();
    	
    	Odontologo odontologo1 = new Odontologo();
    	odontologo1.setId(0);
    	odontologo1.setNombre("Hernan");
    	odontologo1.setApellido("Marquez");
    	odontologo1.setMatricula("15698745");
    	odonServ.guardar(odontologo1);
    	
    	Odontologo odontologo2 = new Odontologo();
    	odontologo2.setId(0);
    	odontologo2.setNombre("Florencia");
    	odontologo2.setApellido("Martinez");
    	odontologo2.setMatricula("12457896");
    	odonServ.guardar(odontologo2);
    	
    	ArrayList<Odontologo> listaodontologo = odonServ.listar();
        
        for(Odontologo ca:listaodontologo)
            System.out.println(ca.getId() + " " + ca.getNombre()+" "+ca.getApellido()+" "+ca.getMatricula());
    	
    	UsuarioService usuServ= new UsuarioService();
        
        ArrayList<Usuario> lista22 = usuServ.listar();
        for(Usuario ca:lista22) {
            System.out.println(ca.getId() + " " + ca.getUsuario()+ " " + ca.getRol()+" "+ca.getPass());}        
        
        
        */
    	
    	AdministradorService service = new AdministradorService();
    	
    	UsuarioService usuServ= new UsuarioService();

        
        Adminstrador admins = new Adminstrador();
        admins.setId(0);
        admins.setPassword("admin");
        
        admins.setNombreUsuario("admin");
        service.guardar(admins);
        
        System.out.println("DAO USUARIO");
        Usuario usu = new Usuario();
        usu.setUsuario("admin", "admin", "admin");
        usu.setId(0);
        
        usuServ.guardar(usu);
        
        ArrayList<Adminstrador> lista = service.listar();
        
        for(Adminstrador ca:lista)
            System.out.println(ca.getId()+" "+ca.getNombreUsuario()+" "+ca.getPassword() );
    	
        
        ArrayList<Usuario> lista22 = usuServ.listar();
        for(Usuario ca:lista22) {
            System.out.println(ca.getId() + " " + ca.getUsuario()+ " " + ca.getRol()+" "+ca.getPass());}      
        
        PanelManager panelManager = new PanelManager();
        panelManager.armarManager();

        


    }
}
