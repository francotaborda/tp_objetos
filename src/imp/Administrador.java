package imp;
import java.util.*;


public class Administrador extends Usuario {

    private String nombre;
    private String apellido;
    private String domicilio;
    private String nombreUsuario;
    private int dni;
    public String password;

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre ) {
        this.nombre=nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido=apellido;
    }

    public String getDomicilio() {
        return domicilio;
    }
    
    public void setDomicilio(String domicilio) {
        this.domicilio=domicilio;
    }


    public int getDNI() {
        return dni; 
    }

    public void setDNI(int dni) {
        this.dni=dni;
    }

    public String getNombreUsuario() {
       return nombreUsuario; 
    }

    public void setNombreUsuario(String nombreUsuario) {
    	this.nombreUsuario=nombreUsuario;
    }

    public String getPassword() {
        return password; 
    }

    public void setPassword(String password) {
        this.password=password; 
    }

}