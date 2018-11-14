package edu.matc.persistence;

import edu.matc.entity.Phonebook;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

/**
 * Data Access class to crud books.
 */
public class PhonebookDao {

    private final Logger logger = LogManager.getLogger(this.getClass());
    SessionFactory sessionFactory = SessionFactoryProvider.getSessionFactory();

    /**
     * Get book by id
     */
    public Phonebook getById(int id) {
        Session session = sessionFactory.openSession();
        Phonebook book = session.get(Phonebook.class, id);
        session.close();
        return book;
    }

    /**
     * update book
     * @param book  Phonebook to be inserted or updated
     */
    public void saveOrUpdate(Phonebook book) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        session.saveOrUpdate(book);
        session.getTransaction().commit();
        session.close();
    }

    /**
     * update Phonebook
     * @param book  Phonebook to be inserted or updated
     */
    public int insert(Phonebook book) {
        int id = 0;
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        id = (int)session.save(book);
        transaction.commit();
        session.close();
        return id;
    }

    /**
     * Delete a book
     * @param book Phonebook to be deleted
     */
    public void delete(Phonebook book) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.delete(book);
        transaction.commit();
        session.close();
    }


    /** Return a list of all books
     *
     * @return All books
     */
    public List<Phonebook> getAll() {
        Session session = sessionFactory.openSession();
        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<Phonebook> query = builder.createQuery(Phonebook.class);
        Root<Phonebook> root = query.from(Phonebook.class);
        List<Phonebook> books = session.createQuery(query).getResultList();
        session.close();
        return books;
    }



}
