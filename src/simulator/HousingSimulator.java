package simulator;

import java.util.ArrayList;

import java.util.Scanner;

public class HousingSimulator {
    //Functions for generating random double
    public static double randomDouble(int from, int to) {
        return (Math.random() * to + from);
    }

    //Functions for generating random int
    public static int randomInt(int from, int to) {
        return (int) (Math.random() * to + from);
    }

	//To be completed by you
    public static void runSimulation(int k, int N) { 
    	// declaring arraylist's for vacant and occupied apartments
    	ArrayList<Apartment> vacant = new ArrayList<Apartment>();
    	ArrayList<Apartment> occupied = new ArrayList<Apartment>();
    	//sorting apartments into the vacant list
    	for (int i = 0; i < N; i++) {
    		Apartment lease = new Apartment(randomDouble(0, 1), i, 0);
    		vacant.add(lease);
    	}
    	//sorting students into a queue
    	MyQueue<Student> students = new MyQueue<Student>();
    	for (int j = 0; j < k; j++) {
    		Student freshmen = new Student(randomDouble(1, 0), j);
    		students.offer(freshmen);
    	}
    	int years = 0;
    	
    	//a loop that will run until all students are housed
    	while(students.size() > 0) {
    		int apartmentsFilled = 0;
    		int vacanciesCreated = 0;
    		
    		//a for loop that decrements yearsleft on occupied apartments
    		//and adds them to vacant list if needed
    		int occupiedSize = occupied.size();
    		for(int k1 = 0; k1 < occupied.size(); k1++) {
    			occupied.get(k1).decYearsLeft();
    			if(occupied.get(k1).getYearsLeft() == 0) {
    				vacant.add(occupied.get(k1));
    				occupied.remove(k1);
    				vacanciesCreated+=1;
    			}
    		}
    		
    		//loop through each appt then for each appt
    		int vacantSize = vacant.size();
        	for(int i = 0; i < vacant.size(); i++) {
        		Apartment currentAppt = vacant.get(i);
        		int studentsSize = students.size();
        		//loop through each student
        		for(int j = 0; j < studentsSize; j++) {
        			Student potentialStudent = students.poll();
        			//if a match is found then add the appt to occupied.
        			if(currentAppt.getQuality() >= potentialStudent.getQualityThreshold()) {
            			currentAppt.setYearsLeft(randomInt(1, 3));
            			occupied.add(currentAppt);
            			vacant.remove(currentAppt);
            			apartmentsFilled+=1;
            			if(k < 10) {
            				System.out.println("The student (" + potentialStudent.getIDNum() + ") likes the apartment (" + i + ")! It's a match!");
            				System.out.println(" ");
            			}
            			break;
            		}
        			//otherwise add back student
        			else {
        				potentialStudent.addDesperation();
        				students.offer(potentialStudent);
        			}
        			if(vacant.size() == 0) {
        				break;
        			}
        		}
        	}
        	//print out stats after each year
    		years+=1;
    		System.out.println("");
    		System.out.println("It has been " + years + " years!");
        	System.out.println("Apartments filled: " + apartmentsFilled);
        	System.out.println("Vacancies created: " + vacanciesCreated);
        	System.out.println("Vacant apartments: " + vacant.size());
        	System.out.println("Occupied apartments: " + occupied.size());
        	System.out.println("Students left: " + students.size());
        	System.out.println("*******************");
        	System.out.println(" ");
    	}
    	
    }

    //Main method for simulation
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of students to run simulation with: ");
        int k = sc.nextInt();

        System.out.print("Enter number of apartments to run simulation with: ");
        int N = sc.nextInt();

        runSimulation(k, N);
        
        sc.close();
    }
}
