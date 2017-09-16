package Model;

import java.io.Serializable;

public class MovieAvlNode  implements Serializable{

    public 	MovieNode movie;
	MovieAvlNode left;
	MovieAvlNode right;
	
	public MovieAvlNode(){
		movie = null;
		left = right = null;
	}
	
}
