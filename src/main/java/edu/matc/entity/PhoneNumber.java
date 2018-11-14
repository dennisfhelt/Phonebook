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

    @Column(name = "number")
    private String number;

    //@ManyToOne
    //@JoinColumn(name = "user",
     //       foreignKey = @ForeignKey(name = "")
    //)
   //private User user;

    /**
     * Instantiates a new PhoneNumber.
     */
    public PhoneNumber() {
    }

    public String getPhoneNumber() {

        return number;
    }

    public void setPhoneNumber(String number) {

        this.number = number;
    }

    @Override
    public String toString() {
        return "PhoneNumber{" +
                "phoneNumber='" + number + '\'' +
                //", user=" + user +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PhoneNumber that = (PhoneNumber) o;
        return Objects.equals(number, that.number);
                //&& Objects.equals(user, that.user);
    }

    @Override
    public int hashCode() {

        return Objects.hash(number);
    }
}
