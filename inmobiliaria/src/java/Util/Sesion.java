package Util;

import javax.servlet.http.HttpSession;

//Propiedades de sesiones
public class Sesion {
    
    public Sesion(){}
    
    
   public String getNombreUsuario(HttpSession session){
        String username;
        session.setAttribute("div", null);
        if(session.getAttribute("username")==null){
            username="Usuario";
    }else{
        username= (String)session.getAttribute("username");
         }
    return username;
    }
   
    public String getIdProp(HttpSession session){
        String idProp;
        if(session.getAttribute("idPropp")==null){
            idProp= null;
    }else{
        idProp= (String)session.getAttribute("idPropp");
         }
    return idProp;
    }
   
       
    
    public String chequeoSesion (HttpSession session){
        String username;
        String subMenu;
        if(session.getAttribute("username")==null){
           username="Usuario";
           subMenu="Login.jsp";
        }else{
            username= (String)session.getAttribute("username");
            subMenu="salir.jsp";
        }
        return username;
    }
    
    public String visCartel (HttpSession session){
         String visibility=(String)session.getAttribute("div");
        if(session.getAttribute("div")== null){
            visibility="hidden";
        }
        return visibility;
}
        
}
