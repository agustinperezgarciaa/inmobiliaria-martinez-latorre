package Entidad;
//Entidad alquiler

import java.util.Calendar;
import java.util.Date;

public class Alquileres {
    protected Cliente alquila;//relacion:Cliente(alquila) 1-n Alquileres
    protected Inmueble alquilado;//relacion:Inmueble(alquilado) 1-n Alquileres
    protected Administrador administra;//relacion:Administrador(administra) 1-n Alquileres
    protected Garante garantiza; //relacion: Garante (garantiza) 1-n Alquileres
    protected long id=1;
    protected Date fecha;
    protected long monto;

    
    public Alquileres(){
    }
    
    public Alquileres(Date fecha,Cliente alquila,Inmueble alquilado,Administrador administra,Garante garantiza, long monto){       
        this.alquila=alquila;
        this.alquilado=alquilado;
        this.administra=administra;
        this.garantiza=garantiza;
	this.fecha=fecha;
        this.monto=monto;
    }
    /* Begin of getters */
	
    public Date getFecha(){
        return this.fecha;	
    }
    
    public Cliente getAlquila(){
        return this.alquila;
    }
    
    public Inmueble getAlquilado(){
        return this.alquilado;
    }
    
    public Administrador getAdministra(){
        return this.administra;
    }
    
    public Garante getGarantiza(){
        return this.garantiza;
    }
    public long getMonto(){
        return this.monto;
    }
    
    public Long getId(){
        return this.id;
    }

    /* End of getters */

    /* Beging of setters */
    public void setAlquila(Cliente alquila){
        this.alquila=alquila;
    }
    
    public void setFecha(Date fecha){
        this.fecha=fecha;
    }
	
    public void setAlquilado(Inmueble alquilado){
        this.alquilado=alquilado;
    }
     
    public void setAdministra(Administrador administra){
        this.administra=administra;
    }
    
    public void setGarantiza(Garante garantiza){
        this.garantiza=garantiza;
    }
    
    public void setId(Long id){
        this.id=id;
    }
    public void setMonto(long monto){
        this.monto=monto;
    }
    /* End of setters */
}
