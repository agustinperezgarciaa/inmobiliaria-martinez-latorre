package Vista;
//Vista de la secci&oacute;n de editor de inmueble
import Entidad.Inmueble;
import Entidad.Imagen;
import Entidad.Propietario;
import Persistencia.AccesoBD;
import java.util.LinkedList;

public class GenerarHTMLGesEditorInmueble extends GenerarHTMLGeneral{
    private LinkedList<Propietario> lisProp;

    public GenerarHTMLGesEditorInmueble(){}
    
public String generarHTMLMainContent (Inmueble inm, Imagen imag, Imagen imag2,Imagen imag3,Imagen imag4,Imagen imag5,Imagen imag6,Imagen imag7, AccesoBD abd){
        String html="";
        html+="<div id=\"main_content\">\n";
        html+=  "<div id=\"admin_header\">\n";
        html+=      "<div class=\"admin_editoffer_title\">Modificar inmueble</div>\n";
        html+=      "<form name=\"formInmueble\" method=\"post\" action=\"Admin.jsp\" >\n";        	
        html+=          "<div id=\"admin_header_border\"></div>\n";
        html+=          "<p>&nbsp;</p>\n";
        html+=          "<p>&nbsp;</p>\n";
        html+=          "<p>&nbsp;</p>\n";
        html+=          "<p>&nbsp;</p>\n";
        html+=      "</form>\n";
        html+=  "</div>\n";
        html+=  "<p>&nbsp;</p>\n";
        html+=  "<div id=\"admin_header_border\"></div>\n";
        html+=  "<div class=\"add_tab\">\n";
        html+=      "<div class=\"form_contact\" style= \"width: 400;\">\n";
        html+=          "<form name=\"formModInmueble\" method=\"post\" id=\"formModInm\" action=\"ConfirmarModificarInmueble.jsp\" onsubmit=\"return formularioEditInm(this)\">\n";
        html+=              "<div class=\"adminform_row_contact\"><label class=\"adminleft\">Direcci&oacute;n:&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span>(*)</span></label><input type=\"text\" name=\"direccionInmueble\" class=\"form_input_contact\" value=\""+inm.getDireccion()+"\"/></div>\n";
        html+=              "<p>&nbsp;</p>\n";
        html+=              "<div class=\"adminform_row_contact\"><label class=\"adminleft\">Precio:&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span>(*) </span></label><input type=\"text\" name=\"precioInmueble\"  class=\"form_input_contact\" value=\""+inm.getPrecio()+"\"/></div>\n";
        html+=              "<p>&nbsp;</p>\n";
        html+=              "<div class=\"adminform_row_contact\"><label class=\"adminleft\">Barrio:&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span>(*) </span> </label>\n";
        html+=                  "<select class=\"form_select\" name=\"barrio\">\n";
        html+=                      "<option select  value=\""+inm.getBarrio().getNombre()+"\">"+inm.getBarrio().getNombre()+"</option>\n";
        html+=                      "<option value=\"Alberdi\">Alberdi</option>\n";
        html+=                      "<option value=\"BandaNorte\">Banda Norte</option>\n";
        html+=                      "<option value=\"MacroCentro\">Macro-centro</option>\n";
        html+=                      "<option value=\"MicroCentro\">Micro-centro</option>\n";
        html+=                      "<option value=\"Golf\">Golf</option>\n";
        html+=                      "<option value=\"Bimaco\">Bimaco</option>\n";
        html+=                      "<option value=\"Fenix\">Fenix</option>\n";
        html+=                  "</select>\n";
        html+=              "</div>\n";//endadminform_row_contact(ubicacion)
        html+=              "<p>&nbsp;</p>\n";
        html+=              "<div class=\"adminform_row_contact\"><label class=\"adminleft\">Tipo:&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span>(*) </span></label>\n";
        html+=                  "<select class=\"form_select\"  name=\"tipoInmueble\">\n";
        html+=                      "<option select value=\""+inm.getTipo()+"\">"+inm.getTipo()+"</option>\n";
        html+=                      "<option value=\"Departamento\">Departamento</option>\n";
        html+=                      "<option value=\"Casa\">Casa</option>\n";
        html+=                      "<option value=\"Oficina\">Oficina</option>\n";
        html+=                      "<option value=\"Local\">Local</option>\n";
        html+=                      "<option value=\"Salon\">Sal&oacute;n</option>\n";
        html+=                  "</select>\n";
        html+=              "</div>\n";//endAdminform_row_contact(inmueble)
        html+=              "<p>&nbsp;</p>\n";
        html+=              "<div class=\"adminform_row_contact\"><label class=\"adminleft\">Operaci&oacute;n:&nbsp;&nbsp;&nbsp;&nbsp;<span>(*) </span></label>\n";
        html+=                  "<select class=\"form_select\"  name=\"operacionInmueble\">\n";
        html+=                      "<option select  value=\""+inm.getOperacion()+"\">"+inm.getOperacion()+"</option>\n";
        html+=                      "<option value=\"Alquiler\">Alquiler</option>\n";
        html+=                      "<option value=\"Venta\">Venta</option>\n";
        html+=                  "</select>\n";
        html+=              "</div>\n";//endAdminform_row_contact(operacion)    
        html+=              "<p>&nbsp;</p>\n";
        html+=              "<div class=\"adminform_row_contact\"><label class=\"adminleft\">Disponibilidad:<span>(*)</span></label>\n";
        html+=                  "<select class=\"form_select\"  name=\"disponibilidadInmueble\">\n";
        html+=                      "<option select  value=\""+inm.getDisp()+"\">"+inm.getDisp()+"</option>\n";
        html+=                      "<option value=\"No Disponible\">No Disponible</option>\n";
        html+=                      "<option value=\"Disponible\">Disponible</option>\n";
        html+=                  "</select>\n";
        html+=              "</div>\n";//endAdminform_row_contact(disponibilidad)    
        html+=              "<p>&nbsp;</p>\n"; 
        html+=          "<div class=\"adminform_row_contact\"><label class=\"adminleft\">Propietario:&nbsp;&nbsp;&nbsp;&nbsp;<span>(*) </span> </label>\n";
        html+=                  "<select id=\"selecPropietario\" class=\"form_select\"  name=\"propietarioInmueble\" onChange=\"selecPropietarioo()\">\n";
        html+=                      "<option select value=\""+inm.getOwner().getId()+"\">"+inm.getOwner().getApellido()+", "+inm.getOwner().getNombre()+"</option>\n";
        lisProp=abd.listar(new Propietario(),"");
        for(int i=0;i<=lisProp.size()-1;i++){
            html+=                      "<option value=\""+lisProp.get(i).getId()+"\">"+lisProp.get(i).getApellido()+", "+lisProp.get(i).getNombre()+"</option>\n";
        }
        html+=                  "</select>\n";
        html+=          "</div>\n";//endAdminform_row_contact(Propietario)
        html+=              "<div class=\"adminform_row_contact\"><label class=\"adminleft\"> <p align=\"left\">Imagen Administraci&oacute;n (54*40):&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span>(*)</span></p> </label><br/><input type=\"file\" name=\"imgAdministracion\" class=\"form_input_contact\"/></div>\n";
        html+=              "<p align=\"left\"> <img src="+imag.getPath()+" width=\"50\" height=\"50\" > Imagen administracion actual ("+imag.getPath()+")</p>" ;
        html+=              "<div class=\"adminform_row_contact\"><label class=\"adminleft\"><p align=\"left\">Imagen buscador (175*150):&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span>(*)</span></p> </label><br/><input type=\"file\" name=\"imgBuscador\"value=\"\" class=\"form_input_contact\"/></div>\n";
        html+=              "<p align=\"left\"> <img src="+imag2.getPath()+" width=\"50\" height=\"50\" > Imagen buscador actual ("+imag2.getPath()+")</p>" ;
        html+=              "<div class=\"adminform_row_contact\"><label class=\"adminleft\"><p align=\"left\">Imagen detalle (282*212):&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span>(*)</span></p> </label><br/><input type=\"file\" name=\"imgDetalleGrande\" value=\"\"class=\"form_input_contact\"/></div>\n";
        html+=              "<p align=\"left\"> <img src="+imag3.getPath()+" width=\"50\" height=\"50\" > Imagen detalle grande actual ("+imag3.getPath()+")</p>" ;
        html+=              "<div class=\"adminform_row_contact\"><label class=\"adminleft\"><p align=\"left\">1-Imagen detalle (282*212):&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span>(*)</span></p> </label><br/><input type=\"file\" name=\"imgDetalle1\"value=\"\" class=\"form_input_contact\"/></div>\n";
        html+=              "<p align=\"left\"> <img src="+imag4.getPath()+" width=\"50\" height=\"50\" > Imagen detalle1 actual ("+imag4.getPath()+")</p>" ;
        html+=              "<div class=\"adminform_row_contact\"><label class=\"adminleft\"><p align=\"left\">2-Imagen detalle (282*212):&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span>(*)</span></p> </label><br/><input type=\"file\" name=\"imgDetalle2\"value=\"\" class=\"form_input_contact\"/></div>\n";
        html+=              "<p align=\"left\"> <img src="+imag5.getPath()+" width=\"50\" height=\"50\" > Imagen detalle2 actual ("+imag5.getPath()+")</p>" ;
        html+=              "<div class=\"adminform_row_contact\"><label class=\"adminleft\"><p align=\"left\">3-Imagen detalle (282*212):&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span>(*)</span></p> </label><br/><input type=\"file\" name=\"imgDetalle3\"value=\"\" class=\"form_input_contact\"/></div>\n";
        html+=              "<p align=\"left\"> <img src="+imag6.getPath()+" width=\"50\" height=\"50\" > Imagen detalle3 actual ("+imag6.getPath()+")</p>" ;
        html+=              "<div class=\"adminform_row_contact\"><label class=\"adminleft\"><p align=\"left\">4-Imagen detalle (282*212):&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span>(*)</span></p> </label><br/><input type=\"file\" name=\"imgDetalle4\"value=\"\" class=\"form_input_contact\"/></div>\n";
        html+=              "<p align=\"left\"> <img src="+imag7.getPath()+" width=\"50\" height=\"50\" > Imagen detalle4 actual ("+imag7.getPath()+")</p>" ;

        html+=              "<p>&nbsp;</p>\n";
        html+=          "<div class=\"adminform_row_contact\"><label class=\"adminleft\">Descripci&oacute;n:&nbsp;&nbsp;<span>(*)</span> </label><textarea name=\"descripcionInmueble\" rows=\"\" cols=\"\" >"+inm.getDescripcion()+"</textarea></div>\n";
     //   html+=              "<div><label class=\"adminleft\">Descripci&oacute;n:&nbsp;&nbsp;&nbsp;&nbsp; <span>(*)</span> </span></label><textarea name=\"descripcionInmueble\"  rows=\"\" cols=\"\" >"+inm.getDescripcion()+"</textarea></div>\n";
        html+=              "<div><label class=\"adminleft\"></label><input name=\"id\" type=\"hidden\" class=\"form_input_contact\" value=\""+inm.getId()+"\"/></div>\n";
        html+=              "<div><label class=\"adminleft\"></label><input name=\"idI1\" type=\"hidden\" class=\"form_input_contact\" value=\""+imag.getId()+"\"/></div>\n";
        html+=              "<div><label class=\"adminleft\"></label><input name=\"idI2\" type=\"hidden\" class=\"form_input_contact\" value=\""+imag2.getId()+"\"/></div>\n";
        html+=              "<div><label class=\"adminleft\"></label><input name=\"idI3\" type=\"hidden\" class=\"form_input_contact\" value=\""+imag3.getId()+"\"/></div>\n";
        html+=              "<div><label class=\"adminleft\"></label><input name=\"idI4\" type=\"hidden\" class=\"form_input_contact\" value=\""+imag4.getId()+"\"/></div>\n";
        html+=              "<div><label class=\"adminleft\"></label><input name=\"idI5\" type=\"hidden\" class=\"form_input_contact\" value=\""+imag5.getId()+"\"/></div>\n";
        html+=              "<div><label class=\"adminleft\"></label><input name=\"idI6\" type=\"hidden\" class=\"form_input_contact\" value=\""+imag6.getId()+"\"/></div>\n";
        html+=              "<div class=\"adminform_row_contact\"><label class=\"adminleft\"></label><input name=\"idI7\" type=\"hidden\" class=\"form_input_contact\" value=\""+imag7.getId()+"\"/></div>\n";
        html+=              "<div style=\"float:right; padding:10px 25px 0 0;\">\n";       
        html+=              "<div class=\"right_button\"><input onclick=\"return formularioEditInm(this)\" type=image value = sumit alt = sumit Button src=\"images/aceptar.png;\"onMouseOver=this.src=\"images/aceptar.png\" style=\"width:20px;\"></div>\n"; 
        html+=              "<div class=\"right_button\"><a href=\"Admin.jsp\" onclick=\"return confirm('Operacion Cancelada');\"><img src=\"images/cancelar.png\"style=\"width:20px\"> </a></div>\n";
        html+=          "</div>\n";
        html+=      "</form>\n";
        html+=  "</form>\n";
        html+=  "</div>\n";//EndFormContact
        html+=  "<p>&nbsp;</p><p>&nbsp;</p>\n";
        html+=  "<div class=\"admin_footer_help\">\n";
        html+=      "<p><span>&nbsp;&nbsp;&nbsp;&nbsp;(*)</span> Reemplace en los campos que desea modificar los datos</p>\n";
        html+=  "</div>\n";//EndAdmin_footer_help    
        html+="</div>\n";//EndAdd_tab
        html+="</div>\n";//endOfMain_content
        return html;       
    }
}