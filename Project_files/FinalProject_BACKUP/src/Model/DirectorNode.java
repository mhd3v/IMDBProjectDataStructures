package Model;

import java.io.Serializable;

import javax.swing.JOptionPane;

public class DirectorNode  implements Serializable {

	String name;
	int director_facebook_likes;
	MoviesOfDirector movies_of_director;
	
	
	void searchMovieDirector(String data, MovieAvlTree movie) {

		boolean found = searchDirector(data, movie.directors.getRoot());
		if(found == false){
			System.out.println("Director " + data + " not found!");
		    JOptionPane.showMessageDialog(null, "Director  " + data + "  not found!");	
		}
	}

	boolean searchDirector(String data, DirectorAvlNode node) {
		boolean found = false;
		while ((node != null) && !found) {
			String rval = node.director.name;
			if (data.compareTo(rval) < 0)
				node = node.left;
			else if (data.compareTo(rval) > 0)
				node = node.right;
			else {
				System.out.println("Director found! Printing Movies");
				System.out.println(node.director.name + " has directed " + node.director.movies_of_director.count + " movies:");
				
				node.director.movies_of_director.print();
				found = true;
				break;
			}
			found = searchDirector(data, node);
		}

		return found;
	}

}
