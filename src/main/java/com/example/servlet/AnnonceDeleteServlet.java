package com.example.servlet;

import dao.AnnonceDAO2;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/annonceDelete")
public class AnnonceDeleteServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //AnnonceDAO annonceDAO = new AnnonceDAO(ConncetionDB.getInstance());
        AnnonceDAO2 annonceDAO = new AnnonceDAO2();
        annonceDAO.delete(annonceDAO.read(Integer.parseInt(req.getParameter("id"))));
        resp.sendRedirect("annonceList");
    }
}
