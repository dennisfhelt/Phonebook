package edu.matc.controller;


import javax.ws.rs.FormParam;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

/**
 * The type Rest service.
 */
@Path("/text")
public class RESTService {


    /**
     * Find text response.
     *
     * @param value          the value
     * @param searchCriteria the search criteria
     * @return the response
     */
    @POST
    @Produces("text/plain")
    public Response findText(@FormParam("value") String value, @FormParam("searchCriteria") String searchCriteria) {
        RESTCreator create = new RESTCreator();
        String response = create.getClasses(searchCriteria, value);

        return Response.status(200)
                .entity(" You entered search Criteria: " + searchCriteria + " for value " + value
                        + "<br> Users: " + response)
                .build();
    }





}
