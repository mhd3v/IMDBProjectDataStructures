package Model;

import java.io.Serializable;

public class ActorsAvlTree  implements Serializable {

	
	int count= 0;
	
	ActorAvlNode root;
	ActorNode movie;

	ActorsAvlTree() {
		this.root = null;
	}
	
	ActorAvlNode getRoot(){
		return root;
	}

	int getCount(){
		return count;
	}
	public ActorAvlNode find(String id) {
		ActorAvlNode current = root;

		while (current != null) {
			if (current.actor.name == id) {
				return current;
			} else if (current.actor.name.compareTo(id) > 0) {
				current = current.left;
			} else
				current = current.right;
		}

		return null;
	}
	
	
	private void insert(ActorNode key) {
		ActorAvlNode newActorAvlNode = new ActorAvlNode();
		newActorAvlNode.actor = key;

		if (root == null) {
			root = newActorAvlNode;
			count++;
			return;
		}
		
		ActorAvlNode current = root;
		ActorAvlNode parent = null;

		while (true) {
			parent = current;
			if (key.name.compareTo(current.actor.name) < 0) {
				current = current.left;
				if (current == null) {
					parent.left = newActorAvlNode;
					count++;
					return;
				}

			} else {
				current = current.right;
				if (current == null) {
					parent.right = newActorAvlNode;
					count++;
					return;
				}
			}

		}

	}

	public void insertAVL(ActorNode key) {
		insert(key);
		checkBalanceFactor(null, root);
	}

	
	private void checkBalanceFactor(ActorAvlNode parent, ActorAvlNode ActorAvlNode) {
		if (ActorAvlNode == null)
			return;
		else {
			int balanceFactor = getBalanceFactor(ActorAvlNode);
			if (balanceFactor == -2 || balanceFactor == 2) {
			
				if (balanceFactor == 2) {
					
					ActorAvlNode x = ActorAvlNode;
					ActorAvlNode y = ActorAvlNode.left;
					if (getHeight(y.left) < getHeight(y.right)) {
						singleLeftRotation(x, y);
						singleRightRotation(parent, x);
					} else {
						singleRightRotation(parent, x);
					}
				} else {
					
					ActorAvlNode x = ActorAvlNode;
					ActorAvlNode y = ActorAvlNode.right;
					if (getHeight(y.left) > getHeight(y.right)) {
						singleRightRotation(x, y);
						singleLeftRotation(parent, x);
					} else {
						singleLeftRotation(parent, x);
					}
				}
			}
			checkBalanceFactor(ActorAvlNode, ActorAvlNode.left);
			checkBalanceFactor(ActorAvlNode, ActorAvlNode.right);
		}
	}

	private int getHeight(ActorAvlNode ActorAvlNode) {
		
		if (ActorAvlNode == null)
			return 0;
		else {
			int leftTree = getHeight(ActorAvlNode.left);
			int rightTree = getHeight(ActorAvlNode.right);
		
			if (leftTree > rightTree)
				return leftTree + 1;
			else
				return rightTree + 1;
		}
	}

	int getBalanceFactor(ActorAvlNode ActorAvlNode) {
		return getHeight(ActorAvlNode.left) - getHeight(ActorAvlNode.right);
	}

	private void singleLeftRotation(ActorAvlNode parent, ActorAvlNode x) {
		ActorAvlNode y = x.right;
		x.right = y.left;
		y.left = x;

		if (x == root)
			root = y;
		else {
			if (parent.left == x)
				parent.left = y;
			else if (parent.right == x)
				parent.right = y;
		}

	}

	private void singleRightRotation(ActorAvlNode parent, ActorAvlNode x) {
		ActorAvlNode y = x.left;
		x.left = y.right;
		y.right = x;

		if (x == root)
			root = y;
		else {
			if (parent.left == x)
				parent.left = y;
			else if (parent.right == x)
				parent.right = y;
		}

	}

	public void inOrderPrint(ActorAvlNode loc) {
		
		if (loc != null) {
			inOrderPrint(loc.left);
			System.out.println(loc.actor.name);
			inOrderPrint(loc.right);
		}
		
	}


}
