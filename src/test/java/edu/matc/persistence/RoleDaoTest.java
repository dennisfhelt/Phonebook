package edu.matc.persistence;

import edu.matc.entity.Role;
import edu.matc.testUtils.Database;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static edu.matc.testUtils.Database.getInstance;
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
        Database database = getInstance();
        database.runSQL("cleandb.sql");

        dao = new Dao(Role.class);
    }

    /**
     * Verifies gets all orders successfully.
     */
    @Test
    void getAllRolesSuccess() {
        List<Role> role = dao.getAll();
        assertEquals(1, role.size());
    }

    /**
     * Verifies a order is returned correctly based on id search
     */
    @Test
    void getByIdSuccess() {
        Role retrievedRole = (Role) dao.getById(1);
        assertNotNull(retrievedRole);
        assertEquals(retrievedRole, dao.getById(1));
    }

    @Test
    void getByPropertyEqualSuccess() {
        List<Role> roles = dao.getByPropertyEqual("role", "admin");
        assertEquals(1, roles.size());
        assertEquals(1, roles.get(0).getId());
    }

    @Test
    void deleteSuccess() {
        dao.delete(dao.getById(1));
        assertNull(dao.getById(1));
    }

}
