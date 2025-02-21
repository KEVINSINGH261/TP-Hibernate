package com.example.servlet;

import bean.Annonce;
import dao.AnnonceDAO2;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Timestamp;

@WebServlet("/annonceUpdate")
public class AnnonceUpdateServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        //AnnonceDAO annonceDAO = new AnnonceDAO(ConncetionDB.getInstance());
        AnnonceDAO2 annonceDAO = new AnnonceDAO2();
        Annonce annonce = annonceDAO.read(Integer.parseInt(request.getParameter("id")));
        request.setAttribute("annonce", annonce);

        request.getRequestDispatcher("annonceUpdate.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        String titre = request.getParameter("titre");
        String description = request.getParameter("description");
        String adresse = request.getParameter("adresse");
        String email = request.getParameter("mail");

        if(titre == null || titre.isEmpty() || description == null || description.isEmpty() || adresse == null || adresse.isEmpty() ||email == null || email.isEmpty()){
            request.setAttribute("message", "Veuillez entrer les champs");
        }

        else {
            Annonce annonce = new Annonce(Integer.parseInt(request.getParameter("id")), titre, description, adresse, email, new Timestamp(System.currentTimeMillis()));

            //AnnonceDAO annonceDAO = new AnnonceDAO(ConncetionDB.getInstance());
            AnnonceDAO2 annonceDAO = new AnnonceDAO2();
            annonceDAO.update(annonce);
            request.setAttribute("message", "mise à jour");
        }

        response.sendRedirect("annonceList");

    }
}
