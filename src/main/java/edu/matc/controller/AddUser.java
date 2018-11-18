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
 * Servlet to add new user to the database.
 * @author kheise
 */
@WebServlet(
        urlPatterns = {"/addUser"}
)

public class AddUser extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Get Form Parameters
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String confirmPassword = request.getParameter("confirmPassword");
        String firstName = request.getParameter("firstName");
        String lastName = request.getParameter("lastName");
        String address = request.getParameter("address");
        String city = request.getParameter("city");
        String state = request.getParameter("state");
        String zipCode = request.getParameter("zipCode");
        String homePhone = request.getParameter("homeNumber");
        String cellPhone = request.getParameter("cellNumber");
        String workPhone = request.getParameter("workNumber");
        String email = request.getParameter("email");

        // Create Daos
        Dao locationDao = new Dao(Location.class);
        Dao userDao = new Dao(User.class);
        Dao roleDao = new Dao(Role.class);
        Dao phoneNumberDao = new Dao(PhoneNumber.class);
        Dao phoneTypeDao = new Dao(PhoneType.class);

        // Create objects and add to the database
        Location location = new Location();
        location.setStreetAddress(address);
        location.setCity(city);
        location.setState(state);
        location.setStatePostal(zipCode);
        locationDao.insert(location);

        User user = new User();
        user.setFirstName(firstName);
        user.setLastName(lastName);
        user.setPassword(password);
        user.setUsername(username);
        user.setLocation(location);

        Role role = new Role();
        role.setRole("user");
        role.setUsername(username);
        role.setUser(user);
        user.addRole(role);

        userDao.insert(user);

        // Redirect
        RequestDispatcher dispatcher = request.getRequestDispatcher("/signUpConfirmation.jsp");
        dispatcher.forward(request, response);
    }
}
