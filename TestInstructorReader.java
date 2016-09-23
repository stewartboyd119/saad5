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

}
