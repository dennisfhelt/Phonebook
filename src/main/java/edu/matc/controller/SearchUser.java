package edu.matc.controller;

import edu.matc.entity.*;
import edu.matc.persistence.Dao;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * A simple servlet to welcome the user.
 * @author lclemens
 */

@WebServlet(
        urlPatterns = {"/searchUser"}
)

public class SearchUser extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        Dao dao = new Dao(User.class);
        Dao locationDao = new Dao(Location.class);
        Dao numberDao = new Dao(PhoneNumber.class);
        if (req.getParameter("submit").equals("search")) {
            req.setAttribute("user", dao.getById((req.getParameter("searchTerm"))));
        } else {
            req.setAttribute("users", dao.getAll());
            req.setAttribute("locations", locationDao.getAll());
            //req.setAttribute("numbers", numberDao.getAll());
        }

        RequestDispatcher dispatcher = req.getRequestDispatcher("index.jsp");
        dispatcher.forward(req, resp);
    }
}