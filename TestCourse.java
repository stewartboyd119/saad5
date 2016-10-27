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
		//prereq should be empty when use this sort of construcotr
		assertTrue(courseAvailableAllSemesters.getPrereqs().isEmpty());

		assertFalse(courseNotAvailableAnySemesters.isAvailable(Semester.Fall));
		assertFalse(courseNotAvailableAnySemesters.isAvailable(Semester.Spring));
		assertFalse(courseNotAvailableAnySemesters.isAvailable(Semester.Summer));
	}

	@Test
	public void testCourseConstructorWithPrereqs() {
		java.util.HashSet<Course> prereqs = new java.util.HashSet<Course>();
		prereqs.add(courseAvailableAllSemesters);
		prereqs.add(courseNotAvailableAnySemesters);
		
		Course course = new Course(1, "title", true, true, true, prereqs);
		assertEquals(course.getPrereqs(), prereqs);
	}

	@Test
	public void testCourseInstantiation() {
		Instructor instructor = new Instructor(1, "", "", "");
		Student student = new Student(1, "", "", "");
		CourseInstance courseInstance = new CourseInstance(courseAvailableAllSemesters, instructor, 2);
		//courseAvailableAllSemesters.addCourseInstance(courseInstance);
		courseInstance.registerStudent(student);
		assertTrue(courseInstance.getNumberOfAvailableSeats().equals(1));
		assertTrue(courseAvailableAllSemesters.getNumberOfAvailableSeats().equals(1));
	}
}
