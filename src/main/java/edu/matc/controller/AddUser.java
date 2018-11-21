package edu.matc.controller;

import edu.matc.entity.*;
import edu.matc.persistence.Dao;

import javax.servlet.RequestDispatcher;
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
        String homeNumber = request.getParameter("homeNumber");
        String cellNumber = request.getParameter("cellNumber");
        String workNumber = request.getParameter("workNumber");
        String email = request.getParameter("email");

        // Create Daos
        Dao locationDao = new Dao(Location.class);
        Dao userDao = new Dao(User.class);
        Dao roleDao = new Dao(Role.class);
        Dao phoneNumberDao = new Dao(PhoneNumber.class);
        Dao phoneTypeDao = new Dao(PhoneType.class);

        // Validate form
        String errorMessage;
        List<User> usernameCheck = userDao.getByPropertyLike("username", username);

        if (usernameCheck.size() != 0) {
            // Check that username is unique
            errorMessage = "*The username you have selected is already in use";
            HttpSession session = request.getSession();
            session.setAttribute("errorMessage", errorMessage);
            response.sendRedirect("signUp.jsp");
        } else if (!password.equals(confirmPassword)) {
            // Check that password fields match
            errorMessage = "*The passwords you have entered do not match";
            HttpSession session = request.getSession();
            session.setAttribute("errorMessage", errorMessage);
            response.sendRedirect("signUp.jsp");
        } else if (password.length() < 6 || confirmPassword.length() < 6) {
            // Check that password is at least 6 characters
            errorMessage = "*Your password must contain at least 6 characters";
            HttpSession session = request.getSession();
            session.setAttribute("errorMessage", errorMessage);
            response.sendRedirect("signUp.jsp");
        } else {
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

            if (homeNumber.length() > 0) {
                PhoneNumber homePhone = new PhoneNumber();
                homePhone.setNumber(homeNumber);
                homePhone.setUser(user);
                homePhone.setPhoneType((PhoneType)phoneTypeDao.getById(2));
                phoneNumberDao.insert(homePhone);
            }

            if (cellNumber.length() > 0) {
                PhoneNumber cellPhone = new PhoneNumber();
                cellPhone.setNumber(cellNumber);
                cellPhone.setUser(user);
                cellPhone.setPhoneType((PhoneType)phoneTypeDao.getById(3));
                phoneNumberDao.insert(cellPhone);
            }

            if (workNumber.length() > 0) {
                PhoneNumber workPhone = new PhoneNumber();
                workPhone.setNumber(workNumber);
                workPhone.setUser(user);
                workPhone.setPhoneType((PhoneType)phoneTypeDao.getById(1));
                phoneNumberDao.insert(workPhone);
            }

            // Redirect
            response.sendRedirect("signUpConfirmation.jsp");
        }
    }
}
