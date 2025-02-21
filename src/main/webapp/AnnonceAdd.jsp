<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Ajouter une annonce</title>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">
    <script src="https://kit.fontawesome.com/a076d05399.js" crossorigin="anonymous"></script>
</head>
<body>

<%@ include file="navbar.jsp" %>

<div class="container mt-4">
    <h2 class="text-center text-primary">Ajouter une annonce</h2>

    <% String message = (String) request.getAttribute("message"); %>
    <% if (message != null) { %>
    <div class="alert alert-info alert-dismissible fade show text-center mt-3" role="alert">
        <%= message %>
        <button type="button" class="btn-close" data-bs-dismiss="alert" aria-label="Close"></button>
    </div>
    <% } %>

    <div class="w-50 mx-auto bg-light shadow p-4 rounded">
        <form action="annonceAdd" method="post">
            <div class="mb-3">
                <label class="form-label" for="titre">Titre :</label>
                <input class="form-control" name="titre" id="titre" placeholder="Entrez le titre de l'annonce" required>
            </div>

            <div class="mb-3">
                <label class="form-label" for="description">Description :</label>
                <textarea id="description" name="description" class="form-control" placeholder="Ajoutez une description" required></textarea>
            </div>

            <div class="mb-3">
                <label class="form-label" for="adresse">Adresse :</label>
                <input class="form-control" name="adresse" id="adresse" placeholder="Saisissez l'adresse" required>
            </div>

            <div class="mb-3">
                <label class="form-label" for="mail">Email :</label>
                <input class="form-control" type="email" name="mail" id="mail" placeholder="exemple@mail.com" required>
            </div>

            <div class="text-center">
                <button class="btn btn-primary" type="submit">
                    <i class="fas fa-paper-plane"></i> Envoyer
                </button>
            </div>
        </form>
    </div>
</div>

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>
