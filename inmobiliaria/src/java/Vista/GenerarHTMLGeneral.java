package Vista;

//Vista general

import Entidad.Cliente;
import Persistencia.AccesoBD;
import java.util.LinkedList;

public class GenerarHTMLGeneral {
    private LinkedList<Cliente> lisClie;

    public GenerarHTMLGeneral(){
    }
    
    public String generarHTMLHead(String titulo){
        String html="";
        html+="<html>";
        html+=  "<link rel=\"stylesheet\" type=\"text/css\" href=\"style.css\" />\n";
        html+=  "<div id=\"wrapper\">";
        html+=      "<head>\n";
        html+=          "<meta http-equiv=\"Content-Type\" content=\"text/html; charset=windows-1252\" />\n";
        html+=          "<link rel=\"shortcut icon\" type=\"image/x-icon\" href=\"images/favicon.ico\">";
        html+=          "<title>"+titulo+"</title>\n";
        html+=          "<link rel=\"stylesheet\" type=\"text/css\" href=\"admin.css\" />\n";
        html+=          "<script src=\"fun.js\" type=\"text/javascript\"></script>";
        html+=      "</head>\n";
        html+=      "<body>\n";
        html+=          "<div id=\"main_container\">";
        return html;
    }
    
    //efecto de fotos en pagina principal(index)
    public String generarHTLMHeadDos(String titulo){
        String html="";
        html+="<html>";
        html+=      "<link rel=\"stylesheet\" type=\"text/css\" href=\"style.css\" />\n";
        html+= "<div id=\"wrapper\">";
        html+=  "<head>\n";
        html+=      "<script src=\"fun.js\" type=\"text/javascript\"></script>";
        html+=          "<meta http-equiv=\"Content-Type\" content=\"text/html; charset=windows-1252\" />\n";
        html+=          "<link rel=\"shortcut icon\" type=\"image/x-icon\" href=\"images/favicon.ico\">";
        html+=          "<title>"+titulo+"</title>\n";
        // Comienza muestra inmuebles 
	html+=          "<link href=\"SkitterSlideshow/css/skitter.styles.css\" type=\"text/css\" media=\"all\" rel=\"stylesheet\" />\n";
	html+=          "<link href=\"SkitterSlideshow/css/highlight.black.css\" type=\"text/css\" media=\"all\" rel=\"stylesheet\" />\n";
	html+=          "<link href=\"SkitterSlideshow/css/sexy-bookmarks-style.css\" type=\"text/css\" media=\"all\" rel=\"stylesheet\" />\n";
	html+=          "<script src=\"SkitterSlideshow/js/jquery-1.6.3.min.js\"></script>\n";
	html+=          "<script src=\"SkitterSlideshow/js/jquery.easing.1.3.js\"></script>\n";
	html+=          "<script src=\"SkitterSlideshow/js/jquery.animate-colors-min.js\"></script>\n";
	html+=          "<script src=\"SkitterSlideshow/js/jquery.skitter.min.js\"></script>\n";
	html+=          "<script src=\"SkitterSlideshow/js/highlight.js\"></script>\n";
	html+=          "<script src=\"SkitterSlideshow/js/sexy-bookmarks-public.js\"></script>\n";
        html+=      "<script>\n";
	html+=          "$(document).ready(function(){\n";
	html+=              "$('.box_skitter_large').skitter({label: false, numbers: false});\n";
	html+=              "$('.box_skitter_small').skitter({label: false, numbers: false, interval: 1000});\n";
	html+=              "$('.box_skitter_medium').css({width: 500, height: 200}).skitter({show_randomly: true, navigation: false, dots: true, interval: 5000});\n";
	html+=              "$('.box_skitter_normal').css({width: 400, height: 300}).skitter({animation: 'blind', interval: 2000, hideTools: true});\n";
	html+=              "$('pre.code').highlight({source:1, zebra:1, indent:'space', list:'ol'});\n";
	html+=          "});\n";
	html+=      "</script>\n";
        //Termina muestra inmuebles
        html+=  "</head>\n";
        html+=  "<body>\n";
        html+=      "<div id=\"main_container\">";
        return html;
    }
    public String generarHTMLHeadUno(String titulo){
        String html="";
        html+="<html>";
        html+=  "<head>\n";
        html+=      "<meta http-equiv=\"Content-Type\" content=\"text/html; charset=windows-1252\" />\n";
        html+=          "<link rel=\"shortcut icon\" type=\"image/x-icon\" href=\"images/favicon.ico\">";
        html+=      "<title>"+titulo+"</title>\n";
        html+=      "<link rel=\"stylesheet\" type=\"text/css\" href=\"style.css\" />\n";
        html+=      "<script src=\"fun.js\" type=\"text/javascript\"></script>";
        html+=  "</head>\n";
        html+=  "<body>\n";
        html+=      "<div id=\"main_container\">";
        return html;
    }
    public String generarHTMLFinal(){
       String html ="";
       html+=       "</div>\n";//endDIV:main_container
       html+=   "</div>\n"; //end of wrapper
       html+= "</div>\n";
       return html;
    }
    public String generarHTMLFina2l(){
       String html ="";
       html+=       "</div>\n";//endDIV:main_container
       html+=   "</body>\n"; 
       html+= "</div>\n";
       return html;
    }
    public String generarHTMLMenu(String user){
        String html="";
        html+="<div id=\"header\">\n";
        html+=  "<div id=\"logo\">\n";
        html+=      "<a href=\"Index.jsp\"><img src=\"images/logo.gif\" width=\"140\" height=\"70\" border=\"0\" /></a>\n";
        html+=  "</div>\n";
        html+=  "<div class=\"banner_adds\">\n";
        html+=       "<a href=\"https://www.facebook.com/pages/Inmobiliaria-Martinez-Latorre-Asoc/388635474532597?ref=stream\"><img title=\"Seguinos en Facebook\" src=\"images/facebook_64x64.png\" width=\"45\" height=\"45\" border=\"0\" align=\"right\" /></a>\n";
        html+=  "</div>\n";    
        html+=  "<div class=\"menu\">\n";
        html+=      "<ul>\n";
        html+=          "<li><a href=\"Index.jsp\">Inicio</a></li>\n";
        html+=          "<li><a href=\"Servicios.jsp\">Servicios</a></li>\n";
        html+=          "<li><a href=\"Buscador.jsp\">Buscador de Propiedades</a></li>\n";
        html+=          "<li><a href=\"Nosotros.jsp\">Nosotros </a></li>\n";
        html+=          "<li><a href=\"Tasaciones.jsp\">Tasaciones </a></li>\n";
        html+=          "<li><a href=\"Contactenos.jsp\">Contacto</a></li>\n";
        if(user.compareTo("Usuario")==0){
            html+=              "<li><a href=\"Login.jsp\">Login</a></li>\n";
        }else{
            html+=              "<li><a href=\"Admin.jsp\">Admin\n</a>\n";
            html+=              "<li><a href=\"Salir.jsp\">Salir\n</a></li>\n";
        }
        html+=          "</li>\n";
        html+=      "</ul>\n";
        html+=  "</div>\n";
        html+="</div>\n";
        return html;
    }
    
