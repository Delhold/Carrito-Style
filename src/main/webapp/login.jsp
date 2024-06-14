<%--
  Created by IntelliJ IDEA.
  User: ADMIN-ITQ
  Date: 30/5/2024
  Time: 8:16
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Ingresando al Sistema</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f2f2f2;
            margin: 0;
            padding: 0;
        }

        h3 {
            color: #333;
            text-align: center;
            margin-top: 50px;
        }

        ul {
            list-style-type: none;
            margin: 0;
            padding: 0;
            text-align: center;
        }

        li {
            display: inline;
            margin: 0 10px;
        }

        a {
            text-decoration: none;
            color: #333;
            padding: 10px 20px;
            border: 1px solid #ccc;
            transition: background-color 0.3s ease;
            border-radius: 5px;
        }

        a:hover {
            background-color: #007bff;
            color: #fff;
        }

        /* Estilos para el nav-bar */
        .navbar {
            background-color: #333;
            overflow: hidden;
            position: fixed;
            top: 0;
            width: 100%;
            z-index: 1000;
        }

        .navbar ul {
            display: flex;
            justify-content: right;
            padding: 0;
            margin: 0;
        }

        .navbar li {
            margin: 0 15px;
        }

        .navbar a {
            color: white;
            padding: 14px 20px;
            text-decoration: none;
            display: block;
            transition: background-color 0.3s ease;
        }

        .navbar a:hover {
            background-color: #979797;
        }

        .navbar .icon {
            display: flex;
            align-items: center;
            padding: 14px 20px;
        }

        /* Ajuste del contenido al nav-bar */
        .content {
            padding-top: 60px;
        }

        /* Estilo para los iconos */
        .navbar img {
            height: 24px;
            vertical-align: middle;
        }

        /* Estilo para el formulario */
        .content form {
            background-color: #fff;
            border-radius: 5px;
            box-shadow: 0px 0px 10px 0px rgba(0, 0, 0, 0.1);
            padding: 20px;
            max-width: 400px;
            margin: 0 auto;
        }

        .content form h2 {
            color: #333;
            text-align: center;
            margin-bottom: 20px;
        }

        .content form label {
            display: block;
            margin-bottom: 10px;
            color: #333;
        }

        .content form input[type="text"],
        .content form input[type="password"] {
            width: 100%;
            padding: 10px;
            margin-bottom: 20px;
            border: 1px solid #ccc;
            border-radius: 5px;
            box-sizing: border-box;
        }

        .content form input[type="submit"] {
            width: 100%;
            padding: 10px;
            background-color: #007bff;
            color: #fff;
            border: none;
            border-radius: 5px;
            cursor: pointer;
            transition: background-color 0.3s ease;
        }

        .content form input[type="submit"]:hover {
            background-color: #0056b3;
        }
    </style>
</head>
<body>
<%--------------------------INICIO NAV-BAR ---------------------------------%>
<div class="navbar">
    <ul>
        <li class="icon">
            <!-- Espacio para el icono principal -->
            <img src="imagenes/store.png" alt="Icono principal" style="height: 24px;">
        </li>
        <li><a href="/login_war/productos"><img src="imagenes/cart.png" alt="Carrito"></a></li>
        <li><a href="/login_war/ServletLogin"><img src="imagenes/user.png" alt="Login"></a></li>
        <li><a href="/login_war/logout"><img src="imagenes/logout.png" alt="Logout"></a></li>
    </ul>
</div>
<%--------------------------FIN NAV-BAR ---------------------------------%>
<div class="content">
<h1>Iniciar sesión</h1>
<form action="Login" method="post">
    <div>
        <label for="username">Ingrese el nombre del usuario</label>
        <input type="text" name="username" id="username">
    </div>
    <div>
        <label for="password">Ingrese la contraseña</label>
        <input type="password" name="password" id="password">
    </div>
    <div>
        <input type="submit" value="Login">
    </div>
</form>
</div>
</body>
</html>
