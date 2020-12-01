package Homework5;

import java.io.FileReader;
import java.io.IOException;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;

public class hw5_part2 {

	public static void insert(Float x, PriorityQueue<Float> list) {
		System.out.println(" ");
		System.out.println("Inserting: " + x);
		
		//creating a boolean to check if the element has been inserted in the try()
		@SuppressWarnings("unused")
		boolean check = false;
		
		//a base case for the empty list
		if(list.size() == 0) {
			list.add(x);
			System.out.println("First box is created");
			check = true;
		}
		
		//attempting to add the element to an existing box
		if(check == false) {
			
			//creating a copy of the priority queue to work with an edit
			Object[] copy = list.toArray();
			
			//checking all boxes to see if the element will fit anywhere
			for(int i = 0; i < copy.length; i++) {
				
				//these steps keep the size of the float to 1 decimal
				Object curr_elem = copy[i];
				float old_capacity = (float) curr_elem;
				//without this, the program has trouble comparing floats because
				//it will read 0.6 as 0.600000000001 or some variation of that
				double temp_capacity =  Math.round((old_capacity + x)* 100.0) / 100.0;
				float new_capacity = (float)temp_capacity;
				
				//if the empty space in the current box is less than or equal to the element
				if(new_capacity <= 1.0) {
					//then insert the element and break the loop
					copy[i] = new_capacity;
					check = true;
					System.out.println("box " + i + " capacity updated to: " + copy[i]);
					
					//copying the array back to the priority queue
					PriorityQueue<Float> temp = new PriorityQueue<Float>(Comparator.reverseOrder());
					for(int j = 0; j < copy.length; j++) {
						temp.add((float) copy[j]);
					}
					list.clear();
					list.addAll(temp);
					break;
				}
				
			}
		}
		//if the element did not fit into any of the boxes
		if(check == false) {
			//then start a new box with element-0p
			list.add(x);
			System.out.println("new box created");
			System.out.println("current amount of boxes: " + list.size());
		}
	}
	
	public static String summary(PriorityQueue<Float> list) {
		//summarizing the amount in each box
		StringBuilder str = new StringBuilder();
		Object[] copy = list.toArray();
		str.append("The contents of the boxes are: ");
		for(int i = 0; i < copy.length-1; i++) {
			str.append(copy[i] + ", ");
		}
		//making sure the list isn't empty
		if(copy.length > 0) {
			//print the capacity of the final element, ensuring there is no comma at the end
			str.append(copy[copy.length - 1]);
		}
		return str.toString();
	}
	
	public static void main(String args[]) throws IOException {
		
		//Scanning in the elements
		Scanner s = new Scanner(new FileReader("hw5_elements.txt"));
		
		//a queue for the boxes to be inserted which prioritizes the max
		PriorityQueue<Float> box_list = new PriorityQueue<Float>(Comparator.reverseOrder());

		//creating a priority queue for the elements which prioritizes the max
		PriorityQueue<Float> pq = new PriorityQueue<Float>(Comparator.reverseOrder());

		//inserting the elements into the priority queue
		while(s.hasNext()) {
			Float element = Float.parseFloat(s.nextLine());
			pq.add(element);
		}

		while(!pq.isEmpty()){
			//inserting the elements from the priority queue one by one
			insert(pq.poll(), box_list);
			System.out.println(summary(box_list));
		}
		
		s.close();
		//summarizing the amount of boxes needed and the amount in each box
		System.out.println(" ");
		System.out.println("The amount of boxes needed was: " + box_list.size());
		System.out.println(summary(box_list));
	}

}
