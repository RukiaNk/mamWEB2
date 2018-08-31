/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author ananicole
 */
@WebServlet(urlPatterns = {"/PortalServlet"})
public class PortalServlet extends HttpServlet {
    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        response.setContentType("text/html;charset=UTF-8");
        
        HttpSession session = request.getSession(false);
       
        List<Usuario> lista = ProjectDao.getUsuarios();
        
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            if (session != null) {
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Formulario</title>");            
            out.println("<link href=\"resources/bootstrap/dist/css/bootstrap.min.css\" rel=\"stylesheet\">\n" +
"<link rel=\"stylesheet\" href=\"resources/bootstrap/dist/css/bootstrap-reboot.min.css\" type=\"text/css\"/>\n" +
"</head>");
            out.println("<body>");
            out.println("<div class=\"container\" style=\"width: 400px; margin: 100px;\">");
            out.println("<form action=\"CadastrarUsuarioServlet\" method=\"POST\">");
            out.println("<div class=\"form-group\">");
            out.println("<label for=\"nome\">Nome</label>");
            out.println("<input type=\"text\" class=\"form-control\" id=\"nome\" placeholder=\"Nome\" name=\"nome\">");
            out.println("</div>");
            out.println("<div class=\"form-group\">");
            out.println("<label for=\"login\">Login</label>");
            out.println("<input type=\"text\" class=\"form-control\" id=\"login\" placeholder=\"Login\" name=\"login\">");
            out.println("</div>");
            out.println("<div class=\"form-group\">");
            out.println("<label for=\"senha\">Senha</label>");
            out.println("<input type=\"password\" class=\"form-control\" id=\"senha\" placeholder=\"Senha\" name=\"senha\">");
            out.println("</div>");
            out.println("<div>");
            out.println("<a href= \"CadastrarUsuarioServlet\" type=\"button\"  class=\"btn btn-success\" name=\"salvar\">Salvar</a>");
            out.println("<a href= \"LogoutServlet\" type=\"button\"  class=\"btn btn-danger\" name=\"deslogar\" >Sair</a>");
            out.println("</div></div>");
            out.println("</form>");
            out.println("<div class=\"container\" style=\"width: 1000px; margin: 100px;\"><table class=\"table table-striped\">");
            out.println("<thead>" +"<tr>" + "<th>Nome</th>" + "<th>Login</th>" +"<th>Senha</th>"+"</tr>"+"</thead>"+"<tbody>");           
            for(Usuario cd : lista){
                out.println("<tr>" +"<td>"+ cd.getNome()+"</td>");
                out.println("<td>"+ cd.getLogin()+"</td>");
                out.println("<td>"+ cd.getSenha()+"</td></tr>");
            }
            out.println("</tbody></table></div>");
          
            out.println("</body>");
            out.println("</html>");
            
            
                }else{
                    request.setAttribute("errorMessage", "No session.");
                    request.setAttribute("page", "PortalServlet.java");
                    request.getRequestDispatcher("ErroServlet").forward(
                    request, response);
            }       
        }   
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}