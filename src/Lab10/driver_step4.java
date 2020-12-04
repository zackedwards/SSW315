package Lab10;

import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class driver_step4 {

	public static void main(String args[]) throws IOException {
		//importing the text files into hash tables
		QuadraticProbingHashTable dictionary = new QuadraticProbingHashTable( 2 * 45402);
		Scanner s = new Scanner(new FileReader("linuxwords.txt"));
		while(s.hasNext()) {
			dictionary.insert(new MyString(s.nextLine()));
		}
		
		QuadraticProbingHashTable hbFinn = new QuadraticProbingHashTable(2 * 45402);
		Scanner s2 = new Scanner(new FileReader("huckleberry_short.txt"));
		while(s2.hasNext()) {
			hbFinn.insert(new MyString(s2.nextLine()));
		}
		
		QuadraticProbingHashTable dict_random = new QuadraticProbingHashTable(2 * 45402);
		Scanner s3 = new Scanner(new FileReader("linuxwords_rand.txt"));
		while(s3.hasNext()) {
			dict_random.insert(new MyString(s3.nextLine()));
		}
		System.out.println("Number of probes in the dictionary: " + dictionary.count);
		System.out.println("Number of probes in Huckleberry Finn: " + hbFinn.count);
		System.out.println("Number of probes in the randomized dictionary: " + dict_random.count);
		float avg1 = (float)dictionary.count/(float)45402;
		float avg2 = (float)hbFinn.count/(float)45402;
		float avg3 = (float)dict_random.count/(float)45402;
		System.out.println();
		System.out.println("Average Number of probes in the dictionary: " + avg1);
		System.out.println("Average Number of probes in Huckleberry Finn: " + avg2);
		System.out.println("Average Number of probes in the randomized dictionary: " + avg3);
		s.close();
		s2.close();
		s3.close();
	}
	
}
