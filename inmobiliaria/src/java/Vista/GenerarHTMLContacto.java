package Vista;
//Vista de la secci&oacute;n contacto
public class GenerarHTMLContacto extends GenerarHTMLGeneral{

    public GenerarHTMLContacto(){}
    
    public String GenerarHTMLGenerarColumn1(){
        String html="";
        html+="<div id=\"main_content\">\n"; 
    	html+=   "<div class=\"column1\">\n";
        html+=      "<p>&nbsp;</p>";
        html+=      "<p>&nbsp;</p>";
        html+=      "<p>&nbsp;</p>";
        html+=      "<p>&nbsp;</p>";
        html+=      "<p>&nbsp;</p>";
        html+=      "<img src=\"images/recepcionista.png\" alt=\"Recepcionista\" width=\"250\" height=\"400\" />\n";       	
        html+=   "</div>\n";
        html+=  "<div class=\"main_text_box\"></div>\n";           
        html+="</div>\n";
        return html;
    }
    public String GenerarHTMLGenerarColumn8(){
        String html="";
        html+="<div class=\"column8\">\n";
        html+=   "<div class=\"title\">Dejanos tu consulta y/o sugerencia, en brevedad nos pondremos en contacto con usted.</div> \n";
       	html+=       "<div class=\"contact_tab\">\n";
        html+=          "<a id=\"foxyform_embed_link_176601\" href=\"http://es.foxyform.com/\">foxyform</a>";
        html+=          "<script type=\"text/javascript\">";
        html+=              "(function(d, t){";
        html+=                  "var g = d.createElement(t),";
        html+=                  "s = d.getElementsByTagName(t)[0];";
        html+=                  "g.src = \"http://es.foxyform.com/js.php?id=176601&sec_hash=1b696462931&width=350px&height=400px\";";
        html+=                  "s.parentNode.insertBefore(g, s);";
        html+=              "}(document, \"script\"));";
        html+=          "</script>";
        html+=       "</div>\n";
        html+="</div>\n";                
        return html;
    }
}
