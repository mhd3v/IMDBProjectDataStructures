package Model;

import java.io.Serializable;

public class DirectorAvlNode  implements Serializable{

	DirectorNode director;
	DirectorAvlNode left;
	DirectorAvlNode right;
	
	DirectorAvlNode(){
		director = null;
		left = right = null;
	}
}
