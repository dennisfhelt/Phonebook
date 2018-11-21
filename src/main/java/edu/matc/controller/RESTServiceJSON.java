package edu.matc.controller;

import edu.matc.entity.Location;
import edu.matc.entity.PhoneNumber;
import edu.matc.entity.User;
import edu.matc.persistence.Dao;
import org.json.simple.JSONArray;

import javax.ws.rs.FormParam;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("/json")
public class RESTServiceJSON {

    Dao dao = new Dao(User.class);
    Dao phone = new Dao(PhoneNumber.class);
    Dao address = new Dao(Location.class);

    @POST
    @Produces("application/json")

    public Response findJSON(@FormParam("value") String value, @FormParam("searchCriteria") String searchCriteria) {
        JSONArray array = new JSONArray();

        if (value.isEmpty()) {

            List<User> users = dao.getAll();
            for (User user : users) {
                array.add("First Name: " + user.getFirstName() + " Last Name: " + user.getLastName()
                        + " ID: " + user.getId());
                array.add(" Phone Numbers: " + user.getNumbers());
                array.add(" Address: " + user.getLocation() + "<br>");
            }
        } else {
            if (searchCriteria.contains("id")) {
                User user = (User) dao.getById(value);
                array.add("<br> First Name: " + user.getFirstName() + " Last Name: " + user.getLastName()
                        + " ID: " + user.getId() + " Phone Numbers: " + user.getNumbers() + "Address: "
                        + user.getLocation() + "<br>");
            } else {
                List<User> users = dao.getByPropertyLike("lastName", value);
                for (User user : users) {
                    array.add("First Name: " + user.getFirstName() + " Last Name: " + user.getLastName()
                            + " ID: " + user.getId() + " Phone Numbers: " + user.getNumbers() + "Address: "
                            + user.getLocation() + "<br>");
                }
            }
        }
        return Response.status(200)
                .entity(array)
                .build();
    }

}