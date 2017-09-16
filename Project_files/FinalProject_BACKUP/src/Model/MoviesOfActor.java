package Model;

import java.io.Serializable;

import javax.swing.JOptionPane;

public class MoviesOfActor  implements Serializable{

	class Node{

		Node next;
		MovieNode movie;

	}
	
	CoActorsLinkList final_coActorList = new CoActorsLinkList();
	CoActorsLinkList coActorList;
	
	int count = 0;
	Node start;

	int getCount() {
		return count;
	}

	MoviesOfActor() {
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
	
	void printCoActors(ActorNode actor){
		
		Node loc = start;
		Node pLoc = null;
		
		while(loc != null){
			
			pLoc = loc;
			
			coActorList = pLoc.movie.actors_of_movie.getCo(pLoc.movie, actor);
			
			if(!alreadyExists(coActorList.Start.actor))
			final_coActorList.insert(coActorList.Start.actor);
			
			if(!alreadyExists(coActorList.Start.next.actor))
			final_coActorList.insert(coActorList.Start.next.actor);
			
			loc = loc.next;
			
		}
		
		final_coActorList.print();
		
	
		
	}
	
	boolean alreadyExists(ActorNode actor){
		
		CoActorsLinkList.Node loc = final_coActorList.getStart();
		
		if(loc != null){
		
		while(loc != null){
					
			if(loc.actor.name.equals(actor.name))
				return true;
			
						
			loc = loc.next;
				
			
		}
		
		}
		
		return false;
	}
	
	
}
