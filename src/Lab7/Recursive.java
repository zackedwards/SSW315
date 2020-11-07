package Lab7;

import java.util.ArrayList;

class Recursive
{
	private static ArrayList<Integer> list = new ArrayList<Integer>();
	private static ArrayList<Integer> reversedList = new ArrayList<Integer>();
	
	// this one builds a list containing values from 1 to n
	public static ArrayList<Integer> buildList(int n)
	{
		// write this in terms of a recursive call using a smaller n
		
		ArrayList<Integer> tempList = null;
		if (n <= 0) // The smallest list we can make
		{  
			return new ArrayList<Integer>();
		
		}
		else // All other size lists are created here
		{
			tempList= buildList(n-1);
			tempList.add(n);
			
		}
		list = tempList;
		return list;
		
	}
	
	// this one reverses a list in-place
	public static ArrayList<Integer> reverse(ArrayList<Integer> lst)
	{
		// write this in terms of a recursive call using a smaller lst
		
		if (lst.size() == 0 || lst.size() == 1)
		// The list is empty or has one element)
		{// Return the list as is – no need to reverse!
			return lst;

		} else {
			// Use the solution to a smaller version of the problem
			// to solve the general problem
			int first = lst.remove(0);
			reverse(lst);
			lst.add(first);
		}
		reversedList = lst;
		return reversedList;
	}
	
	
	// return the sum of all Integers in the ArrayList
	// this should not change the lst argument
	public static int add(ArrayList<Integer> lst)
	{
		return add(lst,0);
	}
	// Print out all the contents of the argument
	// this should not change the lst argument
	public static void print(ArrayList<Integer> lst)
	{
		print(lst,0);
		return;
	}
	
	private static int add (ArrayList<Integer> lst, int index)
	{
		// think of the input as the inclusive sublist of elements from index
		// to lst.size(). make this sublist shorter in the recursive call
		// by incrementing index
		if(index == lst.size()){
			return 0;
		}
		int sum = add(lst, index + 1) + lst.get(index);
		return sum;
		
		
		
	}
	private static void print (ArrayList<Integer> lst, int index)
	{
		// write this in the same way as add, above
		if(index == lst.size()){
			return;
		}

		System.out.println(lst.get(index));
		print(lst,index + 1);	
		
		
		
	}


	public static void main(String[] args)
	{
		ArrayList<Integer> lst = Recursive.buildList(5);
		System.out.println(lst);
		
		reverse(lst);
		System.out.println(lst);
		
		Recursive.print(lst);
		System.out.println(Recursive.add(lst));
		
	}

}