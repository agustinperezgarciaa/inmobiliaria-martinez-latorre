package Vista;
import Entidad.Administrador;
import java.util.LinkedList;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import Persistencia.AccesoBD;

//Vista de la secci&oacute;n gestionar administrador
public class GestionarAdministrador {
    String nameClass="even";
    private LinkedList<Administrador> lisAdmin;
    String valorSelect;  
    
    public String GestionarAdministrador(AccesoBD abd,HttpServletRequest request,HttpSession session) throws Exception{
        String html="";
        html =listarTablaAdmin(abd,request,session);
        valorSelect=(String)request.getParameter("selecAdministrador");
        if("AA".equals(valorSelect)){
            html=altaAdmin(); 
        }
        if ("LA".equals(valorSelect)){
            html=listarTablaAdmin(abd,request,session);
        }
        return html;
    }
    
    private  String listarTablaAdmin(AccesoBD abd,HttpServletRequest request,HttpSession session){
        String html="";
        try{ 
            html+="<form  name=\"FormularioEditarAdministrador\" id=\"FormAdminEdit\" method=\"post\" action=\"ModificarAdministrador.jsp\">\n";
            html+=  "<input type=\"hidden\" id=\"editAdmin\" name=\"editarAdministrador\" value=\"\">\n";                           //Input para el Editar
            html+="</form>\n";
            html+="<form  name=\"FormularioEliminarAdministrador\" id=\"FormAdminElim\" method=\"post\" action=\"BajaAdministrador.jsp\">\n";
            html+=  "<input type=\"hidden\" id=\"elimAdmin\" name=\"eliminarAdministrador\" value=\"\">\n";                         //Input para el Eliminar
            html+="</form>\n";   
            lisAdmin=abd.listar(new Administrador(),"");
        }catch(Exception e){
            e.printStackTrace();
        }
        html+=      "<div class=\"table_grid\">\n";
        html+=          "<table  cellspacing=\"0\"   cellpadding=\"0\">\n";
        html+=              "<tr>\n";
	html+=                  "<th style=\"width:20px;\">ID</th>\n";
	html+=                  "<th style=\"width:50px;\">Nombre y Apellido</th>\n";
	html+=                  "<th style=\"width:30px;\">Usuario</th>\n";
	html+=                  "<th style=\"width:50;\">Tel. Movil y Fijo</th>\n";
	html+=                  "<th style=\"width:10;\">Direcci&oacute;n</th>\n";
	html+=                  "<th style=\"width:30;\">Fecha Nac.</th>\n";
	html+=                  "<th style=\"width:10;\">Email</th>\n";
	html+=                  "<th style=\"width:10;\">Localidad</th>\n";
        html+=                  "<th style=\"width:1;\">Editar</th>\n";
	html+=                  "<th style=\"width:1;\">Eliminar</th>\n";
        html+=              "</tr>\n";
        for (int i=0;i<=lisAdmin.size()-1;i++){
            html+=          "<tr class= "+nameClass+">\n";
            html+=              "<td><center> "+lisAdmin.get(i).getId()+" </center></td>\n";
            html+=              "<td><center>"+lisAdmin.get(i).getNombre()+" "+lisAdmin.get(i).getApellido() +" </center></td>\n";
            html+=              "<td><center>"+lisAdmin.get(i).getUsuario()+"</center> </td>\n"; 
            html+=              "<td><center>"+lisAdmin.get(i).getTelMovil()+" - "+lisAdmin.get(i).getTelFijo()+ "</center></td>\n";
            html+=              "<td><center>"+lisAdmin.get(i).getDirecc()+"</center></td>\n";
            html+=              "<td><center>"+lisAdmin.get(i).getFechaNac().getDate()+"/"+(lisAdmin.get(i).getFechaNac().getMonth()+1)+"/"+(lisAdmin.get(i).getFechaNac().getYear()+1900)+"</center></td>\n";
            html+=              "<td><center>"+lisAdmin.get(i).getEmail()+"</center></td>\n";
            html+=              "<td><center>"+lisAdmin.get(i).getLoc()+"</center></td>\n";
            html+=              "<td><center><input type=image value = sumit alt = sumit Button src=\"images/adminicons/edit.png\" onMouseOver=this.src=\"images/adminicons/edit.png\" onclick=\"editAdministrador("+lisAdmin.get(i).getId()+");\" width=\"22\" height=\"22\" border=\"0\"></center></td>\n"; 
            html+=              "<td><center><input type=image value = sumit alt = sumit Button src=\"images/adminicons/delete.png\" onMouseOver=this.src=\"images/adminicons/delete.png\" onclick=\"elimAdministrador("+lisAdmin.get(i).getId()+");\" width=\"22\" height=\"22\" border=\"0\"></center></td>\n"; 
            html+=          "</tr>\n";
            if(nameClass.compareTo("even")==0){
                nameClass="odd";
            }else if(nameClass.compareTo("odd")==0){
                nameClass="even";
            }
        }//endFor
        html+=      "</table>\n";//line49
        html+="	  <p>&nbsp;</p>\n";
        html+="	  <p>&nbsp;</p>\n";
        html+="	  <p>&nbsp;</p>\n";
        html+=  "</div>\n";//endTable_grid
        return html;
    } 
    
