package edu.matc.controller;

 import edu.matc.entity.User;
 import edu.matc.persistence.Dao;

 import javax.ws.rs.ApplicationPath;
 import javax.ws.rs.FormParam;
 import javax.ws.rs.POST;
 import javax.ws.rs.Path;
 import javax.ws.rs.core.Application;
 import javax.ws.rs.core.Response;
 import java.util.HashSet;
 import java.util.List;
 import java.util.Set;
 
 //Defines the base URI for all resource URIs.
 @Path("/application") //You may want to add a value here so that all traffic isn't routed to the class below.
 
 //The java class declares root resource and provider classes
 public class RESTApplication {
 
     //The method returns a non-empty collection with classes, that must be included in the published JAX-RS application
    // @Override
    // public Set<Class<?>> getClasses() {
     //    HashSet h = new HashSet<Class<?>>();
     //    h.add(RESTService.class );
     //    return h;
     //}

     @POST
     @Path("/id")

     public Response findId(@FormParam("id") int id) {
         if(id == 0) {

             Dao dao = new Dao(User.class);
             List<User> users = dao.getAll();
             StringBuilder response = new StringBuilder();
             for(User user : users){
                 response.append("First Name: " + user.getFirstName() + " Last Name: " + user.getLastName()
                         + " ID: " + user.getId() + "<br>");
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