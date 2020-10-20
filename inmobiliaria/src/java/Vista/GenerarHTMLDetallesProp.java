package Vista;
//Vista de la secci&oacute;n de detalles de una propiedad
import Entidad.Imagen;
import Entidad.Inmueble;
import java.util.LinkedList;
import Persistencia.AccesoBD;

public class GenerarHTMLDetallesProp extends GenerarHTMLGeneral {
   private Long idInm;
   
   public GenerarHTMLDetallesProp(){}
   
   public String generarHTLMColumnaUno(){
       String html=""; 
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
       html+="                 <form name=\"buscador\" action= \"Buscador.jsp\">\n";                 
       html+=                  "<div class=\"form_row_contact\">\n";
       html+=                      "<label class=\"adminleft\">Ubicaci&oacute;n<span>(*) </span>: </label>\n";
       html+=                      "<p>\n";
       html+=                          "<select name=\"ubicacion\" class=\"form_select\" style=\"width:160px\">\n";
       html+=                              "<option value=\"Macro-centro\">-----------------------------------</option>\n";//Valor por defecto(Macrocentro)
       html+=                              "<option value=\"Alberdi\">Alberdi</option>\n";
       html+=                              "<option value=\"BandaNorte\">Banda Norte</option>\n";
       html+=                              "<option value=\"Fenix\">Fenix</option>\n";
       html+=                              "<option value=\"Pizarro\">Pizarro</option>\n";
       html+=                              "<option value=\"Macro-centro\">Macro-Centro</option>\n";
       html+=                              "<option value=\"Micro-centro\">Micro-Centro</option>\n";
       html+=                          "</select>\n";
       html+=                      "</p>\n";
       html+=                      "<p>&nbsp;</p>\n";
       html+=                  "</div>\n";//div-47
       html+=                  "<div class=\"form_row_contact\">\n";
       html+=                      "<p>&nbsp;</p>\n";
       html+=                      "<label class=\"adminleft\">Inmueble<span>(*) </span>: </label>\n";
       html+=                      "<select name=\"inmueble\" class=\"form_select\"style=\"width:160px\">\n";
       html+=                          "<option value=\"Departamento\">-----------------------------------</option>\n";//Valor por defecto(casa)
       html+=                          "<option value=\"Departamento\">Departamento</option>\n";
       html+=                          "<option value=\"Casa\">Casa</option>\n";
       html+=                          "<option value=\"Oficina\">Oficina</option>\n";
       html+=                          "<option value=\"Local\">Local</option>\n";
       html+=                          "<option value=\"Salon\">Sal&oacute;n</option>\n";
       html+=                      "</select>\n";
       html+=                  "</div>\n";//div-62
       html+=                  "<div class=\"form_row_contact\">\n";
       html+=                      "<p>&nbsp;</p>\n";
       html+=                      "<label class=\"adminleft\">Operaci&oacute;n<span>(*) </span>: </label>\n";
       html+=                      "<select name=\"operacion\" class=\"form_select\"style=\"width:160px\">\n";
       html+=                          "<option value=\"\">-----------------------------------</option>\n";//Valor por defecto(alquiler)
       html+=                          "<option value=\"Alquiler\">Alquiler</option>\n";
       html+=                          "<option value=\"Venta\">Venta</option>\n";
       html+=                      "</select>\n";
       html+=                  "</div>\n";//div-74
       html+=                  "<div style=\"float:right; padding:10px 25px 0 0;\">\n";
       html+=                  "<input type=image value = sumit alt = sumit Button name=\"buscProp\"   src=\"images/find.gif\"onMouseOver=this.src=\"images/find.gif\">\n";
       html+=                  "</div>\n";
       html+=                  "<p>&nbsp;</p>\n";        
       html+=              "</div>\n";//div-43
       html+=          "</div>\n";//div-41
       html+=          "<div class=\"bottom_left_box\"></div>\n";
       html+=      "</div>\n";//div-35
       html+=      "<div class=\"left_box\">\n";
       html+=          "<div class=\"admin_footer_help\"; style=\"width: 200px\">\n";
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
       html+=                          "<p><strong>Email:</strong> martnieslatorre@gmail.com<br />\n";
       html+=                          "<p><strong>Tel&eacute;fono:</strong> 0358 462-2447 <p />\n";
       html+=                          "<strong>   Direcci&oacute;n:</strong> Mitre 1013 - Dpto A </p>\n";
       html+=                          "<p><strong>Fax:</strong> -- -- <p/>\n";
       html+=                          "<span>www.inmobiliaramartinezlatorre.com..ar</span>\n";
       html+=                          "</p>\n";
       html+=                          "</p>\n";
       html+=                        "</form>\n";
       html+=                      "</div>\n"    ;
       html+=                  "</div>\n";                    
       html+=              "</div>\n";
       html+=          "</div>\n";
       html+=          "<div class=\"bottom_left_box\"></div>\n";
       html+=      "</div>\n";         
       html+=           "<p>&nbsp;</p>\n";
       html+=           "<p>&nbsp;</p>\n";
       html+=           "<p>&nbsp;</p>\n";
       html+=           "<p>&nbsp;</p>\n";
       html+="</div>\n";//finColumnaUno
       return html;
  }  
  public String generarHTMLColumnaCuatro(Long idInmueble){
      idInm=idInmueble;
      String html ="";
      html+=    "<div class=\"column4\">\n";
      html+=        "<div class=\"title\">Caracter&iacute;sticas del Inmueble numero: "+idInm+" </div>\n";
      html+=    "</div>\n";//finColumnaCuatro       
      return html;
  }
  
