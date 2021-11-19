package imp;


import java.io.Serializable;
import java.util.*;

public class Turno implements Serializable{
    private boolean disponible;
    private String fecha;
    private int paciente;
    private String odontologo;
    private long id;
    
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }
    
    public boolean getDisponible() {
    	return disponible;
    }

    public void setDisponible(boolean disponible) {
        this.disponible=disponible;
    }

    public String getFecha() {
    	return fecha; 
    }

    public void setFecha(String fecha) {
    	this.fecha=fecha;
    }

    public int getPaciente() {
      return paciente; 
       
        
    }
    public void setPaciente() {
    	paciente=this.getPaciente();
 
    }

    public String getOdontologo() {
        return odontologo;
    }


    public void setOdontologo(String odontologo) {
    	this.odontologo=odontologo;
        
    }

}