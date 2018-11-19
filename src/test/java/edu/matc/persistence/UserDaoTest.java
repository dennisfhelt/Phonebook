package edu.matc.persistence;

import edu.matc.entity.PhoneNumber;
import edu.matc.entity.Role;
import edu.matc.entity.User;
import edu.matc.testUtils.Database;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class UserDaoTest {

/**
 * The dao test.
 */
    Dao dao;


    /**
     * Creating the dao.
     */
    @BeforeEach
    void setUp() {
        Database database = Database.getInstance();
        database.runSQL("cleandb.sql");

        dao = new Dao(User.class);
    }

    /**
     * Verifies gets all orders successfully.
     */
    @Test
    void getAllUsersSuccess() {
        List<User> users = dao.getAll();
        assertEquals(users, dao.getAll());
    }


    /**
     * Verifies a order is returned correctly based on id search
     */
    @Test
    void getByIdSuccess() {
        User retrievedUser = (User)dao.getById("2");
        assertNotNull(retrievedUser);
        assertEquals(retrievedUser, dao.getById("2"));
    }

    /**
     * Verify successful insert of a order
     */
    @Test
    void insertPhoneNumberSuccess() {

        Dao userDao = new Dao(User.class);
        User user = (User)dao.getById("1");
        PhoneNumber newPhoneNumber = new PhoneNumber("6080000000", user);
        user.addPhoneNumber(newPhoneNumber);

        int id = dao.insert(newPhoneNumber);

        assertNotEquals(0,id);
        PhoneNumber insertedPhoneNumber = (PhoneNumber)dao.getById((Integer.toString(id)));
        assertEquals("6080000000", insertedPhoneNumber.getNumber());
        assertNotNull(insertedPhoneNumber.getUser());
        assertEquals("Joe", insertedPhoneNumber.getUser().getFirstName());
        // Could continue comparing all values, but
        // it may make sense to use .equals()
        // TODO review .equals recommendations http://docs.jboss.org/hibernate/orm/5.2/orderguide/html_single/Hibernate_Order_Guide.html#mapping-model-pojo-equalshashcode
    }


    /**
     * Verify successful delete of order
     */
    @Test
    void deleteSuccess() {
        dao.delete(dao.getById("3"));
        assertNull(dao.getById("3"));
    }

    /**
     * Verify successful update of order
     */
    @Test
    void updateWithPhoneNumberSuccess() {
        String phoneNumber = "6080001111";
        PhoneNumber phoneNumberToUpdate = (PhoneNumber)dao.getById("3");
        phoneNumberToUpdate.setNumber(phoneNumber);
        dao.saveOrUpdate(phoneNumberToUpdate);
        PhoneNumber retrievedPhoneNumber = (PhoneNumber)dao.getById("3");
        assertEquals(phoneNumberToUpdate, retrievedPhoneNumber);
    }

    @Test
    void updateWithRoleSuccess() {
        String userRole = "Administrator";
        Role roleToUpdate = (Role)dao.getById("3");
        roleToUpdate.setRole(userRole);
        dao.saveOrUpdate(roleToUpdate);
        Role retrievedPhoneNumber = (Role)dao.getById("3");
        assertEquals(roleToUpdate, retrievedPhoneNumber);
    }

    /**
     * Verify successful get by property (equal match)
     */
    @Test
    void getByPropertyEqualSuccess() {
        List<User> users = dao.getByPropertyEqual("firstName", "Aseng");
        assertEquals(users, dao.getByPropertyEqual("firstName", "Aseng"));

    }

    /**
     * Verify successful get by property (like match)
     */
    @Test
    void getByPropertyLikeSuccess() {
        List<User> users = dao.getByPropertyLike("username", "rr");
        assertEquals(users, dao.getByPropertyLike("username", "rr"));
    }
}