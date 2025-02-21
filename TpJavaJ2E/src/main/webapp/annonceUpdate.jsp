<%@ page import="bean.Annonce" %><%--
  Created by IntelliJ IDEA.
  User: bilel
  Date: 07/02/2025
  Time: 11:34
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
    <head>
        <title>Annonce update</title>
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">

    </head>
    <body>
    <% Annonce annonce = (Annonce) request.getAttribute("annonce"); %>
    <h2 class="text-center mt-3">Formulaire Mise à jour annonce</h2>
    <div class="w-50 mx-auto bg-body-secondary mt-3 p-3 rounded">
        <form action="annonceUpdate" method="post">
            <input type="hidden" value="<%= annonce.getId() %>" name="id" id="id">
            <label class="form-label" for="titre">Titre :</label>
            <input class="form-control" name="titre" id="titre" value="<%= annonce.getTitle() %>">
            <label class="form-label mt-3" for="description">Description :</label>
            <textarea id="description" name="description" class="form-control"><%= annonce.getDescription() %></textarea>
            <label class="form-label mt-3" for="adresse">Adresse :</label>
            <input class="form-control" name="adresse" id="adresse" value="<%= annonce.getAdresse() %>">
            <label class="form-label mt-3" for="mail">Mail :</label>
            <input class="form-control" name="mail" id="mail" value="<%= annonce.getEmail() %>">
            <div class="d-flex justify-content-center mt-3">
                <button class="btn btn-primary">Envoyer</button>
            </div>
        </form>
    </div>
    <p><%= request.getAttribute("message") %></p>
    </body>
</html>
