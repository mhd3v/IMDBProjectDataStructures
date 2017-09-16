package Model;

import java.io.Serializable;

import javax.swing.JOptionPane;

public class MoviesOfDirector  implements Serializable{

	class Node{

		Node next;
		MovieNode movie;

	}

	int count = 0;
	Node start;

	int getCount() {
		return count;
	}

	MoviesOfDirector() {
		start = null;
	}

	void insert(MovieNode movie) {

		Node newMovie = new Node();
		newMovie.movie = movie;

		if (start == null) {
			start = newMovie;
			count++;
		}

		else {

			Node loc = start;
			while (loc.next != null) {

				loc = loc.next;

			}

			loc.next = newMovie;
			count++;

		}

	}

	void print() {
		Node loc = start;
       JOptionPane.showMessageDialog(null, loc.movie.director.name + " has directed " + loc.movie.director.movies_of_director.count + " movies! Displaying them " );
		while (loc != null) {
			System.out.println("================================");
			System.out.println("Title: " + loc.movie.movie_title);
			System.out.println("Year: " + loc.movie.title_year);
			System.out.println("IMDB Score: " + loc.movie.imdb_score);
			System.out.println("Actors:");
			loc.movie.actors_of_movie.print();
			JOptionPane.showMessageDialog(null, "Title: " + loc.movie.movie_title + "\n Year: " + loc.movie.title_year + "\n IMDB Rating:" + loc.movie.imdb_score + 
					"\n Actors: \n" + loc.movie.actors_of_movie.Start.actor.name + "\n" + loc.movie.actors_of_movie.Start.next.actor.name
					 + "\n" + loc.movie.actors_of_movie.Start.next.next.actor.name);
			
			
			loc = loc.next;
		}
		
		
	}

}
