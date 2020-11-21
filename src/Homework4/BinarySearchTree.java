package Homework4;

import java.util.ArrayList;

import Lab8.BinaryNode;
import Lab8.DuplicateItemException;
import Lab8.ItemNotFoundException;

//BinarySearchTree class
//
//CONSTRUCTION: with no initializer
//
//******************PUBLIC OPERATIONS*********************
//void insert( x )       --> Insert x
//void remove( x )       --> Remove x
//void removeMin( )      --> Remove minimum item
//Comparable find( x )   --> Return item that matches x
//Comparable findMin( )  --> Return smallest item
//Comparable findMax( )  --> Return largest item
//boolean isEmpty( )     --> Return true if empty; else false
//void makeEmpty( )      --> Remove all items
//void traverseIndOrder  --> print the tree in order
//void traverPreOrder    --> prints the tree in pre-order
//String toString()      --> Return the tree represented as an array, in type String
//******************ERRORS********************************
//Exceptions are thrown by insert, remove, and removeMin if warranted

/**
 * Implements an unbalanced binary search tree. Note that all "matching" is
 * based on the compareTo method.
 * 
 * @author Mark Allen Weiss completed by: Zack Edwards
 */

public class BinarySearchTree<AnyType extends Comparable<? super AnyType>> {
	/**
	 * Construct the tree.
	 */
	public class BinaryNode<AnyType> {
		// Constructor
		BinaryNode(AnyType theElement) {
			element = theElement;
			left = right = null;
			duplicate = new ArrayList<BinaryNode>();
		}

		// Data; accessible by other package routines
		AnyType element; // The data in the node
		BinaryNode<AnyType> left; // Left child
		BinaryNode<AnyType> right; // Right child
		ArrayList<BinaryNode> duplicate;// duplicate list
	}

	public BinarySearchTree() {
		root = null;
	}

	/**
	 * Insert into the tree.
	 * 
	 * @param x the item to insert.
	 * @throws DuplicateItemException if x is already present.
	 */
	public void insert(AnyType x) {
		root = insert(x, root);
	}

	/**
	 * Remove from the tree..
	 * 
	 * @param x the item to remove.
	 * @throws ItemNotFoundException if x is not found.
	 */
	public void remove(AnyType x) {
		root = remove(x, root);
	}

	/**
	 * Remove minimum item from the tree.
	 * 
	 * @throws ItemNotFoundException if tree is empty.
	 */
	public void removeMin() {
		root = removeMin(root);
	}

	/**
	 * Find the smallest item in the tree.
	 * 
	 * @return smallest item or null if empty.
	 */
	public AnyType findMin() {
		return elementAt(findMin(root));
	}

	/**
	 * Find the largest item in the tree.
	 * 
	 * @return the largest item or null if empty.
	 */
	public AnyType findMax() {
		return elementAt(findMax(root));
	}

	/**
	 * Find an item in the tree.
	 * 
	 * @param x the item to search for.
	 * @return the matching item or null if not found.
	 */
	public AnyType find(AnyType x) {
		return elementAt(find(x, root));
	}

	/**
	 * Make the tree logically empty.
	 */
	public void makeEmpty() {
		root = null;
	}

	/**
	 * Test if the tree is logically empty.
	 * 
	 * @return true if empty, false otherwise.
	 */
	public boolean isEmpty() {
		return root == null;
	}

	/**
	 * Internal method to get element field.
	 * 
	 * @param t the node.
	 * @return the element field or null if t is null.
	 */
	private AnyType elementAt(BinaryNode<AnyType> t) {
		return t == null ? null : t.element;
	}

	/**
	 * Internal method to insert into a subtree.
	 * 
	 * @param x the item to insert.
	 * @param t the node that roots the tree.
	 * @return the new root.
	 * @throws DuplicateItemException if x is already present.
	 */
	protected BinaryNode<AnyType> insert(AnyType x, BinaryNode<AnyType> t) {
		if (t == null)
			t = new BinaryNode<AnyType>(x);
		else if (x.compareTo(t.element) < 0)
			t.left = insert(x, t.left);
		else if (x.compareTo(t.element) > 0)
			t.right = insert(x, t.right);
		else
			t.duplicate.add(new BinaryNode(x)); // Duplicate
		return t;
	}

	/**
	 * Internal method to remove from a subtree.
	 * 
	 * @param x the item to remove.
	 * @param t the node that roots the tree.
	 * @return the new root.
	 * @throws ItemNotFoundException if x is not found.
	 */
	protected BinaryNode<AnyType> remove(AnyType x, BinaryNode<AnyType> t) {
		if (t == null)
			throw new ItemNotFoundException(x.toString());
		if (x.compareTo(t.element) < 0)
			t.left = remove(x, t.left);
		else if (x.compareTo(t.element) > 0)
			t.right = remove(x, t.right);
		else if (t.duplicate.size() != 0) {
			t.duplicate.remove(0);
		} else if (t.left != null && t.right != null) // Two children
		{
			t.element = findMin(t.right).element;
			t.right = removeMin(t.right);
		} else
			t = (t.left != null) ? t.left : t.right;
		return t;
	}

