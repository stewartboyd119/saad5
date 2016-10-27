import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class TestAdministrator2 {

	Administrator administrator;
	Student student;
	Student student2;
	Instructor instructor;
	Course course1;
	Course course2;
	Course course3;
	Course course4;
	Course course5;
	Course course6;
	CourseInstance course3Instance1;
	@Before
	public void setUp() throws Exception {
		administrator = new Administrator();
		student = new Student(1, "Stewart", "", "");
		student2 = new Student(2, "Justin", "", "");
		instructor = new Instructor(1, "Asif", "", "");
		administrator.getStudents().add(student);
	    course1 = new Course(1, "", false, false, false);
		course2 = new Course(2, "", false, false, false);
		course3 = new Course(3, "", false, false, false);
		course4 = new Course(4, "", false, false, false);
		course5 = new Course(5, "", false, false, false);
		course6 = new Course(6, "", false, false, false);
		course3Instance1 = new CourseInstance(course3, instructor, 200);
		administrator.getCourseCatalogue().getCourses().add(course1);
		administrator.getCourseCatalogue().getCourses().add(course2);
		administrator.getCourseCatalogue().getCourses().add(course3);
		administrator.getCourseCatalogue().getCourses().add(course4);
		administrator.getCourseCatalogue().getCourses().add(course5);
		administrator.getCourseCatalogue().getCourses().add(course6);
		administrator.getPrereqs().add(new Prereq(course2.getID(), course1.getID())); //pass
		administrator.getPrereqs().add(new Prereq(course3.getID(), course1.getID())); //fail
		administrator.getPrereqs().add(new Prereq(course1.getID(), course4.getID())); //hasnt taken
		administrator.getPrereqs().add(new Prereq(course5.getID(), course6.getID())); //pass


		administrator.updateCourseWithPrereqs();
		//student, courseID, instructorID, comment, grade
		//PerformanceRecord performanceRecord = new PerformanceRecord(studentID, courseID, instructorID, comment, grade)
		
		administrator.getPerformanceRecords().add(new PerformanceRecord(1, course2.getID(), 1, "comment", Grade.A));
		administrator.getPerformanceRecords().add(new PerformanceRecord(1, course3.getID(), 1, "comment", Grade.F));
		administrator.getPerformanceRecords().add(new PerformanceRecord(1, course5.getID(), 1, "comment", Grade.C));
		administrator.getPerformanceRecords().add(new PerformanceRecord(2, course5.getID(), 1, "comment", Grade.A));
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testHasPassingGradeForPrereqs() {
		//prereq id, course id

		//one of the classes had failing prereq. This should return False
		assertFalse(administrator.hasPassingGradesForPrereqs(student, course1));
		//No performance record for the course prereq. Should return False
		assertFalse(administrator.hasPassingGradesForPrereqs(student, course4));
		//Passing grade for prereq. SHould retunr True
		assertTrue(administrator.hasPassingGradesForPrereqs(student, course6));
		//This class didn't require prereq. Should return True
		assertTrue(administrator.hasPassingGradesForPrereqs(student, course2));
		
	}

	@Test
	public void testProcessRequestClassAlreadyTakenAndPassed() {
		Request request = new Request(student.getUuid(), course2.getID());
	
		administrator.getRequests().add(request);
		assertTrue(administrator.getDeniedRequestsAlreadyTaken().size() == 0);
		assertTrue(administrator.getDeniedRequestsNoPrereq().size() == 0);
		assertTrue(administrator.getDeniedRequestsNoSeats().size() == 0);
		assertTrue(administrator.getValidRequests().size() == 0);
		administrator.processRequest();
		assertTrue(administrator.getDeniedRequestsAlreadyTaken().size() == 1);
		assertTrue(administrator.getDeniedRequestsNoPrereq().size() == 0);
		assertTrue(administrator.getDeniedRequestsNoSeats().size() == 0);
		assertTrue(administrator.getValidRequests().size() == 0);
	}

	@Test
	public void testProcessRequestClassAlreadyTakenAndFailed() {
		Request request = new Request(student.getUuid(), course3.getID());
		administrator.getRequests().add(request);
		assertTrue(administrator.getDeniedRequestsAlreadyTaken().size() == 0);
		assertTrue(administrator.getDeniedRequestsNoPrereq().size() == 0);
		assertTrue(administrator.getDeniedRequestsNoSeats().size() == 0);
		assertTrue(administrator.getValidRequests().size() == 0);
		administrator.processRequest();
		assertTrue(administrator.getDeniedRequestsAlreadyTaken().size() == 0);
		assertTrue(administrator.getDeniedRequestsNoPrereq().size() == 0);
		assertTrue(administrator.getDeniedRequestsNoSeats().size() == 0);
		assertTrue(administrator.getValidRequests().size() == 1);
	}

	@Test
	public void testProcessRequestClassNoSeats() {
		Request request = new Request(student.getUuid(), course6.getID());
		administrator.getRequests().add(request);
		assertTrue(administrator.getDeniedRequestsAlreadyTaken().size() == 0);
		assertTrue(administrator.getDeniedRequestsNoPrereq().size() == 0);
		assertTrue(administrator.getDeniedRequestsNoSeats().size() == 0);
		assertTrue(administrator.getValidRequests().size() == 0);
		administrator.processRequest();
		assertTrue(administrator.getDeniedRequestsAlreadyTaken().size() == 0);
		assertTrue(administrator.getDeniedRequestsNoPrereq().size() == 0);
		assertTrue(administrator.getDeniedRequestsNoSeats().size() == 1);
		assertTrue(administrator.getValidRequests().size() == 0);
	}

	@Test
	public void testProcessRequestClassNotRightPrereqs() {
		Request request = new Request(student.getUuid(), course1.getID());
		administrator.getRequests().add(request);
		assertTrue(administrator.getDeniedRequestsAlreadyTaken().size() == 0);
		assertTrue(administrator.getDeniedRequestsNoPrereq().size() == 0);
		assertTrue(administrator.getDeniedRequestsNoSeats().size() == 0);
		assertTrue(administrator.getValidRequests().size() == 0);
		administrator.processRequest();
		assertTrue(administrator.getDeniedRequestsAlreadyTaken().size() == 0);
		assertTrue(administrator.getDeniedRequestsNoPrereq().size() == 1);
		assertTrue(administrator.getDeniedRequestsNoSeats().size() == 0);
		assertTrue(administrator.getValidRequests().size() == 0);
	}


	@Test
	public void testCanRetakeCourse() {
		//passed course. cant retake
		assertFalse(administrator.canRetakeCourse(student, course2));
		
		//failed course. all good to retake
		assertTrue(administrator.canRetakeCourse(student, course3));
		
	}

	@Test
	public void testGetCorrectAcademicRecord() {
		//previosu bug found that first time a course ID was matched
		//that result was returned.
		assertTrue(administrator.highestGradeInCourse(student2, course5) == Grade.A);
	}
}
