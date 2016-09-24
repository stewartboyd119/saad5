import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class TestStudentReader {

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testReadingALine() {
		String[] line = {"9","GARY ALLEN","128 Pine Street 83866","8304231126"};
		Student student = StudentReader.readLine(line);
		org.junit.Assert.assertTrue(student.getUuid() == 9);
		assertEquals(student.getName(), "GARY ALLEN");
		assertEquals(student.getAddress(), "128 Pine Street 83866");
		assertEquals(student.getPhoneNumber(), "8304231126");
	}

	@Test
	public void testReadingAFile() {
		StudentReader studentReader = new StudentReader("students.csv");
		java.util.List<Student> students = studentReader.read();
	}

}
