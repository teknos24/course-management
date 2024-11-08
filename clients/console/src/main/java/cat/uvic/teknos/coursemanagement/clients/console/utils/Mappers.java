package cat.uvic.teknos.coursemanagement.clients.console.utils;

import cat.uvic.teknos.coursemanagement.clients.console.dto.GenreDto;
import cat.uvic.teknos.coursemanagement.models.Genre;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.module.SimpleModule;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;

public class Mappers {
    private static final ObjectMapper mapper;

    static  {
        mapper = new ObjectMapper();
        mapper
                .registerModule(new JavaTimeModule()) // Registered to map LocalDate (add implementation("com.fasterxml.jackson.datatype:jackson-datatype-jsr310:2.18.0" to build.gradle.kts) )
                .registerModule(
                        new SimpleModule()
                            .addAbstractTypeMapping(Genre.class, GenreDto.class)
                )
                .registerModule(
                        new SimpleModule()
                                .addAbstractTypeMapping(Genre.class, GenreDto.class)
                ); // Registered to map the Genre deserialization
    }

    public static ObjectMapper get() {
        return mapper;
    }
}
