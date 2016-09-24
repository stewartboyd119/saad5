import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class TestInstructorReader {

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testReadingALine() {
		String[] line = {"2","EVERETT KIM","699 Sheffield Drive 59251","8041174317"};
		Instructor instructor = InstructorReader.readLine(line);
		org.junit.Assert.assertTrue(instructor.getUuid() == 2);
		assertEquals(instructor.getName(), "EVERETT KIM");
		assertEquals(instructor.getAddress(), "699 Sheffield Drive 59251");
		assertEquals(instructor.getPhoneNumber(), "8041174317");
	}

	@Test
	public void testReadingAFile() {
		InstructorReader instructorReader = new InstructorReader("instructors.csv");
		java.util.List<Instructor> instructorsFromRead = instructorReader.read();
		java.util.List<Instructor> instructorsCorrect = new java.util.ArrayList<Instructor>();

		instructorsCorrect.add(new Instructor(2,"EVERETT KIM","699 Sheffield Drive 59251","8041174317"));
		instructorsCorrect.add(new Instructor(3,"JOSEPH LE","974 River Road 61972","9939922102"));
		instructorsCorrect.add(new Instructor(4,"ROBERT RYAN","481 Valley View Drive 42223","7153848491"));
		instructorsCorrect.add(new Instructor(5,"JOSEPH LAWSON","447 Carriage Drive 77403","7405768930"));
		instructorsCorrect.add(new Instructor(8,"REBECCA CURRY","692 Ashley Court 92876","9636667844"));

		assertTrue(instructorsFromRead.size() == instructorsCorrect.size());
		for (Integer i = 0; i < instructorsFromRead.size(); i+=1) {
			assertTrue(instructorsFromRead.get(i).equals(instructorsCorrect.get(i)));
		}
	}
}
