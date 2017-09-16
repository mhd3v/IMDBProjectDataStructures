package Model;

import java.io.Serializable;

import javax.swing.JOptionPane;

public class ActorsOfAMovieList  implements Serializable{

	class Node {

		ActorNode actor;
		Node next;
	}

	Node Start;
	CoActorsLinkList coActors = new CoActorsLinkList();
	
	Node getStart(){
		return Start;
	}
	
	ActorsOfAMovieList() {

		Start = null;

	}
	
	

	
	
	void insert(ActorNode actor) {
		Node newNode = new Node();
		newNode.actor = actor;

		if (Start == null)
			Start = newNode;
		else {

			Node loc = Start;
			Node pLoc = null;

			while (loc != null) {
				pLoc = loc;
				loc = loc.next;
			}

			pLoc.next = newNode;

		}
	}

	void print(){
		Node loc = Start;
		Node pLoc = null;
		
		while(loc != null){
			pLoc = loc;
			System.out.println(pLoc.actor.name);
			loc = loc.next;
		}
	}
	
	CoActorsLinkList getCo(MovieNode movie, ActorNode actor){

		Node loc = movie.actors_of_movie.getStart();
		Node pLoc = null;
		
		while(loc != null){
			
				pLoc = loc;
			
				if(pLoc.actor.name != actor.name)
					coActors.insert(pLoc.actor);
				
				loc = loc.next;
				
		}
		
		return coActors;
		
	}
	
	void printCoExcept(String name){
		Node loc = Start;
		
		while(loc != null){
			if(!loc.actor.name.equals(name))
			System.out.println(loc.actor.name);
			loc = loc.next;
		}
		
		JOptionPane.showMessageDialog(null, loc.actor.name + "   "  + loc.next.actor.name + "   " + loc.next.next.actor.name);
	}

	
}
