package edu.matc.controller;
import edu.matc.entity.User;
import edu.matc.persistence.Dao;

import javax.ws.rs.*;
import javax.ws.rs.core.Response;
import java.util.List;

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
                User user = (User)dao.getById(value);
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
}
