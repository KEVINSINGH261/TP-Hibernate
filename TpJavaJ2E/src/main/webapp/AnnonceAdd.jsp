
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Annonce</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
</head>
<body>
    <h2 class="text-center mt-3">Formulaire annonce</h2>
    <div class="w-50 mx-auto bg-body-secondary mt-3 p-3 rounded">
        <form action="annonceAdd" method="post">
            <label class="form-label" for="titre">Titre :</label>
            <input class="form-control" name="titre" id="titre">
            <label class="form-label mt-3" for="description">Description :</label>
            <textarea id="description" name="description" class="form-control"></textarea>
            <label class="form-label mt-3" for="adresse">Adresse :</label>
            <input class="form-control" name="adresse" id="adresse">
            <label class="form-label mt-3" for="mail">Mail :</label>
            <input class="form-control" name="mail" id="mail">
            <div class="d-flex justify-content-center mt-3">
                <button class="btn btn-primary">Envoyer</button>
            </div>
        </form>
    </div>
    <%
        String message = (String) request.getAttribute("message");
        if (message != null) {
    %>
    <div class="alert alert-primary m-3" role="alert">
        <%= message %>
    </div>
    <%
        }
    %>

</body>
</html>
