package Vista;
import Entidad.Administrador;
import Persistencia.AccesoBD;
import java.util.LinkedList;
import javax.servlet.http.HttpServletRequest;
//Vista de la secci&oacute;n administrador
public class GenerarHTMLAdmin extends GenerarHTMLGeneral{
    GestionarListasInmueble tla=new GestionarListasInmueble();
    private LinkedList<Administrador> lisAdm;
    private String valorSelect="";
    String flagg;
    String hidden="hidden";
    String primeraVez = "true";
    
    public GenerarHTMLAdmin(String flagg){
        this.flagg=flagg;
            if(flagg==null){
            hidden="";
        }
    }
 
    public String GenerarMainConten(HttpServletRequest request,AccesoBD abd, String username){ 
        valorSelect="";
        String html="";    
        String hidden="hidden";        
        int a=tla.getNumberSolicitud(abd);
        html+="<div id=\"main_content\">\n";
        html+=  "<div id=\"admin_header\">\n";
        valorSelect=(String)request.getParameter("listarPor");
        if(valorSelect==null){
            valorSelect = "Propiedades disponibles";
        }
        html+=      "<div class=\"admin_index_title\">"+valorSelect+"</div>\n";
        html+=        "<div class=\"right_button\" style=\"margin-left: 600px;position:absolute;botton 0;\"\"text-align: left\"><a href=\"#\" onclick=\"solicitudess();\">Solicitudes ("+a+") &nbsp;&nbsp;&nbsp;</a></div>\n";
        html+=          "<form name=\"formListar\" id=\"solicitudes\" method=\"post\" action=\"Admin.jsp\" >\n";
        html+=              "<input type=\"hidden\" id=\"flag\" name=\"flagSolicitud\" value=\"\" >\n";
        html+=          "</form>\n";
        html+=      "<div class=\"right_buttons\">\n";
        html+=              "<form name=\"formGestionar\" method=\"post\" action=\"Gestiones.jsp\" >\n";
        html+=                  "<label class=\"search\" style=\"padding-top:2px;\">Gestionar:  </label>\n";
        if (username.equals("superusuario")){
        html+=                  "<select name=\"gestionar\" class=\"form_select\" style=\"width:150px\">\n";
        html+=                      "<option  select>-----------------------------------</option>\n";
        html+=                      "<option value=\"Cliente\">Cliente</option>\n";
        html+=                      "<option value=\"Garante\">Garante</option>\n";
        html+=                      "<option value=\"Propietario\">Propietario</option>\n";
        html+=                      "<option value=\"Alquilar\">Alquiler</option>\n";
        html+=                      "<option value=\"Comprar\">Venta</option>\n";
        html+=                      "<option value=\"Administrador\">Administrador</option>\n";
        }else{
        html+=                  "<select name=\"gestionar\" class=\"form_select\" style=\"width:150px\">\n";
        html+=                      "<option  select>-----------------------------------</option>\n";
        html+=                      "<option value=\"Cliente\">Cliente</option>\n";
        html+=                      "<option value=\"Garante\">Garante</option>\n";
        html+=                      "<option value=\"Propietario\">Propietario</option>\n";
        html+=                      "<option value=\"Alquilar\">Alquiler</option>\n";
        html+=                      "<option value=\"Comprar\">Venta</option>\n";
        html+=                      "<option "+hidden+" value=\"Administrador\">Administrador</option>\n";
        html+=                  "</select>\n";
        }
        html+=                  "<input type=image value = sumit alt = sumit Button  src=\"images/adminicons/search.png\"onMouseOver=this.src=\"images/adminicons/search.png\" style=\"width:20px;\">"; 
        html+=              "</form>\n";
        html+=      "</div>\n";
        html+=  "</div>\n";//endOfAdmin_header
        return html;
     }
    
