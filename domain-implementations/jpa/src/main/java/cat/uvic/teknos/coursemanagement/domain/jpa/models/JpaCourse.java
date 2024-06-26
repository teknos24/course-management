package cat.uvic.teknos.coursemanagement.domain.jpa.models;

import cat.uvic.teknos.coursemanagement.models.Course;
import cat.uvic.teknos.coursemanagement.models.Student;
import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Set;
public class JpaCourse implements Course {
    private int id;
    private int year;
    private String name;
    private Set<Student>  students = new HashSet<>();

    @Override
    public int getId() {
        return id;
    }

    @Override
    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public int getYear() {
        return year;
    }

    @Override
    public void setYear(int year) {
        this.year = year;
    }

    @Override
    public Set<Student> getStudents() {
        return students;
    }

    @Override
    public void setStudents(Set<Student> students) {
        this.students = students;
    }
}
