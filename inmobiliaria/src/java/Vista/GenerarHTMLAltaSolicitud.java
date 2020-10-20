package Vista;

import Entidad.Barrio;
import Entidad.ClientePosible;
import Entidad.Garante;
import Entidad.Inmueble;
import Persistencia.AccesoBD;
import java.util.LinkedList;
//Vista de la secci&oacute;n de confirmar los datos de inmueble y cliente interesado para confirmar una nueva venta/alquiler 
public class GenerarHTMLAltaSolicitud extends GenerarHTMLGeneral{
    String fecha=null;
    private LinkedList<Garante> lisGar;

    public GenerarHTMLAltaSolicitud(){}
    
    public String generarHTMLMainContent (){
        String html="";
        html+="<div id=\"main_content\">\n";
        html+=  "<div id=\"admin_header\">\n";
      //html+=      "<div class=\"admin_editoffer_title\">Detalles de la Solicitud:</br><span>Fecha de la solicitud: "+fecha+"<span></div>\n";
        html+=      "<div class=\"admin_editoffer_title\">Detalles de la Solicitud:</br></div>\n";
        html+=      "<div id=\"admin_header_border\"></div>\n";
        html+=      "<p>&nbsp;</p>\n";
        html+=      "<p>&nbsp;</p>\n";
        html+=      "<p>&nbsp;</p>\n";
        html+=      "<p>&nbsp;</p>\n";
        html+=  "</div>\n";
        html+=  "<p>&nbsp;</p>\n";
        html+=  "<div id=\"admin_header_border\"></div>\n";
        return html;
    }

