package Vista;

import Entidad.Propietario;
import java.util.LinkedList;
import javax.servlet.http.HttpServletRequest;
import Persistencia.AccesoBD;

//Vista de la secci&oacute;n gestionar propietario
public class GestionarPropietario {
    String nameClass="even";
    private LinkedList<Propietario> lisProp;
    String flag,valorSelect;    

   public String TablaGestionarPropietario(AccesoBD abd,HttpServletRequest request,String flag) throws Exception{
     String html="";
     this.flag=flag;
     html = listarTablaProp(abd,request);
     String  valorSelect=(String)request.getParameter("selecPropietario");
     if("AP".equals(valorSelect)){
        html=altaProp();
     }
     if ("LP".equals(valorSelect)){
        html=listarTablaProp(abd,request);
     }
     return html;
   }
    
    private  String listarTablaProp(AccesoBD abd,HttpServletRequest request){
        String html="";
        try{ 
            html+="<form  name=\"FormularioEditarPropietario\" id=\"FormPropEdit\" method=\"post\" action=\"ModificarPropietario.jsp\">\n";
            html+=  "<input type=\"hidden\" id=\"editProp\" name=\"editarPropietario\" value=\"\">\n";                           //Input para el Editar
            html+="</form>\n";
            html+="<form  name=\"FormularioEliminarPropietario\" id=\"FormPropElim\" method=\"post\" action=\"BajaPropietario.jsp\">\n";
            html+=  "<input type=\"hidden\" id=\"elimProp\" name=\"eliminarPropietario\" value=\"\">\n";                         //Input para el Eliminar
            html+="</form>\n";   
            lisProp=abd.listar(new Propietario(),"");
        }catch(Exception e){
            e.printStackTrace();
        }
        html+=  "<div class=\"table_grid\">\n";
        html+=      "<table  cellspacing=\"0\"   cellpadding=\"0\">\n";
        html+=          "<tr>\n";
	html+=              "<th style=\"width:20px;\">ID</th>\n";
	html+=              "<th style=\"width:100px;\">Nombre y Apellido</th>\n";
	html+=              "<th style=\"width:50;\">Tel. Movil y Fijo</th>\n";
	html+=              "<th style=\"width:100;\">Direcci&oacute;n</th>\n";
	html+=              "<th style=\"width:30;\">Fecha Nac.</th>\n";
	html+=              "<th style=\"width:100;\">Email</th>\n";
	html+=              "<th style=\"width:50;\">Localidad</th>\n";
        html+=              "<th style=\"width:1;\">Editar</th>\n";
	html+=              "<th style=\"width:1;\">Eliminar</th>\n";
        html+=          "</tr>\n";
        for (int i=0;i<=lisProp.size()-1;i++){
            html+=          "<tr class= "+nameClass+">\n";
            html+=              "<td><center> "+lisProp.get(i).getId()+" </center></td>\n";
            html+=              "<td><center>"+lisProp.get(i).getNombre()+" "+lisProp.get(i).getApellido() +" </center></td>\n";
            html+=              "<td><center>"+lisProp.get(i).getTelMovil()+" - "+lisProp.get(i).getTelFijo()+ "</center></td>\n";
            html+=              "<td><center>"+lisProp.get(i).getDirecc()+"</center></td>\n";
            html+=              "<td><center>"+lisProp.get(i).getFechaNac().getDate()+"/"+(lisProp.get(i).getFechaNac().getMonth()+1)+"/"+(lisProp.get(i).getFechaNac().getYear()+1900)+"</center></td>\n";
            html+=              "<td><center>"+lisProp.get(i).getEmail()+"</center></td>\n";
            html+=              "<td><center>"+lisProp.get(i).getLoc()+"</center></td>\n";
            html+=              "<td><center><input type=image value = sumit alt = sumit Button src=\"images/adminicons/edit.png\" onMouseOver=this.src=\"images/adminicons/edit.png\" onclick=\"editPropietario("+lisProp.get(i).getId()+");\" width=\"22\" height=\"22\" border=\"0\"></center></td>\n"; 
            html+=              "<td><center><input type=image value = sumit alt = sumit Button src=\"images/adminicons/delete.png\" onMouseOver=this.src=\"images/adminicons/delete.png\" onclick=\"elimPropietario("+lisProp.get(i).getId()+");\" width=\"22\" height=\"22\" border=\"0\"></center></td>\n"; 
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
    
    private String altaProp(){
        String html="";
        html+="<div class=\"add_tab\">\n";
        html+=  "<div class=\"form_contact\">\n";
        html+=      "<form name=\"formAltaProp\" method=\"post\" action=\"AltaPropietario.jsp\" onsubmit=\"return formularioProp(this)\">\n";
        html+=      "<input type=\"hidden\" name=\"bandera\" value="+flag+">";
        html+=      "<div class=\"adminform_row_contact\"><label class=\"adminleft\">Nombre:&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span>(*) </span> </label><input name=\"nombre\" type=\"text\" class=\"form_input_contact\" value=\"\"/><br/><p>&nbsp;</p></div>\n";
        html+=      "<div class=\"adminform_row_contact\"><label class=\"adminleft\">Apellido:&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span>(*) </span> </label><input name=\"apellido\"  type=\"text\" class=\"form_input_contact\" value=\"\"/><br/><p>&nbsp;</p></div>\n";
        html+=      "<div class=\"adminform_row_contact\"><label class=\"adminleft\">D.N.I:&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span>(*) </span> </label><input name=\"dni\"  type=\"text\" class=\"form_input_contact\" value=\"\"/><br/><p>&nbsp;</p></div>\n";
        html+=      "<div class=\"adminform_row_contact\"><label class=\"adminleft\">Direcci&oacute;n:&nbsp;&nbsp;&nbsp;&nbsp<span>(*) </span> </label><input name=\"direccion\"  type=\"text\" class=\"form_input_contact\" value=\"\"/></br><p>&nbsp;</p></div>\n";
        html+=      "<div class=\"adminform_row_contact\"><label class=\"adminleft\">Email:&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span>(*) </span> </label><input name=\"mail\"  type=\"text\" class=\"form_input_contact\" value=\"\"/><br/><p>&nbsp;</p></div>\n";
        html+=      "<div class=\"adminform_row_contact\"><label class=\"adminleft\">Tel.Fijo:&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</label><input name=\"telFijo\"  type=\"text\" class=\"form_input_contact\" value=\"\"/><br/><p>&nbsp;</p></div>\n";
        html+=      "<div class=\"adminform_row_contact\"><label class=\"adminleft\">Tel.M&oacute;vil:&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span>(*) </span> </label><input name=\"telMovil\"  type=\"text\" class=\"form_input_contact\" value=\"\"/><br/><p>&nbsp;</p></div>\n";
        html+=      "<div class=\"adminform_row_contact\"><label class=\"adminleft\">Fecha.Nac:&nbsp;&nbsp;<span>(*) </span> </br>(dd/mm/aaaa)&nbsp;&nbsp;&nbsp; </label><input name=\"fechaNac\"  type=\"text\" class=\"form_input_contact\" value=\"\"/><br/><p>&nbsp;</p></div>\n";
        html+=      "<div class=\"adminform_row_contact\"><label class=\"adminleft\">Localidad:&nbsp;&nbsp;&nbsp;&nbsp;<span>(*) </span> </label><input name=\"localidad\" type=\"text\" class=\"form_input_contact\" value=\"\"/><br/><p>&nbsp;</p></div>\n";
        html+=      "<div style=\"float:right; padding:10px 25px 0 0;\">\n";
        if(flag==null){
            html+=              "<div class=\"right_button\"><input onclick=\"return formularioProp(this)\" type=image value = sumit alt = sumit Button src=\"images/aceptar.png;\"onMouseOver=this.src=\"images/aceptar.png\" style=\"width:20px;\"></div>\n"; 
            html+=              "<div class=\"right_button\"><a href=\"GestionarPropietario.jsp\" onclick=\"return confirm('Operacion Cancelada');\"><img src=\"images/cancelar.png\"style=\"width:20px\"> </a></div>\n";
         }else if(flag!=null){
            //desde AltaAlq
            html+=      "<div class=\"right_button\"><input onClick=\"window.close();\" type=image value = sumit alt = sumit Button src=\"images/aceptar.png;\"onMouseOver=this.src=\"images/aceptar.png\" style=\"width:20px;\"></div>\n";
            html+=      "<div class=\"right_button\"><a href=\"javascript:history.back(1);\" onclick=\"return confirm('Operacion Cancelada');\"><img src=\"images/cancelar.png\"style=\"width:20px\"> </a></div>\n";
        }
        html+=      "<p>&nbsp;</p>\n";
        html+=      "</div>\n";
        html+=      "<p>&nbsp;</p>\n";
        html+=    "</form>\n";
        html+=  "</div>\n";//EndFormContact
        html+=  "<div class=\"admin_footer_help\">\n";
        html+=      "<p><span>&nbsp;&nbsp;&nbsp;&nbsp;(*)</span> Campos requeridos para editar y/o modificar un propietario.</p>\n";
        html+=  "</div>\n";//EndAdmin_footer_help    
        html+="</div>\n";//EndAdd_tab
        html+="	  <p>&nbsp;</p>\n";
        html+="	  <p>&nbsp;</p>\n";
        html+="	  <p>&nbsp;</p>\n";
        return html;
    }
}