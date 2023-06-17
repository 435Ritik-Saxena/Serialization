package com.techlabs.Movie;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class MovieController {
	 private MovieManager manager;

	    public MovieController() {
	        manager = new MovieManager();
	    }

	    public void start() {
	        displayMenu();
	    }
	    private void displayMenu() {
	        System.out.println("Movie Store Menu");
	        System.out.println("1. Add Movie");
	        System.out.println("2. Clear Movies");
	        System.out.println("3. Show Movies");
	        System.out.println("4. Exit");

	        int choice = getUserChoice();

	        switch (choice) {
	            case 1:
	                Movie movie = setMovieDetails();
	                manager.addMovie(movie);
	                System.out.println("Movie added successfully!");
	                displayMenu();
	                break;
	            case 2:
	                manager.clearMovies();
	                System.out.println("Movies cleared successfully!");
	                displayMenu();
	                break;
	            case 3:
	                System.out.println("Movies:");
	                manager.showMovies();
	                displayMenu();
	                break;
	            case 4:
	                System.out.println("Exiting...");
	                break;
	            default:
	                System.out.println("Invalid choice. Please try again.");
	                displayMenu();
	        }
	    }
	    private int getUserChoice() {
	        int choice = 0;
	        try {
	            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
	            choice = Integer.parseInt(reader.readLine());
	        } catch (IOException | NumberFormatException e) {
	            System.out.println("Error reading input: " + e.getMessage());
	        }
	        return choice;
	    }
	    private Movie setMovieDetails() {
	        int id = manager.getMovieId();
	        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
	        try {
	            System.out.print("Enter movie name: ");
	            String name = reader.readLine();
	            System.out.print("Enter movie year: ");
	            int year = Integer.parseInt(reader.readLine());
	            System.out.print("Enter movie genre: ");
	            String genre = reader.readLine();

	            return new Movie(id, name, year, genre);
	        } catch (IOException | NumberFormatException e) {
	            System.out.println("Error setting movie details: " + e.getMessage());
	        }
	        return null;
	    }

}
