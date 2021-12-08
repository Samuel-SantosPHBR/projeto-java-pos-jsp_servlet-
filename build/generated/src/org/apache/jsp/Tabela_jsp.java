package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import Classe.ClienteDAO;
import Classe.Conexao;

public final class Tabela_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public java.util.List<String> getDependants() {
    return _jspx_dependants;
  }

  public void _jspService(HttpServletRequest request, HttpServletResponse response)
        throws java.io.IOException, ServletException {

    PageContext pageContext = null;
    HttpSession session = null;
    ServletContext application = null;
    ServletConfig config = null;
    JspWriter out = null;
    Object page = this;
    JspWriter _jspx_out = null;
    PageContext _jspx_page_context = null;

    try {
      response.setContentType("text/html;charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;
      _jspx_resourceInjector = (org.glassfish.jsp.api.ResourceInjector) application.getAttribute("com.sun.appserv.jsp.resource.injector");

      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <link rel=\"stylesheet\" type=\"text/css\" href=\"Boos/node_modules/bootstrap/dist/css/bootstrap.css\">\n");
      out.write("        <title>JSP Page</title>\n");
      out.write("        \n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("        <nav class=\"navbar navbar-expand-lg navbar navbar-dark bg-dark\">\n");
      out.write("            <div class=\"container\"><a class=\"navbar-brand\" href=\"#\">Projeto</a>\n");
      out.write("                <button class=\"navbar-toggler\" type=\"button\" data-toggle=\"collapse\" data-target=\"#navbarNav\" aria-controls=\"navbarNav\" aria-expanded=\"false\" aria-label=\"Toggle navigation\">\n");
      out.write("                    <span class=\"navbar-toggler-icon\"></span>\n");
      out.write("\t\t</button>\n");
      out.write("\t\t<div class=\"collapse navbar-collapse\" id=\"navbarNav\">\n");
      out.write("                    <ul class=\"navbar-nav\">\n");
      out.write("\t\t\t<li class=\"nav-item\">\n");
      out.write("\t\t\t    <a class=\"nav-link\" href=\"index.html\">Home</a>\n");
      out.write("\t\t\t</li>\n");
      out.write("\t\t\t<li class=\"nav-item\">\n");
      out.write("\t\t\t    <a class=\"nav-link\" href=\"CadastroCliente.jsp\">Adicionar Usuarios</a>\n");
      out.write("\t\t\t</li>\n");
      out.write("\t\t\t<li class=\"nav-item active\">\n");
      out.write("\t\t\t    <a class=\"nav-link\" href=\"Tabela.jsp\">Ver Tabela<span class=\"sr-only\">(current)</span></a>\n");
      out.write("\t\t\t</li>\n");
      out.write("                    </ul>\n");
      out.write("\t\t</div>\n");
      out.write("\t\t  <div>\n");
      out.write("\t\t</nav>\n");
      out.write("        \n");
      out.write("        \n");
      out.write("        ");

            ClienteDAO dao = new ClienteDAO();
            dao.listagemJSP();
        
      out.write("\n");
      out.write("    </body>\n");
      out.write("</html>\n");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          out.clearBuffer();
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
