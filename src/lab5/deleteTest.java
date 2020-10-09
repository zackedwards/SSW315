package lab5;

import static org.junit.jupiter.api.Assertions.*;


import org.junit.jupiter.api.Test;

class deleteTest {

	@Test
	void test() {
		MyDLLImpl <Integer> dll0 = new MyDLLImpl<Integer> ();
		assertTrue(dll0.isEmpty());
		dll0.delete(2);
		assertTrue(dll0.isEmpty());
		dll0.insert(10);
		dll0.insert(34);
		dll0.insert(56);
		dll0.insert(364);
		assertFalse(dll0.isEmpty());
		assertEquals(4, dll0.getSize());
		assertTrue(dll0.lookup(56));
		assertFalse(dll0.lookup(3));
		dll0.delete(10);
		assertEquals(3, dll0.getSize());
		dll0.delete(56);
		assertEquals(2, dll0.getSize());
	}

}
