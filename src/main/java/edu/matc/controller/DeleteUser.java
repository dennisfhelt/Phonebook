package edu.matc.controller;

import edu.matc.entity.*;
import edu.matc.persistence.Dao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

/**
 * Servlet to add new user to the database.
 *
 * @author kheise
 */
@WebServlet(
        urlPatterns = {"/deleteUser"}
)

public class DeleteUser extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Get Form Parameters
        String id = request.getParameter("id");
        String firstName = request.getParameter("firstName");
        String lastName = request.getParameter("lastName");

        // Create Dao
        Dao userDao = new Dao(User.class);

        // Validate form
        String errorMessage;
        User userToDelete = (User)userDao.getById(Integer.parseInt(id));

        if (userToDelete == null) {
            // Check that id exists
            errorMessage = "*That is not a valid id";
            HttpSession session = request.getSession();
            session.setAttribute("errorMessage", errorMessage);
            response.sendRedirect("delete.jsp");
        } else {

            userDao.delete(userToDelete);
        }

            // Redirect
            response.sendRedirect("deleteSuccess.jsp");
        }
    }

