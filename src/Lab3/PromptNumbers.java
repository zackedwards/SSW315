package Lab3;

import java.util.Scanner;

/*This program prompts the user to enter several numbers,
stores the numbers into an array,
then prints the numbers in forwards and backwards order.

Expected example output:

How many numbers will you enter? 4
Type a number: 12
Type a number: 8
Type a number: -2
Type a number: 39

Your numbers in forward order:
12
8
-2
39

Your numbers in backward order:
39
-2
8
12
*/

public class PromptNumbers {
	
	public static void forwardOrder(int[] array) {
		for (int i = 0; i < array.length; i++) {
			System.out.print(array[i] + ", ");
		}
	}
	
	public static void swapAll(int[] array1, int[] array2) {
		int[] temp = array1.clone();
		System.arraycopy(array2, 0, array1, 0, array1.length);
		System.arraycopy(temp, 0, array2, 0, array1.length);
	}
	
	public static void main(String[] args) {
		Scanner console = new Scanner(System.in);
		System.out.print("How many numbers will you enter? ");
		int count = console.nextInt();
		
		
		int[] list = new int[count];
		for (int i = 0; i < count; i++) {
			// your code goes here; store the numbers
			System.out.print("Type a number: ");
			int input = console.nextInt();
			list[i] = input;
		}
		console.close();
		System.out.println();
		System.out.println("Your numbers in forward order:");
		forwardOrder(list);

		System.out.println();
		System.out.println("Your numbers in backward order:");
		
		// your code goes here; print the numbers in backward order
		for (int i = count - 1; i >= 0; i--) {
			System.out.print(list[i] + ", ");
		}
		
		
		int[] a1 = {11, 42, -5, 27, 0, 89};
		int[] a2 = {10, 20, 30, 40, 50, 60};
		System.out.println();
		System.out.println("This is a1: ");
		forwardOrder(a1);
		System.out.println();
		System.out.println("This is a2: ");
		forwardOrder(a2);
		swapAll(a1, a2);
		
		System.out.println();
		System.out.println();
		System.out.println("After Swap:");
		System.out.print("a1: ");
		forwardOrder(a1);
		System.out.println();
		System.out.print("a2: ");
		forwardOrder(a2);
		
		
	}
}