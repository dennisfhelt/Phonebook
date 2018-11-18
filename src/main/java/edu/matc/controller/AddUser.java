package edu.matc.controller;

import edu.matc.entity.Location;
import edu.matc.entity.PhoneNumber;
import edu.matc.entity.Role;
import edu.matc.entity.User;
import edu.matc.persistence.Dao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Servlet to add new user to the database.
 * @author kheise
 */
@WebServlet(
        urlPatterns = {"/addUser"}
)

public class AddUser extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Dao locationDao = new Dao(Location.class);
        Dao userDao = new Dao(User.class);
        Dao phoneNumberDao = new Dao(PhoneNumber.class);
        Dao roleDao = new Dao(Role.class);

        Location location = new Location();
        location.setStreetAddress(request.getParameter("address"));
        location.setCity(request.getParameter("city"));
        location.setState(request.getParameter("state"));
        location.setStatePostal(request.getParameter("zipCode"));

        User user = new User();
        user.setFirstName(request.getParameter("firstName"));
        user.setLastName(request.getParameter("lastName"));
        user.setPassword(request.getParameter("password"));
        user.setUsername(request.getParameter("username"));
        user.setLocation(location);
    }
}
