package Entidad;
//Entidad inmueble
public class Inmueble {
    protected Propietario posee;//relacion:owner(posee) 1-n inmueble
    protected Barrio tiene;//relacion:Barrio(tiene)1- * inmueble
    protected long id=1;
    protected String operacion;
    protected String tipo;
    protected int precio;
    protected String descr;
    protected String direccion;
    protected String disponibilidad;
    public Inmueble(){
       
    }
    
    public Inmueble(String operacion,Propietario posee,String tipo,int precio,String descr,Barrio tiene,String dire,String disponibilidad){
        this.disponibilidad=disponibilidad;
	this.operacion=operacion;
        this.posee=posee;
        this.tipo=tipo;
        this.descr=descr;
        this.precio=precio;
        this.tiene=tiene;
        this.direccion=dire;
    }
    /* Begin of getters */
    public String getDisp(){
	return this.disponibilidad;
    }
    
    public Barrio getBarrio(){
        return this.tiene;
    }
    public Long getId(){
        return this.id;
    }
    public String getOperacion(){
        return this.operacion;
    }
    public int getPrecio(){
        return this.precio;
    }
    public String getDireccion(){
        return this.direccion;
    }
    
    public Propietario getOwner(){
        return this.posee;
    }

    public String getTipo(){
        return this.tipo;
    }
 
    public double getValor(){
        return this.precio;
    }
    public String getDescripcion(){
        return this.descr;
    }
    /* End of getters */

    /* Beging of setters */
    
    public void setBarrio(Barrio tieneBarrio){
        this.tiene=tieneBarrio;
    }

	
     public void setDisp(String disponibilidad){
        this.disponibilidad=disponibilidad;
    }
     
    public void setOperacion(String operacion){
        this.operacion=operacion;
    }
    
    public void setPropietario(Propietario posee){
        this.posee=posee;
    }
   
    public void setTitulo(String titulo){
        this.tipo=titulo;
    }
    public void setTipo(String tipo){
        this.tipo=tipo;
    }
    public void setDireccion(String dire){
        this.direccion=dire;
    }
    public void setValor(int precio){
        this.precio=precio;
    }
    public void setDescripcion(String descr){
        this.descr=descr;
    }
    public void setId(Long id){
        this.id=id;
    }
    /* End of setters */
}
