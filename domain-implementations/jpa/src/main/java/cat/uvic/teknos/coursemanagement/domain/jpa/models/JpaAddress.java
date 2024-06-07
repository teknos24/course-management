package cat.uvic.teknos.coursemanagement.domain.jpa.models;

import cat.uvic.teknos.coursemanagement.models.Address;
import jakarta.persistence.*;

public class JpaAddress implements Address {
    private int id;
    private String zip;
    private String street;

    @Override
    public int getId() {
        return id;
    }

    @Override
    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String getZip() {
        return zip;
    }

    @Override
    public void setZip(String zip) {
        this.zip = zip;
    }

    @Override
    public String getStreet() {
        return street;
    }

    @Override
    public void setStreet(String street) {
        this.street = street;
    }
}
