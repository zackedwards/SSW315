package simulator;

public class MyQueue<E> {
    //Node class for single linked list queue
    private static class Node<E> {
        //Instance variables for Node
        private E data;
        private Node<E> next;

        //Constructor for Node, to be completed by you
        private Node(E dataItem) { 
        	data = dataItem;
        	this.next = null;
        }

        //Constructor for Node, to be completed by you
        private Node(E dataItem, Node<E> nodeRef) { 
        	data = dataItem;
        	this.next = nodeRef;
        }
    }

    //Instance variables for queue
    private Node<E> front;
    private Node<E> rear;
    private int size;

    //Constructor for queue, to be completed by you
    public MyQueue () {    
    	size = 0;
    }

    //Adds a node to queue, to be completed by you
    public boolean offer(E item) {   
    	Node<E> temp = new Node<E>(item);
    	if(size == 0) {
    		front =  temp;
    		rear = temp;
    		front.next = null;
    		rear.next= null;
    		size+=1;
    	}
    	else if (size == 1) {
    		rear = temp;
    		front.next = rear;
    		size+=1;
    	}
    	else {
        	rear.next = temp;
        	rear = temp;
        	rear.next = null;
        	size+=1;
    	}
    	return true;
    }

    //Returns the node at front of queue, to be completed by you
    public E peek() {   
    	return front.data;
    }

    //Returns and removes the node at front of queue, to be completed by you
    public E poll() {   
    	Node<E> temp = front;
    	front = front.next;
    	size--;
    	return temp.data;
    }

    //Returns the data element at a specific index, to be completed by you
    public E get(int index) {    
    	Node<E> temp = front;
    	int i = 0;
    	while(i != index) {
    		temp = temp.next;
    		i+=1;
    	}
    	return temp.data;
    }

    //Returns the size of the queue, to be completed by you
    public int size() {		
    	return size;
    }
}