    private String altaAdmin(){
        String html="";
        html+="<div class=\"add_tab\">\n";
        html+=  "<div class=\"form_contact\">\n";
        html+=      "<form name=\"formAltaAdministrador\" method=\"post\" id=\"formAltaAdministrador\" action=\"AltaAdministrador.jsp\" onsubmit=\"return formularioAdmin(this)\" >\n";
        html+=          "<div class=\"adminform_row_contact\"><label class=\"adminleft\">Nombre:&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span>(*) </span> </label><input name=\"nombre\" type=\"text\" class=\"form_input_contact\" value=\"\"/><br/></div><p>&nbsp;</p>\n";
        html+=          "<div class=\"adminform_row_contact\"><label class=\"adminleft\">Apellido:&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span>(*) </span> </label><input name=\"apellido\"  type=\"text\" class=\"form_input_contact\" value=\"\"/><br/></div><p>&nbsp;</p>\n";
        html+=          "<div class=\"adminform_row_contact\"><label class=\"adminleft\">D.N.I:&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span>(*) </span> </label><input name=\"dni\"  type=\"text\" class=\"form_input_contact\" value=\"\"/><br/></div><p>&nbsp;</p>\n";
        html+=          "<div class=\"adminform_row_contact\"><label class=\"adminleft\">Direcci&oacute;n:&nbsp;&nbsp;&nbsp;&nbsp<span>(*) </span>  </label><input name=\"direccion\"  type=\"text\" class=\"form_input_contact\" value=\"\"/></div><p>&nbsp;</p>\n";
        html+=          "<div class=\"adminform_row_contact\"><label class=\"adminleft\">Pag.Web:&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span>(*) </span> </label><input name=\"paginaWeb\"  type=\"text\" class=\"form_input_contact\" value=\"\"/></div><p>&nbsp;</p>\n";
        html+=          "<div class=\"adminform_row_contact\"><label class=\"adminleft\">Usuario:&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span>(*) </span> </label><input name=\"usuario\"  type=\"text\" class=\"form_input_contact\" value=\"\"/></div><p>&nbsp;</p>\n";
        html+=          "<div class=\"adminform_row_contact\"><label class=\"adminleft\">Email:&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span>(*) </span> </label><input name=\"mail\"  type=\"text\" class=\"form_input_contact\" value=\"\"/><br/></div><p>&nbsp;</p>\n";
        html+=          "<div class=\"adminform_row_contact\"><label class=\"adminleft\">Tel.Fijo:&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; </label><input name=\"telFijo\"  type=\"text\" class=\"form_input_contact\" value=\"\"/><br/></div><p>&nbsp;</p>\n";
        html+=          "<div class=\"adminform_row_contact\"><label class=\"adminleft\">Tel.M&oacute;vil:&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span>(*) </span> </label><input name=\"telMovil\"  type=\"text\" class=\"form_input_contact\" value=\"\"/><br/></div><p>&nbsp;</p>\n";
        html+=          "<div class=\"adminform_row_contact\"><label class=\"adminleft\">Fecha.Nac:&nbsp;&nbsp;<span>(*) </span> </br>(dd/mm/aaaa)&nbsp;&nbsp;&nbsp; </label><input name=\"fechaNac\"  type=\"text\" class=\"form_input_contact\" value=\"\"/><br/><p>&nbsp;</p></div>\n";
        html+=          "<div class=\"adminform_row_contact\"><label class=\"adminleft\">Localidad:&nbsp;&nbsp;&nbsp;&nbsp;<span>(*) </span> </label><input name=\"localidad\" type=\"text\" class=\"form_input_contact\" value=\"\"/><br/></div><p>&nbsp;</p>\n";
        html+=          "<div class=\"adminform_row_contact\"><label class=\"adminleft\">Contraseña:&nbsp;&nbsp;<span>(*) </span> </label><input name=\"passUno\"  type=\"password\" value=\"\" class=\"form_input_contact\"/></div><p>&nbsp;</p>\n";
        html+=          "<div class=\"adminform_row_contact\"><label class=\"adminleft\">Reenscribir&nbsp;&nbsp;&nbsp;<span>(*) </span>  </br>contraseña:&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</label><input name=\"passDos\" type=\"password\" value=\"\" class=\"form_input_contact\"/></div><p>&nbsp;</p>\n";
        html+=          "<div style=\"float:right; padding:10px 25px 0 0;\">\n";
        html+=          "<div class=\"right_button\"><input onclick=\"return formularioAdmin(this)\" type=image value = sumit alt = sumit Button src=\"images/aceptar.png;\"onMouseOver=this.src=\"images/aceptar.png\" style=\"width:20px;\"></div>\n"; 
        html+=          "<div class=\"right_button\"><a href=\"GestionarAdministrador.jsp\" onclick=\"return confirm('Operacion Cancelada');\"><img src=\"images/cancelar.png\"style=\"width:20px\"> </a></div><p>&nbsp;</p>\n";
        html+=          "</div>\n";
        html+=      "</form>\n";
        html+=  "</div>\n";//EndFormContact
        html+=  "<div class=\"admin_footer_help\" >\n";
        html+=      "<p><span>&nbsp;&nbsp;&nbsp;(*)</span> Campos requeridos para editar y/o modificar un administrador.</p>\n";
        html+=  "</div><p>&nbsp;</p>\n";//EndAdmin_footer_help    
        html+="</div>\n";//EndAdd_tab
        html+="	  <p>&nbsp;</p>\n";
        html+="	  <p>&nbsp;</p>\n";
        html+="	  <p>&nbsp;</p>\n";
        return html;
    }
}
