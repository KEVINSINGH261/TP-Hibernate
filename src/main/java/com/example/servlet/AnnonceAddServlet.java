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

@WebServlet("/annonceAdd")
public class AnnonceAddServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("AnnonceAdd.jsp").forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String titre = request.getParameter("titre");
        String description = request.getParameter("description");
        String adresse = request.getParameter("adresse");
        String email = request.getParameter("mail");


        if(titre == null || titre.isEmpty() || description == null || description.isEmpty() || adresse == null || adresse.isEmpty() ||email == null || email.isEmpty()){
            request.setAttribute("message", "Veuillez entrer les champs");
        }

        else {
            Annonce annonce = new Annonce();
            annonce.setTitle(request.getParameter("titre"));
            annonce.setDescription(request.getParameter("description"));
            annonce.setAdresse(request.getParameter("adresse"));
            annonce.setEmail(request.getParameter("mail"));
            annonce.setDate(new Timestamp(System.currentTimeMillis()));
            //AnnonceDAO annonceDAO = new AnnonceDAO(ConncetionDB.getInstance());
            AnnonceDAO2 annonceDAO = new AnnonceDAO2();
            if(annonceDAO.create(annonce)) {
                request.setAttribute("message", "Annonce ajouter");
            }
        }

        request.getRequestDispatcher("AnnonceAdd.jsp").forward(request, response);
    }
}
