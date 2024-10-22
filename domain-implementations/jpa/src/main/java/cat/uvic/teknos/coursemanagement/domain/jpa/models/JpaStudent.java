package cat.uvic.teknos.coursemanagement.domain.jpa.models;

import cat.uvic.teknos.coursemanagement.models.Course;
import cat.uvic.teknos.coursemanagement.models.Genre;
import cat.uvic.teknos.coursemanagement.models.Student;
import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.Set;

@Entity
@Table(name = "student")
public class JpaStudent implements Student {
    @Id
    @Column(name = "ID", nullable = false)
    private int id;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ADDRESS")
    private JpaAddress address;

    @Column(name = "BORN_ON")
    private LocalDate bornOn;

    @ManyToOne(fetch = FetchType.LAZY, targetEntity = JpaGenre.class)
    @JoinColumn(name = "GENRE")
    private Genre genre;

    @Column(name = "FIRST_NAME")
    private String firstName;

    @Column(name = "LAST_NAME")
    private String lastName;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public JpaAddress getAddress() {
        return address;
    }

    public void setAddress(JpaAddress address) {
        this.address = address;
    }

    public LocalDate getBornOn() {
        return bornOn;
    }

    public void setBornOn(LocalDate bornOn) {
        this.bornOn = bornOn;
    }

    @Override
    public Set<Course> getCourses() {
        return Set.of();
    }

    @Override
    public void setCourses(Set<Course> courses) {

    }

    public Genre getGenre() {
        return genre;
    }

    @Override
    public void setGenre(Genre genre) {
        this.genre = genre;
    }


    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

}