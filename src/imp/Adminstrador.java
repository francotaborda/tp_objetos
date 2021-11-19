package imp;
import java.io.Serializable;



public class Adminstrador extends Usuario implements Serializable {


    private String nombreUsuario;
    public String password;
    private long id;
    
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNombreUsuario() {
       return nombreUsuario; 
    }
    //heredo usuario de log in 
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