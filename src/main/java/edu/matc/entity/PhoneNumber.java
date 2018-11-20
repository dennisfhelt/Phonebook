package edu.matc.entity;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import javax.persistence.Entity;
import java.util.Objects;

/**
 * The phone number.
 */
@Entity(name = "PhoneNumber")
@Table(name = "PhoneNumbers")
public class PhoneNumber {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
    @GenericGenerator(name = "native", strategy = "native")
    private int id;

    @Column(name = "number")
    private String number;

    @ManyToOne
    @JoinColumn(name = "Users_id",
            foreignKey = @ForeignKey(name = "PhoneNumbers_Users")
    )
    private User user;

    @ManyToOne
    @JoinColumn(name = "PhoneType_id",
            foreignKey = @ForeignKey(name = "PhoneNumbers_PhoneType")
    )
    private PhoneType phoneType;

    /**
<<<<<<< HEAD
     * Instantiates a new PhoneNumber.
=======
     * Instantiates a new Phone number.
>>>>>>> acc8487cf5a51bb16d83c03f93ba4e208bdd2975
     */
    public PhoneNumber() {
    }



    /**
     * Instantiates a new Phone number.
     *
     * @param number    the number
     * @param user      the user
     * @param phoneType the phone type
     */
    public PhoneNumber(String number, User user, PhoneType phoneType) {
        this.number = number;
        this.user = user;
        this.phoneType = phoneType;
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
     * Gets number.
     *
     * @return the number
     */
    public String getNumber() {
        return number;
    }

    /**
     * Sets number.
     *
     * @param number the number
     */
    public void setNumber(String number) {
        this.number = number;
    }

    /**
     * Gets user.
     *
     * @return the user
     */
    public User getUser() {
        return user;
    }

    /**
     * Sets user.
     *
     * @param user the user
     */
    public void setUser(User user) {
        this.user = user;
    }

    /**
     * Gets phone type.
     *
     * @return the phone type
     */
    public PhoneType getPhoneType() {
        return phoneType;
    }

    /**
     * Sets phone type.
     *
     * @param phoneType the phone type
     */
    public void setPhoneType(PhoneType phoneType) {
        this.phoneType = phoneType;
    }

    @Override
    public String toString() {
        return "PhoneNumber{" +
                "id=" + id +
                ", number='" + number + '\'' +
                ", user=" + user +
                ", phoneType=" + phoneType +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PhoneNumber that = (PhoneNumber) o;
        return id == that.id &&
                Objects.equals(number, that.number);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, number, user, phoneType);
    }
}
