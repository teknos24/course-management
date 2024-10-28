package cat.uvic.teknos.coursemanagement.clients.console.dto;

import cat.uvic.teknos.coursemanagement.models.Genre;

public class GenreDto implements Genre {
    private int id;
    private String description;

    @Override
    public int getId() {
        return id;
    }

    @Override
    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String getDescription() {
        return description;
    }

    @Override
    public void setDescription(String description) {
        this.description = description;
    }
}
