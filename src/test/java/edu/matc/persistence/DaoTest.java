package edu.matc.persistence;

import edu.matc.entity.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class DaoTest {

    Dao dao;

    /**
     * Run set up tasks before each test:
     * 1. execute sql which deletes everything from the table and inserts records)
     * 2. Create any objects needed in the tests
     */
    @BeforeEach
    void setUp() {

        edu.matc.test.util.Database database = edu.matc.test.util.Database.getInstance();
        database.runSQL("cleandb.sql");
        dao = new Dao(User.class);
    }

    /**
     * Verify successful retrieval of a user
     */
    @Test
    void getByIdSuccess() {
        User retrievedUser = (User)dao.getById("3");
        assertEquals("Barney", retrievedUser.getFirstName());
        assertEquals("Curry", retrievedUser.getLastName());
        assertEquals("bcurry", retrievedUser.getUserName());
        assertEquals(3, retrievedUser.getId());
    }

    /**
     * Verify successful insert of a user
     */
    @Test
    void insertSuccess() {

        User newUser = new User("Fred", "Flintstone", "fflintstone", LocalDate.parse("1968-01-01"));
        int id = dao.insert(newUser);
        assertNotEquals(0,id);
        User insertedUser = (User)dao.getById(Integer.toString(id));
        assertTrue(insertedUser.equals(newUser));
    }



    /**
     * Verify successful delete of user
     */
    @Test
    void deleteSuccess() {
        dao.delete(dao.getById("3"));
        assertNull(dao.getById("3"));
    }

    /**
     * Update success.
     */
    @Test
    void updateSuccess() {
        String newLastName = "Davis";
        User userToUpdate = (User)dao.getById("3");
        userToUpdate.setLastName(newLastName);
        dao.saveOrUpdate(userToUpdate);
        User retrievedUser = (User)dao.getById("3");
        assertTrue(userToUpdate.equals(retrievedUser));
    }

    /**
     * Verify successful retrieval of all users
     */
    @Test
    void getAllSuccess() {
        List<User> users = dao.getAll();
        assertEquals(6, users.size());
    }

    /**
     * Verify successful get by property (equal match)
     */
    @Test
    void getByPropertyEqualSuccess() {
        List<User> users = dao.getByPropertyLike("lastName", "Curry");
        assertEquals(1, users.size());
        assertEquals(3, users.get(0).getId());
    }

    /**
     * Verify successful get by property (like match)
     */
    @Test
    void getByPropertyLikeSuccess() {
        List<User> users = dao.getByPropertyLike("lastName", "c");
        assertEquals(3, users.size());
    }

    @Test
    void getByPropertyEqual() {
        List<User> users = dao.getByPropertyEqual("firstName", "Dawn");
        assertEquals(1, users.size());
    }

}