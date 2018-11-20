package edu.matc.controller;


import edu.matc.entity.*;
import edu.matc.persistence.Dao;
import org.json.simple.JSONArray;
import javax.ws.rs.FormParam;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.ws.rs.*;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.Response;
import java.util.List;
import java.util.Locale;

@Path("/text")
public class RESTService {

    Dao dao = new Dao(User.class);
    Dao phone = new Dao(PhoneNumber.class);
    Dao address = new Dao(Location.class);

    @POST
    @Produces("text/plain")
    public Response findText(@FormParam("value") String value, @FormParam("searchCriteria") String searchCriteria) {

        String response = getClasses(searchCriteria, value);

        return Response.status(200)
                .entity(" You entered search Criteria: " + searchCriteria + " for value " + value
                        + "<br> Users: " + response)
                .build();
    }



    public String getClasses(String searchCriteria, String value) {

        StringBuilder response = new StringBuilder();
        if (value.isEmpty()) {

            List<User> users = dao.getAll();
            for (User user : users) {
                response.append("First Name: " + user.getFirstName() + " Last Name: " + user.getLastName()
                        + " ID: " + user.getId() + " Phone Numbers: " + user.getNumbers() + "<br>");
            }
        } else {
            if (searchCriteria.contains("id")) {
                User user = (User) dao.getById(value);
                response.append("<br> First Name: " + user.getFirstName() + " Last Name: " + user.getLastName()
                        + " ID: " + user.getId() + " Phone Numbers: " + user.getNumbers() + "<br>");
            } else {
                List<User> users = dao.getByPropertyLike("lastName", value);
                for (User user : users) {
                    response.append("First Name: " + user.getFirstName() + " Last Name: " + user.getLastName()
                            + " ID: " + user.getId() + " Phone Numbers: " + user.getNumbers() + "<br>");
                }
            }
        }
        return response.toString();
    }

    @GET
    @Produces("text/html")
    public void findUserByLetter(
            @QueryParam("initial") String initial,
            @Context HttpServletRequest request,
            @Context HttpServletResponse response) throws Exception {

        HttpSession session = request.getSession();
        String errorMessage = "";
        Boolean usersFound = true;

        Dao userDao = new Dao(User.class);
        List<User> users = userDao.getByPropertyBeginsWith("lastName", initial);

        if (users.size() < 1) {
            errorMessage = "Sorry, there are no users with a last name beginning with '" + initial + "'";
            usersFound = false;
        }

        session.setAttribute("errorMessage", errorMessage);
        session.setAttribute("usersFound", usersFound);
        session.setAttribute("users", users);

        request.getRequestDispatcher("/searchResults.jsp").forward(request, response);
    }

}
