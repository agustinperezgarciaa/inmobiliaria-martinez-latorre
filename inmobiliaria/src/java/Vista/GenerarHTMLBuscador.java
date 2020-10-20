package Vista;
import Entidad.Barrio;
import Entidad.Inmueble; 
import Entidad.Imagen;
import java.util.LinkedList;
import javax.servlet.http.HttpServletRequest;
import Persistencia.AccesoBD;

//Vista de la secci&oacute;n buscador 
public class GenerarHTMLBuscador extends GenerarHTMLGeneral {
    private LinkedList<Inmueble> lisInm;
    String   nombre,tipo,oper;
    String flag="FALSE";
    public GenerarHTMLBuscador(){}
    
    public String generarHTLMColumnOne(HttpServletRequest request, AccesoBD abd){
        LinkedList<Barrio> lisBarrio;
        String html=""; 
        if(request.getParameter("buscProp")== null){
            String condicionn ="disponibilidad=='Disponible'" ;
            lisInm=abd.listar(new Inmueble(),condicionn);
            flag="TRUE";
        }
         if(request.getParameter("buscProp")!= null){
            try {
                nombre=(String)request.getParameter("nombre");
                tipo=(String)request.getParameter("inmueble");
                oper=(String)request.getParameter("operacion");
                //Barrios que cumplen la condicion
                String condicion1= "nombre=='"+nombre+"'";
                lisBarrio=abd.listar(new Barrio(),condicion1);
                String condicion ="tiene.id=="+lisBarrio.getFirst().getId()+" && tipo=='"+tipo+"' && operacion=='"+oper+"' && disponibilidad=='Disponible'" ;
                //Inmuebles que cumplen la condicion
                lisInm=abd.listar(new Inmueble(),condicion);
            }catch (Exception e){
                e.printStackTrace();
            }
        }
        html+="<dic class=\"main_content\">\n";
        html+=  "<div class=\"column1\">\n";       
        html+=      "<div class=\"left_box\">\n";
        html+=          "<p>\n";
        html+=          "<p>\n";
        html+=          "<p>\n";
        html+=          "<p>\n";
        html+=          "<div class=\"top_left_box\"></div>\n";   
        html+=          "<div class=\"center_left_box\">\n";
        html+=              "<div class=\"box_title\"><span>Buscador</span> de propiedades :</div>\n";  
        html+=              "<div class=\"form\">\n";
        html+=                  "<p>&nbsp;</p>\n";
        /*Formulario Buscador De Propiedades*/
        html+="                 <form name=\"buscador\" method=\"post\" action= \"Buscador.jsp\">\n";                 
        html+=                      "<div class=\"form_row_contact\">\n";
        html+=                          "<label class=\"adminleft\">Barrio<span>(*) </span>: </label>\n";
        html+=                          "<p>\n";
        html+=                              "<select name=\"nombre\" class=\"form_select\" style=\"width:160px\">\n";
        html+=                                  "<option value=\"Macro-centro\">-----------------------------------</option>\n";//Valor por defecto(Macrocentro)
        html+=                                  "<option value=\"Alberdi\">Alberdi</option>\n";
        html+=                                  "<option value=\"BandaNorte\">Banda Norte</option>\n";
        html+=                                  "<option value=\"Fenix\">Fenix</option>\n";
        html+=                                  "<option value=\"Golf\">Golf</option>\n";
        html+=                                  "<option value=\"Bimaco\">Bimaco</option>\n";
        html+=                                  "<option value=\"Macro-centro\">Macro-Centro</option>\n";
        html+=                                  "<option value=\"Micro-centro\">Micro-Centro</option>\n";
        html+=                              "</select>\n";
        html+=                          "</p>\n";
        html+=                          "<p>&nbsp;</p>\n";
        html+=                      "</div>\n";//div-47
        html+=                      "<div class=\"form_row_contact\">\n";
        html+=                          "<p>&nbsp;</p>\n";
        html+=                          "<label class=\"adminleft\">Inmueble<span>(*) </span>: </label>\n";
        html+=                          "<select name=\"inmueble\" class=\"form_select\"style=\"width:160px\">\n";
        html+=                              "<option value=\"Departamento\">-----------------------------------</option>\n";//Valor por defecto(depto)
        html+=                              "<option value=\"Departamento\">Departamento</option>\n";
        html+=                              "<option value=\"Casa\">Casa</option>\n";
        html+=                              "<option value=\"Oficina\">Oficina</option>\n";
        html+=                              "<option value=\"Local\">Local</option>\n";
        html+=                              "<option value=\"Salon\">Sal&oacute;n</option>\n";
        html+=                          "</select>\n";
        html+=                      "</div>\n";//div-62
        html+=                      "<div class=\"form_row_contact\">\n";
        html+=                          "<p>&nbsp;</p>\n";
        html+=                          "<label class=\"adminleft\">Operaci&oacute;n<span>(*) </span>: </label>\n";
        html+=                          "<select name=\"operacion\" class=\"form_select\"style=\"width:160px\">\n";
        html+=                              "<option value=\"Alquilar\">-----------------------------------</option>\n";//Valor por defecto(alquiler)
        html+=                              "<option value=\"Alquilar\">Alquilar</option>\n";
        html+=                              "<option value=\"Comprar\">Comprar</option>\n";
        html+=                          "</select>\n";
        html+=                      "</div>\n";//div-74
        html+=                      "<div style=\"float:right; padding:10px 25px 0 0;\">\n";
        html+=                      "<input type=image value = sumit alt = sumit Button name=\"buscProp\"   src=\"images/Buscar.png\"onMouseOver=this.src=\"images/Buscar.png\">\n";
        html+=                      "</div>\n";
        html+=                      "<p>&nbsp;</p>\n";        
        html+=                  "</form>\n";
        html+=              "</div>\n";//div-43
        html+=          "</div>\n";//div-41
        html+=          "<div class=\"bottom_left_box\"></div>\n";
        html+=      "</div>\n";//div-35
        html+=      "<div class=\"left_box\">\n";
        html+=          "<div class=\"admin_footer_help\" style= \"width: 200px;\" >\n";
        html+=              "<span>(*)</span> Campos requeridos para buscar</p>\n";
        html+=              "<p>una propiedad</p>\n";
        html+=          "</div>\n";
        html+=      "</div> \n";
        html+=      "<p>&nbsp;</p>\n";
        html+=      "<div class=\"left_box\">\n";
        html+=          "<div class=\"top_left_box\"></div>\n"; 
        html+=          "<div class=\"center_left_box\">\n";
        html+=              "<div class=\"box_title\"><span>Informaci&oacute;n</span> de contacto :</div>\n";
        html+=              "<div class=\"form\">\n";
        html+=                  "<div class=\"form_row\">\n";
        html+=                      "<img src=\"images/contact_envelope.gif\" width=\"50\" height=\"47\" border=\"0\" class=\"img_right\" alt=\"\" title=\"\" />\n";
        html+=                      "<div class=\"contact_information\">\n";
        html+=                          "<p><strong>Email:<a href=\"mailto:sistemawebinmobiliario@gmail.com\">martninezlatorre@gmail.com</a> </strong> <br />\n";
        html+=                          "<p><strong>Tel&eacute;fono:</strong> 0358 462-2447 <p />\n";
        html+=                          "<strong>   Direcci&oacute;n:</strong> Mitre 1013 - Dpto A </p>\n";
        html+=                          "<p><strong>Fax:</strong> -- -- <p/>\n";
        html+=                              "<span>www.inmobiliaramartinezlatorre.com.ar</span>\n";
        html+=                          "</p>\n";
        html+=                          "</p>\n";
        html+=                      "</div>\n"    ;
        html+=                  "</div>\n";                    
        html+=              "</div>\n";
        html+=          "</div>\n";
        html+=          "<div class=\"bottom_left_box\"></div>\n";
        html+=      "</div>\n";         
        html+=  "</div>\n";//endOfColumnOne
        return html;
    }
    
