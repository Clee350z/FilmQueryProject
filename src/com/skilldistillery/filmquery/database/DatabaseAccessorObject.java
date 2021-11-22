package com.skilldistillery.filmquery.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.skilldistillery.filmquery.entities.Actor;
import com.skilldistillery.filmquery.entities.Film;

public class DatabaseAccessorObject implements DatabaseAccessor {
	private static final String URL = "jdbc:mysql://localhost:3306/sdvid?useSSL=false";
	private static final String USER = "student";
	private static final String PASS = "student";
  @Override
  public Film findFilmById(int filmId) {
	  Film film = null;
	  try {
		  
		  Connection conn = DriverManager.getConnection(URL, USER, PASS);
	  String sql = "SELECT * FROM film JOIN language ON film.language_id = language.id WHERE film.id = ?";
	  PreparedStatement stmt = conn.prepareStatement(sql);
	  stmt.setInt(1, filmId);
	  ResultSet filmResult = stmt.executeQuery();
	  if (filmResult.next()) {
		film = new Film(); 
	    film.setId(filmResult.getInt("id"));
	    film.setTitle(filmResult.getString("title"));
	    film.setDescription(filmResult.getString("description"));
	    film.setRelease_Year(filmResult.getInt("release_year"));
	    film.setLanguage_Id(filmResult.getInt("language_id"));
	    film.setRental_Duration(filmResult.getInt("rental_duration"));	    
	    film.setRental_Rate(filmResult.getDouble("rental_rate"));
	    film.setLength(filmResult.getDouble("length"));
	    film.setReplacement_cost(filmResult.getDouble("replacement_cost"));
	    film.setRating(filmResult.getString("rating"));
	    film.setSpecial_features(filmResult.getString("special_features"));
	    film.setActors(findActorsByFilmId(filmId));
	    film.setLanguage(filmResult.getString("language.name"));
	    
	    
	    
	  }
		   filmResult.close();
		   stmt.close();
		   conn.close();
  }catch (SQLException e) {
	  e.printStackTrace();
  }
	  return film;
  }

@Override
public Actor findActorById(int actorId) {
	 Actor actor = null;
	  try {
		  
		  Connection conn = DriverManager.getConnection(URL, USER, PASS);
	  String sql = "SELECT * FROM actor WHERE id = ?";
	  PreparedStatement stmt = conn.prepareStatement(sql);
	  stmt.setInt(1, actorId);
	  ResultSet actorResult = stmt.executeQuery();
	  if (actorResult.next()) {
		actor = new Actor(); 
	    actor.setId(actorResult.getInt("id"));
	    actor.setFirstName(actorResult.getString("first_name"));
	    actor.setLastName(actorResult.getString("last_name"));

	  }
	   actorResult.close();
	   stmt.close();
	   conn.close();
}catch (SQLException e) {
	  e.printStackTrace();
}
	  return actor;
}

@Override
public List<Actor> findActorsByFilmId(int filmId) {
	List<Actor> listActors = new ArrayList<>();
	 Actor actor = null;
	  try {
		 
		  Connection conn = DriverManager.getConnection(URL, USER, PASS);
	  String sql = "SELECT * FROM film_actor JOIN actor ON actor.id = film_actor.actor_id WHERE film_id = ?";
	  PreparedStatement stmt = conn.prepareStatement(sql);
	  stmt.setInt(1, filmId);
	  ResultSet actorResult = stmt.executeQuery();
	  if (actorResult.next()) {
		actor = new Actor(); 
	    actor.setId(actorResult.getInt("id"));
	    actor.setFirstName(actorResult.getString("first_name"));
	    actor.setLastName(actorResult.getString("last_name"));
	    
	   listActors.add(actor);
	   
	  }
	   actorResult.close();
	   stmt.close();
	   conn.close();
}catch (SQLException e) {
	  e.printStackTrace();
}
	
	return listActors;
}

public Film findFilmByKeyword(String keyword) {
	  Film film = null;
	  try {
		  String URL = "jdbc:mysql://localhost:3306/sdvid?useSSL=false";
		  Connection conn = DriverManager.getConnection(URL, USER, PASS);
	  String sql = "SELECT * FROM film WHERE (title LIKE ?) OR (description LIKE ?)";
	  PreparedStatement stmt = conn.prepareStatement(sql);
	  stmt.setString(1, "%" + keyword + "%");
	  stmt.setString(2, "%" + keyword + "%");
	  ResultSet filmResult = stmt.executeQuery();
	  if (filmResult.next()) {
		film = new Film(); 
	    film.setTitle(filmResult.getString("title"));
	    film.setDescription(filmResult.getString("description"));

	  }
		   filmResult.close();
		   stmt.close();
		   conn.close();
}catch (SQLException e) {
	  e.printStackTrace();
}
	  return film;
}

}
