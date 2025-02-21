package com.example.servlet;

import dao.AnnonceDAO2;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/annonceList")
public class AnnonceListServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //AnnonceDAO annonceDAO = new AnnonceDAO(ConncetionDB.getInstance());
        AnnonceDAO2 annonceDAO = new AnnonceDAO2();
        request.setAttribute("annonces", annonceDAO.readAll());

        request.getRequestDispatcher("annonceList.jsp").forward(request, response);
    }
}
