package edu.matc.controller;


 import javax.ws.rs.ApplicationPath;
 import javax.ws.rs.core.Application;
 import java.util.HashSet;
 import java.util.Set;

/**
 * The type Rest application.
 */
@ApplicationPath("/application")
 public class RESTApplication extends Application {
 

     @Override
     public Set<Class<?>> getClasses() {
         HashSet result = new HashSet<Class<?>>();
         result.add(RESTService.class );
         result.add(RESTServiceHTML.class);
         result.add(RESTServiceJSON.class);
         return result;
     }

 }
