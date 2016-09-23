import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class TestCourseReader {

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testReadingALine1SemesterEntry() {
		String[] line = {"2","Computer programming","Spring"};
		Course course = CourseReader.readLine(line);
		org.junit.Assert.assertTrue(course.getID() == 2);
		assertEquals(course.getTitle(), "Computer programming");
		assertFalse(course.getIsAvailableFall());
		assertTrue(course.getIsAvailableSpring());
		assertFalse(course.getIsAvailableSummer());
	}

	@Test
	public void testReadingALine2SemesterEntry() {
		String[] line = {"6","Software engineering","Fall","Spring"};
		Course course = CourseReader.readLine(line);
		org.junit.Assert.assertTrue(course.getID() == 6);
		assertEquals(course.getTitle(), "Software engineering");
		assertTrue(course.getIsAvailableFall());
		assertTrue(course.getIsAvailableSpring());
		assertFalse(course.getIsAvailableSummer());
	}

	@Test
	public void testReadingALine3SemesterEntry() {
		String[] line = {"28","Computer graphics","Spring","Fall", "Summer"};
		Course course = CourseReader.readLine(line);
		org.junit.Assert.assertTrue(course.getID() == 28);
		assertEquals(course.getTitle(), "Computer graphics");
		assertTrue(course.getIsAvailableFall());
		assertTrue(course.getIsAvailableSpring());
		assertTrue(course.getIsAvailableSummer());
	}
}
