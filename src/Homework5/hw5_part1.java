package Homework5;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class hw5_part1 {
	
	public static void main(String args[]) throws IOException {
		
		//Scanning in the elements
		Scanner s = new Scanner(new FileReader("hw5_elements"));
		
		//a queue for the elements to be inserted
		ArrayList<box> box_list = new ArrayList<box>();
		
		//inserting the elements into the priority queue
		while(s.hasNext()) {
			//scanning the next line
			Float element = Float.parseFloat(s.nextLine());
			System.out.println(" ");
			System.out.println("Inserting: " + element);
			
			//creating a boolean to check if the element has been inserted in the try()
			@SuppressWarnings("unused")
			boolean check = false;
			
			//a base case for the empty list
			if(box_list.size() == 0) {
				box entry = new box(element);
				box_list.add(entry);
				System.out.println("First box is created");
				check = true;
			}
			
			if(check == false) {
				//checking all boxes to see if the element will fit anywhere
				for(int i = 0; i < box_list.size(); i++) {
					//if the empty space in the current box is less than or equal to the element
					if(element <= (1.0 - box_list.get(i).capacity)) {
						//then insert the element and break the loop
						float old_capacity = box_list.get(i).capacity;
						//keeping the size of the float to 1 decimal
						double temp_capacity =  Math.round((old_capacity + element)* 100.0) / 100.0;
						float new_capacity = (float)temp_capacity;
						//updating to capacity of the box, by inserting the element
						box_list.get(i).capacity = new_capacity;
						check = true;
						System.out.println("box " + i + " capacity updated to: " + box_list.get(i).capacity);
						break;
					}
					
				}
			}
			//if the element did not fit into any of the boxes
			if(check == false) {
				//then start a new box with element-0p
				box entry = new box(element);
				box_list.add(entry);
				System.out.println("new box created");
				System.out.println("current amount of boxes: " + box_list.size());
			}
			
		}
		System.out.println(" ");
		System.out.println("The amount of boxes needed was: " + box_list.size());
		System.out.println("The contents of the boxes: ");
		for(int i = 0; i < box_list.size()-1; i++) {
			System.out.print(box_list.get(i).capacity + ", ");
		}
		System.out.print(box_list.get(box_list.size() - 1).capacity);
	}


	

}
