<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    //Cerrado de sesi&oacute;n
    session.setAttribute("username", null);
    session.setAttribute("conex",null);
    session.invalidate();
    response.sendRedirect("Index.jsp");
%>
