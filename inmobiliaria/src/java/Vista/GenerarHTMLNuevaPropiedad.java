package Vista;

//Vista de la secci&oacute;n de nuevo inmueble


import Entidad.Propietario;
import Persistencia.AccesoBD;
import java.util.LinkedList;

public class GenerarHTMLNuevaPropiedad extends GenerarHTMLGeneral{
    String flag;
    String hidden="hidden";
    private LinkedList<Propietario> lisProp;


    public GenerarHTMLNuevaPropiedad(String flag){
        this.flag=flag;
            if(flag==null){
            hidden="";
        }
    }
    
    public String generarHTMLMainContent (){
        String html="";
        html+="<div id=\"main_content\">\n";
        html+=  "<div id=\"admin_header\">\n";
        if(flag==null){
        html+=      "<div class=\"admin_editoffer_title\">Nuevo Inmueble</div>\n";
        }else
            if(flag!=null){
        html+=      "<div class=\"admin_editoffer_title\">Cree un nuevo Inmueble (luego de crearlo, debe rellenar los campos que habia ingresado anteriormente)</div>\n";
        }
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

    public String generarHTMLAddTab(AccesoBD abd){
        String html="";
        html+="<div class=\"add_tab\">\n";
        html+=  "<div class=\"form_contact\">\n";
        html+=      "<form  id=\"formularioAltaInmueble \"name=\"inmuebleNuevo\"  method=\"post\" action=\"AltaInmueble.jsp\" onsubmit=\"return formularioInm(this)\">";
        html+=      "<input type=\"hidden\" name=\"bandera\" value="+flag+">";
        html+=          "<div class=\"adminform_row_contact\"><label class=\"adminleft\">Direcci&oacute;n:&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span>(*)</span> </label><input type=\"text\" name=\"direccionInmueble\" class=\"form_input_contact\" value=\"\"/></div>\n";
        html+=          "<p>&nbsp;</p>\n";
        html+=          "<div class=\"adminform_row_contact\"><label class=\"adminleft\">Precio:&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span>(*) </span> </label><input type=\"text\" name=\"precioInmueble\"  class=\"form_input_contact\" value=\"\"/></div>\n";
        html+=          "<p>&nbsp;</p>\n";
        html+=          "<div class=\"adminform_row_contact\"><label class=\"adminleft\">Barrio:&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span>(*) </span> </label>\n";
        html+=                  "<select class=\"form_select\" name=\"barrio\">\n";
        html+=                      "<option select  value=\"vacio\">--------------------------------------------------------</option>\n";
        html+=                      "<option value=\"Alberdi\">Alberdi</option>\n";
        html+=                      "<option value=\"BandaNorte\">Banda Norte</option>\n";
        html+=                      "<option value=\"Macro-centro\">Macro-centro</option>\n";
        html+=                      "<option value=\"Micro-centro\">Micro-centro</option>\n";
        html+=                      "<option value=\"Golf\">Golf</option>\n";
        html+=                      "<option value=\"Bimaco\">Bimaco</option>\n";
        html+=                      "<option value=\"Fenix\">Fenix</option>\n";
        html+=                  "</select>\n";
        html+=          "</div>\n";//endadminform_row_contact(ubicacion)
        html+=          "<p>&nbsp;</p>\n";
        html+=          "<div class=\"adminform_row_contact\"><label class=\"adminleft\">Tipo:&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span>(*) </span> </label>\n";
        html+=                  "<select class=\"form_select\"  name=\"tipoInmueble\">\n";
        html+=                      "<option select value=\"vacio\">--------------------------------------------------------</option>\n";
        html+=                      "<option value=\"Departamento\">Departamento</option>\n";
        html+=                      "<option value=\"Casa\">Casa</option>\n";
        html+=                      "<option value=\"Oficina\">Oficina</option>\n";
        html+=                      "<option value=\"Local\">Local</option>\n";
        html+=                      "<option value=\"Salon\">Sal&oacute;n</option>\n";
        html+=                  "</select>\n";
        html+=          "</div>\n";//endAdminform_row_contact(inmueble)
        html+=          "<p>&nbsp;</p>\n";
        html+=          "<div class=\"adminform_row_contact\"><label class=\"adminleft\">Operaci&oacute;n:&nbsp;&nbsp;&nbsp;&nbsp;<span>(*) </span> </label>\n";
        html+=                  "<select class=\"form_select\"  name=\"operacionInmueble\">\n";
        html+=                      "<option select  value=\"vacio\">--------------------------------------------------------</option>\n";
        html+=                      "<option value=\"Alquilar\">Alquiler</option>\n";
        html+=                      "<option value=\"Comprar\">Venta</option>\n";
        html+=                  "</select>\n";
        html+=          "</div>\n";//endAdminform_row_contact(operacion)    
        html+=          "<p>&nbsp;</p>\n";
        html+=          "<div class=\"adminform_row_contact\"><label class=\"adminleft\">Disponibilidad:<span>(*) </span></label>\n";
        html+=                  "<select class=\"form_select\"  name=\"disponibilidadInmueble\">\n";
        html+=                      "<option select  value=\"vacio\">--------------------------------------------------------</option>\n";
        html+=                      "<option value=\"No Disponible\">No disponible</option>\n";
        html+=                      "<option value=\"Disponible\">Disponible</option>\n";
        html+=                  "</select>\n";
        html+=          "</div>\n";//endAdminform_row_contact(disponibilidad)    
        html+=          "<p>&nbsp;</p>\n";
        html+=          "<div class=\"adminform_row_contact\"><label class=\"adminleft\">Propietario:&nbsp;&nbsp;&nbsp;&nbsp;<span>(*) </span> </label>\n";
        html+=                  "<select id=\"selecPropietario\" class=\"form_select\"  name=\"propietarioInmueble\" onChange=\"selecPropietarioo()\">\n";
        html+=                      "<option "+hidden+"  select value=\"vacio\">--------------------------------------------------------</option>\n";
        html+=                      "<optgroup "+hidden+"  label=\" Asignar nuevo propietario:\">\n";
        html+=                          "<option "+hidden+"  value=\"nuevo\">Crear</option>\n";
        html+=                      "</optgroup>";
        html+=                          "<optgroup "+hidden+"  label=\" Seleccionar existente:\">\n";
        html+=                      "</optgroup>";
        lisProp=abd.listar(new Propietario(),"");
        for(int i=0;i<=lisProp.size()-1;i++){
            html+=                      "<option value=\""+lisProp.get(i).getId()+"\">"+lisProp.get(i).getApellido()+", "+lisProp.get(i).getNombre()+"</option>\n";
        }
        html+=                  "</select>\n";
        html+=          "</div>\n";//endAdminform_row_contact(Propietario)
        html+=          "<p>&nbsp;</p>\n";     

        html+=          "<div class=\"adminform_row_contact\"><label class=\"adminleft\"> <p align=\"left\">Imagen Administraci&oacute;n (54*40):&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span>(*)</span></p> </label><br/><input type=\"file\" name=\"imgAdministracion\" class=\"form_input_contact\"/></div>\n";
        html+=          "<div class=\"adminform_row_contact\"><label class=\"adminleft\"><p align=\"left\">Imagen buscador (175*150):&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span>(*)</span></p> </label><br/><input type=\"file\" name=\"imgBuscador\"value=\"\" class=\"form_input_contact\"/></div>\n";
        html+=          "<div class=\"adminform_row_contact\"><label class=\"adminleft\"><p align=\"left\">Imagen detalle (282*212):&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span>(*)</span></p> </label><br/><input type=\"file\" name=\"imgDetalleGrande\" value=\"\"class=\"form_input_contact\"/></div>\n";
        html+=          "<div class=\"adminform_row_contact\"><label class=\"adminleft\"><p align=\"left\">1-Imagen detalle (282*212):&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span>(*)</span></p> </label><br/><input type=\"file\" name=\"imgDetalle1\"value=\"\" class=\"form_input_contact\"/></div>\n";
        html+=          "<div class=\"adminform_row_contact\"><label class=\"adminleft\"><p align=\"left\">2-Imagen detalle (282*212):&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span>(*)</span></p> </label><br/><input type=\"file\" name=\"imgDetalle2\"value=\"\" class=\"form_input_contact\"/></div>\n";
        html+=          "<div class=\"adminform_row_contact\"><label class=\"adminleft\"><p align=\"left\">3-Imagen detalle (282*212):&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span>(*)</span></p> </label><br/><input type=\"file\" name=\"imgDetalle3\"value=\"\" class=\"form_input_contact\"/></div>\n";
        html+=          "<div class=\"adminform_row_contact\"><label class=\"adminleft\"><p align=\"left\">4-Imagen detalle (282*212):&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span>(*)</span></p> </label><br/><input type=\"file\" name=\"imgDetalle4\"value=\"\" class=\"form_input_contact\"/></div>\n";
        html+=          "<p>&nbsp;</p>\n";
        html+=          "<div class=\"adminform_row_contact\"><label class=\"adminleft\">Descripci&oacute;n:&nbsp;&nbsp;<span>(*)</span> </label><textarea name=\"descripcionInmueble\" rows=\"\" cols=\"\" ></textarea></div>\n";
        html+=          "<div style=\"float:right; padding:10px 25px 0 0;\">\n";       
        if(flag==null){
        html+=          "<div class=\"right_button\"><input onclick=\"return formularioInm(this)\" type=image value = sumit alt = sumit Button src=\"images/aceptar.png;\"onMouseOver=this.src=\"images/aceptar.png\" style=\"width:20px;\"></div>\n"; 
        html+=          "<div class=\"right_button\"><a href=\"Admin.jsp\" onclick=\"return confirm('Operacion Cancelada');\"><img src=\"images/cancelar.png\"style=\"width:20px\"> </a></div>\n";
         }else if(flag!=null){
            //desde AltaAlq
            html+=      "<div class=\"right_button\"><input onClick=\"window.close();\" type=image value = sumit alt = sumit Button src=\"images/aceptar.png;\"onMouseOver=this.src=\"images/aceptar.png\" style=\"width:20px;\"></div>\n";
            html+=      "<div class=\"right_button\"><a href=\"javascript:history.back(1);\" onclick=\"return confirm('Operacion Cancelada');\"><img src=\"images/cancelar.png\"style=\"width:20px\"> </a></div>\n";
        }
        html+=       "</div>\n";
        html+=    "</form>\n";
        html+=  "</div>\n";//EndFormContact
        html+=  "<p>&nbsp;</p><p>&nbsp;</p>\n";
        html+=  "<div class=\"admin_footer_help\">\n";
        html+=      "<p><span>&nbsp;&nbsp;&nbsp;&nbsp;(*)</span> Campos requeridos para agregar una propiedad.</p><p>&nbsp;&nbsp;&nbsp;&nbsp;El formato de una imagen debe ser .png.</p>\n";
        html+=  "</div>\n";//EndAdmin_footer_help    
        html+= "</div>\n";//EndAdd_tab
        html+="</div>\n";//endOfMain_content
        return html;
    }
    
    public String generarHTMLFooterIn(){ 
        String html="";  
        html+="<div "+hidden+" id=\"footer2\">\n";
        html+=  "<div "+hidden+" style= \"width:970px;\" \"height:41px;\" \"clear:both;\" \"font-size:11px;\" \"background-color:#f2efef;\" \"border-top:1px #eeabbd dashed;\" \"left: 21px;\" \"top: 1049px;\" \"margin-left:185px;\"";
        html+=      "<link rel=\"stylesheet\" type=\"text/css\" href=\"style.css\" />\n";
        html+=      "<div "+hidden+" id=\"copyright\">\n";
        html+=          "<div style=\"float:left; padding:3px;\"><a href=\"#\"><img src=\"images/logo.gif\" width=\"42\" height=\"35\" alt=\"\" title=\"\" border=\"0\" /></a></div>\n";
        html+=          "<div style=\"float:left; padding:14px 10px 10px 10px;\"> Martinez Latorrez &#38; Asoc. &copy; All Rights Reserved 2008 </div>\n";
        html+=          "<div style=\"float:right; padding:9px;\"><b> Contador de visitas:<align=\"right\"><a  target=\"_blank\"><img src=\"http://contadores.gratisparaweb.com/imagen.php?contador=15&id2=152645\" alt=\"Contadores\" width=\"35\" border=\"0\"></a><br><br><map name=\"Map\"><area shape=\"rect\" coords=\"48,1,90,22\" target=\"_blank\" alt=\"Cursos\"><area shape=\"rect\" coords=\"0,0,47,15\" href=\"http://contadores.gratisparaweb.com\" target=\"_blank\" ></map></a></div></b> </div>\n";
        html+=      "</div>\n";
        html+=  "</div>\n";
        html+="</html>\n";
    return html;        
    }

}



