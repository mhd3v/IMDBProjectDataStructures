package Model;

import java.io.Serializable;

import javax.swing.JOptionPane;

import Model.MoviesOfDirector.Node;

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

	String print() {
		Node loc = start;
		
		String output = "";
//        if(loc != null)
//		    JOptionPane.showMessageDialog(null, loc.movie.movie_title + " ; year =  " +loc.movie.title_year   + "    \n     "  + loc.next.movie.movie_title + " ; year = " + loc.next.movie.title_year + "    \n      " + loc.next.next.movie.movie_title + " ; year =  " +  loc.next.next.movie.title_year +"     \n  " + loc.next.next.next.movie.movie_title + "  ; year = " +  loc.next.next.next.movie.title_year);
//        else
//        	JOptionPane.showMessageDialog(null , "Director not found");
		while (loc != null) {
			System.out.println("Title: " + loc.movie.movie_title);
			System.out.println("Year: " + loc.movie.title_year);
			System.out.println("IMDB Score: " + loc.movie.imdb_score);
			System.out.println("Actors:");
			output += "Title  = " + loc.movie.movie_title  +  " \n" + "Year : " + loc.movie.title_year + " \n" + "IMDB Score = " + loc.movie.imdb_score + "\n " +  loc.movie.actors_of_movie.print();;
		    
			loc = loc.next;
		}
		
		return output;
	}

}
