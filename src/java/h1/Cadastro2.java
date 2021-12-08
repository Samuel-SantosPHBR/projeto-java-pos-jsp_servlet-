/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package h1;

import Classe.Cliente;
import Classe.ClienteDAO;
import Classe.Produto;
import Classe.ProdutoDAO;
import java.io.IOException;
import java.io.PrintWriter;
import static java.lang.Float.parseFloat;
import static java.lang.Integer.parseInt;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author professores.lapa
 */
@WebServlet(name = "Cadastro2", urlPatterns = {"/Cadastro2"})
public class Cadastro2 extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            
             // cria objetos da classe 
            ProdutoDAO dao = new ProdutoDAO();
            Produto c = new Produto();
            
            //atribui valores ao objeto da classe produto com os valores passado pelo post
            c.setQuantidade(parseInt(request.getParameter("quantidade")));
            c.setFornecedor(request.getParameter("fornecedor"));
            c.setTipo(request.getParameter("tipo"));
            c.setNome(request.getParameter("nome"));
            c.setValor(parseFloat(request.getParameter("valor")));
            
            //executa o comando adicionar presente  na classe ProdutoDAO e passa como parametro o cliente
            try {
                dao.adiciona(c);
            } catch (SQLException ex) {
                Logger.getLogger(Cadastro.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            response.sendRedirect("Tabela2.jsp");
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
