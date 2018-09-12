package com.ufpr.tads.web2.servlets;


import com.ufpr.tads.web2.dao.ProjectDao;
import java.io.IOException;
//import java.io.PrintWriter;

//import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
//import javax.servlet.http.HttpSession;

/**
 *
 * @author michellynk
 */
@WebServlet(urlPatterns = {"/LoginServlet"})
public class LoginServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request,HttpServletResponse response) 
    		throws ServletException, IOException {
        		request.getRequestDispatcher("index.html").forward(request, response);
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String n = request.getParameter("login");
        String p = request.getParameter("senha");

        if(ProjectDao.validaLogin(n, p)){
        	request.getSession().setAttribute("Name",n);
        	response.sendRedirect("PortalServlet");
        }
        else{
            request.setAttribute("errorMessage", "Invalid Credentials!");
            request.setAttribute("page", "index.html");
            request.getRequestDispatcher("ErroServlet").forward(
                    request, response);
        }

    }
}
