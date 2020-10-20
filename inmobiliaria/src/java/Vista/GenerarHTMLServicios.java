package Vista;

//Vista de la secci&oacute;n servicios
public class GenerarHTMLServicios extends GenerarHTMLGeneral{
    
    public GenerarHTMLServicios(){}
    
    public String generarHTMLMainContent(){
        String html="";
        html+="<div id=\"main_content\" > \n";
    	html+=  "<div class=\"column1\">\n";
	html+=      "<p>&nbsp;</p>\n";
	html+=      "<p>&nbsp;</p>\n";
        html+=      "<p>&nbsp;</p>\n";
	html+=      "<img src=\"images/servicios2.jpg\"width=\"260\" height=\"520\" />\n";
        html+=  "</div>\n";//<!-- end of column one -->
   	html+=  "<div class=\"main_text_box\"></div>\n";
     	html+=      "<div class=\"column8\">\n";
        html+=      "<p>&nbsp;</p>";
        html+=      "<p>&nbsp;</p>";
	html+=      "<div class=\"title\">Servicios</div> \n";
	html+=      "<div class=\"contact_tab\">\n";
        html+=          "<strong><font color=\"red\"><H3>Gesti&oacute;n comercial de alquileres:</font></H3>";
        html+=          "<ul>"; 
        html+=              "<li>Realizaci&oacute;n por encargo de las reparaciones necesarias en la propiedad para su colocaci&oacute;n en el mercado o para el reintegro del inmueble a la finalizaci&oacute;n del contrato.\n</li>"; 
        html+=              "<li>Publicaciones en diarios, revistas, sitios de Internet. (Diario La Capital, Revista Mercado Inmobiliaria, etc.)\n</li>";
        html+=              "<li>Colocaci&oacute;n de carteles en la propiedad.\n</li>";
        html+=              "<li>Averiguaci&oacute;n de antecedente y solvencia de las garant&iacute;as. Para ello nos encontramos adheridos a empresas como Veraz Equifax y a la C&aacute;mara de Cr&eacute;dito Comercial.</li>";
        html+=              "<li>Confecci&oacute;n del contrato de alquiler adecuado.</li>";
        html+=          "</ul>";
        html+=          "<strong><font color=\"red\"><H3>Administraci&oacute;n de alquileres:</font></H3>";
        html+=          "<ul>"; 
        html+=              "<li>Seguimiento y control del cumplimiento de todas las cl&aacute;usulas del contrato.\n</li>"; 
        html+=              "<li>Cobro y pago de alquileres. (Posibilidad de hacerlo v&iacute;a transferencia bancaria)\n</li>";
        html+=              "<li>Verificaci&oacute;n del pago de los impuestos, expensas y servicios.\n</li>";
        html+=              "<li>Reparaciones de los desperfectos que surgieran en la propiedad por orden y cuenta del propietario o inquilino, seg&uacute;n corresponda.</li>";
        html+=          "</ul>";
        html+=          "<strong><font color=\"red\"><H3>Gesti&oacute;n comercial de ventas:</font></H3>";
        html+=          "<ul>"; 
        html+=              "<li>Tasaci&oacute;n del inmueble.\n</li>"; 
        html+=              "<li>Estudio de los T&iacute;tulos de la propiedad.\n</li>";
        html+=              "<li>Confecci&oacute;n de un registro de im&aacute;genes digitales de la propiedad para la visualizaci&oacute;n de sus caracter&iacute;sticas, previa visita f&iacute;sica, evitando p&eacute;rdidas de tiempo en caso de no concordar con los gustos del interesado..\n</li>";
        html+=              "<li>Publicaciones en diarios, revistas, sitios de Internet (Diario La Capital, Revista Mercado Inmobiliaria, etc.)\n</li>";
        html+=              "<li>Colocaci&oacute;n de carteles en la propiedad.\n</li>"; 
        html+=          "</ul>";  
        html+=          "<strong><font color=\"red\"><H3>Busqueda de propiedades:</font></H3>";
        html+=          "<ul>"; 
        html+=              "<li>No pierda mas tiempo! Nos ocupamos de buscar en el mercado la propiedad que esta deseando.</li>"; 
        html+=          "</ul>";
        html+=          "</p>\n";
	html+=          "<div style=\"float:right; padding:10px 15px 0 0;\">\n";
	html+=      "</div>\n";
	html+=    "</div>\n";
	html+=  "</div>\n";//<!-- end of column four -->        		
	html+="</div>\n";//<!-- end of main_content -->
        return html;
    }
}
