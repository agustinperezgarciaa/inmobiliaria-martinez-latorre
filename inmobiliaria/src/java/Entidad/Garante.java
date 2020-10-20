package Entidad;
//Entidad garante

import java.util.Date;

public class Garante extends Persona{
    protected String profesion;
    protected String lugarTrabajo;
    protected String nacionalidad;

    
   public Garante(){}
   
    public Garante(String email,String nombre,String apellido,String dni,String direcc,String telFijo,String telMovil,String loc,Date fechaNac,String profesion,String lugarTrabajo,String nacionalidad){
        this.email=email;
	this.nombre=nombre;
        this.apellido=apellido;
        this.dni=dni;
        this.direcc=direcc;
        this.telFijo=telFijo;
        this.telMovil=telMovil;
        this.loc=loc;
        this.fechaNac=fechaNac;
        this.profesion=profesion;
        this.lugarTrabajo=lugarTrabajo;
        this.nacionalidad=nacionalidad;

    }
   
   /*Beggin Setters*/
   
   public void setProfesion(String profesion){
       this.profesion=profesion;
   }
   public void setLugarTrabajo(String lugarTrabajo){
       this.lugarTrabajo=lugarTrabajo;
   }
   public void setNacionalidad(String nacionalidad){
       this.nacionalidad=nacionalidad;
   }

   /*End Setters*/
   
   /*Beggin Getters*/
   
   public String getProfesion(){
       return profesion;
   }
   public String getLugarTrabajo(){
       return lugarTrabajo;
   }
   public String getNacionalidad(){
       return nacionalidad;
   }
  
   /*End Getters*/
            
}
