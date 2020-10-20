package Entidad;
//Entidad cliente

import java.util.Date;

public class Cliente extends Persona{
    
    
    public Cliente(){
    }
    
     public Cliente(String email,String nombre,String apellido,String dni,String direcc,String telFijo,String telMovil,String loc,Date fechaNac){
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
   
  
}



