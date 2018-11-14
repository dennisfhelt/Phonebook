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

    @Column(name = "land_line")
    private String landLine;

    @Column(name = "work_phone")
    private String workPhone;

    @Column(name = "street_address")
    private String streetAddress;
    private String city;
    @Column(name = "state_postal")
    private String statePostal;

    /**
     * Instantiates a new Location.

    public Location() {
    }


    /**
     * Instantiates a new Location.
     *
     * @param lastName      the last name
     * @param firstName     the first name
     * @param id            the id
     * @param landLine      the land line
     * @param workPhone     the work phone
     * @param streetAddress the street address
     * @param statePostal   the state postal

    public Location(String lastName, String firstName, int id, String landLine, String workPhone, String streetAddress, String statePostal) {
        this.lastName = lastName;
        this.firstName = firstName;
        this.id = id;
        this.landLine = landLine;
        this.workPhone = workPhone;
        this.streetAddress = streetAddress;
        this.statePostal = statePostal;
    }

    /**
     * Gets last name.
     *
     * @return the last name

    public String getLastName() {
        return lastName;
    }

    /**
     * Sets last name.
     *
     * @param lastName the last name

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    /**
     * Gets first name.
     *
     * @return the first name

    public String getFirstName() {
        return firstName;
    }

    /**
     * Sets first name.
     *
     * @param firstName the first name

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    /**
     * Gets id.
     *
     * @return the id

    public int getId() {
        return id;
    }

    /**
     * Sets id.
     *
     * @param id the id

    public void setId(int id) {
        this.id = id;
    }

    /**
     * Gets land line.
     *
     * @return the land line

    public String getLandLine() {
        return landLine;
    }

    /**
     * Sets land line.
     *
     * @param landLine the land line

    public void setLandLine(String landLine) {
        this.landLine = landLine;
    }

    /**
     * Gets work phone.
     *
     * @return the work phone

    public String getWorkPhone() {
        return workPhone;
    }

    /**
     * Sets work phone.
     *
     * @param workPhone the work phone

    public void setWorkPhone(String workPhone) {
        this.workPhone = workPhone;
    }

    /**
     * Gets street address.
     *
     * @return the street address

    public String getStreetAddress() {
        return streetAddress;
    }

    /**
     * Sets street address.
     *
     * @param streetAddress the street address

    public void setStreetAddress(String streetAddress) {
        this.streetAddress = streetAddress;
    }

    /**
     * Gets city.
     *
     * @return the city

    public String getCity() {
        return city;
    }

    /**
     * Sets city.
     *
     * @param city the city

    public void setCity(String city) {
        this.city = city;
    }

    /**
     * Gets state postal.
     *
     * @return the state postal

    public String getStatePostal() {
        return statePostal;
    }

    /**
     * Sets state postal.
     *
     * @param statePostal the state postal

    public void setStatePostal(String statePostal) {
        this.statePostal = statePostal;
    }

    @Override
    public String toString() {
        return "Location{" +
                "lastName='" + lastName + '\'' +
                ", firstName='" + firstName + '\'' +
                ", id=" + id +
                ", landLine='" + landLine + '\'' +
                ", workPhone='" + workPhone + '\'' +
                ", streetAddress='" + streetAddress + '\'' +
                ", city='" + city + '\'' +
                ", statePostal='" + statePostal + '\'' +
                '}';
    }
}

        */