	/**
	 * Internal method to remove minimum item from a subtree.
	 * 
	 * @param t the node that roots the tree.
	 * @return the new root.
	 * @throws ItemNotFoundException if t is empty.
	 */
	protected BinaryNode<AnyType> removeMin(BinaryNode<AnyType> t) {
		if (t == null)
			throw new ItemNotFoundException();
		else if (t.left != null) {
			t.left = removeMin(t.left);
			return t;
		} else
			return t.right;
	}

	/**
	 * Internal method to find the smallest item in a subtree.
	 * 
	 * @param t the node that roots the tree.
	 * @return node containing the smallest item.
	 */
	protected BinaryNode<AnyType> findMin(BinaryNode<AnyType> t) {
		if (t != null)
			while (t.left != null)
				t = t.left;

		return t;
	}

	/**
	 * Internal method to find the largest item in a subtree.
	 * 
	 * @param t the node that roots the tree.
	 * @return node containing the largest item.
	 */
	private BinaryNode<AnyType> findMax(BinaryNode<AnyType> t) {
		if (t != null)
			while (t.right != null)
				t = t.right;

		return t;
	}

	/**
	 * Internal method to find an item in a subtree.
	 * 
	 * @param x is item to search for.
	 * @param t the node that roots the tree.
	 * @return node containing the matched item.
	 */
	private BinaryNode<AnyType> find(AnyType x, BinaryNode<AnyType> t) {
		while (t != null) {
			if (x.compareTo(t.element) < 0)
				t = t.left;
			else if (x.compareTo(t.element) > 0)
				t = t.right;
			else
				return t; // Match
		}

		return null; // Not found
	}

//To be completed by me: Search() contains() list() and traverseInOrder()
	/**
	 * See if the tree contains a given item.
	 * 
	 * @param target the item to search for
	 * @return true if the item is in the tree
	 */
	public boolean contains(AnyType target) {
		return search(root, target);
	}

	/** Recursively search the tree for the target */
	private boolean search(BinaryNode<AnyType> curr, AnyType target) {
		if (curr != null) {
			if (curr.element.compareTo(target) < 0) {
				return search(curr.right, target);
			} else if (curr.element.compareTo(target) > 0) {
				return search(curr.left, target);
			} else {
				return true;
			}
		}
		return false;

	}

	/**
	 * Show an ordered list of the items in the tree, one item per line.
	 */
	public void list() {
		traverseInOrder(root);
	}

	/** Recursive in-order traversal of the tree, printing each node */
	private void traverseInOrder(BinaryNode<AnyType> curr) {
		if (curr.left != null) {
			traverseInOrder(curr.left);
		}
		System.out.println(curr.element);

		// checking for duplicates

		for (int i = 0; i < curr.duplicate.size(); i++) {
			System.out.println(curr.duplicate.get(i).element);
		}

		if (curr.right != null) {
			traverseInOrder(curr.right);
		}
	}

	/** The tree root. */
	/** Print a formatted display of the tree. */
	public void print() {
		traversePreOrder(root, 0);
	}

	/**
	 * Recursive pre-order traversal of the tree, printing each node indented an
	 * amount corresponding to its level in the tree.
	 */
	private void traversePreOrder(BinaryNode<AnyType> curr, int indent) {
		for(int i = 0; i < indent; i++) {
			System.out.print("\t");
		}
		System.out.println(curr.element);
		for (int i = 0; i < curr.duplicate.size(); i++) {
			System.out.println(curr.duplicate.get(i).element);
		}
		if (curr.left != null) {
			traversePreOrder(curr.left, indent + 1);
		}

		if (curr.right != null) {
			traversePreOrder(curr.right, indent + 1);
		}
	}

	protected BinaryNode<AnyType> root;

	public String toString() {
		StringBuilder s = new StringBuilder("");
		s.append(toString(root, s, 0));
		return s.toString();
	}

	private String toString(BinaryNode<AnyType> x, StringBuilder s, int indent) {		
		for(int i = 0; i < indent; i++) {
			s.append("\t");
		}
		if (x != null) {
			if (x.left != null) {
				toString(x.left, s, indent);
			}
			else {
				for(int i = 0; i < indent+1; i++) {
					s.append("\t");
				}
				s.append(". \n");
			}
			if (x.right != null) {
				toString(x.right, s, indent);
				
			}
			else {
				for(int i = 0; i < indent+1; i++) {
					s.append("\t");
				}
				s.append(". \n");
			}
			s.append(x.element + "\n");
		}
		return s.toString();
	}

	// Test program
	public static void main(String[] args) {
		BinarySearchTree<Integer> t = new BinarySearchTree<Integer>();
		final int NUMS = 4000;
		final int GAP = 37;

		System.out.println("Checking... (no more output means success)");

		for (int i = GAP; i != 0; i = (i + GAP) % NUMS)
			t.insert(i);
		for (int i = 1; i < NUMS; i += 2)
			t.remove(i);
		if (t.findMin() != 2 || t.findMax() != NUMS - 2)
			System.out.println("FindMin or FindMax error!");
		for (int i = 2; i < NUMS; i += 2)
			if (t.find(i) != i)
				System.out.println("Find error1!");
		for (int i = 1; i < NUMS; i += 2)
			if (t.find(i) != null)
				System.out.println("Find error2!");
		System.out.println(t.toString());

		if (t.contains(2)) {
			System.out.println("true");
		}
	}
}
