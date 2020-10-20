package Vista;

import Entidad.Imagen;
import Entidad.Inmueble;
import java.util.LinkedList;
import Persistencia.AccesoBD;

//Vista de la pantalla principal
public class GenerarHTMLIndex extends GenerarHTMLGeneral {
    private LinkedList<Inmueble> lisInm;
    private LinkedList<Imagen> picc;
    
    public GenerarHTMLIndex(){}
    
    public String generarHTMLColumnOne(){
        String html="";
        //distinciones
        html+="<dic class=\"main_content\">\n";
        html+=  "<div class=\"column1\">\n";       
        html+=      "<div class=\"left_box\">\n";
        html+=          "<p>\n";
        html+=          "<p>\n";
        html+=          "<p>\n";
        html+=          "<p>\n";
        html+=          "<div class=\"top_left_box\"></div>\n";
        html+=          "<div class=\"center_left_box\">\n";
        html+=              "<div class=\"box_title\"><span>Distinciones</span> de la empresa: </div>\n";              
        html+=              "<p>\n";
        html+=              "<p>\n";
        html+=              "<p>\n";
        html+=              "<img src=\"images/premio-excelencia.gif\" style=\"width:255px;\" >";
        html+=              "<p>\n";
        html+=              "<p>\n";
        html+=              "<p>\n";
        html+=              "<img src=\"images/premio-giem.gif\"style=\"width:255px;\">";
        html+=              "<p>\n";
        html+=          "</div>";
        html+=       "</div>";
        html+=       "<p>\n";
        html+=       "<p>\n";
        html+=       "<p>\n";
       //info de contacto
        html+=       "<div class=\"left_box\">\n";
        html+=          "<div class=\"center_left_box\">\n";
        html+=              "<div class=\"top_left_box\"></div>\n";
        html+=              "<div class=\"box_title\"><span>Informaci&oacute;n</span> de contacto:</div>\n";
        html+=                  "<div class=\"form\">\n";
        html+=                      "<div class=\"form_row\">\n";
        html+=                          "<img src=\"images/contact_envelope.gif\" width=\"50\" height=\"47\" border=\"0\" class=\"img_right\" alt=\"\" title=\"\" />\n";
        html+=                          "<div class=\"contact_information\">\n";
        html+=                              "<p><strong>Email:<a href=\"mailto:sistemawebinmobiliario@gmail.com\">martninezlatorre@gmail.com</a> </strong> <br />\n";
        html+=                              "<p><strong>Tel&eacute;fono:</strong> 0358 462-2447 <p />\n";
        html+=                              "<strong>   Direcci&oacute;n:</strong> Mitre 1013 - Dpto A </p>\n";
        html+=                              "<p><strong>Fax:</strong> -- -- <p/>\n";
        html+=                              "<span>www.inmobiliaramartinezlatorre.com..ar</span>\n";
        html+=                              "</p>\n";
        html+=                              "</p>\n";
        html+=                          "</div>\n";
        html+=                      "</div>\n";                    
        html+=              "</div>\n";
        html+=          "</div>\n";
        html+=          "<div class=\"bottom_left_box\"></div>\n";
       // como llegar
        html+=          "<div class=\"left_box\">\n";
        html+=              "<p>\n";
        html+=              "<p>\n";
        html+=              "<p>\n";
        html+=              "<div class=\"center_left_box\">\n";
        html+=                  "<div class=\"top_left_box\"></div>\n";
        html+=                  "<div class=\"box_title\"><span>¿Como llegar?</span> </div>\n";              
        html+=              "</div>\n";
        html+=              "<map> <a href=\"https://maps.google.com.ar/maps?q=mitre+1030&hl=es&ie=UTF8&ll=-33.125916,-64.352911&spn=0.005598,0.010568&sll=-33.126551,-64.341403&sspn=0.089563,0.169086&hnear=Mitre+1030,+R%C3%ADo+Cuarto,+C%C3%B3rdoba&t=m&z=17\"> <img src=\"images/mapa.jpg\" style=\"width:257px;\"></a></map>";
        html+=              "<div class=\"bottom_left_box\"></div>\n";
        html+=          "</div>\n";   
        html+=      "</div>\n";         
        html+=  "</div>\n";//end of column one
     return html;
    }
    
