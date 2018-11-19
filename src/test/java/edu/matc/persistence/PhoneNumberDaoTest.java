package edu.matc.persistence;

import edu.matc.entity.PhoneNumber;
import edu.matc.testUtils.Database;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class PhoneNumberDaoTest {

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

        dao = new Dao(PhoneNumber.class);
    }

    /**
     * Verifies gets all orders successfully.
     */
    @Test
    void getAllPhoneNumbersSuccess() {
        List<PhoneNumber> phoneNumbers = dao.getAll();
        assertEquals(4, phoneNumbers.size());
    }

    @Test
    void getByIdSuccess() {
        PhoneNumber retrievedPhoneNumber = (PhoneNumber) dao.getById("2");
        assertNotNull(retrievedPhoneNumber);
        assertEquals(retrievedPhoneNumber, dao.getById("2"));
    }

    /**
     * Verify successful get by property (equal match)
     */
    @Test
    void getByPropertyEqualSuccess() {
        List<PhoneNumber> phoneNumbers = dao.getByPropertyEqual("number", "6084445678");
        assertEquals(1, phoneNumbers.size());
        assertEquals(3, phoneNumbers.get(0).getId());
    }

    /**
     * Verify successful get by property (like match)
     */
    @Test
    void getByPropertyLikeSuccess() {
        List<PhoneNumber> phoneNumbers = dao.getByPropertyLike("number", "56");
        assertEquals(2, phoneNumbers.size());
    }

}
