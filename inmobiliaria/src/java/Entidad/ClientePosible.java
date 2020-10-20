package Entidad;
//Entidad cliente posible

import java.util.Date;

public class ClientePosible extends Persona{
    protected String operacion;
    protected long leInteresa;//id del inmueble de interes
    protected String estado;
    
    public ClientePosible(){};
    
    public ClientePosible(String email,String nombre,String apellido,String dni,String direcc,String telFijo,String telMovil,String loc,Date fechaNac, String operacion,long leInteresa,String estado){
        this.email=email;
        this.nombre=nombre;
        this.apellido=apellido;
        this.dni=dni;
        this.direcc=direcc;
        this.telFijo=telFijo;
        this.telMovil=telMovil;
        this.loc=loc;
        this.fechaNac=fechaNac;
        this.operacion=operacion;
        this.leInteresa=leInteresa;
        this.estado=estado;
    }

    
    public void setOperacion(String operacion){
        this.operacion=operacion;
    }
    public void setEstado(String estado){
        this.estado=estado;
    }
    public void setLeInteresa(long leInteresa){
        this.leInteresa=leInteresa;
    }
    public String getOperacion(){
        return this.operacion;
    }
    public String getEstado(){
        return this.estado;
    }
    public long getLeInteresa(){
        return this.leInteresa;
    }
  }
