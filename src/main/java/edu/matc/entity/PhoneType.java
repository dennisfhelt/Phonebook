package edu.matc.entity;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

/**
 * Phone Type Class
 *
 * @author kheise
 */
@Entity(name = "PhoneType")
@Table(name = "PhoneType")
public class PhoneType {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
    @GenericGenerator(name = "native", strategy = "native")
    private int id;

    private String type;

    @OneToMany(mappedBy = "phoneType", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER)
    private Set<PhoneNumber> numbers = new HashSet<>();

    /**
     * Instantiates a new Phone type.
     */
    public PhoneType() {
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

    /**
     * Gets type.
     *
     * @return the type
     */
    public String getType() {
        return type;
    }

    /**
     * Sets type.
     *
     * @param type the type
     */


    public void setType(String type) {
        this.type = type;
    }

    /**
     * Gets numbers.
     *
     * @return the numbers
     */
    public Set<PhoneNumber> getNumbers() {
        return numbers;
    }

    /**
     * Sets numbers.
     *
     * @param numbers the numbers
     */
    public void setNumbers(Set<PhoneNumber> numbers) {
        this.numbers = numbers;
    }

    /**
     * Add phone number.
     *
     * @param phoneNumber the phone number
     */
    public void addPhoneNumber(PhoneNumber phoneNumber) {
        numbers.add(phoneNumber);
    }

    /**
     * Remove phone number.
     *
     * @param phoneNumber the phone number
     */
    public void removePhoneNumber(PhoneNumber phoneNumber) {
        numbers.remove(phoneNumber);
        phoneNumber.setUser(null);
    }


    @Override
    public String toString() {
        return "PhoneType{" +
                "id=" + id +
                ", type='" + type + '\'' +
                '}';
    }
}
