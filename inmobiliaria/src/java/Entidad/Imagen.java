package Entidad;
//Entidad imagen
public class Imagen {
    protected long id=1;
    protected Inmueble inm=null;//relacion:inmueble(tiene) 1-n imagenes
    protected String tipo=""; 
    protected String path="";
   
   
    
    public Imagen(){
       
    }
    public Imagen(String path,Inmueble inm,String tipo){
        this.inm=inm;
        this.path=path;
        this.tipo=tipo;
    }
    /*Begin of setters*/
    public void setInmueble(Inmueble inm){
        this.inm=inm;
    }
    public void setTipo(String tipo){
        this.tipo=tipo;
    }
    public void setPath(String path){
        this.path=path;
    }
    /*End of setters*/
    
    /*Begind of getters*/
    public String getPath(){
        return this.path;
    }
    public String getTipo(){
        return this.tipo;
    }
    public long getId() {
        return this.id;
    }
    public Inmueble getInmueble(){
        return this.inm;
    }
    /*End of getters*/
}
