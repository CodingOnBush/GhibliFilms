package com.example.ghiblifilms;

import java.util.ArrayList;

public class Film {
    private int id;
    private String title;
    private String description;
    private String director;
    private String producer;
    private int release_date;
    private int rt_score;
    private ArrayList<String> people;
    private ArrayList<String> species;
    private ArrayList<String> locations;
    private ArrayList<String> vehicles;
    private String url;

    public Film(int id, String title, String description, String director, String producer, int release_date, int rt_score, ArrayList<String> people, ArrayList<String> species, ArrayList<String> locations, ArrayList<String> vehicles, String url) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.director = director;
        this.producer = producer;
        this.release_date = release_date;
        this.rt_score = rt_score;
        this.people = people;
        this.species = species;
        this.locations = locations;
        this.vehicles = vehicles;
        this.url = url;
    }

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public String getDirector() {
        return director;
    }

    public String getProducer() {
        return producer;
    }

    public int getRelease_date() {
        return release_date;
    }

    public int getRt_score() {
        return rt_score;
    }

    public ArrayList<String> getPeople() {
        return people;
    }

    public ArrayList<String> getSpecies() {
        return species;
    }

    public ArrayList<String> getLocations() {
        return locations;
    }

    public ArrayList<String> getVehicles() {
        return vehicles;
    }

    public String getUrl() {
        return url;
    }
}
