package edu.matc.entity;


import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

/**
 * Represents a Location entry
 */
@Entity(name = "Location")
@Table(name = "Locations")
public class Location {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
    @GenericGenerator(name = "native", strategy = "native")

    private int id;

    @Column(name = "street")
    private String streetAddress;

    private String city;

    private String state;

    @Column(name = "zip")
    private String statePostal;

    /**
     * Instantiates a new Location.
    */
    public Location() {
    }


    /**
     * Instantiates a new Location.
     *
     * @param id            the id
     * @param streetAddress the street address
     * @param statePostal   the state postal
     */
    public Location(int id, String streetAddress, String city, String state, String statePostal) {
        this.id = id;
        this.streetAddress = streetAddress;
        this.city = city;
        this.state = state;
        this.statePostal = statePostal;
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
     * Gets street address.
     *
     * @return the street address
    */
    public String getStreetAddress() {
        return streetAddress;
    }

    /**
     * Sets street address.
     *
     * @param streetAddress the street address
    */
    public void setStreetAddress(String streetAddress) {
        this.streetAddress = streetAddress;
    }

    /**
     * Gets city.
     *
     * @return the city
    */
    public String getCity() {
        return city;
    }

    /**
     * Sets city.
     *
     * @param city the city
    */
    public void setCity(String city) {
        this.city = city;
    }

    /**
     * Sets new state.
     *
     * @param state New value of state.
     */
    public void setState(String state) {
        this.state = state;
    }

    /**
     * Gets state.
     *
     * @return Value of state.
     */
    public String getState() {
        return state;
    }

    /**
     * Gets state postal.
     *
     * @return the state postal
    */
    public String getStatePostal() {
        return statePostal;
    }

    /**
     * Sets state postal.
     *
     * @param statePostal the state postal
    */
    public void setStatePostal(String statePostal) {
        this.statePostal = statePostal;
    }

    @Override
    public String toString() {
        return "Location{" +
                ", id=" + id +
                ", streetAddress='" + streetAddress + '\'' +
                ", state=" + state + '\'' +
                ", city='" + city + '\'' +
                ", statePostal='" + statePostal + '\'' +
                '}';
    }


}