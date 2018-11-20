package edu.matc.persistence;

import edu.matc.entity.Location;
import edu.matc.testUtils.Database;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;

public class LocationDaoTest {

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

        dao = new Dao(Location.class);
    }

    /**
     * Verifies gets all orders successfully.
     */
    @Test
    void getAllUsersSuccess() {
        List<Location> locations = dao.getAll();
        assertEquals(3, locations.size());
    }

    /**
     * Verifies a order is returned correctly based on id search
     */
    @Test
    void getByIdSuccess() {
        Location retrievedLocation = (Location)dao.getById(2);
        assertNotNull(retrievedLocation);
        assertEquals(retrievedLocation, dao.getById(2));
    }

    @Test
    void deleteSuccess() {
        dao.delete(dao.getById(1));
        assertNull(dao.getById(1));
    }

    /**
     * Verify successful get by property (equal match)
     */
    @Test
    void getByPropertyEqualSuccess() {
        List<Location> locations = dao.getByPropertyEqual("city", "Madison");
        assertEquals(3, locations.size());

    }

    /**
     * Verify successful get by property (like match)
     */
    @Test
    void getByPropertyLikeSuccess() {
        List<Location> locations = dao.getByPropertyLike("streetAddress", "Rd");
        assertEquals(2, locations.size());
    }

}
