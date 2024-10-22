package cat.uvic.teknos.coursemanagement.domain.jpa.models;

import cat.uvic.teknos.coursemanagement.models.Course;
import cat.uvic.teknos.coursemanagement.models.Student;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.util.Set;

@Entity
@Table(name = "course")
public class JpaCourse implements Course {
    @Id
    @Column(name = "ID", nullable = false)
    private int id;

    @Column(name = "YEAR")
    private int year;

    @Column(name = "NAME")
    private String name;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    @Override
    public Set<Student> getStudents() {
        return Set.of();
    }

    @Override
    public void setStudents(Set<Student> students) {

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}