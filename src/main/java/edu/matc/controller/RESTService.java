package matc.controller;
import matc.entity.User;
import matc.persistence.Dao;

import javax.ws.rs.*;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("/users")
public class RESTCreator {

    @POST
    @Path("/id")

    public Response findId(@FormParam("id") int id) {
        if(id == 0) {

            Dao dao = new Dao(User.class);
            List<User> users = dao.getAll();
            StringBuilder response = new StringBuilder();
            for(User user : users){
                response.append("First Name: " + user.getFirstName() + " Last Name: " + user.getLastName()
                        + " ID: " + user.getId() + " Date of Birth: " + user.getDateOfBirth() + "<br>");
            }
            return Response.status(200)
                    .entity("Users <br> " + response)
                    .build();
        } else {
            return Response.status(200)
                    .entity(" You entered id: " + id)
                    .build();
        }
    }
}
