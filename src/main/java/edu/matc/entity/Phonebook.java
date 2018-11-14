package edu.matc.entity;

import javax.persistence.*;

/**
 * Represents a Phonebook entry
 */
@Entity(name = "Phonebook")
@Table(name = "user")
public class Phonebook {
    @Column(name = "last_name")
    private String lastName;
    @Column(name = "first_name")
    private String firstName;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
    private int id;

    /**
     * Instantiates a new Phonebook.
     */
    public Phonebook() {
    }


    /**
     * Instantiates a new Phonebook.
     *
     * @param lastName      the last name
     * @param firstName     the first name
     * @param id            the id
     * @param landLine      the land line
     * @param workPhone     the work phone
     * @param streetAddress the street address
     * @param statePostal   the state postal
     */
    public Phonebook(String lastName, String firstName, int id, String landLine, String workPhone, String streetAddress, String statePostal) {
        this.lastName = lastName;
        this.firstName = firstName;
        this.id = id;
    }

    /**
     * Gets last name.
     *
     * @return the last name
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * Sets last name.
     *
     * @param lastName the last name
     */
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    /**
     * Gets first name.
     *
     * @return the first name
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * Sets first name.
     *
     * @param firstName the first name
     */
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    /**
     * Gets id.
     *
     * @return the id
     */
    public int getId() {
        return id;
    }

    /**
     * Sets id.
     *
     * @param id the id
     */
    public void setId(int id) {
        this.id = id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Phonebook)) return false;

        Phonebook phonebook = (Phonebook) o;

        if (id != phonebook.id) return false;
        if (!lastName.equals(phonebook.lastName)) return false;
        return firstName.equals(phonebook.firstName);
    }

    @Override
    public int hashCode() {
        int result = lastName.hashCode();
        result = 31 * result + firstName.hashCode();
        result = 31 * result + id;
        return result;
    }

    @Override
    public String toString() {
        return "Phonebook{" +
                "lastName='" + lastName + '\'' +
                ", firstName='" + firstName + '\'' +
                ", id=" + id +
                '}';
    }
}