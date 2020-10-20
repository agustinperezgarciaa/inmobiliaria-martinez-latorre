package Persistencia;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;
import java.io.*;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.*;
import javax.jdo.*;
import javax.servlet.http.HttpSession;

public class AccesoBD{
   protected Singleton singleton;
    protected PersistenceManager persistencia;
    protected PersistenceManagerFactory pmf;
    protected Transaction tx;
    
    
    
    /**
     * Constructor de la clase que nos garantiza que sea una unica instancia
     * a traves del singleton.
     */
   
    public  AccesoBD(){
       singleton = Singleton.getInstance();
       pmf = JDOHelper.getPersistenceManagerFactory("jpox.properties");
       
    }
    
    /**
     * Constructor con PersistenceManager ya existente.
     * @param pm 
     */
    public AccesoBD(PersistenceManager pm){
        persistencia = pm;
   }

    /**
     * Actualiza el valor del PersistenceManager.
     * @param pm 
     */
    public void setPersistencia(PersistenceManager pm){
        persistencia = pm;
    }
    
    /**
     * Obtiene el estado actual de la persistencia.
     * @return el valor del PersistenceManager.
     */
    public PersistenceManager getPersistencia(){
       return persistencia;
    }

    /**
     * Metodo que mantiene la persistencia de los objetos.
     * @param obj Objeto el cual se actualiza y se mantiene persistente.
     */
     public void hacerPersistente(Object obj){
         
        persistencia.makePersistent(obj);   
     }
     
     /**
      * Metodo que elimina de la persistencia el objeto pasado por parametro.
      * @param obj Objeto a eliminar.
      */
     public void eliminar(Object obj){
        persistencia.deletePersistent(obj);
     }
     
    /**
      * Abre una transacci&oacute;n.
      */
     public void iniciarTransaccion(){
         try {
             //-----------------------------------------
             persistencia = pmf.getPersistenceManager();
             //-----------------------------------------
             tx = persistencia.currentTransaction();
             tx.begin();
         }
         catch ( Exception E){
             System.out.println("Error al iniciar la transaccion");

         }
     }
     /**
      * Concreta todas las actualizaciones de la transacci&oacute;n en la persistencia.
      */
     public void concretarTransaccion(){
        tx.commit();
        //----------------------------------------------
        if (!persistencia.isClosed())
            persistencia.close();
        //----------------------------------------------
     }
     
     /**
      * Descarta todas las actualizaciones realizadas en la transacci&oacute;n.
      */
    public void rollbackTransaccion(){
         tx.rollback();
        //----------------------------------------------
        if (!persistencia.isClosed())
            persistencia.close();
        //----------------------------------------------
     }


     /**
      * es necesario que se encuentre instalado el motor de base de datos 
      * MySql con usuario "root" y password "".
      * 
      * En caso en que no este creada la base de datos la crea.
      * @throws SQLException
      * @throws InstantiationException
      * @throws IllegalAccessException
      * @throws ClassNotFoundException 
      */
     public void CrearBaseDeDatos() throws SQLException, FileNotFoundException, IOException {
         File dir=new File("webapps/Tesis/WEB-INF/classes/jpox.properties");
          FileReader fr = new FileReader(dir.getAbsolutePath());
          BufferedReader bf = new BufferedReader(fr);
          String cadena = "";
          String user = "";
          String pass = "";
          String puerto = "";
          while ((cadena=bf.readLine())!=null) {
              if (cadena.split("javax.jdo.option.ConnectionUserName=").length>1){
                  user=cadena.split("javax.jdo.option.ConnectionUserName=")[1];
              }
              if (cadena.split("javax.jdo.option.ConnectionPassword=").length>1){
                  pass=cadena.split("javax.jdo.option.ConnectionPassword=")[1];
              }
              if (cadena.split("puertoMySql=").length>1){
                  puerto=cadena.split("puertoMySql=")[1];
              }
          }
          if (!puerto.equals("")){
            //  Connection conexion = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:"+puerto+"/", user, pass);               
             // String query = "create database IF NOT EXISTS inmobiliaria";
            //  Statement st  = (Statement) conexion.createStatement();
             // st.executeUpdate(query);
          }
          
     }
          
     

     /**
      * Busca un objeto por ciertas caracteristicas.
      * @param o 
      * @param condicion
      * @return retorna un LinkedList de tipo Objeto que cumple con las caracteristicas deseadas,en caso contrario retorna null.
      */
    public LinkedList listar (Object o,String condicion){
        try {
            LinkedList lis = new LinkedList();
            Extent e = persistencia.getExtent(o.getClass());
            Query q = persistencia.newQuery(e,condicion);
            Collection c = (Collection)q.execute();
            Iterator iter = c.iterator();
            while(iter.hasNext()){
                lis.add(iter.next());
            }
            return lis;
        }
        catch (Exception e){
        }
        return null;
    }
    
     public LinkedList getObjectsOrdered(Class clase,String filter, String ordering){
        
        try{
            Class clienteClass = clase;
            Extent clnCliente = persistencia.getExtent(clienteClass, false);
            Query query = persistencia.newQuery(clnCliente,filter);
            query.setOrdering(ordering); 
            Collection c=(Collection)query.execute();
            return new LinkedList(c);
        } catch(Exception e) {
            return null;
        }
    }
    
  
    public Object buscarPorId (Object o, Long id){
        Object p = null;
        try {
            Extent e = persistencia.getExtent(o.getClass(),true);
            String condicion = "id == "+id;
            Query q = persistencia.newQuery(e,condicion);
            Collection c = (Collection)q.execute();
            Iterator iter = c.iterator();
            if (iter.hasNext()){
                p = (Object)iter.next();
            }
        }
        catch (Exception e){
            p=null;
        }
        return p;
    }
    public Object buscarPorCond(Object o, String condicion){
        Object p = null;
        try {
            Extent e = persistencia.getExtent(o.getClass(),true);
            //String condicion = "id == "+id;
            Query q = persistencia.newQuery(e,condicion);
            Collection c = (Collection)q.execute();
            Iterator iter = c.iterator();
            if (iter.hasNext()){
                p = (Object)iter.next();
            }
        }
        catch (Exception e){
            p=null;
        }
        return p;
    }
    

    
    public void sesionIniciada(HttpSession session){
        if (session.getAttribute("conex")==null){
            AccesoBD baseDatos =new AccesoBD();
            /*la guarda para obtenerla cuando lo necesita*/
            session.setAttribute("conex", baseDatos);
        }
    }
    
    public String loguinCheck(HttpSession session){
        if (session.getAttribute("conex")==null){
            AccesoBD baseDatos =new AccesoBD();
            /*la guarda para obtenerla cuando lo necesita*/
            session.setAttribute("conex", baseDatos);
        }
        String visibility=(String)session.getAttribute("div");
        if(session.getAttribute("div")== null){
            visibility="hidden";
        }
        String username;
        if(session.getAttribute("username")==null){
           username="Usuario";

        }else{
            username= (String)session.getAttribute("username");
        }
        return username;
    }
}


