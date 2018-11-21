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

/**
 * The type Rest service json.
 */
@Path("/json")
public class RESTServiceJSON {

    /**
     * The Dao.
     */
    Dao dao = new Dao(User.class);
    /**
     * The Phone.
     */
    Dao phone = new Dao(PhoneNumber.class);
    /**
     * The Address.
     */
    Dao address = new Dao(Location.class);

    /**
     * Find json response.
     *
     * @param value          the value
     * @param searchCriteria the search criteria
     * @return the response
     */
    @POST
    @Produces("application/json")

    public Response findJSON(@FormParam("value") String value, @FormParam("searchCriteria") String searchCriteria) {
        ObjectMapper mapper = new ObjectMapper();
        RESTCreator create = new RESTCreator();
        String jsonResponse="";
        String response = create.getClasses(searchCriteria, value);

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
}