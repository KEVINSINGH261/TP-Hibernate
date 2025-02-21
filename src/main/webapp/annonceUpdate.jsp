<%@ page import="bean.Annonce" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Modifier Annonce</title>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>

<%@ include file="navbar.jsp" %>

<% Annonce annonce = (Annonce) request.getAttribute("annonce"); %>

<div class="container mt-5">
    <div class="row justify-content-center">
        <div class="col-md-6">
            <div class="card shadow-lg">
                <div class="card-header bg-primary text-white text-center">
                    <h3>Modifier l'annonce</h3>
                </div>
                <div class="card-body">
                    <form action="annonceUpdate" method="post">
                        <input type="hidden" value="<%= annonce.getId() %>" name="id">

                        <div class="mb-3">
                            <label class="form-label" for="titre">Titre :</label>
                            <input class="form-control" name="titre" id="titre" value="<%= annonce.getTitle() %>" required>
                        </div>

                        <div class="mb-3">
                            <label class="form-label" for="description">Description :</label>
                            <textarea id="description" name="description" class="form-control" required><%= annonce.getDescription() %></textarea>
                        </div>

                        <div class="mb-3">
                            <label class="form-label" for="adresse">Adresse :</label>
                            <input class="form-control" name="adresse" id="adresse" value="<%= annonce.getAdresse() %>" required>
                        </div>

                        <div class="mb-3">
                            <label class="form-label" for="mail">Email :</label>
                            <input class="form-control" name="mail" id="mail" type="email" value="<%= annonce.getEmail() %>" required>
                        </div>

                        <div class="text-center">
                            <button type="submit" class="btn btn-success">Mettre à jour</button>
                            <a href="annonceList" class="btn btn-secondary">Retour</a>
                        </div>
                    </form>
                </div>
            </div>

            <% String message = (String) request.getAttribute("message");
                if (message != null && !message.isEmpty()) { %>
            <div class="alert alert-info text-center mt-3">
                <%= message %>
            </div>
            <% } %>

        </div>
    </div>
</div>

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>
