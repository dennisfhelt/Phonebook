package edu.matc.controller;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import edu.matc.entity.Location;
import edu.matc.entity.PhoneNumber;
import edu.matc.entity.User;
import edu.matc.persistence.Dao;

import javax.ws.rs.FormParam;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;
import java.io.IOException;
import java.util.List;

@Path("/json")
public class RESTServiceJSON {

    Dao dao = new Dao(User.class);
    Dao phone = new Dao(PhoneNumber.class);
    Dao address = new Dao(Location.class);

    @POST
    @Produces("application/json")

    public Response findJSON(@FormParam("value") String value, @FormParam("searchCriteria") String searchCriteria) {
        ObjectMapper mapper = new ObjectMapper();
        String jsonResponse="";
        String response = getClasses(searchCriteria, value);

        try {

            jsonResponse = mapper.writeValueAsString(response);
        } catch (JsonGenerationException e) {
            e.printStackTrace();
        } catch (JsonMappingException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }


        return Response.status(200)
                .entity(jsonResponse)
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
            if(searchCriteria.contains("id")) {
                User user = (User)dao.getById(Integer.parseInt(value));

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

}