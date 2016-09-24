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

	@Test
	public void testReadingAFile() {
		CourseReader courseReader = new CourseReader("courses.csv");
		java.util.List<Course> coursesFromRead = courseReader.read();
		java.util.List<Course> coursesCorrect = new java.util.ArrayList<Course>();


		coursesCorrect.add(new Course(2,"Computer programming",false, true, false));
		coursesCorrect.add(new Course(4,"Data structures", false, true, false));
		coursesCorrect.add(new Course(6,"Software engineering", true, true, false));
		coursesCorrect.add(new Course(8,"Computer architecture", true, true, false));
		coursesCorrect.add(new Course(10,"Operating systems", false, false, true));
		coursesCorrect.add(new Course(13,"Machine learning", false, false, false));
		coursesCorrect.add(new Course(16,"Computer security", false, true, true));
		coursesCorrect.add(new Course(17,"Relational databases",false, true, false));
		coursesCorrect.add(new Course(19,"Structured Storage",true, false, true));
		coursesCorrect.add(new Course(20,"Programming language pragmatics", false, true, false));
		coursesCorrect.add(new Course(23,"Algorithm design", true, true, false));
		coursesCorrect.add(new Course(24,"Web designing",false, true, true));
		coursesCorrect.add(new Course(25,"Artificial intelligence", false, true, true));
		coursesCorrect.add(new Course(28,"Computer graphics", false, true, true));
		coursesCorrect.add(new Course(29,"Parallel computing",true, true, false));

		assertTrue(coursesFromRead.size() == coursesCorrect.size());
		for (Integer i = 0; i < coursesFromRead.size(); i+=1) {
			System.out.println(i);
			assertTrue(coursesFromRead.get(i).equals(coursesCorrect.get(i)));
		}
	
	}
}
