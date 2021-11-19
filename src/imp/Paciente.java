package imp;


import java.io.Serializable;
import java.util.*;
public class Paciente extends Usuario implements Serializable {

    private String nombre;
    private String domicilio;
    private int dni;
    private String apellido;
    private String fechaDeAlta;
    public String nombreUsuario;
    public String password;
    private long id;
    
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }
    
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
    public String getFechaDeAlta() {
        return fechaDeAlta;
    }
    public void setFechaDeAlta(String fechaDeAlta) {
        this.fechaDeAlta=fechaDeAlta; 
    }

}