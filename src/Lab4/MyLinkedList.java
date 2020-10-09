package Lab4;

public class MyLinkedList { // Start of class MyLinkedList
	private Node first;
	private Node last;

	// LinkList constructor
	public MyLinkedList() {
		first = null;
		last = null;
	}

	// Returns true if the linked list is empty
	public boolean isEmpty() {
		return first == null;

	}

	// Inserts a new node at the first of the linked list
	public void addFirst(int d1, double d2) {
		Node node = new Node(d1, d2);
		node.next = first;
		first = node;
	}

	// Deletes the node at the first of the linked list
	public Node deleteFirst() {
		Node temp = first;
		first = first.next;
		return temp;
	}

	// Prints the linked list data
	public void printList() {
		Node currentNode = first;
		System.out.print("List: ");
		while (currentNode != null) {
			currentNode.printNode();
			currentNode = currentNode.next;
		}
		System.out.println("");

	}

	public void addLast(int d1, double d2) {
		Node temp = first;
		while (temp.next != null) {
			temp = temp.next;
		}
		last = temp;

		last.next = new Node(d1, d2);
		last = last.next;
	}

	public Node deleteLast() {
		Node temp = first;
		if (temp.next == null) {
			Node remove = temp;
			temp = null;
			last = temp;
			first = temp;
			return remove;
		} else {
			while (temp.next != last) {
				temp = temp.next;
			}

			Node remove = temp.next;
			temp.next = null;
			last = temp;
			return remove;
		}
	}

	public int size() {
		int counter = 1;
		if (first == null) {
			return (0);
		}
		Node temp = first;
		while (temp.next != null) {
			temp = temp.next;
			counter += 1;
		}
		return counter;
	}
	public void reverse() {
		Node curr = first;
		Node swap = null;
		while(curr != null) {
			Node next = curr.next;
			curr.next = swap;
			swap = curr;
			curr = next;
		}
		last = first;
		first = swap;
		
	}
} // End of class LinkList

//The following code is to test your linked list.
/*
 * public class MyLinkedListTest { //Start of class MyLinkedListTest public
 * static void main(String[] args) { MyLinkedList list = new MyLinkedList();
 * list.addFirst(1, 1.01); list.printList(); list.addFirst(2, 2.02);
 * list.printList(); list.addFirst(3, 3.03); list.printList(); list.addFirst(4,
 * 4.04); list.printList(); list.addFirst(5, 5.05); list.printList();
 * 
 * while(!list.isEmpty()) { Node deletedLink = list.deleteFirst();
 * System.out.print("deleted: "); deletedLink.printNode();
 * System.out.println(""); } list.printList(); } } //End of class
 * MyLinkedListTest
 */