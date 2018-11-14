package edu.matc.persistence;
/**
import edu.matc.entity.Location;
import edu.matc.entity.Phonephonebook;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class PhonebookDaoTest {

    PhonebookDao dao;

    @BeforeEach
    void setUp() {
        edu.matc.test.util.Database database = edu.matc.test.util.Database.getInstance();
        database.runSQL("cleandb.sql");

        dao = new PhonebookDao();

    }

    @Test
    void getByIdSuccess() {
        Location retrievedLocation = dao.getById(3);
        assertEquals("Java: A Beginner’s Guide (Sixth Edition)", retrievedLocation.getTitle());
        assertEquals("Herbert Schilt", retrievedLocation.getAuthor());
        assertEquals("978-0071809252", retrievedLocation.getIsbn());
        assertEquals(2014, retrievedLocation.getPublicationYear());

    }

    @Test
    void saveOrUpdateSuccess() {
        Location retrievedLocation = dao.getById(3);
        retrievedLocation.setAuthor("Rudyard Kipling");
        dao.saveOrUpdate(retrievedLocation);
        retrievedLocation = dao.getById(3);
        assertEquals("Rudyard Kipling", retrievedLocation.getAuthor());
    }

    @Test
    void insertSuccess() {

        Location addedLocation = new Location("Green Eggs and Ham", "Dr. Seuss", 33, "978-007414141", 1950);
        dao.insert(addedLocation);
        Location retrievedLocation = dao.getById(4);
        assertEquals("Green Eggs and Ham", retrievedLocation.getTitle());
        assertEquals("Dr. Seuss", retrievedLocation.getAuthor());
        assertEquals("978-007414141", retrievedLocation.getIsbn());
        assertEquals(1950, retrievedLocation.getPublicationYear());
    }

    @Test
    void deleteSuccess() {
        Location locationToRemove = dao.getById(3);
        dao.delete(locationToRemove);
        assertNull(dao.getById(3));
    }

    @Test
    void getAllSuccess() {
        List<Location> users = dao.getAll();
        assertEquals(3, users.size());
    }
}

*/