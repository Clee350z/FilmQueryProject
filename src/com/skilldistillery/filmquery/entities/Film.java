package com.skilldistillery.filmquery.entities;

import java.util.List;
import java.util.Objects;

public class Film {
	public Film(List<Actor> actors, int id, String title, String description, int release_Year, int language_Id,
			int rental_Duration, double rental_Rate, double length, double replacement_cost, String rating,
			String special_features, String language) {
		super();
		this.actors = actors;
		this.id = id;
		this.title = title;
		this.description = description;
		this.release_Year = release_Year;
		this.language_Id = language_Id;
		this.rental_Duration = rental_Duration;
		this.rental_Rate = rental_Rate;
		this.length = length;
		this.replacement_cost = replacement_cost;
		this.rating = rating;
		this.special_features = special_features;
		this.language = language;
	}
	
	public Film() {
		super();
	}

	private List<Actor> actors;
	private int id;
	private String title;
	private String description;
	private int release_Year;
	private int language_Id;
	private int rental_Duration;
	private double rental_Rate;
	private double length;
	private double replacement_cost;
	private String rating;
	private String special_features;
	private String language;
	
	public String getLanguage() {
		return language;
	}

	public void setLanguage(String language) {
		this.language = language;
	}

	public List<Actor> getActors() {
		return actors;
	}
	public void setActors(List<Actor> actors) {
		this.actors = actors;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public int getRelease_Year() {
		return release_Year;
	}
	public void setRelease_Year(int release_Year) {
		this.release_Year = release_Year;
	}
	public int getLanguage_Id() {
		return language_Id;
	}
	public void setLanguage_Id(int language_Id) {
		this.language_Id = language_Id;
	}
	public int getRental_Duration() {
		return rental_Duration;
	}
	public void setRental_Duration(int rental_Duration) {
		this.rental_Duration = rental_Duration;
	}
	public double getRental_Rate() {
		return rental_Rate;
	}
	public void setRental_Rate(double rental_Rate) {
		this.rental_Rate = rental_Rate;
	}
	public double getLength() {
		return length;
	}
	public void setLength(double length) {
		this.length = length;
	}
	public double getReplacement_cost() {
		return replacement_cost;
	}
	public void setReplacement_cost(double replacement_cost) {
		this.replacement_cost = replacement_cost;
	}
	public String getRating() {
		return rating;
	}
	public void setRating(String rating) {
		this.rating = rating;
	}
	public String getSpecial_features() {
		return special_features;
	}
	public void setSpecial_features(String special_features) {
		this.special_features = special_features;
	}
	@Override
	public String toString() {
		return "Film [actors=" + actors + ", id=" + id + ", title=" + title + ", description=" + description
				+ ", release_Year=" + release_Year + ", language_Id=" + language_Id + ", rental_Duration="
				+ rental_Duration + ", rental_Rate=" + rental_Rate + ", length=" + length + ", replacement_cost="
				+ replacement_cost + ", rating=" + rating + ", special_features=" + special_features + "]";
	}
	@Override
	public int hashCode() {
		return Objects.hash(actors, description, id, language_Id, length, rating, release_Year, rental_Duration,
				rental_Rate, replacement_cost, special_features, title);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Film other = (Film) obj;
		return Objects.equals(actors, other.actors) && Objects.equals(description, other.description) && id == other.id
				&& language_Id == other.language_Id
				&& Double.doubleToLongBits(length) == Double.doubleToLongBits(other.length)
				&& Objects.equals(rating, other.rating) && release_Year == other.release_Year
				&& rental_Duration == other.rental_Duration
				&& Double.doubleToLongBits(rental_Rate) == Double.doubleToLongBits(other.rental_Rate)
				&& Double.doubleToLongBits(replacement_cost) == Double.doubleToLongBits(other.replacement_cost)
				&& Objects.equals(special_features, other.special_features) && Objects.equals(title, other.title);
	}
	
}

