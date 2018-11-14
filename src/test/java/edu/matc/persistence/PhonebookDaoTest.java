package edu.matc.persistence;

import edu.matc.entity.Phonebook;
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
        Phonebook retrievedPhonebook = dao.getById(3);
        assertEquals("Java: A Beginner’s Guide (Sixth Edition)", retrievedPhonebook.getTitle());
        assertEquals("Herbert Schilt", retrievedPhonebook.getAuthor());
        assertEquals("978-0071809252", retrievedPhonebook.getIsbn());
        assertEquals(2014, retrievedPhonebook.getPublicationYear());

    }

    @Test
    void saveOrUpdateSuccess() {
        Phonebook retrievedPhonebook = dao.getById(3);
        retrievedPhonebook.setAuthor("Rudyard Kipling");
        dao.saveOrUpdate(retrievedPhonebook);
        retrievedPhonebook = dao.getById(3);
        assertEquals("Rudyard Kipling", retrievedPhonebook.getAuthor());
    }

    @Test
    void insertSuccess() {

        Phonebook addedPhonebook = new Phonebook("Green Eggs and Ham", "Dr. Seuss", 33, "978-007414141", 1950);
        dao.insert(addedPhonebook);
        Phonebook retrievedPhonebook = dao.getById(4);
        assertEquals("Green Eggs and Ham", retrievedPhonebook.getTitle());
        assertEquals("Dr. Seuss", retrievedPhonebook.getAuthor());
        assertEquals("978-007414141", retrievedPhonebook.getIsbn());
        assertEquals(1950, retrievedPhonebook.getPublicationYear());
    }

    @Test
    void deleteSuccess() {
        Phonebook phonebookToRemove = dao.getById(3);
        dao.delete(phonebookToRemove);
        assertNull(dao.getById(3));
    }

    @Test
    void getAllSuccess() {
        List<Phonebook> users = dao.getAll();
        assertEquals(3, users.size());
    }
}

