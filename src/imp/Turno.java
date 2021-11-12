package imp;


import java.util.*;

public class Turno {
    private boolean disponible;
    private Date fecha;
    private int paciente;
    private String odontologo;
    public boolean getDisponible() {
    	return disponible;
    }

    public void setDisponible(boolean disponible) {
        this.disponible=disponible;
    }

    public void getFecha() {
        // TODO implement here
    }

    /**
     * 
     */
    public void setFecha() {
        // TODO implement here
    }

    /**
     * @return 
     * 
     */
    public int getPaciente() {
      return paciente; 
       
        
    }
    public void setPaciente() {
    	paciente=this.getPaciente();
    }

    public String getOdontologo() {
        return odontologo;
    }


    public void setOdontologo() {
    	this.odontologo=odontologo;
        
    }

}