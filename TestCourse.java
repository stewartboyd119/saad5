import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class TestCourse {

	Course courseAvailableAllSemesters;
	Course courseNotAvailableAnySemesters;

	@Before
	public void setUp() throws Exception {
		courseAvailableAllSemesters = new Course(1, "title", true, true, true);
		courseNotAvailableAnySemesters = new Course(1, "title", false, false, false);
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testCourseIsAvailable() {
		assertTrue(courseAvailableAllSemesters.isAvailable(Semester.Fall));
		assertTrue(courseAvailableAllSemesters.isAvailable(Semester.Spring));
		assertTrue(courseAvailableAllSemesters.isAvailable(Semester.Summer));

		assertFalse(courseNotAvailableAnySemesters.isAvailable(Semester.Fall));
		assertFalse(courseNotAvailableAnySemesters.isAvailable(Semester.Spring));
		assertFalse(courseNotAvailableAnySemesters.isAvailable(Semester.Summer));
	}

}
