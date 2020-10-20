package Vista;
//Vista de la secci&oacute;n nosostros
public class GenerarHTMLNosotros extends GenerarHTMLGeneral{
    
    public GenerarHTMLNosotros(){}
    public String generarHTMLMainContent(){
        String html="";
        html+="<div id=\"main_content\"> \n";
    	html+=      "<div class=\"column1\">\n";
	html+=          "<p>&nbsp;</p>\n";
	html+=          "<p>&nbsp;</p>\n";
        html+=          "<p>&nbsp;</p>\n";
	html+=          "<img src=\"images/Nosotros3.jpg\"width=\"250\" height=\"410\" />\n";
        html+=      "</div>\n";//<!-- end of column one -->
   	html+=      "<div class=\"main_text_box\"></div>\n";
     	html+=      "<div class=\"column8\">\n";
        html+=          "<p>&nbsp;</p>";
        html+=          "<p>&nbsp;</p>";
	html+=          "<div class=\"title\">Nosotros</div> \n";
	html+=          "<div class=\"contact_tab\">\n";
	html+=              "<p class=\"Estilo3\"><strong><font color=\"red\">Inmobiliaria Martinez Latorrez & Asoc.</font> Naci&oacute; hace 20 años como una Empresa Familiar e Innovadora con atenci&oacute;n cordial y personalizada. Usted cuenta con el respaldo de un grupo de Profesionales Matriculados, altamente capacitados para que sus operaciones lleguen en todos los casos con &eacute;xito. \n";
        html+=              "<p>&nbsp;</p>\n";   	               
        html+=              "<p class=\"Estilo3\"><strong><font color=\"red\">Nuestro objetivo principal</font> es dar soluciones a nuestros clientes, brindando asesoramiento e informaci&oacute;n permanente para responder a las necesidades contando con la mayor disposici&oacute;n para escuchar sus necesidades.";
        html+=              "<p>&nbsp;</p>\n";
        html+=              "<p class=\"Estilo3\"><strong><font color=\"red\">Nos caracterizamos </font> por brindar soluciones con agilidad y creatividad comercial. Con un trato exclusivo aportamos una din&aacute;mica basada en nuevas ideas, tecnolog&iacute;as y el marketing aplicado al negocio inmobiliario. M&aacute;s de 10.000 operaciones en todos los rubros del mercado avalan nuestra idoneidad.";
        html+=              "<p class=\"Estilo3\"><strong>\n";
        html+=              "<p>&nbsp;</p>\n";
        html+=              "<p class=\"Estilo3\"><strong><font color=\"red\">Operamos </font> fundamentalmente en la cuidad de Rio Cuarto y zona, para ello contamos con dos sucursales propias equipadas con sistemas inform&aacute;ticos modernos y la comodidad que usted merece.</strong>\n";   
        html+=              "<p>&nbsp;</p>\n";
        html+=              "<table>";
        html+=                  "<style>  td { border: 2px solid red; border-spacing: 10px; }  </style> "; 
        html+=                  "<tr>  ";
        html+=                      "<td><H2><font color=\"red\"><DIV ALIGN = \"LEFT\">&nbsp;&nbsp;Sucursal 1:</font> <p>&nbsp;</p> ";
        html+=                      "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;  - Direcci&oacute;n: Mitre 1013 - Dpto A  </p>";
        html+=                      "&nbsp;&nbsp;&nbsp; &nbsp;&nbsp;&nbsp;         - Email: martnieslatorreS1@gmail.com             &nbsp;&nbsp;&nbsp;&nbsp;</p>";
        html+=                      "&nbsp;&nbsp; &nbsp;&nbsp;&nbsp;&nbsp;     - Tel&eacute;fono: 0358 462-2447</p></H2> </LEFT></td>&nbsp;&nbsp; "; 
        html+=                      "<td><H2><font color=\"red\"><DIV ALIGN = \"LEFT\">&nbsp;&nbsp;Sucursal 2:</font><p>&nbsp;</p> ";
        html+=                      "&nbsp;&nbsp;&nbsp;  &nbsp;&nbsp;&nbsp;&nbsp;  - Direcci&oacute;n: Sobremonte 368 </p>";
        html+=                      "&nbsp;&nbsp;&nbsp; &nbsp; &nbsp;&nbsp;        - Email: martnieslatorreS2@gmail.com &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</p>";
        html+=                      "&nbsp;&nbsp; &nbsp;&nbsp; &nbsp;&nbsp;        - Tel&eacute;fono: 0358 462-2448</p></H2> </td> ";
        html+=                      "</DIV> ";
        html+=                  "</tr>  ";
        html+=              "</table>  ";
	html+=              "<br />\n";
	html+=              "</p>\n";
	html+=      "</div>\n";//<!-- end of column four -->        		
	html+="</div>\n";//<!-- end of main_content -->
        return html;
    }
}
