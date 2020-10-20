package Entidad;
//Entidad persona

import java.util.Date;

public class Persona{
    protected long id=1;
    protected String email;
    protected String nombre="";
    protected String apellido="";
    protected String dni="";
    protected String direcc="";
    protected String telFijo="";
    protected String telMovil="";
    protected String loc="";
    protected Date fechaNac;
    
    public Persona(){}

    public Persona(String email,String nombre,String apellido,String dni,String direcc,String telFijo,String telMovil,String loc,Date fechaNac){
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
    /*Begin of Setters*/
    public void setNombre(String nombre){
        this.nombre=nombre;
    }
    public void setApellido(String apellido){
        this.apellido=apellido;
    }
    public void setDni(String dni){
        this.dni=dni;
    }
    public void setDirecc(String direcc){
        this.direcc=direcc;
    }
    public void setTelFijo(String telFijo){
        this.telFijo=telFijo;
    }
    public void setTelMovil(String telMovil){
        this.telMovil=telMovil;
    }
    public void setLoc(String loc){
        this.loc=loc;
    }
    public void setFechaNac(Date fechaNac){
        this.fechaNac=fechaNac;
    }
    public void setEmail(String email) {
    	this.email = email;
    }
    /*End of Setters*/
    
    /*Begin of Getters*/
    public String getEmail() {
    	return email;
    }
    public long getId(){
        return this.id;
    }
    public String getNombre(){
        return this.nombre;
    }
    public String getApellido(){
        return this.apellido;
    }
    public String getDni(){
        return this.dni;
    }
    public String getDirecc(){
        return this.direcc;
    }
    public String getTelFijo(){
        return this.telFijo;
    }
    public String getTelMovil(){
        return this.telMovil;
    }
    public String getLoc(){
        return this.loc;
    }
    public Date getFechaNac(){
        return this.fechaNac;
    }
    /*End of Getters*/
}
