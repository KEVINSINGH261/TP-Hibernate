<%@ page import="java.util.ArrayList" %>
<%@ page import="bean.Annonce" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Liste des annonces</title>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">
    <script src="https://kit.fontawesome.com/a076d05399.js" crossorigin="anonymous"></script>
</head>
<body>

<%@ include file="navbar.jsp" %>

<div class="container mt-4">
    <div class="d-flex justify-content-between align-items-center mb-3">
        <h2 class="text-primary">Liste des annonces</h2>
    </div>

    <% ArrayList<Annonce> annonces = (ArrayList<Annonce>) request.getAttribute("annonces"); %>

    <% if (annonces == null || annonces.isEmpty()) { %>
    <div class="alert alert-info text-center">
        Aucune annonce disponible.
    </div>
    <% } else { %>

    <table class="table table-hover table-striped table-bordered">
        <thead class="table-dark text-center">
        <tr>
            <th>Titre</th>
            <th>Description</th>
            <th>Adresse</th>
            <th>Email</th>
            <th>Date</th>
            <th>Modifier</th>
            <th>Supprimer</th>
        </tr>
        </thead>
        <tbody>
        <% for (Annonce annonce : annonces) { %>
        <tr>
            <td><%= annonce.getTitle() %></td>
            <td><%= annonce.getDescription() %></td>
            <td><%= annonce.getAdresse() %></td>
            <td><%= annonce.getEmail() %></td>
            <td><%= annonce.getDate() %></td>
            <td class="text-center">
                <form action="annonceUpdate" method="get">
                    <input type="hidden" name="id" value="<%= annonce.getId() %>">
                    <button type="submit" class="btn btn-success">
                        <i class="fas fa-edit"></i> Modifier
                    </button>
                </form>
            </td>
            <td class="text-center">
                <form action="annonceDelete" method="post" onsubmit="return confirm('Êtes-vous sûr de vouloir supprimer cette annonce ?');">
                    <input type="hidden" name="id" value="<%= annonce.getId() %>">
                    <button type="submit" class="btn btn-danger">
                        <i class="fas fa-trash-alt"></i> Supprimer
                    </button>
                </form>
            </td>
        </tr>
        <% } %>
        </tbody>
    </table>

    <% } %>
</div>

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>
