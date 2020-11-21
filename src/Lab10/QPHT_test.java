package Lab10;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class QPHT_test {

	@Test
	void test() {
		QuadraticProbingHashTable H = new QuadraticProbingHashTable(21);
		H.insert( new MyInteger( 7 ) );
		H.insert( new MyInteger( 22 ) );
		H.insert( new MyInteger( 44 ) );
		H.insert( new MyInteger( 43 ) );
		H.insert( new MyInteger( 27 ) );
		H.insert( new MyInteger( 89 ) );
		H.insert( new MyInteger( 30 ) );
		H.insert( new MyInteger( 64 ) );
		H.insert( new MyInteger( 85 ) );
		
		HashEntry[] copy = H.getTable();
		
		assertNull(copy[0]);
		assertNotNull(copy[1]);
		assertNotNull(copy[2]);
		assertNull(copy[3]);
		assertNull(copy[4]);
		assertNotNull(copy[5]);
		assertNotNull(copy[6]);
		assertNotNull(copy[7]);
		assertNull(copy[8]);
		assertNotNull(copy[9]);
		assertNotNull(copy[10]);
		
		System.out.println("Number of probes: " + H.count);
		
		QuadraticProbingHashTable T = new QuadraticProbingHashTable(23);
		T.insert(new MyInteger(QuadraticProbingHashTable.hash("A", 23)));
		T.insert(new MyInteger(QuadraticProbingHashTable.hash("W", 23)));
		T.insert(new MyInteger(QuadraticProbingHashTable.hash("X", 23)));
		T.insert(new MyInteger(QuadraticProbingHashTable.hash("Y", 23)));
		T.insert(new MyInteger(QuadraticProbingHashTable.hash("CM", 23)));
		T.insert(new MyInteger(QuadraticProbingHashTable.hash("CK", 23)));
		T.insert(new MyInteger(QuadraticProbingHashTable.hash("BD", 23)));
		T.insert(new MyInteger(QuadraticProbingHashTable.hash("H", 23)));
		T.insert(new MyInteger(QuadraticProbingHashTable.hash("MOB", 23)));
		T.insert(new MyInteger(QuadraticProbingHashTable.hash("BD", 23)));
		System.out.println("Number of probes: " + T.count);
	}

}
