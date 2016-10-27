import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class TestCourseInstance {

	Course course;
	Instructor instructor;
	CourseInstance courseInstance;
	CourseInstance courseInstance2;
	Integer seats1 = 5;
	Integer seats2 = 10;

	@Before
	public void setUp() throws Exception {
		course = new Course(1, "a", false, false, false);
		instructor = new Instructor(1, "a", "a", "a");
		courseInstance = new CourseInstance(course, instructor, seats1);
		courseInstance2 = new CourseInstance(course, instructor, seats2);
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testCourseInstance() {
		/*
		 * There is a double link between course and courseInstance.
		 * Verify that link.
		 */

		//courseInstance has a refernce to its course
		assertTrue(course == courseInstance.getCourse());
		assertTrue(course == courseInstance2.getCourse());
		//course has a refernece to the child courseInstances
		assertTrue(course.getCourseInstances().get(0) == courseInstance);
		assertTrue(course.getCourseInstances().get(1) == courseInstance2);

		assertTrue(course.areAvailableSeats());
		assertTrue(course.getNumberOfAvailableSeats().equals(seats1 + seats2));
	}

}