    public String generarHTMLAddTab(Long idClientePosible,AccesoBD abd){
        String condicionUno= "id=="+idClientePosible;
        ClientePosible CP = (ClientePosible)abd.buscarPorCond(new ClientePosible(),condicionUno);
        String condicionDos= "id=="+CP.getLeInteresa();
        Inmueble inm= (Inmueble)abd.buscarPorCond(new Inmueble(), condicionDos);
        String condicionTres="id=="+inm.getBarrio().getId();
        Barrio bar=(Barrio)abd.buscarPorCond(new Barrio(), condicionTres);
        String html="";
        html+="<div class=\"add_tab\">\n";
        html+=  "<div class=\"form_contact\">\n";
        html+=      "<form name=\"formAltaProp\" method=\"post\" action=\"AltaClienteReal.jsp\" onsubmit = \"return formularioGar(this)\">\n";
        html+=          "<fieldset style=\"border-color:#FFFFFF;\">\n";
        html+=              "<legend align=\"left\">Datos del cliente: </legend>";
        html+=              "<p>&nbsp;</p>\n";
        html+=              "<div class=\"adminform_row_contact\"><label class=\"adminleft\">Nombre:&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span>(*) </span> </label><input name=\"nombre\" type=\"text\" class=\"form_input_contact\" value=\""+CP.getNombre()+"\" readonly/><br/></div>\n";
        html+=              "<p>&nbsp;</p>\n";
        html+=              "<div class=\"adminform_row_contact\"><label class=\"adminleft\">Apellido:&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span>(*) </span> </label><input name=\"apellido\"  type=\"text\" class=\"form_input_contact\" value=\""+CP.getApellido()+"\" readonly/><br/></div>\n";
        html+=              "<p>&nbsp;</p>\n";
        html+=              "<div class=\"adminform_row_contact\"><label class=\"adminleft\">D.N.I:&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span>(*) </span> </label><input name=\"dni\"  type=\"text\" class=\"form_input_contact\" value=\""+CP.getDni()+"\" readonly/><br/></div>\n";
        html+=              "<input type=\"hidden\" name=\"idCP\" value=\""+idClientePosible+"\">\n";
        html+=              "<p>&nbsp;</p>\n";
        html+=              "<div class=\"adminform_row_contact\"><label class=\"adminleft\">Direcci&oacute;n:&nbsp;&nbsp;&nbsp;&nbsp<span>(*) </span> </label><input name=\"direccion\"  type=\"text\" class=\"form_input_contact\" value=\""+CP.getDirecc()+"\"readonly/></div>\n";
        html+=              "<input type=\"hidden\" name=\"idInm\" value=\""+inm.getId()+"\">\n";
        html+=              "<p>&nbsp;</p>\n";
        html+=              "<div class=\"adminform_row_contact\"><label class=\"adminleft\">Email:&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span>(*) </span> </label><input name=\"mail\"  type=\"text\" class=\"form_input_contact\" value=\""+CP.getEmail()+"\"readonly/><br/></div>\n";
        html+=              "<p>&nbsp;</p>\n";
        html+=              "<div class=\"adminform_row_contact\"><label class=\"adminleft\">Tel.Fijo:&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span>(*) </span> </label><input name=\"telFijo\"  type=\"text\" class=\"form_input_contact\" value=\""+CP.getTelFijo()+"\"/><br/><p>&nbsp;</p></div>\n";
        html+=              "<p>&nbsp;</p>\n";
        html+=              "<div class=\"adminform_row_contact\"><label class=\"adminleft\">Tel.M&oacute;vil:&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span>(*) </span> </label><input name=\"telMovil\"  type=\"text\" class=\"form_input_contact\" value=\""+CP.getTelMovil()+"\"/><br/><p>&nbsp;</p></div>\n";
        html+=              "<p>&nbsp;</p>\n";
        html+=              "<div class=\"adminform_row_contact\"><label class=\"adminleft\">Fecha.Nac:&nbsp;&nbsp;<span>(*) </span> </br>(dd/mm/aaaa)&nbsp;&nbsp;&nbsp; </label><input name=\"fechaNac\"  type=\"text\" class=\"form_input_contact\" value=\""+CP.getFechaNac().getDate()+"/"+(CP.getFechaNac().getMonth()+1)+"/"+(CP.getFechaNac().getYear()+1900)+"\"/><br/><p>&nbsp;</p></div>\n";
        html+=              "<p>&nbsp;</p>\n";
        html+=              "<div class=\"adminform_row_contact\"><label class=\"adminleft\">Localidad:&nbsp;&nbsp;&nbsp;&nbsp;<span>(*) </span> </label><input name=\"localidad\" type=\"text\" class=\"form_input_contact\" value=\""+CP.getLoc()+"\"readonly/><br/></div>\n";
        html+=              "<p>&nbsp;</p>\n";
        if (CP.getOperacion().equals("Comprar")){
            //input hidden para que la funcion formularioGar siempre tenga algo para comparar 
            html+=              "<div class=\"adminform_row_contact\"><label class=\"adminleft\"></label><input type=\"hidden\" name=\"GaranteAlquiler\" type=\"text\" class=\"form_input_contact\" value=\"\"readonly/><br/></div>\n";
            html+=          "</fieldset>\n";
        }
        if (CP.getOperacion().equals("Alquilar")){
            html+=          "<div class=\"adminform_row_contact\"><label class=\"adminleft\">Garante:&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span>(*) </span> </label>\n";
            html+=                  "<select id=\"selecGarante\" class=\"form_select\"  name=\"GaranteAlquiler\" onChange=\"selecGarantee()\">\n";
            html+=                      "<option select value=\"vacio\">--------------------------------------------------------</option>\n";
            lisGar=abd.listar(new Garante(),"");
            for(int i=0;i<=lisGar.size()-1;i++){        
                html+=                      "<option value=\""+lisGar.get(i).getId()+"\">"+lisGar.get(i).getApellido()+", "+lisGar.get(i).getNombre()+"</option>\n";
        }
        html+=                  "</select>\n";
        html+=          "</div>\n";//endAdminform_row_contact(Garante)  
        html+=          "</fieldset>\n";
        }
        html+=          "<p>&nbsp;</p>\n";
        html+=          "<p>&nbsp;</p>\n";
        html+=          "<fieldset style=\"border-color:#FFFFFF;\">\n";
        html+=              "<legend align=\"left\">Datos del inmueble: </legend>";
        html+=              "<p>&nbsp;</p>\n";
        html+=              "<p>&nbsp;</p>\n";
        html+=              "<div class=\"adminform_row_contact\"><label class=\"adminleft\">Operaci&oacute;n:&nbsp;&nbsp;&nbsp;&nbsp;<span>(*) </span> </label><input type=\"text\" name=\"operacionInmueble\"  class=\"form_input_contact\" value=\""+CP.getOperacion()+"\"readonly/></div>\n";
        html+=              "<p>&nbsp;</p>\n";
        html+=              "<div class=\"adminform_row_contact\"><label class=\"adminleft\">Precio:&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span>(*) </span> </label><input type=\"text\" name=\"precioInmueble\"  class=\"form_input_contact\" value=\""+inm.getPrecio()+"\"readonly/></div>\n";
        html+=              "<p>&nbsp;</p>\n";
        html+=              "<div class=\"adminform_row_contact\"><label class=\"adminleft\">Barrio:&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span>(*) </span> </label><input type=\"text\" name=\"barrioInmueble\"  class=\"form_input_contact\" value=\""+bar.getNombre()+"\"readonly/></div>\n";
        html+=              "<p>&nbsp;</p>\n";
        html+=              "<div class=\"adminform_row_contact\"><label class=\"adminleft\">Ubicaci&oacute;n:&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span>(*) </span> </label><input type=\"text\" name=\"ubicacionInmueble\"  class=\"form_input_contact\" value=\""+inm.getDireccion()+"\" readonly/></div>\n";
        html+=              "<p>&nbsp;</p>\n";
        html+=              "<div class=\"adminform_row_contact\"><label class=\"adminleft\">Tipo:&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span>(*) </span> </label><input type=\"text\" name=\"tipoInmueble\"  class=\"form_input_contact\" value=\""+inm.getTipo()+"\" readonly/></div>\n";
        html+=              "<p>&nbsp;</p>\n";
        html+=              "<div class=\"adminform_row_contact\"><label class=\"adminleft\">Descripci&oacute;n:<span>(*)</span> </label> <p>&nbsp;</p><textarea name=\"descripcionInmueble\" rows=\"\" cols=\"\" readonly>"+inm.getDescripcion()+"</textarea></div>\n";
        html+=              "<p>&nbsp;</p>\n"; 
        html+=          "</fieldset>\n";
        html+=          "<p>&nbsp;</p>\n";    
        html+=          "<div style=\"float:right; padding:10px 25px 0 0;\">\n";
        html+=              "<div class=\"right_button\"><input onclick=\"return formularioGar(this)\" type=image value = sumit alt = sumit Button src=\"images/aceptar.png;\"onMouseOver=this.src=\"images/aceptar.png\" style=\"width:20px;\"></div>\n"; 
        html+=              "<div class=\"right_button\"><a href=\"Admin.jsp\" onclick=\"return confirm('Operacion Cancelada');\"><img src=\"images/cancelar.png\"style=\"width:20px\"> </a></div>\n";
        html+=          "</div>\n";
        html+=      "</form>\n";
        html+=  "</div>\n";//EndFormContact
        html+=  "<div class=\"admin_footer_help\">\n";
        html+=      "<p><span>&nbsp;&nbsp;&nbsp;&nbsp;(*)</span> Datos del cliente e inmueble respectivamente.</p>\n";
        html+=  "</div>\n";//EndAdmin_footer_help    
        html+="</div>\n";//EndAdd_tab
        html+="</div>\n";//endOfMain_content
        return html;
       
    }

}

