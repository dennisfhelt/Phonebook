package edu.matc.controller;

import edu.matc.entity.Location;
import edu.matc.entity.PhoneNumber;
import edu.matc.entity.PhoneType;
import edu.matc.entity.User;
import edu.matc.persistence.Dao;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Response;
import java.util.List;

/**
 * The type Rest service html.
 */
@Path("/users")
public class RESTServiceHTML {

    /**
     * The User dao.
     */
    Dao userDao = new Dao(User.class);

    /**
     * Find user by letter response.
     *
     * @param initial the initial
     * @return the response
     */
    @GET
    @Produces("text/html")
    public Response findUserByLetter(@QueryParam("initial") String initial) {

        List<User> users = userDao.getByPropertyBeginsWith("lastName", initial);

        String output = "<html lang=\"en\">";
        output += "<head>";
        output += "<title>Phonebook - Results</title>";
        output += "<link rel=\"stylesheet\" href=\"https://maxcdn.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css\">";
        output += "<script src=\"https://maxcdn.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js\"></script>";
        output += "</head>";

        output += "<body style=\"padding:2em;background-color:#333;color:white;text-align:center;\" class=\"container\">";
        output += "<br />";
        output += "<h1 style=\"color:#F3CD52;\" class=\"display-3\">Search Results:</h1>";
        output += "<br />";

        if (users.size() <  1) {
            output += "<h5 style=\"color:red;\">No users found whose last name begins with '" + initial + "'</h5";
        } else {
            output += "<table class=\"table table-borderless\">";
            output += "<tr style=\"font-size:1.5em;\">";
            output += "<th>First Name</th><th>Last Name</th><th>Address</th><th>City</th><th>State</th><th>Zip Code</th>";
            output += "</tr>";

            for (User user : users) {
                Location location = user.getLocation();
                output += "<tr>";
                output += "<td>" + user.getFirstName() + "</td>";
                output += "<td>" + user.getLastName() + "</td>";
                output += "<td>" + location.getStreetAddress() + "</td>";
                output += "<td>" + location.getCity() + "</td>";
                output += "<td>" + location.getState() + "</td>";
                output += "<td>" + location.getStatePostal() + "</td>";
                output += "</tr>";
            }

            output += "</table>";
        }

        output += "<br /><br />";
        output += "<h5><a href=\"/homePage.jsp\">&lt;&lt; Back to Search Page</a></h5>";
        output += "</body>";
        output += "</html>";

        return Response.status(200).entity(output).build();
    }

}
