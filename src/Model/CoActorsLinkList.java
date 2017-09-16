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
	
	String print(){
		Node loc = Start;
		Node pLoc = null;
		String output = "";
		
		System.out.print( count + " actors");
		System.out.println("");
		System.out.println("---------------------------------");
		output += count + "actors \n" + "------------------------------\n";
		
		while(loc != null)
		{
			pLoc = loc;
			System.out.println(pLoc.actor.name);
			output += pLoc.actor.name  + "\n";
			//JOptionPane.showMessageDialog(null, loc.actor.name );
			loc = loc.next;
		}
		
		output += "-------------------------------\n" ;
		System.out.println("---------------------------------");
		return output;
	}
	
}
