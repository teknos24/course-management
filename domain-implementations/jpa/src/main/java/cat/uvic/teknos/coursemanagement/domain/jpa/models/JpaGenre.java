package cat.uvic.teknos.coursemanagement.domain.jpa.models;

import cat.uvic.teknos.coursemanagement.models.Genre;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.io.Serializable;

@Entity
@Table(name = "genre")
public class JpaGenre implements Genre {
    @Id
    @Column(name = "ID", nullable = false)
    private int id;

    @Column(name = "DESCRIPTION")
    private String description;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

}