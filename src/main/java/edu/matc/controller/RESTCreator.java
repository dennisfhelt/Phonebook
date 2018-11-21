package edu.matc.controller;

import edu.matc.entity.User;
import edu.matc.persistence.Dao;

import java.util.List;

/**
 * The type Rest creator.
 */
public class RESTCreator {

    /**
     * The Dao.
     */
    Dao dao = new Dao(User.class);

    /**
     * Gets classes.
     *
     * @param searchCriteria the search criteria
     * @param value          the value
     * @return the classes
     */
    public String getClasses(String searchCriteria, String value) {

        StringBuilder response = new StringBuilder();
        if (value.isEmpty()) {

            List<User> users = dao.getAll();
            for (User user : users) {
                response.append("First Name: " + user.getFirstName() + " Last Name: " + user.getLastName()
                        + " ID: " + user.getId() + " Phone Numbers: " + user.getNumbers() + " Adresses: "
                        + user.getLocation());
            }
        } else {
            if(searchCriteria.contains("id")) {
                User user = (User)dao.getById(Integer.parseInt(value));

                response.append("<br> First Name: " + user.getFirstName() + " Last Name: " + user.getLastName()
                        + " ID: " + user.getId() + " Phone Numbers: " + user.getNumbers() + " Adresses: "
                        + user.getLocation());
            } else {
                List<User> users = dao.getByPropertyLike("lastName", value);
                for (User user : users) {
                    response.append("First Name: " + user.getFirstName() + " Last Name: " + user.getLastName()
                            + " ID: " + user.getId() + " Phone Numbers: " + user.getNumbers() + " Adresses: "
                            + user.getLocation());
                }
            }
        }
        return response.toString();
    }
}
