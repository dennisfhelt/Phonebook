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
        if(value.isEmpty()) {

            List<User> users = dao.getAll();
            StringBuilder response = new StringBuilder();
            for(User user : users){
                response.append("First Name: " + user.getFirstName() + " Last Name: " + user.getLastName()
                        + " ID: " + user.getId() + "<br>");
            }
            return Response.status(200)
                    .entity("Users <br> " + response + " Search Criteria: " + searchCriteria)
                    .build();
        } else {
            if(searchCriteria.contains("id")) {
                User user = (User)dao.getById(searchCriteria);
                return Response.status(200)
                        .entity(" You entered Last Name: " + value + " Search Criteria: " + searchCriteria
                                + "<br> First Name: " + user.getFirstName() + " Last Name: " + user.getLastName()
                        + " ID: " + user.getId() + "<br>")
                        .build();
            } else {
                List<User> users = dao.getByPropertyLike("lastName", value);
                StringBuilder response = new StringBuilder();
                for(User user : users){
                    response.append("First Name: " + user.getFirstName() + " Last Name: " + user.getLastName()
                            + " ID: " + user.getId() + "<br>");
                }
                return Response.status(200)
                        .entity(" You entered Last Name: " + value + " Search Criteria: " + searchCriteria
                                + "<br> Users: " + response)
                        .build();
            }

        }
    }
}
