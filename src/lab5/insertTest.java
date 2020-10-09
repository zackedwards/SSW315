package lab5;

import static org.junit.jupiter.api.Assertions.*;


import org.junit.jupiter.api.Test;

class insertTest {

	@Test
	void test() {
		MyDLLImpl <Integer> dll0 = new MyDLLImpl<Integer> ();
		assertTrue(dll0.isEmpty());
		dll0.insert(10);
		dll0.insert(34);
		dll0.insert(56);
		dll0.insert(364);
		assertFalse(dll0.isEmpty());
		assertEquals(4, dll0.getSize());
		dll0.insert(5, dll0.get(34));
		assertEquals(5, dll0.getSize());
	}

}
