package cat.uvic.teknos.coursemanagement.services.controllers;

import cat.uvic.teknos.coursemanagement.domain.jpa.models.JpaGenre;
import cat.uvic.teknos.coursemanagement.domain.jpa.models.JpaStudent;
import cat.uvic.teknos.coursemanagement.models.Genre;
import cat.uvic.teknos.coursemanagement.models.Student;
import cat.uvic.teknos.coursemanagement.services.utils.Mappers;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import org.junit.jupiter.api.Test;
import com.fasterxml.jackson.databind.module.SimpleModule;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class StudentControllerTest {

    @Test
    void serializationAndDeserializationWithInterfaceFields() throws JsonProcessingException {
        var student = new JpaStudent();
        student.setFirstName("John");
        student.setLastName("Doe");
        student.setBornOn(LocalDate.of(1980, 1, 1));

        var genre = new JpaGenre();
        genre.setId(1);
        genre.setDescription("Male");
        student.setGenre(genre);

        var mapper = Mappers.get();
        var json = mapper.writeValueAsString(student);

        assertNotNull(json);

        var studentDeserialized = mapper.readValue(json, JpaStudent.class);

        assertNotNull(studentDeserialized);
        assertNotNull(studentDeserialized.getGenre());
    }
}