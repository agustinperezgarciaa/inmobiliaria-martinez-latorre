package Vista;
public class GenerarHTMLInmoFuturo extends GenerarHTMLGeneral{
    
    //Vista de la secci&oacute;n de el futuro del mercado inmobiliario
    public GenerarHTMLInmoFuturo(){}
    
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
        html+=          "<p>&nbsp;</p>";
        html+=          "<p>&nbsp;</p>";
	html+=          "<div class=\"title\">C&oacute;mo es el mercado inmobiliario que se viene</div> \n";
	html+=          "<div class=\"contact_tab\">\n";
        html+=              "<p>&nbsp;</p>";
        html+=              "<B>  La mirada de los principales actores del rubro, que estuvieron reunidos en el Expo Real Estate. Sus estrategias para maximizar la rentabilidad.</B>\n";
        html+=              "<p>&nbsp;</p>";
        html+=              "<B> Entre la Expo Real Estate 2012 y la que aconteci&oacute; hace unos d&iacute;as, muchas variables se sumaron al escenario del mercado inmobiliario argentino. Entre ellos podr&iacute;amos nombrar los cr&eacute;ditos Pro.Cre.Ar, los planes de financiamiento que ofrece el Banco Ciudad y los Cedin. Sin embargo, ninguno de estos factores cambi&oacute; la sensaci&oacute;n de incertidumbre que se puso de manifiesto en el &uacute;ltimo encuentro de operadores inmobiliarios que tuvo lugar en el Hotel Hilton de Puerto Madero. Herman Faigenbaum de Cushman & Wakefield lo resumi&oacute; en pocas palabras: &quot;todav&iacute;a no sabemos de qu&eacute; se tratan estos cambios. El proceso se est&aacute; consolidando bajo nuevos paradigmas&quot;.\n";
        html+=              "<p>&nbsp;</p>";
        html+=              "Como el año anterior, los desarrolladores consultados confirmaron que son los consumidores finales los que sostienen los proyectos actuales. La demanda conformada por grandes inversores que tuvo su momento de esplendor hasta 2010/2011 ya no est&aacute; tan activa.\n";
        html+=              "<p>&nbsp;</p>";
        html+=              "Este cambio obliga a los desarrolladores a cambiar su estrategia. Para que un emprendimiento sea exitoso, se señal&oacute; la importancia de ofrecer financiamiento a largo plazo y &quot;ser creativos, darle contenido a las marcas&quot;, indic&oacute; Gustavo Cohen, de la firma Urbania Desarrollos.\n";
        html+=              "<p>&nbsp;</p>";
        html+=              "Lo cierto es que para ello es necesario contar con un capital preoperatorio que garantice el comienzo de la obra. Gustavo Menayed, de Grupo Portland, recomend&oacute; &quot;buscar inversores de mayor envergadura y apostar a la diversidad&quot;. Como ejemplo de esto &uacute;ltimo mencion&oacute; un desarrollo de su compañ&iacute;a en una nueva zona en La Matanza, destinado a familias.\n";
        html+=              "<p>&nbsp;</p>";
        html+=              "Por su parte, Cohen dio algunas pistas de las consecuencias que traer&aacute; este nuevo perfil de comprador. &quot;Se van a empezar a concentrar grandes y medianos emprendedores para tener una performance m&aacute;s profesional&quot;. Menayed coincidi&oacute;: &quot;entre los desarrolladores ya se nota una comuni&oacute;n en sus proyectos&quot;.\n"+
                            "En tanto, Santiago Tarasido, director de CRIBA, destac&oacute; la importancia de los tenedores de terrenos como inversores. ";
        html+=              "<p>&nbsp;</p>";
        html+=              "Mariano Galeazza de Grupo Monarca asinti&oacute;: &quot;ahora hay m&aacute;s propietarios que nos ofrecen la tierra a cambio de metros cuadrados&quot;. Y recomend&oacute; a los empresarios presentes detenerse a pensar: &quot;¿qu&eacute; porcentaje de los metros cuadrados que haga en el desarrollo puedo ceder? As&iacute; es como se est&aacute; negociando con los tenedores de tierra&quot;.</B>";
	html+="             <div style=\"float:right; padding:10px 15px 0 0;\">\n";
	html+="		</div>\n";
	html+="     </div>\n";
	html+="   </div>\n";//<!-- end of column four -->        		
	html+="</div>\n";//<!-- end of main_content -->
        return html;
    }
}