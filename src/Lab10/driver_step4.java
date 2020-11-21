package Lab10;

import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class driver_step4 {

	public static void main(String args[]) throws IOException {
		//importing the text files into hash tables
		QuadraticProbingHashTable dictionary = new QuadraticProbingHashTable(59023);
		Scanner s = new Scanner(new FileReader("linuxwords.txt"));
		System.out.println(s);
//		try(Scanner s = new Scanner(new FileReader("linuxwords.txt"))){
//			while(s.hasNext()) {
//				dictionary.insert(new MyInteger(QuadraticProbingHashTable.hash(s.nextLine(), dictionary.size())));
//			}
//		} catch (FileNotFoundException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		HashEntry[] copy = dictionary.getTable();
		for(int i = 0; i < copy.length-1; i++) {
        	if(copy[i] != null) {
        		System.out.println(copy[i].element);
        	}
        }
	}
	
}
