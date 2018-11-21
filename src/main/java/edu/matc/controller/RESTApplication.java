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
 @ApplicationPath("/application") //You may want to add a value here so that all traffic isn't routed to the class below.
 
 //The java class declares root resource and provider classes
 public class RESTApplication extends Application {
 
     //The method returns a non-empty collection with classes, that must be included in the published JAX-RS application
     @Override
     public Set<Class<?>> getClasses() {
         HashSet result = new HashSet<Class<?>>();
         result.add(RESTService.class );
         result.add(RESTServiceHTML.class);
         result.add(RESTServiceJSON.class);
         return result;
     }

 }
