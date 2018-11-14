package edu.matc.entity;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import javax.persistence.Entity;
import java.util.Objects;

/**
 * The type role.
 */

@Entity(name = "Role")
@Table(name = "Role")
public class Role {


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
    @GenericGenerator(name = "native", strategy = "native")
    private int id;

    private String role;

    //@ManyToOne
    //@JoinColumn(role = "user_id",
     //       foreignKey = @ForeignKey(role = "user_id")
    //)
    //private User user;

    /**
     * Instantiates a new Role.
     */
    public Role() {
    }

    /**
     * Instantiates a new Role.
     *
     * @param role        the role
     * @param user        the user
     */
    public Role(String role, User user) {
        //this.user = user;
        this.role = role;
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
     * Gets role.
     *
     * @return the role
     */
    public String getrole() {
        return role;
    }

    /**
     * Sets role.
     *
     * @param role the role
     */
    public void setrole(String role) {
        this.role = role;
    }


    /**
     * Gets user.
     *
     * @return the user
     */
   // public User getUser() {
        //return user;
   // }

    /**
     * Sets user.
     *
     * @param //user the user
     */
    //public void setUser(User user) {
        //this.user = user;
    //}

    @Override
    public String toString() {
        return "Role{" +
                "id=" + id +
                ", role='" + role + '\'' +
                //", user=" + user +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Role role = (Role) o;
        return id == role.id &&
                Objects.equals(role, role.role);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id,  role);
    }

}