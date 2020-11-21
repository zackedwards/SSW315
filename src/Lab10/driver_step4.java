package Lab10;

import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class driver_step4 {

	public static void main(String args[]) throws IOException {
		//importing the text files into hash tables
		QuadraticProbingHashTable dictionary = new QuadraticProbingHashTable(59023);
		Scanner s = new Scanner(new FileReader("linuxwords.txt"));
		while(s.hasNext()) {
			dictionary.insert(s.nextLine());
		}
		
		QuadraticProbingHashTable hbFinn = new QuadraticProbingHashTable(59023);
		Scanner s2 = new Scanner(new FileReader("huckleberry_short.txt"));
		while(s2.hasNext()) {
			hbFinn.insert(new MyInteger(QuadraticProbingHashTable.hash(s2.nextLine(), 59023)));
		}
		
		QuadraticProbingHashTable dict_random = new QuadraticProbingHashTable(59023);
		Scanner s3 = new Scanner(new FileReader("linuxwords_rand.txt"));
		while(s3.hasNext()) {
			dict_random.insert(new MyInteger(QuadraticProbingHashTable.hash(s3.nextLine(), 59023)));
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
	}
	
}
