package Model;

import java.io.Serializable;

public class Keywords  implements Serializable{

	class Node {
		
		Node next;
		String keyword;
		
	}
	
	Node loc;
	Node Start;
	
	Keywords(){
		Start = null;
	}
	
	void insert(String key){
		
		Node newNode = new Node();
		newNode.keyword = key;
		
		
		if(Start == null)
			Start = newNode;
		else{
				loc = Start;
				
				while(loc.next != null)
					loc = loc.next;
				
				loc.next  = newNode;				
			}
		
	}
}
