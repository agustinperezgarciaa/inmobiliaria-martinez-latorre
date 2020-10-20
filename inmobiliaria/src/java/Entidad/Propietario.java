package Entidad;
//Entidad propietario

import java.util.Date;

public class Propietario extends Persona{
  
    public Propietario(){}
    
     public Propietario(String email,String nombre,String apellido,String dni,String direcc,String telFijo,String telMovil,String loc,Date fechaNac){
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
