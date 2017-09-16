package Model;

import java.io.Serializable;

import javax.swing.JOptionPane;

public class ActorNode implements Serializable {

	String name;
	int actor_facebook_like;
	MoviesOfActor movies_of_actor;
	CoActorsLinkList coActors;

	ActorNode() {
		name = null;
		movies_of_actor = null;
	}

	String searchMovieActor(String data, MovieAvlTree movie) {
        String show = "";
		String found = searchActor(data, movie.actors.getRoot());
		show += found;
		if(found == null){
			System.out.println("Actor " + data + " not found!");
		    show += "Actor " + data + " not found!" ;
		}
		return show;
	}

	String searchActor(String data, ActorAvlNode node) {
		boolean found = false;
		String out = "";
		while ((node != null) && !found) {
			String rval = node.actor.name;
			if (data.compareTo(rval) < 0)
				node = node.left;
			else if (data.compareTo(rval) > 0)
				node = node.right;
			else {
				//JOptionPane.showMessageDialog(null, data + " has acted in " + node.actor.movies_of_actor.count+ " movies! Displaying them " );
				out += data + " has acted in " + node.actor.movies_of_actor.count+ " movies! Displaying them \n" ;
				System.out.println("Actor found! Printing Movies");
				System.out.println(node.actor.name + " has " + node.actor.movies_of_actor.count + " movies:");
			    out +=	node.actor.movies_of_actor.print();
				found = true;
				break;
			}
		 searchActor(data, node);
		}

		
		return out;
	}
	
	
	String searchMovieCoActors(String data, MovieAvlTree movie) {
        String out = "";
		String found = coActors(data, movie.actors.getRoot());
		out += found;
		if(found == null){
			JOptionPane.showMessageDialog(null, "Actor not found!");
			System.out.println("Actor " + data + " not found!");
			out += "Actor " + data + " not found! \n";
		}
		return out;
	}
	
	String coActors(String data, ActorAvlNode node) {
		boolean found = false;
		String out = "";
		while ((node != null) && !found) {
			String rval = node.actor.name;
			if (data.compareTo(rval) < 0)
				node = node.left;
			else if (data.compareTo(rval) > 0)
				node = node.right;
			else {
				System.out.println("Actor found! ");
				System.out.print(node.actor.name + " has " + " worked with " );
	            out += "Actor found! \n" + node.actor.name + " has " + " worked with \n" ;
				out +=	node.actor.movies_of_actor.printCoActors(node.actor);
				found = true;
				break;
			}
			 coActors(data, node);
		}

		
		return out;
	}
	
	
	void coActorsInParticular(String actorName, String movieName, MovieAvlNode movieNode){
		
		boolean status = coActorsFind(actorName, movieName, movieNode);
		if(status == false){
			System.out.println("Movie was not found!");
		   JOptionPane.showMessageDialog(null, "Movie not found");
		}
	}

	boolean coActorsFind(String actorName, String movieName, MovieAvlNode node) {
		
		boolean found = false;
		while ((node != null) && !found) {
			
			if (movieName.compareTo(node.movie.movie_title) < 0)
				node = node.left;
			else if (movieName.compareTo(node.movie.movie_title) > 0)
				node = node.right;
			else {
				System.out.println("Movie found! Printing Co-Stars of " + actorName);
				node.movie.actors_of_movie.printCoExcept(actorName);
				found = true;
				break;
			}
			found = coActorsFind(actorName, movieName, node);
		}

		
		return found;
		
	}
	
	
	
	

}
