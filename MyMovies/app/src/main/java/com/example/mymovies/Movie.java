package com.example.mymovies;

public class Movie {
    private String title;
    private int image;
    private int description;
    private String directors;
    private String actors;
    private String youTubeLink;

    public Movie(String title, int image, int description, String directors, String actors, String youTubeLink) {
        this.title = title;
        this.image = image;
        this.description = description;
        this.directors = directors;
        this.actors = actors;
        this.youTubeLink = youTubeLink;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public int getDescription() {
        return description;
    }

    public void setDescription(int description) {
        this.description = description;
    }

    public String getDirectors() {
        return directors;
    }

    public void setDirectors(String directors) {
        this.directors = directors;
    }

    public String getActors() {
        return actors;
    }

    public void setActors(String actors) {
        this.actors = actors;
    }

    public String getYouTubeLink() {
        return youTubeLink;
    }

    public void setYouTubeLink(String youTubeLink) {
        this.youTubeLink = youTubeLink;
    }
}
