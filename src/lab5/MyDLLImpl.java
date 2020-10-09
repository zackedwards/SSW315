package lab5;

public class MyDLLImpl <E> implements MyDoubleLinkedList {

	private MyDoubleNode head;
	private MyDoubleNode tail;
	private int size;
	
	public MyDLLImpl() {
		head = new MyDoubleNode(null, tail, null);
		tail = new MyDoubleNode(null, null, head);
		size = 0;
	}
	@Override
	public void insert(Object x) {
		// TODO Auto-generated method stub
		MyDoubleNode current = new MyDoubleNode(x, tail, tail.prev);
		tail.prev.next = current;
		tail.prev = current;
		size++;
	}

	@Override
	public void delete(Object x) {
		// TODO Auto-generated method stub
		if(this.isEmpty() == false) {
			for(MyDoubleNode i = head; i != tail.next; i = i.next) {
				if(i.data == x) {
					i.prev.next = i.next;
					i.next.prev = i.prev;
					size--;
				}
			}
		}
		
	}

	@Override
	public boolean lookup(Object x) {
		// TODO Auto-generated method stub
		for(MyDoubleNode i = head; i != tail; i = i.next) {
			if(i.data == x) {
				return true;
			}
		}
		return false;
	}

	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return size == 0;
	}

	@Override
	public void printList() {
		// TODO Auto-generated method stub
		MyDoubleNode currentNode = head.next;
		System.out.print("List: ");
		while (currentNode != tail.prev) {
			System.out.print(currentNode.data + ", ");
			currentNode = currentNode.next;
		}
		System.out.println(tail.prev.data + ".");

	}

	@Override
	public void printListRev() {
		// TODO Auto-generated method stub
		MyDoubleNode currentNode = tail.prev;
		System.out.print("List in reverse: ");
		while (currentNode != head.next) {
			System.out.print(currentNode.data + ", ");
			currentNode = currentNode.prev;
		}
		System.out.println(head.next.data + ".");

	}
	public int getSize() {
		return size;
	}
	public void insert(Object x, MyDoubleNode a) {
		MyDoubleNode current = new MyDoubleNode(x, a.next, a);
		a.next.prev = current;
		a.next = current;
		size++;
	}
	public MyDoubleNode get(Object x) {
		for(MyDoubleNode i = head; i != tail; i = i.next) {
			if(i.data == x) {
				return i;
			}
		}
		return null;
	}

}
