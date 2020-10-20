package Vista;

//Vista de la secci&oacute;n tasaciones
public class GenerarHTMLTasaciones extends GenerarHTMLGeneral{
    
    public GenerarHTMLTasaciones(){}
    
    public String generarHTMLMainContent(){
        String html="";
        html+="<div id=\"main_content\"> \n";
    	html+=  "<div class=\"column1\">\n";
	html+=      "<p>&nbsp;</p>\n";
	html+=      "<p>&nbsp;</p>\n";
        html+=      "<p>&nbsp;</p>\n";
        html+=      "<p>&nbsp;</p>\n";
        html+=      "<p>&nbsp;</p>\n";
        html+=      "<img src=\"images/tasaciones.jpg\"width=\"250\" height=\"400\" />\n";
        html+=  "</div>\n";//<!-- end of column one -->
   	html+=  "<div class=\"main_text_box\"></div>\n";
     	html+=    "<div class=\"column8\">\n";
	html+=      "<div class=\"title\">Tasaciones</div> \n";
	html+=      "<div class=\"contact_tab\">\n";
	html+=          "<p class=\"Estilo3\"><strong>Nuestro personal  capacitado, realizar&aacute; una valoraci&oacute;n, teniendo en cuenta diversos factores,como por ejemplo:&nbsp;el estado del inmueble, reformas, la ubicaci&oacute;n, etc.<br />\n";
	html+=          "En brevedad nos pondremos en contacto con utd.</strong>\n";   	               
	html+=          "<br />\n";
	html+=          "<br />\n";
        html+=          "<a id=\"foxyform_embed_link_176601\" href=\"http://es.foxyform.com/\">foxyform</a>";
        html+=          "<script type=\"text/javascript\">";
        html+=              "(function(d, t){";
        html+=                  "var g = d.createElement(t),";
        html+=                  "s = d.getElementsByTagName(t)[0];";
        html+=                  "g.src = \"http://es.foxyform.com/js.php?id=176601&sec_hash=1b696462931&width=350px&height=400px\";";
        html+=                  "s.parentNode.insertBefore(g, s);";
        html+=              "}(document, \"script\"));";
        html+=          "</script>";
	html+=      "</div>\n";   
	html+=  "</div>\n";//<!-- end of column four -->        		
	html+="</div>\n";//<!-- end of main_content -->
        return html;
    }
}