    public String genererHTMLSlider(){
        String html="";
	html+="<p>&nbsp</p>";
        html+=" <div class=\"columnSlide\">\n";
        html+="     <div id=\"slide\">\n";
	html+="         <div id=\"page\">\n";
	html+="             <div id=\"content\">\n";
	html+="                 <div class=\"border_box\">\n";
	html+="                     <div class=\"box_skitter box_skitter_large\">\n";
        html+="                         <ul>\n";
	html+="                             <li><img src=\"SkitterSlideshow/images/casas/1.jpg\" class=\"block\" /></li>\n";
	html+="                             <li><img src=\"SkitterSlideshow/images/casas/2.jpg\" class=\"cubeHide\" /></li>\n";
	html+="                             <li><img src=\"SkitterSlideshow/images/casas/3.jpg\" class=\"cubeRandom\" /></li>\n";
	html+="                             <li><img src=\"SkitterSlideshow/images/casas/4.jpg\" class=\"cubeStop\" /></li>\n";
	html+="                             <li><img src=\"SkitterSlideshow/images/casas/5.jpg\" class=\"block\" /></li>\n";
	html+="                             <li><img src=\"SkitterSlideshow/images/casas/6.jpg\" class=\"cubeHide\" /></li>\n";
	html+="                             <li><img src=\"SkitterSlideshow/images/casas/7.jpg\" class=\"cubeRandom\" /></li>\n";
	html+="                             <li><img src=\"SkitterSlideshow/images/casas/8.jpg\" class=\"cubeStop\" /></li>\n";
	html+="                             <li><img src=\"SkitterSlideshow/images/casas/9.jpg\" class=\"block\" /></li>\n";
	html+="                             <li><img src=\"SkitterSlideshow/images/casas/10.jpg\" class=\"cuberHide\" /></li>\n";
	html+="                         </ul>\n";
	html+="                     </div>\n";
	html+="                 </div>\n";
  	html+="             </div>\n";
	html+="         </div>\n";
	html+="     </div>\n";
        html+=" </div>\n"; 
        return html;
    }
    
    public String generearHTMLColumnfour(AccesoBD abd){
        String html="";
        String condicion= "";
        html+=" <p>&nbsp;</p>\n";
        html+=" <div class=\"column4\">\n";
        html+="     <div class=\"title\">Datos de inter&eacute;s</div> \n";
        html+="     <div class=\"offer_box_wide\">\n";
        html+="         <a><img src=\"images/mudanza.jpg\" width=\"130\" height=\"98\" class=\"img_left\" alt=\"\" title=\"\" border=\"0\"/></a>\n";
        html+="         <div class=\"offer_info\">\n";
        html+="             <span>8 pasos para una mudanza organizada</span>";
        html+="         </div>\n";
        html+="         <p class=\"offer\">\n";
        html+="             Los expertos dicen que mudarse puede ser una de las actividades m&aacute;s estresantes y que producen much&iacute;sima ansiedad.";
        html+="             <div class=\"more\"><a href=\"Mudanza.jsp\">...more</a></div>\n";
        html+="             <div class=\"offer_info\">\n";
        html+="                 <p class=\"offer\">\n";
        html+="                 </p>\n";
        html+="             </div>\n";
        html+="     </div>\n";
        html+="     <div class=\"offer_box_wide\">\n";
        html+="         <a><img src=\"images/inmoDigital.jpg\" width=\"130\" height=\"98\" class=\"img_left\" alt=\"\" title=\"\" border=\"0\"/></a>\n";
        html+="         <div class=\"offer_info\">\n";
        html+="             <span>Encuentre el hogar que siempre soñ&oacute;</span>\n";
        html+="             <p class=\"offer\">\n";
        html+="                 Martinez Latorre Inmobiliaria pone a disposici&oacute;n un nuevo servicio digital, nada m&aacute;s simple para informarte de tu alquiler, desde donde quieras, cuando quieras.\n";
        html+="             </p>\n";
        html+="         </div>\n";
        html+="     </div>\n";
        html+="     <div class=\"offer_box_wide\">\n";
        html+="         <a><img src=\"images/inmoFuturo.png\" width=\"130\" height=\"98\" class=\"img_left\" alt=\"\" title=\"\" border=\"0\"/></a>\n";
        html+="         <div class=\"offer_info\">\n";
        html+="             <span>C&oacute;mo es el mercado inmobiliario que se viene</span>\n";
        html+="         </div>\n";
        html+="         <p class=\"offer\">\n";
        html+="             La mirada de los principales actores del rubro. Sus estrategias para maximizar la rentabilidad.\n";
        html+="         </p>\n";
        html+="         <p>&nbsp;</p>\n";        
        html+="         <div class=\"more\"><a href=\"InmoFuturo.jsp\">...more</a></div>\n";
        html+="     </div>\n";
        html+="     <div class=\"offer_box_wide\">\n";
        html+="         <a> <img src=\"images/casaNueva.jpg\" width=\"130\" height=\"98\" class=\"img_left\" alt=\"\" title=\"\" border=\"0\"/></a>\n";
        html+="         <div class=\"offer_info\">\n";
        html+="             <span>Siete pasos imprescindibles antes de comprar una casa usada</span>\n";
        html+="             <p class=\"offer\">\n";
        html+="                 Al comprar una casa, se deben tomar una serie de precauciones previas a la entrega de la señal que reserva el inmueble.\n";
        html+="             </p>\n";
        html+="         <div class=\"more\"><a href=\"CasaUsada.jsp\">...more</a></div>\n";
        html+="      </div>\n";
        html+="  </div>  \n";
        html+=" </div>\n";//endOfColumnFour 
        html+="</div>\n";//endOfMain_content
        html+="<p>&nbsp;</p>\n";
        html+="<p>&nbsp;</p>\n";        
        return html;
    }
}
