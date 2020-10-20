package Entidad;
//Entidad venta

import java.util.Date;

public class Venta {
    protected Cliente vende;//relacion:Cliente(alquila) 1-n Alquileres
    protected Inmueble vendido;//relacion:Inmueble(alquilado) 1-n Alquileres
    protected Administrador administra;//relacion:Administrador(administra) 1-n Alquileres
    protected Date fecha;
    protected long id=1;
    protected long monto;
    

    
    public Venta(){
    }
    
    public Venta(Date fecha,Cliente vende,Inmueble vendido,Administrador administra, long monto){       
        this.fecha=fecha;
	this.vende=vende;
        this.vendido=vendido;
        this.administra=administra;
        this.monto=monto;
      
    }
    
    /* Begin of getters */
    public Cliente getVende(){
        return this.vende;
    }
   
    public Date getFecha(){
        return this.fecha;
    }
    public Inmueble getVendido(){
        return this.vendido;
    }
    public Administrador getAdministra(){
        return this.administra;
    }
    public long getId(){
        return this.id;
    }
    public long getMonto(){
        return this.monto;
    }
    /* End of getters */

    /* Beging of setters */
    public void setVende(Cliente vende){
        this.vende=vende;
    }
    
    public void setFecha(Date fecha){
        this.fecha=fecha;
    }
     public void setVendido(Inmueble Vendido){
        this.vendido=Vendido;
    }
     
    public void setAdministra(Administrador administra){
        this.administra=administra;
    }
    public void setMonto(long monto){
        this.monto=monto;
    }
    /* End of setters */
}
