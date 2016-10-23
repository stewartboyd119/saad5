import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import java.util.List;
import java.util.ArrayList;


public class TestAssignmentReader {

	ArrayList<Course> courses;
	ArrayList<Instructor> instructors;

	Course course1;
	Course course2;
	Course coursePrereq;

	Instructor instructor1;
	Instructor instructor2;


	@Before
	public void setUp() throws Exception {
		courses = new ArrayList<Course>();
		instructors = new ArrayList<Instructor>();
		course1 = new Course(1, "Class1", true, false, false);
		course2 = new Course(2, "Class2", false, true, false);
		coursePrereq = new Course(1, "Class3", false, false, true);
		course1.getPrereqs().add(coursePrereq);
		course2.getPrereqs().add(coursePrereq);
		courses.add(course1);
		courses.add(course2);
		courses.add(coursePrereq);

		instructor1 = new Instructor(1, "John Oliber", "1014 Sugar Mt", "7137745349");
		instructor2 = new Instructor(2, "Stew", "2222 Sugar Mt", "888888888");
		instructors.add(instructor1);
		instructors.add(instructor2);

	}

	@After
	public void tearDown() throws Exception {
	}


	@Test
	public void testReadingALine() {
		// course, instructor, and seat
		String[] line = {"2","3","5"};
		Assignment assignmentFromRead = AssignmentReader.readLine(line);
		Assignment assignment = new Assignment(2, 3, 5);
		assertTrue(assignment.getInstructorID() == 2);
		assertTrue(assignment.getCourseID() == 3);
		assertTrue(assignment.getNumberOfSeats() == 5);
		assertTrue(assignmentFromRead.equals(assignment));
	}

	@Test
	public void testAddingAssignmentToCourse() {
		//instructor id, course id, number of seats

		Assignment assignment1 = new Assignment(1, 1, 4);
		Assignment assignment2 = new Assignment(1, 2, 2);
		CourseInstance courseFromAssignment1;
		CourseInstance courseFromAssignment2;
		try {
			courseFromAssignment1 = new CourseInstance(assignment1, courses, instructors);
			courseFromAssignment2 = new CourseInstance(assignment2, courses, instructors);
		} catch (IDNotFound e) {
			e.printStackTrace();
			return;
		}
		 
		CourseInstance courseDirectInt1 = new CourseInstance(this.course1, this.instructor1, 4);
		CourseInstance courseDirectInt2 = new CourseInstance(this.course2, this.instructor1, 2);
		assertTrue(courseFromAssignment1.equals(courseDirectInt1));
		assertTrue(courseFromAssignment2.equals(courseDirectInt2));
		assertTrue(courseFromAssignment1.notEquals(courseDirectInt2));
		assertTrue(courseFromAssignment2.notEquals(courseDirectInt1));
	}

	@Test
	public void testReadingAFile() {

		AssignmentReader assignmentReader = new AssignmentReader("bin/CSV/assignments.csv");
		java.util.List<Assignment> assignmentsFromRead = assignmentReader.read();
		java.util.List<Assignment> assignmentsCorrect = new java.util.ArrayList<Assignment>();

		assignmentsCorrect.add(new Assignment(2,13,2));
		assignmentsCorrect.add(new Assignment(5,17,1));
		assignmentsCorrect.add(new Assignment(3,10,1));
		assignmentsCorrect.add(new Assignment(5,29,1));
		assignmentsCorrect.add(new Assignment(2,19,1));
		assignmentsCorrect.add(new Assignment(8,29,1));
		assignmentsCorrect.add(new Assignment(3,28,5));

		assertTrue(assignmentsFromRead.size() == assignmentsCorrect.size());
		for (Integer i = 0; i < assignmentsFromRead.size(); i+=1) {
			System.out.println(i);
			assertTrue(assignmentsFromRead.get(i).equals(assignmentsCorrect.get(i)));
		}

	}

}
