package Vista;
//Vista de formulario de nuevo garante
public class GenerarHTMLGarante extends GenerarHTMLGeneral{
    boolean finalizado;
    
    public GenerarHTMLGarante(){
        finalizado=false;
    }
    
    public String generarHTMLMainContent (){
        String html="";
        html+="<div id=\"main_content\">\n";
        html+=  "<div id=\"admin_header\">\n";
        html+=      "<div class=\"admin_editoffer_title\">Datos del Garante:</div>\n";
        html+=  "</div>\n";
        html+=  "<div id=\"admin_header_border\"></div>\n";
        return html;
    }

    public String generarHTMLAddTab(){
        String html="";
        html+="<div class=\"add_tab\">\n";
        html+=  "<div class=\"form_contact\">\n";
        html+=      "<div class=\"adminform_row_contact\"><label class=\"adminleft\">Nombre:&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span>(*) </span> </label><input type=\"text\" class=\"form_input_contact\" value=\"\"/><br/></div>\n";
        html+=      "<div class=\"adminform_row_contact\"><label class=\"adminleft\">Apellido:&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span>(*) </span> </label><input type=\"text\" class=\"form_input_contact\" value=\"\"/><br/></div>\n";
        html+=      "<div class=\"adminform_row_contact\"><label class=\"adminleft\">Edad:&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span>(*) </span> </label><input type=\"text\" class=\"form_input_contact\" value=\"\"/><br/></div>\n";
        html+=      "<div class=\"adminform_row_contact\"><label class=\"adminleft\">D.N.I:&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span>(*) </span> </label><input type=\"text\" class=\"form_input_contact\" value=\"\"/><br/></div>\n";
        html+=      "<div class=\"adminform_row_contact\"><label class=\"adminleft\">Direcci&oacute;n:&nbsp;&nbsp;&nbsp<span>(*) </span> </label><input type=\"text\" class=\"form_input_contact\" value=\"\"/></div>\n";
        html+=      "<div class=\"adminform_row_contact\"><label class=\"adminleft\">Profeci&oacute;n:&nbsp;&nbsp;&nbsp<span>(*) </span> </label><input type=\"text\" class=\"form_input_contact\" value=\"\"/></div>\n";
        html+=      "<div class=\"adminform_row_contact\"><label class=\"adminleft\">Lugar de &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; Trabajo:&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span>(*) </span> </label><input type=\"text\" class=\"form_input_contact\" value=\"\"/></div>\n";
        html+=      "<div class=\"adminform_row_contact\"><label class=\"adminleft\">Fecha &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; </br>Nacimiento:<span>(*) </span> </label><input type=\"text\" class=\"form_input_contact\" value=\"\"/><br/></div>\n";
        html+=      "<div class=\"adminform_row_contact\"><label class=\"adminleft\">Nacionalidad: &nbsp;&nbsp;&nbsp;&nbsp;&nbsp; </label><input type=\"text\" class=\"form_input_contact\" value=\"\"/><br/></div>\n";
        html+=      "<div class=\"adminform_row_contact\"><label class=\"adminleft\">Recibo &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; Sueldo&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span>(*) </span>: </label><input type=\"file\" class=\"form_input_contact\"/></div>\n";
        html+=      "<div class=\"adminform_row_contact\"><label class=\"adminleft\">Impuestos<span>(*) </span>: </label><input type=\"file\" class=\"form_input_contact\"/></div>\n";
        html+=      "<div class=\"adminform_row_contact\"><label class=\"adminleft\">Propiedad/es<span>(*) </span>: </label><input type=\"file\" class=\"form_input_contact\"/></div>\n";
        html+=      "<div class=\"adminform_row_contact\"><label class=\"adminleft\">Aclaraci&oacute;n: &nbsp;&nbsp;&nbsp </label><textarea name=\"\" rows=\"\" cols=\"\" ></textarea></div>\n";
        html+=      "<div style=\"float:right; padding:10px 25px 0 0;\">\n";
        html+=          "<div class=\"right_button\"><a href=\"#\">Guardar</a></div>\n";
        html+=          "<div class=\"right_button\"><a href=\"#\">Cancelar</a></div>\n";
        html+=      "</div>\n";
        html+=  "</div>\n";//EndFormContact
        html+=  "<div class=\"admin_footer_help\">\n";
        html+=      "<p><span>&nbsp;&nbsp;&nbsp;&nbsp;(*)</span> Campos requeridos para editar y/o modificar una propiedad.</p>\n";
        html+=  "</div>\n";//EndAdmin_footer_help    
        html+= "</div>\n";//EndAdd_tab
        html+="</div>\n";//endOfMain_content
        return html;
    }
}