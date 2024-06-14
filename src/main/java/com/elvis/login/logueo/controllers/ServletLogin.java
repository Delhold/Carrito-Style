package com.elvis.login.logueo.controllers;

import com.elvis.login.logueo.services.LoginService;
import com.elvis.login.logueo.services.LoginServiceImplement;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Optional;

//creamos el Path para la conexión al Servlet
@WebServlet({"/Login", "/ServletLogin"})

public class ServletLogin extends HttpServlet {
    final static String USERNAME = "admin";
    final static String PASSWORD = "1234";

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        LoginService auth = new LoginServiceImplement();
        Optional<String> usernameOptional = auth.getUserName(req);
        if (usernameOptional.isPresent()) {
            resp.setContentType("text/html;charset=UTF-8");
            try (PrintWriter out = resp.getWriter()) {
                out.print("<!DOCTYPE html>");
                out.print("<html>");
                out.print("<head>");
                out.print("<meta charset=\"UTF-8\">");
                out.print("<title>Hola "+ usernameOptional.get() + "</title>");
                out.println("<style>");
                out.println("body {");
                out.println("    font-family: Arial, sans-serif;");
                out.println("    background-color: #f2f2f2;");
                out.println("    margin: 0;");
                out.println("    padding: 0;");
                out.println("}");
                out.println(".navbar {");
                out.println("    background-color: #333;");
                out.println("    overflow: hidden;");
                out.println("    position: fixed;");
                out.println("    top: 0;");
                out.println("    width: 100%;");
                out.println("    z-index: 1000;");
                out.println("}");
                out.println(".navbar ul {");
                out.println("    display: flex;");
                out.println("    justify-content: right;");
                out.println("    padding: 0;");
                out.println("    margin: 0;");
                out.println("}");
                out.println(".navbar li {");
                out.println("    margin: 0 15px;");
                out.println("}");
                out.println(".navbar a {");
                out.println("    color: white;");
                out.println("    padding: 14px 20px;");
                out.println("    text-decoration: none;");
                out.println("    display: block;");
                out.println("    transition: background-color 0.3s ease;");
                out.println("}");
                out.println(".navbar a:hover {");
                out.println("    background-color: #979797;");
                out.println("}");
                out.println(".navbar .icon {");
                out.println("    display: flex;");
                out.println("    align-items: center;");
                out.println("    padding: 14px 20px;");
                out.println("}");
                out.println(".navbar img {");
                out.println("    height: 24px;");
                out.println("    vertical-align: middle;");
                out.println("}");
                out.println("h1, p {");
                out.println("    text-align: center;");
                out.println("    margin-top: 20px;");
                out.println("}");
                out.println("p a {");
                out.println("    color: #007bff;");
                out.println("    text-decoration: none;");
                out.println("}");
                out.println("p a:hover {");
                out.println("    text-decoration: underline;");
                out.println("}");
                out.println("</style>");
                out.print("</head>");
                out.println("<body>");
                //-----------------------------------INICIO NAV-BAR-------------------------------------------------------
                out.println("<div class='navbar'>");
                out.println("    <ul>");
                out.println("        <li class='icon'>");
                out.println("            <!-- Espacio para el icono principal -->");
                out.println("            <li> <img src='imagenes/store.png' alt='Icono principal' style='height: 24px;'></li>");
                out.println("        </li>");
                out.println("        <li><a href='/login_war/productos'><img src='imagenes/cart.png' alt='Carrito'></a></li>");
                out.println("        <li><a href='/login_war/ServletLogin'><img src='imagenes/user.png' alt='Login'></a></li>");
                out.println("        <li><a href='/login_war/logout'><img src='imagenes/logout.png' alt='Logout'></a></li>");
                out.println("    </ul>");
                out.println("</div>");
                //-----------------------------------FIN NAV-BAR-------------------------------------------------------
                out.print("<h1>Hola" + usernameOptional.get() + " has iniciado sesión con exito</h1>");
                out.print("<p><a href='" + req.getContextPath() + "/index.html'>volver</a></p>");
                out.print("<p><a href='" + req.getContextPath() + "/logout'>cerrar sesión</a><p>");
                out.println("</body>");
                out.print("</html>");
            }
        }else{
            getServletContext().getRequestDispatcher("/login.jsp").forward(req,resp);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        if (USERNAME.equals(username) && PASSWORD.equals(password)) {
            HttpSession session = req.getSession();
            session.setAttribute("username", username);
            resp.sendRedirect(req.getContextPath() + "/ServletLogin");
        }else{
            resp.sendError(HttpServletResponse.SC_UNAUTHORIZED,"Lo sentimos no esta autorizado para ingresar al sistema");
        }
    }





}

