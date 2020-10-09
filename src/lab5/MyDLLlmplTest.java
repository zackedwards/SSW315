package lab5;

public class MyDLLlmplTest {
	public static void main(String a[]){
		class MyDoubleNode {
			public Object data; 
			public MyDoubleNode next;
			public MyDoubleNode prev;

			//3- implement constructor for Node
			public MyDoubleNode(Object data, MyDoubleNode next, MyDoubleNode prev) {
		        this.data = data;
		        this.next = next;
		        this.prev = prev;
		    }
		}
		  MyDLLImpl<Integer> dll = new MyDLLImpl<Integer>();
		  dll.isEmpty();
		  dll.delete(2);
		  dll.insert(10);
		  dll.insert(34);
		  dll.insert(56);
		  dll.insert(364);
		  dll.delete(56);
		  dll.printList();
		  dll.printListRev();
		  dll.lookup(56);
		  dll.lookup(3);
		  dll.isEmpty();
		  dll.delete(10);
		  dll.printList();
		  dll.printListRev();
		  dll.insert(4, dll.get(34));
		  dll.printList();
		  
		} 

}
