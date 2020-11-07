package simulator;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class MyQueueTest {

	@Test
	void test() {
		MyQueue<Student> students = new MyQueue<Student>();
		assertTrue(students.size() == 0);
		Student zack = new Student(1, 0);
		students.offer(zack);
		assertTrue(students.size() == 1);
		Student jess = new Student(1, 0);
		students.offer(jess);
		assertTrue(students.size() == 2);
		Student paz = new Student(1, 0);
		students.offer(paz);
		assertTrue(students.size() == 3);
		Student jack = new Student(1, 0);
		students.offer(jack);
		assertTrue(students.size() == 4);
		Student bsoong = new Student(1, 0);
		students.offer(bsoong);
		assertTrue(students.size() == 5);
	}

}
