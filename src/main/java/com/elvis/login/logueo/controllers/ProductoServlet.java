package com.elvis.login.logueo.controllers;

import com.elvis.login.logueo.models.Producto;
import com.elvis.login.logueo.services.LoginService;
import com.elvis.login.logueo.services.LoginServiceImplement;
import com.elvis.login.logueo.services.ProductoService;
import com.elvis.login.logueo.services.ProductoServiceImplement;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.Optional;

@WebServlet({"/productoServlet","/productos"})
public class ProductoServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ProductoService service= new ProductoServiceImplement();
        List<Producto> productos = service.listar();
        LoginService auth = new LoginServiceImplement();
        Optional<String> usernameOptional= auth.getUserName(req);
        resp.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = resp.getWriter()) {
            out.print("<!DOCTYPE html>");
            out.print("<html>");
            out.print("<head>");
            out.print("<meta charset=\"UTF-8\">");
            out.print("<title>Listado de productos</title>");
            out.print("<style>");
            out.print("body {");
            out.print("    font-family: Arial, sans-serif;");
            out.print("    background-color: #f2f2f2;");
            out.print("    margin: 0;");
            out.print("    padding: 0;");
            out.print("}");
            out.print(".navbar {");
            out.print("    background-color: #333;");
            out.print("    overflow: hidden;");
            out.print("    position: fixed;");
            out.print("    top: 0;");
            out.print("    width: 100%;");
            out.print("    z-index: 1000;");
            out.print("}");
            out.print(".navbar ul {");
            out.print("    display: flex;");
            out.print("    justify-content: right;");
            out.print("    padding: 0;");
            out.print("    margin: 0;");
            out.print("}");
            out.print(".navbar li {");
            out.print("    margin: 0 15px;");
            out.print("}");
            out.print(".navbar a {");
            out.print("    color: white;");
            out.print("    padding: 14px 20px;");
            out.print("    text-decoration: none;");
            out.print("    display: block;");
            out.print("    transition: background-color 0.3s ease;");
            out.print("}");
            out.print(".navbar a:hover {");
            out.print("    background-color: #979797;");
            out.print("}");
            out.print(".navbar .icon {");
            out.print("    display: flex;");
            out.print("    align-items: center;");
            out.print("    padding: 14px 20px;");
            out.print("}");
            out.print(".navbar img {");
            out.print("    height: 24px;");
            out.print("    vertical-align: middle;");
            out.print("}");
            out.print("h2 {");
            out.print("    text-align: center;");
            out.print("}");
            out.print("table {");
            out.print("    width: 80%;");
            out.print("    margin: 20px auto;");
            out.print("    border-collapse: collapse;");
            out.print("}");
            out.print("th, td {");
            out.print("    padding: 10px;");
            out.print("    border-bottom: 2px solid #ccc;");
            out.print("}");
            out.print("tr:last-child td {");
            out.print("    border-bottom: none;");
            out.print("}");
            out.print("</style>");
            out.print("</head>");
            out.println("<body>");
            out.println("<div class='navbar'>");
            out.println("    <ul>");
            out.println("        <li class='icon'>");
            out.println("            <!-- Espacio para el icono principal -->");
            out.println("            <li><a href='index.html'> <img src='imagenes/store.png' alt='Icono principal' style='height: 24px;'></a></li>");
            out.println("        </li>");
            out.println("        <li><a href='/login_war/productos'><img src='imagenes/cart.png' alt='Carrito'></a></li>");
            out.println("        <li><a href='/login_war/ServletLogin'><img src='imagenes/user.png' alt='Login'></a></li>");
            out.println("        <li><a href='/login_war/logout'><img src='imagenes/logout.png' alt='Logout'></a></li>");
            out.println("    </ul>");
            out.println("</div>");
            out.println("<br>");
            out.println("<br>");
            out.print("<h1>Listado de productos</h1>");
            if (usernameOptional.isPresent()){
                out.print("<div style='color:blue;' > HOLA " + usernameOptional.get() + " Bienvenido MADAFAKA</div>");
            }
            out.print("<table>");
            out.print("<tr>");
            out.print("<th>id</th>");
            out.print("<th>nombre</th>");
            out.print("<th>categoria</th>");
            out.print("<th>descripción</th>");
            if (usernameOptional.isPresent()) {
                out.print("<th>valor</th>");
                out.print("<th>agregar</th>");
            }
            out.print("</tr>");
            productos.forEach(p ->{
                out.print("<tr>");
                out.print("<td>"+ p.getIdProducto()+"</td>");
                out.println("<td>" + p.getNombre() + "</td>");
                out.println("<td>" + p.getCategoria() + "</td>");
                out.print("<td>" + p.getDescripcion() + "</td>");
                if(usernameOptional.isPresent()) {
                    out.println("<td>" + p.getPrecio() + "</td>");
                    out.println("<td><a href=\""
                            + req.getContextPath()
                            +"/agregar-carro?id=" + p.getIdProducto()
                            +"\">agrega al carro</a></td>");

                }
                out.println("</tr>");
            });

            out.print("</table>");
            out.print("");
            out.print("");
            out.println("</body>");
            out.print("</html>");
        }
    }
}