    public String GenerarAdminHeaderBorder(HttpServletRequest request,AccesoBD abd,String user){
        String valorForm =(String)request.getParameter("formListar");
        String html="";
        html+="<div id=\"admin_header_border\"></div>\n";
        html+="<div>&nbsp</div>\n";
        html+= "<div class=\"right_button\" style=\"margin-left: 550px\";\"text-align: left;\"><a href=\"GestionarAltaInmueble.jsp\">Nuevo inmueble&nbsp;&nbsp;&nbsp; </a></div>\n";
        html+=  "<div id=\"admin_search_tab\">\n";
        html+=      "<label class=\"search\" style=\"padding-top:2px;\">Listar por:  </label>\n";
        html+=      "<form name=\"formListar\" method=\"post\" action=\"Admin.jsp\" >\n";
        html+=      "<input type=\"hidden\" name=\"bandera\" value="+flagg+">";
        html+=          "<select id=\"listar\" name=\"listarPor\" class=\"form_select\"  style=\"width:195px\">\n";
        html+=              "<optgroup label=\" Inmuebles:\">\n";
        html+=                  "<option select value=\"Todos\">------------------------------------------</option>\n";
        html+=                  "<option  value=\"Propiedades disponibles\">&nbsp;&nbsp;&nbsp;- Disponibles</option>\n";
        html+=                  "<option value=\"Ordenacion por ubicacion\">&nbsp;&nbsp;&nbsp;- Ubicaci&oacuten</option>\n";
        html+=                  "<option value=\"Ordenacion por precio\">&nbsp;&nbsp;&nbsp;- Precio</option>\n";
        html+=                  "<option value=\"Inmuebles alquilados\">&nbsp;&nbsp;&nbsp;- Alquilados</option>\n";
        html+=                  "<option value=\"Inmuebles vendidos\">&nbsp;&nbsp;&nbsp;- Vendidos</option> action=\"Admin.jsp\"\n";
        html+=                  "<option value=\"Inmuebles para alquilar\">&nbsp;&nbsp;&nbsp;- Para alquilar</option>\n";
        html+=                  "<option value=\"Inmuebles para vender\">&nbsp;&nbsp;&nbsp;- Para vender</option>\n";
        html+=                  "<option value=\"Todos\">&nbsp;&nbsp;&nbsp;- Todos</option>\n";
        html+=              "</optgroup>";
        html+=              "<optgroup label=\" Operaciones:\">\n";
        html+=                  "<option value=\"Venta de administradores\">&nbsp;&nbsp;&nbsp;- Venta de administrador</option>\n";
        html+=                  "<option value=\"Alquiler de administradores\">&nbsp;&nbsp;&nbsp;- Alquiler de administrador</option>\n";
        html+=              "</optgroup>";
        html+=          "</select>\n";
        html+=          "<input type=image value = sumit alt = sumit Button name=\"formListar\" src=\"images/adminicons/search.png\"onMouseOver=this.src=\"images/adminicons/search.png\" style=\"width:20px;\">";         
        html+=      "</form>\n";
        html+="</div>\n";//endAdmin_Search_tab
        String condicion1= "usuario=='"+user+"'";
        lisAdm=abd.listar(new Administrador(),condicion1);
 
            html+="<form  name=\"FormularioEditarAdministrador\" id=\"FormAdminEdit\" method=\"post\" action=\"ModificarAdministrador.jsp\">\n";
            html+=  "<input type=\"hidden\" id=\"editAdmin\" name=\"editarAdministrador\" value=\"\">\n";                           //Input para el Editar
            html+="</form>\n";
        html+= "<b>Administrador conectado (<font color=\"red\">"+user+"</font>)</b> <input title=\"Editar\" type=image value = sumit alt = sumit Button src=\"images/adminicons/edit.png\" onMouseOver=this.src=\"images/adminicons/edit.png\" onclick=\"editAdministrador("+lisAdm.getFirst().getId()+");\" width=\"15\" height=\"15\" border=\"0\">\n"; 
        html+=tla.tablasListarAdmin(abd, valorSelect,valorForm,request);
        return html;
    }  
    
        public String generarHTMLFooter(){ 
        String html="";  
        html+="</body>\n"; 
        html+=  "<div "+hidden+" id=\"footer\">\n";
        html+=      "<div "+hidden+" style= \"width:970px;\" \"height:41px;\" \"clear:both;\" \"font-size:11px;\" \"background-color:#f2efef;\" \"border-top:1px #eeabbd dashed;\" \"left: 21px;\" \"top: 1049px;\" \"margin-left:185px;\"";
        html+=         "<link rel=\"stylesheet\" type=\"text/css\" href=\"style.css\" />\n";
        html+=          "<div "+hidden+" id=\"copyright\">\n";
        html+=          "<div style=\"float:left; padding:3px;\"><a href=\"#\"><img src=\"images/logo.gif\" width=\"42\" height=\"35\" alt=\"\" title=\"\" border=\"0\" /></a></div>\n";
        html+=          "<div style=\"float:left; padding:14px 10px 10px 10px;\"> Martinez Latorrez &#38; Asoc. &copy; All Rights Reserved 2008 </div>\n";
        html+=          "<div style=\"float:right; padding:9px;\"><b> Contador de visitas:<align=\"right\"><a  target=\"_blank\"><img src=\"http://contadores.gratisparaweb.com/imagen.php?contador=15&id2=152645\" alt=\"Contadores\" width=\"35\" border=\"0\"></a><br><br><map name=\"Map\"><area shape=\"rect\" coords=\"48,1,90,22\" target=\"_blank\" alt=\"Cursos\"><area shape=\"rect\" coords=\"0,0,47,15\" href=\"http://contadores.gratisparaweb.com\" target=\"_blank\" ></map></a></div></b> </div>\n";
        html+=      "</div>\n";
        html+=  "</div>\n";
        html+="</html>\n";
        return html;        
    }
}
