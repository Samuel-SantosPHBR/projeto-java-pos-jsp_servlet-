<%-- 
    Document   : index
    Created on : 08/12/2021, 22:41:38
    Author     : USER
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <form action="index.jsp">
            <br /><input type="text" name="usuario" /><br />
            <br /><input type="password" name="senha" /><br />
            <input type="submit" value="Logar" />
        </form>
        
        <%
            String usuario = request.getParameter("usuario");
            String senha = request.getParameter("senha");
                   
            if(usuario!=null && senha!=null && !usuario.isEmpty() && !senha.isEmpty()){
                session.setAttribute("usuario", usuario);
                response.sendRedirect("home.jsp");
            }
        %>
    </body>
</html>
