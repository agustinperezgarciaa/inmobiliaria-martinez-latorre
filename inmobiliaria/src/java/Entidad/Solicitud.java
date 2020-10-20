package Entidad;
//Entidad solicitud
public class Solicitud {
    
    protected Long id;
    protected Inmueble esSolicitado; //relacion inmueble (esSolicitado)1  n Solicitud
    protected ClientePosible realiza; // relacion ClientePosible (realiza) 1  1..n Solicitud
    protected boolean vista,antigua;

    public Solicitud (){}
    
    public Solicitud(Inmueble esSolicitado, ClientePosible realiza,boolean vista,boolean antigua){
        this.esSolicitado=esSolicitado;
        this.realiza=realiza;
        this.vista=vista;
        this.antigua=antigua;
    }
    
    /*Begin of Setters*/
    public void setEsSolicitado(Inmueble esSolicitado){
        this.esSolicitado=esSolicitado;
    }
    public void setVista(boolean vista){
        this.vista=vista;
    }
    public void setAntigua(boolean antigua){
        this.antigua=antigua;
    }
    public void setRealiza(ClientePosible realiza){
        this.realiza=realiza;
    }
    /*End of Setters*/
    
    /*Begin of Getters*/
    public Long getId(){
        return id;
    }
    
    public boolean getVista(){
        return this.vista;
    }
    public boolean getAntigua(){
        return this.antigua;
    }
    public Inmueble getEsSolicitado(){
        return this.esSolicitado;
    }
    public ClientePosible getRealiza(){
        return this.realiza;
    }
   /*End of Getters*/ 
}