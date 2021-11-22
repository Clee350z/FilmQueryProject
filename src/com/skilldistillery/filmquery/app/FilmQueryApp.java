package com.skilldistillery.filmquery.app;

import java.util.Scanner;

import com.skilldistillery.filmquery.database.DatabaseAccessor;
import com.skilldistillery.filmquery.database.DatabaseAccessorObject;
import com.skilldistillery.filmquery.entities.Film;

public class FilmQueryApp {
  
  DatabaseAccessor db = new DatabaseAccessorObject();

  public static void main(String[] args) {
    FilmQueryApp app = new FilmQueryApp();
  //  app.test();
    Scanner input = new Scanner(System.in);
   app.launch(input);
  }

  private void test() {
    Film film = db.findFilmById(1);
    System.out.println(film);
  }

  private void launch(Scanner input) {
    
   
    startUserInterface(input);
    
    
    
    input.close();
  }

  private void startUserInterface(Scanner input) {
    boolean run = true;
    while (run = true) {
    	displayMenu();
    	int userInput = input.nextInt();
    	switch(userInput) {
    	case 1:
    		System.out.println("Please enter the film ID");
    		int userFilmId = input.nextInt();
    		Film film = db.findFilmById(userFilmId);
    		if (film != null) {
    			System.out.println("Title: " + film.getTitle()+", Year: "+  film.getRelease_Year()+
    					", Rating: "+ film.getRating() +", Description: "+ film.getDescription() + ", Language: " + film.getLanguage()
    					+ ", List of Actors:" + film.getActors());    			
    		} else {
    			System.out.println("Not a valid film ID, Please try again.");
    		}
    		break;
    	case 2:
    		System.out.println("Enter a word you think might be in the title or description");
    		String userKeyword = input.next();
    		Film keywordFilm = db.findFilmByKeyword(userKeyword);
    		if (keywordFilm != null) {
    			System.out.println("Title: " + keywordFilm.getTitle()+", Year: "+  keywordFilm.getRelease_Year()+
    					", Rating: "+ keywordFilm.getRating() +", Description: "+ keywordFilm.getDescription()+ ", Language: "+ keywordFilm.getLanguage()
    					+ ", List of Actors:" + keywordFilm.getActors());    			
    		} else {
    			System.out.println("Couldn't find any results for that keyword. Please try again.");
    		}
    		break;
    	case 3:
    		System.out.println("Goodbye!");
    		run = false;
    		return;
    	}
    	
    }
  }
  
  private void displayMenu() {
	  System.out.println("Please choose from the following (1-3)");
	  System.out.println("1. Look up film by the ID number");
	  System.out.println("2. Search films by keyword");
	  System.out.println("3. Exit program");
	 
  }

}
