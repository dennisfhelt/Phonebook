package matc.persistence;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Expression;
import javax.persistence.criteria.Root;
import java.util.List;

/**
 * The type dao.
 *
 * @param <T> the type parameter
 */
public class Dao<T> {
    private final Logger logger = LogManager.getLogger(this.getClass());
    private Class<T> type;

    /**
     * Instantiates a new Dao.
     *
     * @param type the type
     */
    public Dao(Class<T> type) {
        this.type = type;
    }

    /**
     * Gets all users.
     *
     * @return the all users
     */
    public List<T> getAll() {
        Session session = getSession();
        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<T> query = builder.createQuery(type);
        Root<T> root = query.from(type);
        List<T> entity = session.createQuery(query).getResultList();
        session.close();
        return entity;
    }

    /**
     * Get user by id
     *
     * @param id the id
     * @return the by id
     */
    public <T>T getById(String id) {
        Session session = getSession();
        int result = Integer.parseInt(id);
        T entity = (T)session.get( type, result );
        session.close();
        return entity;
    }

    /**
     * update entity
     *
     * @param entity Entity to be inserted or updated
     */
    public void saveOrUpdate(T entity) {
        Session session = getSession();
        session.beginTransaction();
        session.saveOrUpdate(entity);
        session.getTransaction().commit();
        session.close();
    }

    /**
     * update entity
     *
     * @param entity Entity to be inserted or updated
     * @return the int
     */
    public int insert(T entity) {
        int id = 0;
        Session session = getSession();
        Transaction transaction = session.beginTransaction();
        id = (int)session.save(entity);
        transaction.commit();
        session.close();
        return id;
    }

    /**
     * Delete a entity
     *
     * @param entity entity to be deleted
     */
    public void delete(T entity) {
        Session session = getSession();
        Transaction transaction = session.beginTransaction();
        session.delete(entity);
        transaction.commit();
        session.close();
    }

    /**
     * Get user by property (exact match)
     * sample usage: getByPropertyEqual("lastname", "Curry")
     *
     * @param propertyName the property name
     * @param value        the value
     * @return the by property equal
     */
    public List<T> getByPropertyEqual(String propertyName, String value) {
        Session session = getSession();

        logger.debug("Searching for user with " + propertyName + " = " + value);

        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<T> query = builder.createQuery(type);
        Root<T> root = query.from(type);
        query.select(root).where(builder.equal(root.get(propertyName), value));
        List<T> entity = session.createQuery(query).getResultList();

        session.close();
        return entity;
    }

    /**
     * Get user by property (like)
     * sample usage: getByPropertyLike("lastname", "C")
     *
     * @param propertyName the property name
     * @param value        the value
     * @return the by property like
     */
    public List<T> getByPropertyLike(String propertyName, String value) {
        Session session = getSession();

        logger.debug("Searching for user with {} = {}",  propertyName, value);

        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<T> query = builder.createQuery( type );
        Root<T> root = query.from( type );
        Expression<String> propertyPath = root.get(propertyName);

        query.where(builder.like(propertyPath, "%" + value + "%"));

        List<T> entity = session.createQuery( query ).getResultList();
        session.close();
        return entity;
    }

    /**
     * Returns an open session from the SessionFactory
     * @return session
     */
    private Session getSession() {
        return SessionFactoryProvider.getSessionFactory().openSession();

    }
}
