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
        assertEquals(4, phoneTypes.size());
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

    @Test
    void insertWithPhoneNumberSuccess() {

        Dao PhoneTypeDao = new Dao(PhoneType.class);
        PhoneType phoneType = (PhoneType)dao.getById(1);
        PhoneNumber newPhoneNumber = new PhoneNumber("6080000000", phoneType);
        phoneType.addPhoneNumber(newPhoneNumber);

        int id = dao.insert(newPhoneNumber);

        assertNotEquals(0,id);
        PhoneNumber insertedPhoneNumber = (PhoneNumber)dao.getById(id);
        assertEquals("6080000000", insertedPhoneNumber.getNumber());
        assertNotNull(insertedPhoneNumber.getUser());
        assertEquals("Joe", insertedPhoneNumber.getUser().getFirstName());
        // Could continue comparing all values, but
        // it may make sense to use .equals()
        // TODO review .equals recommendations http://docs.jboss.org/hibernate/orm/5.2/orderguide/html_single/Hibernate_Order_Guide.html#mapping-model-pojo-equalshashcode
    }

    /**
     * Verify successful delete of PhoneType
     */
    @Test
    void deleteSuccess() {
        dao.delete(dao.getById(3));
        assertNull(dao.getById(3));
    }

    @Test
    void updateWithPhoneNumberSuccess() {
        String phoneNumber = "6080002222";
        PhoneNumber phoneNumberToUpdate = (PhoneNumber)dao.getById(3);
        phoneNumberToUpdate.setNumber(phoneNumber);
        dao.saveOrUpdate(phoneNumberToUpdate);
        PhoneNumber retrievedPhoneNumber = (PhoneNumber)dao.getById(3);
        assertEquals(phoneNumberToUpdate, retrievedPhoneNumber);
    }

}


