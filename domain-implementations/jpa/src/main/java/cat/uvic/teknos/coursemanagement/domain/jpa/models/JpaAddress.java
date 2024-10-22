package cat.uvic.teknos.coursemanagement.domain.jpa.models;

import cat.uvic.teknos.coursemanagement.models.Address;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "address")
public class JpaAddress implements Address {
    @Id
    @Column(name = "ID", nullable = false)
    private int id;

    @Column(name = "STREET")
    private String street;

    @Column(name = "ZIP")
    private String zip;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getZip() {
        return zip;
    }

    public void setZip(String zip) {
        this.zip = zip;
    }

}