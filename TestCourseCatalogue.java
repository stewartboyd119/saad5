import static org.junit.Assert.*;

import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class TestCourseCatalogue {

	Administrator administrator;
	CourseCatalogue courseCatalogue;
	java.util.List<Course> courses;

	@Before
	public void setUp() throws Exception {
		CourseReader courseReader = new CourseReader("bin/CSV/courses.csv");
		courses = courseReader.read();
		courseCatalogue = new CourseCatalogue(courses);
	}


	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testDoubleIterationOfCourseCatalogue() {
		Integer index = 0;
		Course courseFromList;
		for (Course course: courseCatalogue) {
			courseFromList = courses.get(index);
			assertTrue(courseFromList.equals(course));
			index += 1;
		}
		index = 0;
		for (Course course: courseCatalogue) {
			courseFromList = courses.get(index);
			assertTrue(courseFromList.equals(course));
			index += 1;
		}
	}

	@Test public void testLoopThroughAll() {
		Integer index = 0;
		for (Course _: courseCatalogue) {
			index += 1;
		}
		assertTrue(index.equals(courseCatalogue.numberOfCourses()));
	}

}
