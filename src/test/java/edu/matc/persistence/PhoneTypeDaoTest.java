package edu.matc.persistence;

import edu.matc.entity.PhoneNumber;
import edu.matc.entity.PhoneType;
import edu.matc.testUtils.Database;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class PhoneTypeDaoTest {

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

        dao = new Dao(PhoneType.class);
    }

    /**
     * Verifies gets all orders successfully.
     */
    @Test
    void getAllPhoneTypesSuccess() {
        List<PhoneType> phoneTypes = dao.getAll();
        assertEquals(3, phoneTypes.size());
    }

    /**
     * Verifies a order is returned correctly based on id search
     */
    @Test
    void getByIdSuccess() {
        PhoneType retrievedPhoneType = (PhoneType)dao.getById(2);
        assertNotNull(retrievedPhoneType);
        assertEquals(retrievedPhoneType, dao.getById(2));
    }


    /**
     * Verify successful delete of PhoneType
     */
    @Test
    void deleteSuccess() {
        dao.delete(dao.getById(1));
        assertNull(dao.getById(1));
    }

}


