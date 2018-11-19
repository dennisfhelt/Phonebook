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


    @Override
    public String toString() {
        return "PhoneType{" +
                "id=" + id +
                ", type='" + type + '\'' +
                '}';
    }
}
