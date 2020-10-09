package Lab4;

// *************************************************************** 
//   Shop.java 
// 
//   Uses the Item class to create items and add them to a shopping 
//   cart stored in an ArrayList. 
// *************************************************************** 
import java.util.ArrayList;
import java.util.Scanner;

public class Shop {
	public static void main(String[] args) {
		// *** declare and instantiate a variable cart to be an empty ArrayList
		ArrayList<Item> cart = new ArrayList<Item>();
		Item item;
		String itemName;
		double itemPrice;
		int quantity;
		Scanner scan = new Scanner(System.in);
		String keepShopping = "y";
		do {
			System.out.print("Enter the name of the item: ");
			itemName = scan.nextLine();
			System.out.print("Enter the unit price: ");
			itemPrice = scan.nextDouble();
			System.out.print("Enter the quantity: ");
			quantity = scan.nextInt();

			// *** create a new item and add it to the cart
			item = new Item(itemName, itemPrice, quantity);
			cart.add(item);

			// *** print the contents of the cart object using println
			for(Item i : cart) {
				System.out.println(i);
			}
			System.out.print("Continue shopping (y/n)? ");
			scan.nextLine();
			keepShopping = scan.nextLine();
		} while (keepShopping.equals("y"));
		scan.close();
	}
}
