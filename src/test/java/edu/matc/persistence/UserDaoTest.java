package edu.matc.persistence;

import edu.matc.entity.PhoneNumber;
import edu.matc.entity.PhoneType;
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
    Dao phoneNumberDao;


    /**
     * Creating the dao.
     */
    @BeforeEach
    void setUp() {
        Database database = Database.getInstance();
        database.runSQL("cleandb.sql");

        dao = new Dao(User.class);
        phoneNumberDao = new Dao(PhoneNumber.class);
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
        User retrievedUser = (User)dao.getById(2);
        assertNotNull(retrievedUser);
        assertEquals(retrievedUser, dao.getById(2));
    }

    /**
     * Verify successful insert of a order
     */
    @Test
    void insertWithPhoneNumberSuccess() {

        Dao userDao = new Dao(User.class);
        Dao phoneTypeDao = new Dao(PhoneType.class);
        User user = (User)userDao.getById(1);
        PhoneType phoneType = (PhoneType)phoneTypeDao.getById(1);
        PhoneNumber newPhoneNumber = new PhoneNumber("6080000000", user, phoneType);
        user.addPhoneNumber(newPhoneNumber);

        int id = phoneNumberDao.insert(newPhoneNumber);

        assertNotEquals(0,id);
        PhoneNumber insertedPhoneNumber = (PhoneNumber)phoneNumberDao.getById(id);
        assertEquals("6080000000", insertedPhoneNumber.getNumber());
        assertNotNull(insertedPhoneNumber.getNumber());
        assertEquals(newPhoneNumber, insertedPhoneNumber);
    }

    /**
     * Verify successful delete of order
     */
    /* @Test
    void deleteSuccess() {
        dao.delete(dao.getById(3));
        assertNull(dao.getById(3));
    }
    */
    /**
     * Verify successful update of order
     */
    @Test
    void updateSuccess() {
        String newLastName = "Smith";
        User userToUpdate = (User)dao.getById(3);
        userToUpdate.setLastName(newLastName);
        dao.saveOrUpdate(userToUpdate);
        User retrievedUser = (User)dao.getById(3);
        assertEquals(userToUpdate, retrievedUser);
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