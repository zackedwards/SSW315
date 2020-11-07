package lab6;

import java.util.ArrayDeque;

import java.util.Scanner;

public class ReverseString {
    public static void main(String[] args) {
        System.out.println("Please type any string to be reversed: ");
    	Scanner scanner = new Scanner(System.in);

		//str variable references to the input string.
        String str = scanner.nextLine();
        scanner.close();
       
		// The ArrayDeque class implements a more complete and consistent set of LIFO stack 
		// operations, which should be used in preference to the Stack class.      
    	// stack variable references to a new stack instance.
    	ArrayDeque<Character> stack = new ArrayDeque<>();   

		// Your code to reverse the input string, i.e. str, using the stack go at below:
    	
    	for(int i = 0; i < str.length(); i++) {
    		stack.push(str.charAt(i));
    		
    	}
    	int size = stack.size();
    	for(int j = 0; j < size; j ++) {
    		System.out.print(stack.pop());
    	}







    }
}