package Entidad;
import Seguridad.MD5;
import java.util.Date;

//Entidad administrador
public class Administrador extends Persona{
    protected String pagWeb;
    protected String usuario;
    protected String password;

	
    public Administrador(){

    }
    public Administrador(String usuario){
        this.usuario=usuario;
    }

    public Administrador(String email,String nombre,String apellido,String dni,String direcc,String telFijo,String telMovil,String loc,Date fechaNac,
                            String pagWeb, String usuario, String password) throws Exception
                        {
        this.pagWeb=pagWeb;
        this.usuario=usuario;
        this.password=MD5.md5(password);
        this.email=email;
	this.nombre=nombre;
        this.apellido=apellido;
        this.dni=dni;
        this.direcc=direcc;
        this.telFijo=telFijo;
        this.telMovil=telMovil;
        this.loc=loc;
        this.fechaNac=fechaNac;

    }

    //Begin Getters

    public String getPagWeb() {
            return pagWeb;
    }
    
    public long getId() {
            return id;
    }

    public String getUsuario() {
        return usuario;
    }

    public String getPassword() {
        return password;
    }    
    //End Getters

    //Begin Setters
    public void setPagWeb(String pagWeb) {
        this.pagWeb = pagWeb;
    }
    
    public void setPassword(String password) {
        this.password = password;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }
    //End Setters
}
