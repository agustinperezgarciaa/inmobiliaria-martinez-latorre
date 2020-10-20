package Vista;

import Entidad.Garante;
import java.util.LinkedList;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import Persistencia.AccesoBD;

//Vista de la secci&oacute;n gestionar garante
public class GestionarGarante {
    String nameClass="even";
    private LinkedList<Garante> lisGar;
    String flag,valorSelect;

   public String TablaGestionarGarante(AccesoBD abd,HttpServletRequest request,HttpSession session, String flag) throws Exception{
      String html="";
      this.flag=flag;
      html = listarTablaGar(abd,request,session);
      String  valorSelect=(String)request.getParameter("selecGarante");
      if("AG".equals(valorSelect)){
            html=altaGar(); 
      }
      if ("LG".equals(valorSelect)){
            html=listarTablaGar(abd,request,session);
      }
      return html;
    }
    
    private  String listarTablaGar(AccesoBD abd,HttpServletRequest request,HttpSession session){
       String html="";
        try{ 
            html+="<form  name=\"FormularioEditarGarante\" id=\"FormGarEdit\" method=\"post\" action=\"ModificarGarante.jsp\">\n";
            html+=  "<input type=\"hidden\" id=\"editGar\" name=\"editarGarante\" value=\"\">\n";                           //Input para el Editar
            html+="</form>\n";   
            html+="<form  name=\"FormularioEliminarGarante\" id=\"FormGarElim\" method=\"post\" action=\"BajaGarante.jsp\">\n";
            html+=  "<input type=\"hidden\" id=\"elimGar\" name=\"eliminarGarante\" value=\"\">\n";                         //Input para el Eliminar
            html+="</form>\n";
            lisGar=abd.listar(new Garante(),"");
        }catch(Exception e){
            e.printStackTrace();
        }
        html+=  "<div class=\"table_grid\">\n";
        html+=      "<table  cellspacing=\"0\"   cellpadding=\"0\">\n";
        html+=          "<tr>\n";
	html+=              "<th style=\"width:20px;\">ID</th>\n";
	html+=              "<th style=\"width:150px;\">Nombre y Apellido</th>\n";
	html+=              "<th style=\"width:50;\">Tel. Movil y Fijo</th>\n";
	html+=              "<th style=\"width:100;\">Direcci&oacute;n</th>\n";
	html+=              "<th style=\"width:30;\">Fecha Nac.</th>\n";
	html+=              "<th style=\"width:100;\">Email</th>\n";
	html+=              "<th style=\"width:50;\">Localidad</th>\n";
        html+=              "<th style=\"width:50;\">Profesion</th>\n";
        html+=              "<th style=\"width:1;\">Editar</th>\n";
	html+=              "<th style=\"width:1;\">Eliminar</th>\n";
        html+=          "</tr>\n";
        for (int i=0;i<=lisGar.size()-1;i++){
            html+=          "<tr class= "+nameClass+">\n";
            html+=              "<td><center> "+lisGar.get(i).getId()+" </center></td>\n";
            html+=              "<td><center>"+lisGar.get(i).getNombre()+" "+lisGar.get(i).getApellido() +" </center></td>\n";
            html+=              "<td><center>"+lisGar.get(i).getTelMovil()+" - "+lisGar.get(i).getTelFijo()+ "</center></td>\n";
            html+=              "<td><center>"+lisGar.get(i).getDirecc()+"</center></td>\n";
            html+=              "<td><center>"+lisGar.get(i).getFechaNac().getDate()+"/"+(lisGar.get(i).getFechaNac().getMonth()+1)+"/"+(lisGar.get(i).getFechaNac().getYear()+1900)+"</center></td>\n";
            html+=              "<td><center>"+lisGar.get(i).getEmail()+"</center></td>\n";
            html+=              "<td><center>"+lisGar.get(i).getLoc()+"</center></td>\n";
            html+=              "<td><center>"+lisGar.get(i).getProfesion()+"</center></td>\n";
            html+=              "<td><center><input type=image value = sumit alt = sumit Button src=\"images/adminicons/edit.png\" onMouseOver=this.src=\"images/adminicons/edit.png\" onclick=\"editGarante("+lisGar.get(i).getId()+");\" width=\"22\" height=\"22\" border=\"0\"></center></td>\n"; 
            html+=              "<td><center><input type=image value = sumit alt = sumit Button src=\"images/adminicons/delete.png\" onMouseOver=this.src=\"images/adminicons/delete.png\" onclick=\"elimGarante("+lisGar.get(i).getId()+");\" width=\"22\" height=\"22\" border=\"0\"></center></td>\n"; 
            html+=          "</tr>\n";
            if(nameClass.compareTo("even")==0){
                nameClass="odd";
            }else if(nameClass.compareTo("odd")==0){
                nameClass="even";
            }
        }//endFor
        html+=      "</table>\n";//line49
        html+=  "</div>\n";//endTable_grid
        html+="	  <p>&nbsp;</p>\n";
        html+="	  <p>&nbsp;</p>\n";
        html+="	  <p>&nbsp;</p>\n";
        return html;
    } 
    
