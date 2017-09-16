package Model;

import java.io.Serializable;

import javax.swing.JOptionPane;

public class CoActorsLinkList  implements Serializable {

	class Node{
		ActorNode actor;
		Node next;
	}
	
	Node Start;
	int count = 0;
	
	Node getStart(){
		return Start;
	}
	
	void insert(ActorNode actor){
		
		Node newNode  = new Node();
		newNode.actor  = actor;
		
		if(Start == null){
			Start = newNode;
			count++;
		}
		
		else{
			
			Node loc = Start;
			
			while(loc.next != null)
				loc = loc.next;
			
			loc.next = newNode;
			count++;
		}
		
	}
	
	void print(){
		Node loc = Start;
		Node pLoc = null;
		
		System.out.print( count + " actors");
		System.out.println("");
		System.out.println("---------------------------------");
		
		
		while(loc != null)
		{
			pLoc = loc;
			System.out.println(pLoc.actor.name);
			JOptionPane.showMessageDialog(null, loc.actor.name );
			loc = loc.next;
		}
		
		
		System.out.println("---------------------------------");
		
	}
}
