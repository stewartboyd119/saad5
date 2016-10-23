import static org.junit.Assert.*;

import java.util.Arrays;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class TestAdministrator {

	Administrator administrator;
	@Before
	public void setUp() throws Exception {
		administrator = new Administrator();
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testInstructorByID1() {
		administrator.instructorsFpath = "bin/test_case_0/instructors.csv";
		administrator.readInstructors();
		Instructor instructorCorrect = new Instructor(2,"EVERETT KIM","699 Sheffield Drive 59251","8041174317");

		try {
			Instructor instructorFromIDQuery = administrator.getInstructorByID(2);
			assertTrue(instructorCorrect.equals(instructorFromIDQuery));
		} catch (IDNotFound e) {
			e.printStackTrace();
			org.junit.Assert.fail();
		}
	}

	@Test
	public void testInstructorByID2() {
		administrator.instructorsFpath = "bin/test_case_0/instructors.csv";
		administrator.readInstructors();
		Instructor instructorCorrect = new Instructor(8,"REBECCA CURRY","692 Ashley Court 92876","9636667844");

		try {
			Instructor instructorFromIDQuery = administrator.getInstructorByID(8);
			assertTrue(instructorCorrect.equals(instructorFromIDQuery));
		} catch (IDNotFound e) {
			e.printStackTrace();
			org.junit.Assert.fail();
		}
	}

	@Test
	public void testInstructorNotFoundByID() {
		administrator.instructorsFpath = "bin/test_case_0/instructors.csv";
		administrator.readInstructors();

		try {
			Instructor _ = administrator.getInstructorByID(22222);
			org.junit.Assert.fail();
		} catch (IDNotFound e) {
			e.printStackTrace();
			//error raised if not found. AAnticipated behvior
		}
	}

	@Test
	public void testStudentByID1() {
		administrator.studentsFpath = "bin/test_case_0/students.csv";
		administrator.readStudents();
		Student studentCorreect = new Student(9,"GARY ALLEN","128 Pine Street 83866","8304231126");

		try {
			Student studentFromIDQuery = administrator.getStudentByID(9);
			assertTrue(studentCorreect.equals(studentFromIDQuery));
		} catch (IDNotFound e) {
			e.printStackTrace();
			org.junit.Assert.fail();
		}
	}

	@Test
	public void testStudentByID2() {
		administrator.studentsFpath = "bin/test_case_0/students.csv";
		administrator.readStudents();
		Student studentCorreect = new Student(22,"SUE VELASQUEZ","204 Riverside Drive 72894","7543928902");

		try {
			Student studentFromIDQuery = administrator.getStudentByID(22);
			assertTrue(studentCorreect.equals(studentFromIDQuery));
		} catch (IDNotFound e) {
			e.printStackTrace();
			org.junit.Assert.fail();
		}
	}

	@Test
	public void testSTUDENTNotFoundByID() {
		administrator.studentsFpath = "bin/test_case_0/students.csv";
		administrator.readStudents();

		try {
			Student _ = administrator.getStudentByID(22222);
			org.junit.Assert.fail();
		} catch (IDNotFound e) {
			e.printStackTrace();
			//error raised if not found. AAnticipated behvior
		}
	}

	@Test
	public void testCourseByID1() {
		administrator.coursesFpath = "bin/test_case_0/courses.csv";
		administrator.readCourses();
		Course courseCorrect = new Course(2,"Computer programming",false, true, false);

		try {
			Course courseFromIDQuery = administrator.getCourseCatalogue().getCourseByID(2);
			assertTrue(courseCorrect.equals(courseFromIDQuery));
		} catch (IDNotFound e) {
			e.printStackTrace();
			org.junit.Assert.fail();
		}
	}

	@Test
	public void testCourseByID2() {
		administrator.coursesFpath = "bin/test_case_0/courses.csv";
		administrator.readCourses();
		Course courseCorrect = new Course(29,"Parallel computing",true, true, false);

		try {
			Course courseFromIDQuery = administrator.getCourseCatalogue().getCourseByID(29);
			assertTrue(courseCorrect.equals(courseFromIDQuery));
		} catch (IDNotFound e) {
			e.printStackTrace();
			org.junit.Assert.fail();
		}
	}

	@Test
	public void testCourseNotFoundByID() {
		administrator.coursesFpath = "bin/test_case_0/courses.csv";
		administrator.readCourses();

		try {
			Course _ = administrator.getCourseCatalogue().getCourseByID(22222);
			org.junit.Assert.fail();
		} catch (IDNotFound e) {
			e.printStackTrace();
			//error raised if not found. AAnticipated behvior
		}
	}

	@Test
	public void testCase0() {
		administrator.studentsFpath = "bin/test_case_0/students.csv";
		administrator.instructorsFpath = "bin/test_case_0/instructors.csv";
		administrator.recordsFpath = "bin/test_case_0/records.csv";
		administrator.coursesFpath = "bin/test_case_0/courses.csv";
		administrator.assignmentsFpath = "bin/CSV/assignments.csv";
		administrator.prereqsFpath = "bin/CSV/prereqs.csv";
		administrator.requestsFpath = "bin/CSV/requests.csv";

		Integer[] output = administrator.queryResults();
		Integer[] outputShouldBe = {6, 10, 5, 5, 3, 15, 9, 5, 12, 6};
		//for (Integer elem : output) {
		//	System.out.println(elem);
		//}
		assertTrue(Arrays.equals(outputShouldBe, output));
	}

	@Test
	public void testCase1() {
		administrator.studentsFpath = "bin/test_case_1/students.csv";
		administrator.instructorsFpath = "bin/test_case_1/instructors.csv";
		administrator.recordsFpath = "bin/test_case_1/records.csv";
		administrator.coursesFpath = "bin/test_case_1/courses.csv";
		administrator.assignmentsFpath = "bin/CSV/assignments.csv";
		administrator.prereqsFpath = "bin/CSV/prereqs.csv";
		administrator.requestsFpath = "bin/CSV/requests.csv";

		Integer[] output = administrator.queryResults();
		Integer[] outputShouldBe = {6, 10, 4, 5, 2, 15, 10, 8, 7, 6};
		assertTrue(Arrays.equals(outputShouldBe, output));
	}
	@Test
	public void testCase2() {
		administrator.studentsFpath = "bin/test_case_2/students.csv";
		administrator.instructorsFpath = "bin/test_case_2/instructors.csv";
		administrator.recordsFpath = "bin/test_case_2/records.csv";
		administrator.coursesFpath = "bin/test_case_2/courses.csv";
		administrator.assignmentsFpath = "bin/CSV/assignments.csv";
		administrator.prereqsFpath = "bin/CSV/prereqs.csv";
		administrator.requestsFpath = "bin/CSV/requests.csv";

		Integer[] output = administrator.queryResults();
		Integer[] outputShouldBe = {6, 10, 6, 5, 1, 15, 9, 7, 11, 4};
		assertTrue(Arrays.equals(outputShouldBe, output));
	}
	@Test
	public void testCase3() {
		administrator.studentsFpath = "bin/test_case_3/students.csv";
		administrator.instructorsFpath = "bin/test_case_3/instructors.csv";
		administrator.recordsFpath = "bin/test_case_3/records.csv";
		administrator.coursesFpath = "bin/test_case_3/courses.csv";
		administrator.assignmentsFpath = "bin/CSV/assignments.csv";
		administrator.prereqsFpath = "bin/CSV/prereqs.csv";
		administrator.requestsFpath = "bin/CSV/requests.csv";

		Integer[] output = administrator.queryResults();
		Integer[] outputShouldBe = {6, 10, 6, 5, 2, 15, 12, 6, 12, 5};
		assertTrue(Arrays.equals(outputShouldBe, output));
	}

	@Test
	public void testCase4() {
		administrator.studentsFpath = "bin/test_case_4/students.csv";
		administrator.instructorsFpath = "bin/test_case_4/instructors.csv";
		administrator.recordsFpath = "bin/test_case_4/records.csv";
		administrator.coursesFpath = "bin/test_case_4/courses.csv";
		administrator.assignmentsFpath = "bin/CSV/assignments.csv";
		administrator.prereqsFpath = "bin/CSV/prereqs.csv";
		administrator.requestsFpath = "bin/CSV/requests.csv";

		Integer[] output = administrator.queryResults();
		Integer[] outputShouldBe = {50, 100, 66, 40, 14, 30, 7, 12, 19, 11};
		assertTrue(Arrays.equals(outputShouldBe, output));
	}
	@Test
	public void testCase5() {
		administrator.studentsFpath = "bin/test_case_5/students.csv";
		administrator.instructorsFpath = "bin/test_case_5/instructors.csv";
		administrator.recordsFpath = "bin/test_case_5/records.csv";
		administrator.coursesFpath = "bin/test_case_5/courses.csv";
		administrator.assignmentsFpath = "bin/CSV/assignments.csv";
		administrator.prereqsFpath = "bin/CSV/prereqs.csv";
		administrator.requestsFpath = "bin/CSV/requests.csv";

		Integer[] output = administrator.queryResults();
		Integer[] outputShouldBe = {100, 200, 125, 50, 9, 53, 6, 30, 36, 23};

		assertTrue(Arrays.equals(outputShouldBe, output));
	}

}
