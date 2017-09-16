package Model;

import java.io.Serializable;

public class ActorAvlNode implements Serializable {

	ActorNode actor;
	ActorAvlNode left;
	ActorAvlNode right;
	
	ActorAvlNode(){
		actor = null;
		left = right = null;
	}
	
}

