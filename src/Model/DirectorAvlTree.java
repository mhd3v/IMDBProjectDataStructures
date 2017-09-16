package Model;

import java.io.Serializable;

public class DirectorAvlTree  implements Serializable{

	
	int count= 0;
	
	DirectorAvlNode root;
	ActorNode movie;

	DirectorAvlTree() {
		this.root = null;
	}
	
	DirectorAvlNode getRoot(){
		return root;
	}

	int getCount(){
		return count;
	}
	public DirectorAvlNode find(String id) {
		DirectorAvlNode current = root;

		while (current != null) {
			if (current.director.name == id) {
				return current;
			} else if (current.director.name.compareTo(id) > 0) {
				current = current.left;
			} else
				current = current.right;
		}

		return null;
	}

	public boolean search(String data) {
		return search(data, root);
	}

	private boolean search(String data, DirectorAvlNode node) {
		boolean found = false;
		while ((node != null) && !found) {
			String rval = node.director.name;
			if (data.compareTo(rval) < 0)
				node = node.left;
			else if (data.compareTo(rval) > 0)
				node = node.right;
			else {
				found = true;
				break;
			}
			found = search(data, node);
		}
		return found;
	}

	
	
	private void insert(DirectorNode key) {
		DirectorAvlNode newDirectorAvlNode = new DirectorAvlNode();
		newDirectorAvlNode.director = key;

		// If TREE is Empty...
		if (root == null) {
			root = newDirectorAvlNode;
			count++;
			return;
		}
		// If Tree isnt Empty...
		DirectorAvlNode current = root;
		DirectorAvlNode parent = null;

		while (true) {
			parent = current;
			if (key.name.compareTo(current.director.name) < 0) {
				current = current.left;
				if (current == null) {
					parent.left = newDirectorAvlNode;
					count++;
					return;
				}

			} else {
				current = current.right;
				if (current == null) {
					parent.right = newDirectorAvlNode;
					count++;
					return;
				}
			}

		}

	}

	public void insertAVL(DirectorNode key) {
		insert(key);
		checkBalanceFactor(null, root);
	}

	
	private void checkBalanceFactor(DirectorAvlNode parent, DirectorAvlNode DirectorAvlNode) {
		if (DirectorAvlNode == null)
			return;
		else {
			int balanceFactor = getBalanceFactor(DirectorAvlNode);
			if (balanceFactor == -2 || balanceFactor == 2) {
				// Apply Rotation based on BalanceFactor
				if (balanceFactor == 2) {
					// Apply RightRotation..
					// Checking the Special Case of Double Rotation...
					DirectorAvlNode x = DirectorAvlNode;
					DirectorAvlNode y = DirectorAvlNode.left;
					if (getHeight(y.left) < getHeight(y.right)) {
						singleLeftRotation(x, y);
						singleRightRotation(parent, x);
					} else {
						singleRightRotation(parent, x);
					}
				} else {
					// Apply LeftRotation..
					// Checking the Special Case of Double Rotation...
					DirectorAvlNode x = DirectorAvlNode;
					DirectorAvlNode y = DirectorAvlNode.right;
					if (getHeight(y.left) > getHeight(y.right)) {
						singleRightRotation(x, y);
						singleLeftRotation(parent, x);
					} else {
						singleLeftRotation(parent, x);
					}
				}
			}
			checkBalanceFactor(DirectorAvlNode, DirectorAvlNode.left);
			checkBalanceFactor(DirectorAvlNode, DirectorAvlNode.right);
		}
	}

	private int getHeight(DirectorAvlNode DirectorAvlNode) {
		// Leaf DirectorAvlNode has Height = 1 ;
		if (DirectorAvlNode == null)
			return 0;
		else {
			int leftTree = getHeight(DirectorAvlNode.left);
			int rightTree = getHeight(DirectorAvlNode.right);
			// Getting the Max height of leftTree and rightTree
			// And Adding 1 to get the Height of DirectorAvlNode itself..
			if (leftTree > rightTree)
				return leftTree + 1;
			else
				return rightTree + 1;
		}
	}

	int getBalanceFactor(DirectorAvlNode DirectorAvlNode) {
		return getHeight(DirectorAvlNode.left) - getHeight(DirectorAvlNode.right);
	}

	private void singleLeftRotation(DirectorAvlNode parent, DirectorAvlNode x) {
		DirectorAvlNode y = x.right;
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

	private void singleRightRotation(DirectorAvlNode parent, DirectorAvlNode x) {
		DirectorAvlNode y = x.left;
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

	public void inOrderPrint(DirectorAvlNode loc) {
		
		if (loc != null) {
			inOrderPrint(loc.left);
			System.out.println(loc.director.name);
			inOrderPrint(loc.right);
		}
		
	}


}
