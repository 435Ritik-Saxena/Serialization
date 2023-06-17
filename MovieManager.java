package com.techlabs.Movie;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
public class MovieManager {
	private List<Movie> movies;
 private static final String filePath="C://Users//hp//OneDrive//Desktop//Monocept Assignments/Movie.txt";

    public MovieManager() {
        movies = new ArrayList<>();
        loadMovies();
    }

    public void addMovie(Movie movie) {
        movies.add(movie);
        saveMovies();
    }

    public void clearMovies() {
        movies.clear();
        saveMovies();
    }

    public int getMovieId() {
        return movies.size() + 1;
    }
    public void showMovies() {
        for (Movie movie : movies) {
            System.out.println(movie);
        }
    }
    private void loadMovies() {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(filePath))) {
            movies = (List<Movie>) ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Error loading movies: " + e.getMessage());
        }
    }

    private void saveMovies() {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(filePath))) {
            oos.writeObject(movies);
        } catch (IOException e) {
            System.out.println("Error saving movies: " + e.getMessage());
        }
    }

}