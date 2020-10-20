package Entidad;
//Entidad barrio
public class Barrio {
    protected long id=1;
    protected String nombre="";
    protected String ubicacion="";
   
    
    public Barrio(){}
    
    public Barrio(String nombre,String ubicacion){
        this.nombre=nombre;
        this.ubicacion=ubicacion;
    }
    
    /*Begin of setters*/
    public void setNombre(String nombre){
        this.nombre=nombre;
    } 
    
    public void setUbicacion(String ubicacion){
        this.ubicacion=ubicacion;
    }
    /*end of setters*/
    
    /*Begin of getters*/
    public String getNombre(){
        return nombre;
    }
    
    public String getUbicacion(){
        return ubicacion;
    }
    public long getId(){
        return id;
    }
    /*end of getters*/
}
