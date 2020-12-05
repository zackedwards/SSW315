package lab11;

import static org.junit.jupiter.api.Assertions.*;
import java.util.Arrays;
import org.junit.jupiter.api.Test;

class quickSortTest {

	@Test
	void test1() {
		QuicksortLab sort = new QuicksortLab();
		int[] input1 = {44, 75, 23, 43, 55, 12, 64, 77, 33};
		String expected = "[12, 23, 33, 43, 44, 55, 64, 75, 77]";
		sort.quickSort(input1);
		assertEquals(expected, Arrays.toString(sort.items));
		
	}
	
	@Test
	void test2() {
		QuicksortLab sort = new QuicksortLab();
		int[] input2 = {99, 32, 74, 82, 91, 63, 1, 69, 42, 99, 63, 87, 78, 54, 73, 71, 2};
		String expected = "[1, 2, 32, 42, 54, 63, 63, 69, 71, 73, 74, 78, 82, 87, 91, 99, 99]";
		sort.quickSort(input2);
		assertEquals(expected, Arrays.toString(sort.items));
	}
	
	@Test
	void test3() {
		QuicksortLab sort = new QuicksortLab();
		int[] input3 = { 8, 7, 6, 7, 8, 9, 8, 7, 6, 5, 4, 3, 2, 1, 1, 2, 3, 4, 5, 6, 7, 8, 9, 0, 9, 8, 7, 6, 5, 4, 3, 2,
				1 };
		String expected = "[0, 1, 1, 1, 2, 2, 2, 3, 3, 3, 4, 4, 4, 5, 5, 5, 6, 6, 6, 6, 7, 7, 7, 7, 7, 8, 8, 8, 8, 8, "
				+ "9, 9, 9]";
		sort.quickSort(input3);
		assertEquals(expected, Arrays.toString(sort.items));
	}
	
	@Test
	void test4() {
		QuicksortLab sort = new QuicksortLab();
		int[] input4 = {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,99};
		String expected = "[0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 99]";
		sort.quickSort(input4);
		assertEquals(expected, Arrays.toString(sort.items));
	}

}
