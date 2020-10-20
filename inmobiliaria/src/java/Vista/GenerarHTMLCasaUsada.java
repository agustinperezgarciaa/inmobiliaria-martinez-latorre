package Vista;
//Vista de la secci&oacute;n de siete pasos imprescindibles antes de comprar una casa usada
public class GenerarHTMLCasaUsada extends GenerarHTMLGeneral{
    public GenerarHTMLCasaUsada(){}
    
    public String generarHTMLMainContent(){
        String html="";
        html+="<div id=\"main_content\" > \n";
    	html+="   <div class=\"column1\">\n";
	html+="      <p>&nbsp;</p>\n";
	html+="      <p>&nbsp;</p>\n";
        html+="	     <p>&nbsp;</p>\n";
	html+="	     <img src=\"images/servicios2.jpg\"width=\"260\" height=\"560\" />\n";
        html+="   </div>\n";//<!-- end of column one -->
   	html+="<div class=\"main_text_box\"></div>\n";
     	html+="   <div class=\"column8\">\n";
        html+="     <p>&nbsp;</p>";
	html+="     <div class=\"title\">Siete pasos imprescindibles antes de comprar una casa usada</div> \n";
	html+="     <div class=\"contact_tab\">\n";
        html+="     <p>&nbsp;</p>";
        html+="     <B>Comprar una vivienda es uno de los desembolsos econ&oacute;micos de mayor cuant&iacute;a que se hace a lo largo de la vida. Sin embargo, en algunos casos, personas que han adquirido un piso han conocido despu&eacute;s que pesaba sobre &eacute;l una hipoteca que ahora no pueden pagar o que no era propiedad del vendedor, sino de un familiar. Tambi&eacute;n es posible que el anterior dueño no haya pagado los gastos de la comunidad de vecinos o que la estructura del edificio no est&eacute; en tan buen estado como parec&iacute;a. Aunque la mayor&iacute;a de las transacciones de este tipo se realizan sin que haya ning&uacute;n problema, siempre hay un pequeño porcentaje de individuos que intenta aprovecharse de la situaci&oacute;n.</B>\n";
        html+="     <p>&nbsp;</p>";
        html+="     <strong><font color=\"red\"><H3>Pasos a seguir:</font></H3>";
        html+="     <ul>"; 
        html+="         <li><font color=\"red\">Paso 1</font>: Revisar la vivienda: Lo m&aacute;s probable es que, quien se decide a comprar una vivienda, haya visitado decenas de pisos antes de encontrar el m&aacute;s adecuado. Por este motivo, estar&aacute; acostumbrado a comprobar el estado de ciertos aspectos del inmueble, como su estructura, si la instalaci&oacute;n de la luz y del gas est&aacute;n en buen estado y si los grifos funcionan de manera adecuada. Conviene asimismo medir las habitaciones, los pasillos y las terrazas para conocer si el tamaño del piso coincide con lo dicho por su propietario.\n</li>"; 
        html+="         <li><font color=\"red\">Paso 2</font>: Preguntar a los vecinos: Los detalles que puedan dar los vecinos tambi&eacute;n son importantes, as&iacute; que en una de las visitas se puede preguntar si hay alg&uacute;n problema en la escalera o en la propia vivienda que se quiere adquirir.\n</li>";
        html+="         <li><font color=\"red\">Paso 3</font>: Ir al Registro de la propiedad: En primer lugar hay que verificar que la calle, el n&uacute;mero y los metros cuadrados coinciden con lo que quiere vender el propietario. Despu&eacute;s conviene comprobar que el n&uacute;mero de titulares es el que ha declarado el vendedor.\n</li>";
        html+="         <li><font color=\"red\">Paso 4</font>: Consultar en la comunidad de propietarios: Otra de las comprobaciones que se debe hacer antes de adelantar el dinero es que el titular de la vivienda est&eacute; al corriente de los pagos a la comunidad de vecinos. Para ello, debe hablar con el administrador o con la junta de propietarios. De lo contrario, las deudas pueden recaer sobre el comprador del piso.\n</li>";
        html+="         <li><font color=\"red\">Paso 5</font>: Acudir al ayuntamiento: Cada año los propietarios de una vivienda tienen que abonar el Impuesto de Bienes Inmuebles, el IBI. Quien quiera adquirir un piso de segunda mano debe verificar que est&eacute; pagado. Puede hacerlo en el ayuntamiento o pedir al vendedor el &uacute;ltimo recibo.\n</li>";
        html+="         <li><font color=\"red\">Paso 6</font>: Hacer comprobaciones en el banco: Antes de pagar una señal por la vivienda, hay que estar seguros de que el banco conceder&aacute; la hipoteca. Si al final del proceso el interesado ha adelantado una fianza y no consigue el cr&eacute;dito para pagar la casa, el propietario est&aacute; en su derecho de quedarse con el dinero. Adem&aacute;s, debe consultar los pasos que debe seguir si la vivienda en venta tiene cargas. Una de las posibilidades es quitar la hipoteca en el momento de la compraventa y la otra, subrogarse a la hipoteca del titular.\n</li>";
        html+="         <li><font color=\"red\">Paso 7</font>: Informarse en la comunidad aut&oacute;noma: Al adquirir una vivienda de segunda mano, hay que pagar una serie de impuestos, como el de transmisiones patrimoniales y el de actos documentados. En total, los gastos de la compra pueden llegar al 10% del valor del piso. Ante esta elevada cuant&iacute;a, es muy importante consultar en la correspondiente comunidad aut&oacute;noma si el comprador puede obtener alg&uacute;n beneficio fiscal.\n</li>";
        html+="         </p>\n";
	html+="         <div style=\"float:right; padding:10px 15px 0 0;\">\n";
	html+="	  </div>\n";
      	html+="  </div>\n";
	html+=" </div>\n";//<!-- end of column four -->        		
	html+="</div>\n";//<!-- end of main_content -->
        return html;
    }
}