  public String generarHTMLColumnaDos(Long idInmueble, AccesoBD abd){
      String html="";
      LinkedList<Imagen> picc;
      String cDetGrande="inm.id=="+idInmueble+" && tipo=='imgDetalleGrande'";
      picc=abd.listar(new Imagen(),cDetGrande);
      html+=    "<div class=\"column2\" style=\"background-color:#f3f5f6; margin-left:5px;\">\n";
      html+=        "<div class=\"big_pic\"><img src="+picc.getFirst().getPath()+" width=\"282\" height=\"212\" class=\"img_big_pic\" /></div>\n";
      html+=        "<div class=\"pictures_thumbs\">\n";
      html+=            "<h3>Imagenes disponibles :</h3>\n";
      String cDet1="inm.id=="+idInmueble+" && tipo=='imgDetalle1'";
      picc=abd.listar(new Imagen(),cDet1);
      html+=            "<a> <img src="+picc.getFirst().getPath()+" width=\"104\" height=\"78\" border=\"0\"class=\"img_thumb\" /></a>\n";
      String cDet2="inm.id=="+idInmueble+" && tipo=='imgDetalle2'";
      picc=abd.listar(new Imagen(),cDet2);      
      html+=            "<a> <img src="+picc.getFirst().getPath()+" width=\"104\" height=\"78\" border=\"0\"class=\"img_thumb\" /></a>\n";
      String cDet3="inm.id=="+idInmueble+" && tipo=='imgDetalle3'";
      picc=abd.listar(new Imagen(),cDet3);
      html+=            "<a><img src="+picc.getFirst().getPath()+" width=\"104\" height=\"78\" border=\"0\"class=\"img_thumb\" /></a>\n";
      String cDet4="inm.id=="+idInmueble+" && tipo=='imgDetalle4'";
      picc=abd.listar(new Imagen(),cDet4);
      html+=            "<a><img src="+picc.getFirst().getPath()+" width=\"104\" height=\"78\" border=\"0\"class=\"img_thumb\" /></a>\n";
      html+=        "</div>\n";
      html+=    "</div>\n";//finColumnaDos
      return html;
  }
  
  public String generarHTMLColumnaTres(Long idInmueble, AccesoBD abd){
      String html="";
      Inmueble inm;
      LinkedList<Imagen> picc;
      String cDetGrande="inm.id=="+idInmueble+" && tipo=='imgDetalleGrande'";
      picc=abd.listar(new Imagen(),cDetGrande);
      inm = picc.getFirst().getInmueble();
      html+="   <div class=\"column3\">\n";
      html+="       <div class=\"main_text_box\">\n";
      html+="           <form name=\"formNameClientePosible\" id=\"formIDClientePosible\" action=\"ClientesPosibles.jsp\" method=\"post\">\n";         
      html+="              <input type=\"hidden\" id=\"idInmueble\" name=\"idInm\" value=\""+idInm+"\">\n";
      html+="           </form>\n";
      html+="           <h1><span>Descripci&oacute;n</span></h1>\n";
      html+="           <p>\n";
      html+="           "+inm.getDescripcion()+"\n";   
      html+="           <br /><br />\n";
      html+="           </p>  \n";      
      html+="       </div>\n";
      html+="       <div class=\"title2\">Detalles:</div> \n";
      html+="       <div class=\"details_list\">\n";
      html+="           <ul>\n";
      html+="               <li><span>Precio :</span>  "+inm.getPrecio()+"</li>\n";
      html+="               <li><span>Ciudad :</span>  Rio Cuarto  </li>\n";
      html+="               <li><span>Direcci&oacute;n :</span> "+inm.getPrecio()+"  </li>\n";
      html+="               <li><span>Tipo de inmube : </span>"+inm.getTipo()+"  </li>\n";
      html+="               <li><span>Barrio :</span>  "+inm.getBarrio().getNombre()+"</li>\n";
      html+="           </ul>\n";
      html+="       </div>\n";
      html+="       <div style=\"float:left;\">\n";
      html+=      "<p>&nbsp;</p>";
      html+="           <p><input type=image value = sumit alt = sumit Button src=\"images/interesado.jpg\" onMouseOver=this.src=\"images/interesado.jpg\" style=\"width:140px;\" onclick=\"formClientePosible();\"></p>\n";
      html+="       </div>\n";
      html+="   </div>\n";//finColumnaTres
      html+="</div>\n";//finMainContent
      return html;
  }

}     