    public String generarHTMLColumnFour(AccesoBD abd){
        LinkedList<Imagen> picc;
        String html="";
        html+=  "<div class=\"column4\">\n";
        html+=      "<div class=\"title\" style=\"float:left;\">\n";
        //Busca con los 3 filtros y encuentra mas de un inmueble
        if((lisInm==null) || (lisInm.size()==0)){
                    html+="<div style=\"float:left; height: 40px;\"><strong><br/>No hemos encotrados resultado para tu b&uacute;squeda, int&eacute;ntalo nuevamente.</strong></div>\n";
                    html+=      "</div> \n"; 
                    html+="<img src=\"images/oops.jpg\" width=\"200\" height=\"180\" style=\"padding: 100px 100px 200px 230px;\">";
                            html+=      "</div> \n"; 

        }
        else{
            if((lisInm.size()>1)&&(flag.compareTo("FALSE")==0)){
                html+="<div style=\"float:left;\">Inmuebles filtrado por: -Barrio: " +nombre+" - Operaci&oacute;n : " +oper+" - Tipo : " +tipo+".</div>\n";
            }else
                //Busca con los 3 filtros y encuentra un inmueble
                if(lisInm.size()==1){
                    html+="<div style=\"float:left;\">Inmueble filtrado por: -Barrio : " +nombre+" - Operaci&oacute;n : " +oper+" - Tipo : " +tipo+".</div>\n";
                }
                else 
                    //Busca los inmuebles disponibles
                    if(flag.compareTo("TRUE")==0){
                        html+=         "<div style=\"float:left;\">Inmuebles disponibles</div>\n";
                    }
                    html+=      "</div> \n"; 
                    html+="<form name=\"formNameInmueble\" id=\"formIdInmueble\" action=\"DetallesProp.jsp\" method=\"post\">\n";
                    html+=  "<input type=\"hidden\" id=\"idInmueble\" name=\"idInm\">\n";
                    html+="</form>\n";
                    for (int i=0;i<=lisInm.size()-1;i++){
                        String condicionn="inm.id=="+lisInm.get(i).getId()+" && tipo=='portada'";
                        //inmuebles tipo portada
                        picc=abd.listar(new Imagen(),condicionn);
                        html+=      "<div class=\"offer_box_wide_style1\">\n";
                        html+=          "<img src="+picc.getFirst().getPath()+" width=\"163\" height=\"138\" class=\"img_left\" alt=\"\" title=\"\" border=\"0\"/></a>\n";
                        html+=          "<div class=\"offer_info\">\n";
                        html+=          "<h3><span><strong>Caracter&iacute;sticas:</strong></span></h3>\n";
                        html+=              "<strong>Precio :</strong> $"+lisInm.get(i).getPrecio()+".\n</br>";
                        html+=              "<strong>Descripci&oacute;n:</strong> "+lisInm.get(i).getDescripcion()+".\n</br>";  
                        html+=              "<strong>Operaci&oacute;n:</strong> "+lisInm.get(i).getOperacion()+".\n</br>";
                        html+=              "<strong>Tipo de inmueble :</strong> "+lisInm.get(i).getTipo()+".\n</br>";
                        html+=              "<strong>Barrio:</strong> "+lisInm.get(i).getBarrio().getNombre()+".\n</br>";
                        html+=          "</div>\n";
                        html+=          "<div class=\"more\">\n";
                        html+=              "<p><input type=image value = sumit alt = sumit Button src=\"images/masDetalles.jpg\" onMouseOver=this.src=\"images/masDetalles.jpg\" style=\"width:80px;\" onclick=\"getIdInm("+lisInm.get(i).getId()+")\"></p>\n";
                        html+=          "</div>\n";
                        html+=      "</div>\n";
                    }
                    html+=  "</div>\n";//endOfColumnFour;	
                    html+="</div>\n";//endOfMainContent
            }
                return html;
        
        }
}