    public String generarHTMLFooter(){ 
        String html="";  
        html+=   "</body>\n"; 
        html+=   "<div id=\"footer\">\n";
        html+=      "<div style= \"width:970px;\" \"height:41px;\" \"clear:both;\" \"font-size:11px;\" \"background-color:#f2efef;\" \"border-top:1px #eeabbd dashed;\" \"left: 21px;\" \"top: 1049px;\" \"margin-left:185px;\"";
        html+=      "<link rel=\"stylesheet\" type=\"text/css\" href=\"style.css\" />\n";
        html+=      "<div id=\"copyright\">\n";
        html+=      "<div style=\"float:left; padding:3px;\"><a href=\"#\"><img src=\"images/logo.gif\" width=\"42\" height=\"35\" alt=\"\" title=\"\" border=\"0\" /></a></div>\n";
        html+=      "<div style=\"float:left; padding:14px 10px 10px 10px;\"> Martinez Latorrez &#38; Asoc. &copy; All Rights Reserved 2008 </div>\n";
        html+=      "<div style=\"float:right; padding:9px;\"><b> Contador de visitas:<align=\"right\"><a  target=\"_blank\"><img src=\"http://contadores.gratisparaweb.com/imagen.php?contador=15&id2=152645\" alt=\"Contadores\" width=\"35\" border=\"0\"></a><br><br><map name=\"Map\"><area shape=\"rect\" coords=\"48,1,90,22\" target=\"_blank\" alt=\"Cursos\"><area shape=\"rect\" coords=\"0,0,47,15\" href=\"http://contadores.gratisparaweb.com\" target=\"_blank\" ></map></a></div></b> </div>\n";
        html+=   "</div>\n";
        html+=  "</div>\n";
        html+="</html>\n";
        return html;        
    }
        public String generarHTMLFooterIndex(){ 
        String html="";  
        html+=   "<div id=\"footer2\">\n";
        html+=      "<div style= \"width:970px;\" \"height:41px;\" \"clear:both;\" \"font-size:11px;\" \"background-color:#f2efef;\" \"border-top:1px #eeabbd dashed;\" \"left: 21px;\" \"top: 1049px;\" \"margin-left:185px;\"";
        html+=      "<link rel=\"stylesheet\" type=\"text/css\" href=\"style.css\" />\n";
        html+=      "<div id=\"copyright\">\n";
        html+=      "<div style=\"float:left; padding:3px;\"><a href=\"#\"><img src=\"images/logo.gif\" width=\"42\" height=\"35\" alt=\"\" title=\"\" border=\"0\" /></a></div>\n";
        html+=      "<div style=\"float:left; padding:14px 10px 10px 10px;\"> Martinez Latorrez &#38; Asoc. &copy; All Rights Reserved 2008 </div>\n";
        html+=      "<div style=\"float:right; padding:14px;\"><b> Contador de visitas:<align=\"right\"><a  target=\"_blank\"><img src=\"http://contadores.gratisparaweb.com/imagen.php?contador=15&id2=152645\" alt=\"Contadores\" width=\"35\" border=\"0\"></a><br><br><map name=\"Map\"><area shape=\"rect\" coords=\"48,1,90,22\" target=\"_blank\" alt=\"Cursos\"><area shape=\"rect\" coords=\"0,0,47,15\" href=\"http://contadores.gratisparaweb.com\" target=\"_blank\" ></map></a></div></b> </div>\n";
        html+=   "</div>\n";
        html+=  "</div>\n";
        html+="</html>\n";
        return html;        
    }
        public String generarHTMLFooterIn(){ 
        String html="";  
        html+=  "<div id=\"footer2\">\n";
        html+=      "<div style= \"width:970px;\" \"height:41px;\" \"clear:both;\" \"font-size:11px;\" \"background-color:#f2efef;\" \"border-top:1px #eeabbd dashed;\" \"left: 21px;\" \"top: 1049px;\" \"margin-left:185px;\"";
        html+=      "<link rel=\"stylesheet\" type=\"text/css\" href=\"style.css\" />\n";
        html+=      "<div id=\"copyright\">\n";
        html+=      "<div style=\"float:left; padding:3px;\"><a href=\"#\"><img src=\"images/logo.gif\" width=\"42\" height=\"35\" alt=\"\" title=\"\" border=\"0\" /></a></div>\n";
        html+=      "<div style=\"float:left; padding:14px 10px 10px 10px;\"> Martinez Latorrez &#38; Asoc. &copy; All Rights Reserved 2008 </div>\n";
        html+=      "<div style=\"float:right; padding:9px;\"><b> Contador de visitas:<align=\"right\"><a  target=\"_blank\"><img src=\"http://contadores.gratisparaweb.com/imagen.php?contador=15&id2=152645\" alt=\"Contadores\" width=\"35\" border=\"0\"></a><br><br><map name=\"Map\"><area shape=\"rect\" coords=\"48,1,90,22\" target=\"_blank\" alt=\"Cursos\"><area shape=\"rect\" coords=\"0,0,47,15\" href=\"http://contadores.gratisparaweb.com\" target=\"_blank\" ></map></a></div></b> </div>\n";
        html+=  "</div>\n";
        html+= "</div>\n";
        html+="</html>\n";
        return html;        
    }
        
        
    public String generarHTMLFooter2(){ 
        String html="";        
        html+=  "<div id=\"footerCont\">\n";
        html+=      "<link rel=\"stylesheet\" type=\"text/css\" href=\"Style.css\" />\n";
        html+=      "<div style=\"position:relative\" \"width:970px;\" \"height:41px;\" \"clear:both;\" \"font-size:11px;\" \"background-color:#f2efef;\" \"border-top:1px #eeabbd dashed;\" \"left: 21px;\" \"top: 1049px;\" \"margin-left:185px;\"";
        html+=      "<div id=\"copyright\">\n";
        html+=      "<div style=\"float:left; padding:3px;\"><a href=\"#\"><img src=\"images/logo.gif\" width=\"42\" height=\"35\" alt=\"\" title=\"\" border=\"0\" /></a></div>\n";
        html+=      "<div style=\"float:left; padding:14px 10px 10px 10px;\"> Martinez Latorrez &#38; Asoc. &copy; All Rights Reserved 2008</div>\n";
        html+=      "<div style=\"float:right; padding:9px;\"><b> Contador de visitas:<align=\"right\"><a  target=\"_blank\"><img src=\"http://contadores.gratisparaweb.com/imagen.php?contador=15&id2=152645\" alt=\"Contadores\" width=\"35\" border=\"0\"></a><br><br><map name=\"Map\"><area shape=\"rect\" coords=\"48,1,90,22\" target=\"_blank\" alt=\"Cursos\"><area shape=\"rect\" coords=\"0,0,47,15\" href=\"http://contadores.gratisparaweb.com\" target=\"_blank\" ></map></a></div></b> </div>\n";
        html+=  "</div>\n";
        html+="</div>\n";
        return html;        
    }
        public String generarHTMLFooterCont(){ 
        String html="";        
        html+=  "<div id=\"footerCont\">\n";
        html+=      "<link rel=\"stylesheet\" type=\"text/css\" href=\"Style.css\" />\n";
        html+=      "<div style=\"position:relative\" \"width:970px;\" \"height:41px;\" \"clear:both;\" \"font-size:11px;\" \"background-color:#f2efef;\" \"border-top:1px #eeabbd dashed;\" \"left: 21px;\" \"top: 1049px;\" \"margin-left:185px;\"";
        html+=      "<div id=\"copyright\">\n";
        html+=      "<div style=\"float:left; padding:3px;\"><a href=\"#\"><img src=\"images/logo.gif\" width=\"42\" height=\"35\" alt=\"\" title=\"\" border=\"0\" /></a></div>\n";
        html+=      "<div style=\"float:left; padding:14px 10px 10px 10px;\"> Martinez Latorrez &#38; Asoc. &copy; All Rights Reserved 2008</div>\n";
        html+=      "<div style=\"float:right; padding:9px;\"><b> Contador de visitas:<align=\"right\"><a  target=\"_blank\"><img src=\"http://contadores.gratisparaweb.com/imagen.php?contador=15&id2=152645\" alt=\"Contadores\" width=\"35\" border=\"0\"></a><br><br><map name=\"Map\"><area shape=\"rect\" coords=\"48,1,90,22\" target=\"_blank\" alt=\"Cursos\"><area shape=\"rect\" coords=\"0,0,47,15\" href=\"http://contadores.gratisparaweb.com\" target=\"_blank\" ></map></a></div></b> </div>\n";
        html+=  "</div>\n";
        html+="</div>\n";
        return html;        
    }
}
