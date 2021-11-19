package imp;


import java.io.Serializable;
import java.util.*;

public class Usuario implements Serializable{
	private String usuario; 
    private String pass;
    private String rol;
    private long id;
    
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setUsuario(String pass, String rol, String usuario) {
    	this.usuario=usuario;
    	this.pass=pass;
    	this.rol=rol;
    }
    public String getRol() {
        return rol;
           }
    public String getPass() {
    	return pass;
    }
    public String getUsuario() {
    	return usuario; 
    }

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public void setPass(String pass) {
		this.pass = pass;
	}

	public void setRol(String rol) {
		this.rol = rol;
	}
}