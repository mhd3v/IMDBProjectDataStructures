package Model;

import java.io.Serializable;

public class MovieNode  implements Serializable{

	MovieNode(){}
	
	MovieNode(String movie_title , String color , String  num ,String dur , String  gross , String year , String imdb )
	{
		this.movie_title = movie_title;
		this.color = color;
		this.num_crictics_for_reviews = num;
		this.duration = dur;
		this.genre = gross;
		this.title_year = year;
		this.imdb_score = imdb;
	}
	
	public DirectorNode director;
	public ActorsOfAMovieList actors_of_movie;
	public String movie_title;
	public String color;
	public String num_crictics_for_reviews;
	public String duration;
	public String gross;
	public String num_rated_users;
	public String cast_total_facbook_likes;
	public String facenumber_in_poster;
	public String genre;
	public String plot_keywords;
	public String movie_imdb_link;
	public String num_users_for_reviews;
	public String language;
	public String country;
	public String content_rating;
	public String budget;
	public String title_year;
	public String imdb_score;
	public String aspect_ratio;
	public String movie_facebook_likes;
	public String num_voted_user ;
	public DirectorNode getDirector() {
		return director;
	}

	public void setDirector(DirectorNode director) {
		this.director = director;
	}

	public ActorsOfAMovieList getActors_of_movie() {
		return actors_of_movie;
	}

	public void setActors_of_movie(ActorsOfAMovieList actors_of_movie) {
		this.actors_of_movie = actors_of_movie;
	}

	public String getMovie_title() {
		return movie_title;
	}

	public void setMovie_title(String movie_title) {
		this.movie_title = movie_title;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public String getNum_crictics_for_reviews() {
		return num_crictics_for_reviews;
	}

	public void setNum_crictics_for_reviews(String num_crictics_for_reviews) {
		this.num_crictics_for_reviews = num_crictics_for_reviews;
	}

	public String getDuration() {
		return duration;
	}

	public void setDuration(String duration) {
		this.duration = duration;
	}

	public String getGross() {
		return gross;
	}

	public void setGross(String gross) {
		this.gross = gross;
	}

	public String getNum_rated_users() {
		return num_rated_users;
	}

	public void setNum_rated_users(String num_rated_users) {
		this.num_rated_users = num_rated_users;
	}

	public String getCast_total_facbook_likes() {
		return cast_total_facbook_likes;
	}

	public void setCast_total_facbook_likes(String cast_total_facbook_likes) {
		this.cast_total_facbook_likes = cast_total_facbook_likes;
	}

	public String getFacenumber_in_poster() {
		return facenumber_in_poster;
	}

	public void setFacenumber_in_poster(String facenumber_in_poster) {
		this.facenumber_in_poster = facenumber_in_poster;
	}

	public String getGenre() {
		return genre;
	}

	public void setGenre(String genre) {
		this.genre = genre;
	}

	public String getPlot_keywords() {
		return plot_keywords;
	}

	public void setPlot_keywords(String plot_keywords) {
		this.plot_keywords = plot_keywords;
	}

	public String getMovie_imdb_link() {
		return movie_imdb_link;
	}

	public void setMovie_imdb_link(String movie_imdb_link) {
		this.movie_imdb_link = movie_imdb_link;
	}

	public String getNum_users_for_reviews() {
		return num_users_for_reviews;
	}

	public void setNum_users_for_reviews(String num_users_for_reviews) {
		this.num_users_for_reviews = num_users_for_reviews;
	}

	public String getLanguage() {
		return language;
	}

	public void setLanguage(String language) {
		this.language = language;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getContent_rating() {
		return content_rating;
	}

	public void setContent_rating(String content_rating) {
		this.content_rating = content_rating;
	}

	public String getBudget() {
		return budget;
	}

	public void setBudget(String budget) {
		this.budget = budget;
	}

	public String getTitle_year() {
		return title_year;
	}

	public void setTitle_year(String title_year) {
		this.title_year = title_year;
	}

	public String getImdb_score() {
		return imdb_score;
	}

	public void setImdb_score(String imdb_score) {
		this.imdb_score = imdb_score;
	}

	public String getAspect_ratio() {
		return aspect_ratio;
	}

	public void setAspect_ratio(String aspect_ratio) {
		this.aspect_ratio = aspect_ratio;
	}

	public String getMovie_facebook_likes() {
		return movie_facebook_likes;
	}

	public void setMovie_facebook_likes(String movie_facebook_likes) {
		this.movie_facebook_likes = movie_facebook_likes;
	}

	public String getNum_voted_user() {
		return num_voted_user;
	}

	public void setNum_voted_user(String num_voted_user) {
		this.num_voted_user = num_voted_user;
	}
	
	
	
}