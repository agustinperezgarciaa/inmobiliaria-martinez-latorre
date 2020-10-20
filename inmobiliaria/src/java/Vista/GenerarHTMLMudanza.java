package Vista;
//Vista de la secci&oacute;n de 8 pasos para una mudanza organizada
public class GenerarHTMLMudanza extends GenerarHTMLGeneral{
    
    public GenerarHTMLMudanza(){}
    
    public String generarHTMLMainContent(){
        String html="";
        html+="<div id=\"main_content\" > \n";
    	html+=      "<div class=\"column1\">\n";
	html+=           "<p>&nbsp;</p>\n";
	html+=           "<p>&nbsp;</p>\n";
        html+=           "<p>&nbsp;</p>\n";
	html+=           "<img src=\"images/servicios2.jpg\"width=\"260\" height=\"520\" />\n";
        html+=      "</div>\n";//<!-- end of column one -->
   	html+=      "<div class=\"main_text_box\"></div>\n";            
     	html+=      "<div class=\"column8\">\n";
        html+=          "<p>&nbsp;</p>";
	html+=          "<div class=\"title\">8 pasos para una mudanza organizada</div> \n";
	html+=          "<div class=\"contact_tab\">\n";
	html+=              "<p>&nbsp;</p>";
        html+=              "<B>Cambiar de casa o ciudad puede ser una tarea muy desgastante, los expertos dicen que mudarse puede ser una de las actividades m&aacute;s estresantes y que producen much&iacute;sima ansiedad. Los cambios suelen ser muy positivos en todos los casos pero el hecho de tener que pensar en empacar, clasificar para luego desempacar y de nuevo desclasificar puede producir una verdadera jaqueca. Para lograr que todo salga como queremos debemos organizarnos nuestros pasos a seguir. As&iacute; que aqu&iacute; te va una gu&iacute;a para que no pierdas la cabeza en el proceso.</B>\n";
        html+=              "<p>&nbsp;</p>";
        html+=              "<strong><font color=\"red\"><H3>Pasos a seguir:</font></H3>";
        html+=              "<ul>"; 
        html+=                  "<li><font color=\"red\">Paso 1</font>: Elige una libreta o agenda para describir todas las actividades que debes realizar para una mudanza exitosa. Escribe todo, (desde adquirir cajas, etiquetas, cinta etc. hasta cu&aacute;ndo empezar a empaquetar qu&eacute;).\n</li>"; 
        html+=                  "<li><font color=\"red\">Paso 2</font>: Consigue todas las cajas de cart&oacute;n de distintos tamaños que puedas al igual que varios rollos de cinta. Si contratas una empresa de mudanzas, preg&uacute;ntales si prestan cajas. No olvides guardar unas cuantas para art&iacute;culos de &uacute;ltimo momento como ropa, utensilios de limpieza, comida de la nevera, colchas y dem&aacute;s.\n</li>";
        html+=                  "<li><font color=\"red\">Paso 3</font>: V&aacute;lete de tus maletas, mochilas etc para llenarlas con art&iacute;culos m&aacute;s personales como ropa, art&iacute;culos de baño, los muñecos favoritos de los niños como los peluches, juegos de cama, etc.\n</li>";
        html+=                  "<li><font color=\"red\">Paso 4</font>: Empaca cada uno de los art&iacute;culos con todo lo correspondiente, como una l&aacute;mpara con sus respectivos bombillos etc.\n</li>";
        html+=                  "<li><font color=\"red\">Paso 5</font>: Inicia por empacar todo lo antes posible. Utiliza un calendario para visualizar la fecha del traslado y hazte el prop&oacute;sito de empacar cada d&iacute;a una caja con suficiente tiempo. Puedes comenzar con aquello que no est&eacute;s usando en el momento como los arreglos navideños, libros, cds, art&iacute;culos de la cocina que no utilices frecuentemente, ropa fuera de temporada, etc.\n</li>";
        html+=                  "<li><font color=\"red\">Paso 6</font>: Utiliza pegatinas o tape de distintos colores para clasificar las cajas. Por ejemplo amarillo para la cocina, rojo para el livingroom, azul para la alcoba principal, verde para el diningroom, violeta para las alcobas de los niños etc. De esta forma ser&aacute; m&aacute;s f&aacute;cil identificar el contenido y la zona que le corresponde a cada una de las cajas.\n</li>";
        html+=                  "<li><font color=\"red\">Paso 7</font>: Reserva un lugar seguro para guardar los objetos de valor, documentos importantes, joyas, tarjetas de identidad, pasaportes, entre otros. Para mayor seguridad es recomendable que este tipo de objetos los transportes en tu autom&oacute;vil para que siempre est&eacute;n a tu alcance y no se extrav&iacute;en en la confusi&oacute;n.\n</li>";
        html+=                  "<li><font color=\"red\">Paso 8</font>: Personaliza las cajas de los miembros de tu familia. Si tienes varios niños esta es la mejor manera para que ellos se diviertan involucr&aacute;ndose en el proceso de mudarse. Mot&iacute;valos a desechar aquellos juguetes o ropa que ya no est&eacute;n usando para regal&aacute;rselos a otros niños que puedan aprovecharlos. As&iacute; que dona todo lo que ya utilices como ropa art&iacute;culos o muebles a la caridad, de esta forma tambi&eacute;n renovar&aacute;s la energ&iacute;a de tu nuevo hogar.\n</li>";
        html+=                  "</p>\n";
	html+=                  "<div style=\"float:right; padding:10px 15px 0 0;\">\n";
	html+=          "</div>\n";
	html+=      "</div>\n";
	html+=   "</div>\n";//<!-- end of column four -->        		
	html+="</div>\n";//<!-- end of main_content --> 
        return html;
    }
}
