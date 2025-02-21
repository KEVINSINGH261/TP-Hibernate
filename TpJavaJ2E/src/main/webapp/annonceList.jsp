<%@ page import="java.util.ArrayList" %>
<%@ page import="bean.Annonce" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
    <head>
        <title>Annonce liste</title>
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
    </head>
    <body>
    <% ArrayList<Annonce> annonces = (ArrayList<Annonce>) request.getAttribute("annonces"); %>
        <h2 class="text-center text-primary m-3">Liste des annonces</h2>
        <table class="table table-hover table-striped table-bordered">
            <thead>
                <th>Titre</th>
                <th>Description</th>
                <th>Adresse</th>
                <th>Mail</th>
                <th>Date</th>
                <th>Mettre à jour</th>
                <th>Supprimer</th>
            </thead>
            <tbody>
                <% for (Annonce annonce : annonces) { %>
                        <tr>
                            <td><%= annonce.getTitle() %></td>
                            <td><%= annonce.getDescription() %></td>
                            <td><%= annonce.getAdresse() %></td>
                            <td><%= annonce.getEmail() %></td>
                            <td><%= annonce.getDate() %></td>
                            <td>
                                <form action="annonceUpdate" method="get">
                                    <input type="hidden" value="<%= annonce.getId()%>" name="id" id="id">
                                    <button type="submit" class="btn btn-success">Update</button>
                                </form>
                            </td>
                            <td>
                                <form action="annonceDelete" method="post">
                                    <input type="hidden" value="<%= annonce.getId()%>" name="id" id="id">
                                    <button type="submit" class="btn btn-danger">Supprimer</button>
                                </form>
                            </td>
                        </tr>
                    </a>
                <% } %>
            </tbody>
        </table>
    </body>
</html>