    private String altaGar(){
        String html="";
        html+="<div class=\"add_tab\">\n";
        html+=  "<div class=\"form_contact\">\n";
        html+=      "<form name=\"formAltaGar\" method=\"post\" action=\"AltaGarante.jsp\" onsubmit=\"return formularioGara(this)\" >\n";    
        html+=          "<input type=\"hidden\" name=\"bandera\" value="+flag+">";
        html+=          "<div class=\"adminform_row_contact\"><label class=\"adminleft\">Nombre:&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span>(*) </span> </label><input name=\"nombre\" type=\"text\" class=\"form_input_contact\" value=\"\"/><br/><p>&nbsp;</p></div>\n";
        html+=          "<div class=\"adminform_row_contact\"><label class=\"adminleft\">Apellido:&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span>(*) </span> </label><input name=\"apellido\"  type=\"text\" class=\"form_input_contact\" value=\"\"/><br/><p>&nbsp;</p></div>\n";
        html+=          "<div class=\"adminform_row_contact\"><label class=\"adminleft\">D.N.I:&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span>(*) </span> </label><input name=\"dni\"  type=\"text\" class=\"form_input_contact\" value=\"\"/><br/><p>&nbsp;</p></div>\n";
        html+=          "<div class=\"adminform_row_contact\"><label class=\"adminleft\">Direcci&oacute;n:&nbsp;&nbsp;&nbsp;&nbsp<span>(*) </span> </label><input name=\"direccion\"  type=\"text\" class=\"form_input_contact\" value=\"\"/><br/><p>&nbsp;</p></div>\n";
        html+=          "<div class=\"adminform_row_contact\"><label class=\"adminleft\">Email:&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span>(*) </span> </label><input name=\"mail\"  type=\"text\" class=\"form_input_contact\" value=\"\"/><br/><p>&nbsp;</p></div>\n";
        html+=          "<div class=\"adminform_row_contact\"><label class=\"adminleft\">Tel.Fijo:&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</label><input name=\"telFijo\"  type=\"text\" class=\"form_input_contact\" value=\"\"/><br/><p>&nbsp;</p></div>\n";
        html+=          "<div class=\"adminform_row_contact\"><label class=\"adminleft\">Tel.M&oacute;vil:&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span>(*) </span></label><input name=\"telMovil\"  type=\"text\" class=\"form_input_contact\" value=\"\"/><br/><p>&nbsp;</p></div>\n";
        html+=          "<div class=\"adminform_row_contact\"><label class=\"adminleft\">Fecha.Nac:&nbsp;&nbsp;<span>(*) </span> </br>(dd/mm/aaaa)&nbsp;&nbsp;&nbsp; </label><input name=\"fechaNac\"  type=\"text\" class=\"form_input_contact\" value=\"\"/><br/><p>&nbsp;</p></div>\n";
        html+=          "<div class=\"adminform_row_contact\"><label class=\"adminleft\">Localidad:&nbsp;&nbsp;&nbsp;&nbsp;<span>(*) </span> </label><input name=\"localidad\" type=\"text\" class=\"form_input_contact\" value=\"\"/><br/><p>&nbsp;</p></div>\n";
        html+=          "<div class=\"adminform_row_contact\"><label class=\"adminleft\">Profesion:&nbsp;&nbsp;&nbsp;&nbsp;<span>(*) </span> </label><input name=\"profesion\" type=\"text\" class=\"form_input_contact\" value=\"\"/><br/><p>&nbsp;</p></div>\n";
        html+=          "<div class=\"adminform_row_contact\"><label class=\"adminleft\">Trabaja&nbsp;en:&nbsp;&nbsp;&nbsp;<span>(*) </span></label><input name=\"lugarTrabajo\" type=\"text\" class=\"form_input_contact\" value=\"\"/><br/><p>&nbsp;</p></div>\n";
        html+=          "<div class=\"adminform_row_contact\"><label class=\"adminleft\">Nacionalidad:&nbsp;<span>(*) </span> </label><input name=\"nacionalidad\" type=\"text\" class=\"form_input_contact\" value=\"\"/><br/><p>&nbsp;</p></div>\n";
        html+=          "<div style=\"float:right; padding:10px 25px 0 0;\">\n";
        if (flag==null){
            html+=      "<div class=\"right_button\"><input onclick=\"return formularioGara(this)\" type=image value = sumit alt = sumit Button src=\"images/aceptar.png;\"onMouseOver=this.src=\"images/aceptar.png\" style=\"width:20px;\"></div>\n"; 
            html+=      "<div class=\"right_button\"><a href=\"GestionarGarante.jsp\" onclick=\"return confirm('Operacion Cancelada');\"><img src=\"images/cancelar.png\"style=\"width:20px\"> </a></div>\n";
         }else if(flag!=null){
            //desde AltaAlq
            html+=      "<div class=\"right_button\"><input onClick=\"window.close();\" type=image value = sumit alt = sumit Button src=\"images/aceptar.png;\"onMouseOver=this.src=\"images/aceptar.png\" style=\"width:20px;\"></div>\n";
            html+=      "<div class=\"right_button\"><a href=\"javascript:history.back(1);\" onclick=\"return confirm('Operacion Cancelada');\"><img src=\"images/cancelar.png\"style=\"width:20px\"> </a></div>\n";
        }
        html+=      "</div>\n";
        html+=    "</form>\n";
        html+=  "</div>\n";//EndFormContact
        html+=  "<div class=\"admin_footer_help\">\n";
        html+=      "<p><span>&nbsp;&nbsp;&nbsp;&nbsp;(*)</span> Campos requeridos para ingresar y/o modificar un garante.</p>\n";
        html+=  "</div>\n";//EndAdmin_footer_help    
        html+="</div>\n";//EndAdd_tab
        html+="	  <p>&nbsp;</p>\n";
        html+="	  <p>&nbsp;</p>\n";
        html+="	  <p>&nbsp;</p>\n";
        return html;
    }
}
