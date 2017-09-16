package Model;

import java.io.Serializable;

import javax.swing.JOptionPane;

public class DirectorNode  implements Serializable {

	String name;
	int director_facebook_likes;
	MoviesOfDirector movies_of_director;
	

	String searchMovieDirector(String data, MovieAvlTree movie) {
        String found = "" ;
		 found = searchDirector(data, movie.directors.getRoot());
		if(found == null){
			System.out.println("Director " + data + " not found!");
		 	found = "Director " + data + " not found" ;
		}
		return found;
	}

	String searchDirector(String data, DirectorAvlNode node) {
		boolean found = false;
		String show  = "  ";
		while ((node != null) && !found) {
			String rval = node.director.name;
			if (data.compareTo(rval) < 0)
				node = node.left;
			else if (data.compareTo(rval) > 0)
				node = node.right;
			else {
				System.out.println("Director found! Printing Movies");
				System.out.println(node.director.name + " has directed " + node.director.movies_of_director.count + " movies:");
			    
				show ="Director found! Printing Movies" +	"\n" + node.director.name + " has directed " + node.director.movies_of_director.count + " movies: \n" +node.director.movies_of_director.print();
				found = true;
				break;
			}
			 searchDirector(data, node);
		}

		return show;
	}

}
