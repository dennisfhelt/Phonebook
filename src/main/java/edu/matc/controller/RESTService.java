package edu.matc.controller;
import edu.matc.entity.Location;
import edu.matc.entity.User;
import edu.matc.persistence.Dao;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.ws.rs.*;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.Response;
import java.util.List;
import java.util.Locale;

@Path("/users")
public class RESTService {

    @POST
    public Response findId(@FormParam("value") String value, @FormParam("searchCriteria") String searchCriteria) {
        Dao dao = new Dao(User.class);
        StringBuilder response = new StringBuilder();
        if(value.isEmpty()) {

            List<User> users = dao.getAll();
            for(User user : users){
                response.append("First Name: " + user.getFirstName() + " Last Name: " + user.getLastName()
                        + " ID: " + user.getId() + "<br>");
            }
        } else {
            if(searchCriteria.contains("id")) {
                User user = (User)dao.getById(Integer.parseInt(value));
                response.append("<br> First Name: " + user.getFirstName() + " Last Name: " + user.getLastName()
                        + " ID: " + user.getId() + "<br>");
            } else {
                List<User> users = dao.getByPropertyLike("lastName", value);
                for(User user : users){
                    response.append("First Name: " + user.getFirstName() + " Last Name: " + user.getLastName()
                            + " ID: " + user.getId() + "<br>");
                }
            }

        }
        return Response.status(200)
                .entity(" You entered search Criteria: " + searchCriteria + " for value " + value
                        + "<br> Users: " + response)
                .build();
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
