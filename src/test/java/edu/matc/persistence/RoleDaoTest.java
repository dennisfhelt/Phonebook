package edu.matc.persistence;

import edu.matc.entity.Role;
import edu.matc.testUtils.Database;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;

public class RoleDaoTest {

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

        dao = new Dao(Role.class);
    }

    /**
     * Verifies gets all orders successfully.
     */
    @Test
    void getAllRolesSuccess() {
        List<Role> users = dao.getAll();
        assertEquals(4, users.size());
    }

    /**
     * Verifies a order is returned correctly based on id search
     */
    @Test
    void getByIdSuccess() {
        Role retrievedRole = (Role) dao.getById("2");
        assertNotNull(retrievedRole);
        assertEquals(retrievedRole, dao.getById("2"));
    }

    @Test
    void deleteSuccess() {
        dao.delete(dao.getById("3"));
        assertNull(dao.getById("3"));
    }

    @Test
    void getByPropertyEqualSuccess() {
        List<Role> roles = dao.getByPropertyEqual("role", "User");
        assertEquals(1, roles.size());
        assertEquals(2, roles.get(0).getId());
    }

}
