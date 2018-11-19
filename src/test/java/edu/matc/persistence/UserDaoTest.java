package edu.matc.persistence;

import edu.matc.entity.PhoneNumber;
import edu.matc.entity.User;
import org.hibernate.boot.model.relational.Database;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import javax.persistence.criteria.Order;
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

        dao = new Dao(User.class);
        Database database = Database.getInstance();
        database.runSQL("cleandb.sql");

    }

    /**
     * Verifies gets all orders successfully.
     */
    @Test
    void getAllPhoneNumbersSuccess() {
        List<PhoneNumber> phoneNumbers = dao.getAll();
        assertEquals(7, phoneNumbers.size());
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
    void insertSuccess() {

        Dao userDao = new Dao();
        User user = userDao.getById("1");
        PhoneNumber newPhoneNumber = new PhoneNumber("6080000000", user);
        user.addPhoneNumber(newPhoneNumber);

        int id = dao.insert(newPhoneNumber);

        assertNotEquals(0,id);
        Order insertedOrder = dao.getById(id);
        assertEquals("Plates", insertedOrder.getDescription());
        assertNotNull(insertedOrder.getUser());
        assertEquals("Joe", insertedOrder.getUser().getFirstName());
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
    void updateSuccess() {
        String phoneNumber = "6080001111";
        PhoneNumber phoneNumberToUpdate = (PhoneNumber)dao.getById("3");
        phoneNumberToUpdate.setNumber(phoneNumber);
        dao.saveOrUpdate(phoneNumberToUpdate);
        PhoneNumber retrievedPhoneNumber = (PhoneNumber)dao.getById("3");
        assertEquals(phoneNumberToUpdate, retrievedPhoneNumber);
    }

    /**
     * Verify successful get by property (equal match)
     */
    @Test
    void getByPropertyEqualSuccess() {
        List<Order> orders = dao.getByPropertyEqual("number", "6080001111");
        assertEquals(1, orders.size());
        assertEquals(2, orders.get(0).getId());
    }

    /**
     * Verify successful get by property (like match)
     */
    @Test
    void getByPropertyLikeSuccess() {
        List<PhoneNumber> phoneNumbers = dao.getByPropertyLike("number", "000");
        assertEquals(1, phoneNumbers.size());
    }
}