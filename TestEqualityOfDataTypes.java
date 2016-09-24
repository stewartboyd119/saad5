import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class TestEqualityOfDataTypes {

	Student student1;
	Student student2;
	Student student3;
	Student student4;

	Student student1other;
	Student student2other;
	Student student3other;
	Student student4other;

	Instructor professor1;
	Instructor professor2;
	Instructor professor3;
	Instructor professor4;

	Instructor professor1other;
	Instructor professor2other;
	Instructor professor3other;
	Instructor professor4other;

	Course course1;
	Course course2;
	Course course3;
	Course course4;
	Course course5;
	Course course6;

	Course course1other;
	Course course2other;
	Course course3other;
	Course course4other;
	Course course5other;
	Course course6other;

	PerformanceRecord performanceRecord1;
	PerformanceRecord performanceRecord2;
	PerformanceRecord performanceRecord3;
	PerformanceRecord performanceRecord4;
	PerformanceRecord performanceRecord5;
	PerformanceRecord performanceRecord6;
	PerformanceRecord performanceRecord1other;
	PerformanceRecord performanceRecord2other;
	PerformanceRecord performanceRecord3other;
	PerformanceRecord performanceRecord4other;
	PerformanceRecord performanceRecord5other;
	PerformanceRecord performanceRecord6other;

	@Before
	public void setUp() throws Exception {
		String name = 	"name";
		String name2 = new String(name);
		String number = "7137755439";
		String number2 = new String(number);
		String address = "address";
		String address2 = new String("address");
		String description = "description";
		String description2 = new String(description);
		String comment = "comment";
		String comment2 = new String(comment);
		Integer id = 1;
		Integer courseId = 2;
		Integer proffId = 3;
		student1 = new Student(name, number, address, id);
		student2 = new Student(name, "1", address, id);
		student3 = new Student(name, number, "1", id);
		student4 = new Student(name, number, address, 2);

		student1other = new Student(name2, number2, address2, id);
		student2other = new Student(name2, "1", address2, id);
		student3other = new Student(name2, number2, "1", id);
		student4other = new Student(name2, number2, address2, 2);

		professor1 = new Instructor(name, number, address, id);
		professor2 = new Instructor(name, "1", address, id);
		professor3 = new Instructor(name, number, "1", id);
		professor4 = new Instructor(name, number, address, 2);

		professor1other = new Instructor(name2, number2, address2, id);
		professor2other = new Instructor(name2, "1", address2, id);
		professor3other = new Instructor(name2, number2, "1", id);
		professor4other = new Instructor(name2, number2, address2, 2);

		course1 = new Course(name, description,  id, true, true, true);
		course2 = new Course(name, description, 2, true, true, true);
		course3 = new Course(name, description, id, false, true, true);
		course4 = new Course(name, description, id, true, false, true);
		course5 = new Course(name, description, id, true, true, false);
		course6 = new Course("stew", description, id, true, true, true);

		course1other = new Course(name2, description2,  id, true, true, true);
		course2other = new Course(name2, description2, 2, true, true, true);
		course3other = new Course(name2, description2, id, false, true, true);
		course4other = new Course(name2, description2, id, true, false, true);
		course5other = new Course(name2, description2, id, true, true, false);
		course6other = new Course("stew", description2, id, true, true, true);


		performanceRecord1 = new PerformanceRecord(id, courseId, proffId, comment, Grade.A);
		performanceRecord2 = new PerformanceRecord(id + 1, courseId, proffId, comment, Grade.A);
		performanceRecord3 = new PerformanceRecord(id, courseId + 1, proffId, comment, Grade.A);
		performanceRecord4 = new PerformanceRecord(id, courseId, proffId + 1, comment, Grade.A);
		performanceRecord5 = new PerformanceRecord(id, courseId, proffId, "notcomment", Grade.A);
		performanceRecord6 = new PerformanceRecord(id, courseId, proffId, comment, Grade.B);

		performanceRecord1other = new PerformanceRecord(id, courseId, proffId, comment2, Grade.A);
		assertTrue(student1.getName() != student2other.getName());
		assertTrue(student1.getName().equals(student2other.getName()));

		assertTrue(student1.getPhoneNumber() != student3other.getPhoneNumber());
		assertTrue(student1.getPhoneNumber().equals(student3other.getPhoneNumber()));

		assertTrue(student1.getAddress() != student4other.getAddress());
		assertTrue(student1.getAddress().equals(student4other.getAddress()));
		
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testStudentEqualSelf() {
		assertTrue(student1.equals(student1));
		assertTrue(student2.equals(student2));
		assertTrue(student3.equals(student3));
		assertTrue(student4.equals(student4));
	}

	@Test
	public void testStudentEqualToCopy() {
		assertTrue(student1.equals(student1other));
		assertTrue(student2.equals(student2other));
		assertTrue(student3.equals(student3other));
		assertTrue(student4.equals(student4other));
	}

	@Test
	public void testStudentNotEqual() {
		assertTrue(student1.notEquals(student2));
		assertTrue(student1.notEquals(student3));
		assertTrue(student1.notEquals(student4));
		assertTrue(student2.notEquals(student3));
		assertTrue(student2.notEquals(student4));
		assertTrue(student3.notEquals(student4));
	}

	@Test
	public void testInstructorEqualSelf() {
		assertTrue(professor1.equals(professor1));
		assertTrue(professor2.equals(professor2));
		assertTrue(professor3.equals(professor3));
		assertTrue(professor4.equals(professor4));
	}
	@Test
	public void testInstructorEqualToCopy() {
		assertTrue(professor1.equals(professor1other));
		assertTrue(professor2.equals(professor2other));
		assertTrue(professor3.equals(professor3other));
		assertTrue(professor4.equals(professor4other));
	}
	@Test
	public void testInstructorNotEqual() {
		assertTrue(professor1.notEquals(professor2));
		assertTrue(professor1.notEquals(professor3));
		assertTrue(professor1.notEquals(professor4));
		assertTrue(professor2.notEquals(professor3));
		assertTrue(professor2.notEquals(professor4));
		assertTrue(professor3.notEquals(professor4));
	}


	@Test
	public void testCourseEqualSelf() {
		assertTrue(course1.equals(course1));
		assertTrue(course2.equals(course2));
		assertTrue(course3.equals(course3));
		assertTrue(course4.equals(course4));
	}

	@Test
	public void testCourseEqualToCopy() {
		assertTrue(course1.equals(course1other));
		assertTrue(course2.equals(course2other));
		assertTrue(course3.equals(course3other));
		assertTrue(course4.equals(course4other));
	}

	@Test
	public void testCourseNotEqual() {
		assertTrue(course1.notEquals(course2));
		assertTrue(course1.notEquals(course3));
		assertTrue(course1.notEquals(course4));
		assertTrue(course2.notEquals(course3));
		assertTrue(course2.notEquals(course4));
		assertTrue(course3.notEquals(course4));
	}

	@Test
	public void testPerformanceRecordEqualSelf() {
		assertTrue(performanceRecord1.equals(performanceRecord1));
		assertTrue(performanceRecord2.equals(performanceRecord2));
		assertTrue(performanceRecord3.equals(performanceRecord3));
		assertTrue(performanceRecord4.equals(performanceRecord4));
		assertTrue(performanceRecord5.equals(performanceRecord5));
		assertTrue(performanceRecord6.equals(performanceRecord6));
	}

	@Test
	public void testPerformanceRecordEqualtoCopy() {
		assertTrue(performanceRecord1.equals(performanceRecord1other));
	}

	@Test
	public void testPerformanceRecordNotEqual() {
		assertTrue(performanceRecord1.notEquals(performanceRecord2));
		assertTrue(performanceRecord1.notEquals(performanceRecord3));
		assertTrue(performanceRecord1.notEquals(performanceRecord4));
		assertTrue(performanceRecord1.notEquals(performanceRecord5));
		assertTrue(performanceRecord1.notEquals(performanceRecord6));
		assertTrue(performanceRecord2.notEquals(performanceRecord3));
		assertTrue(performanceRecord2.notEquals(performanceRecord4));
		assertTrue(performanceRecord2.notEquals(performanceRecord5));
		assertTrue(performanceRecord2.notEquals(performanceRecord6));
		assertTrue(performanceRecord3.notEquals(performanceRecord4));
		assertTrue(performanceRecord3.notEquals(performanceRecord5));
		assertTrue(performanceRecord3.notEquals(performanceRecord6));
		assertTrue(performanceRecord4.notEquals(performanceRecord5));
		assertTrue(performanceRecord4.notEquals(performanceRecord6));
		assertTrue(performanceRecord5.notEquals(performanceRecord6));
	}
}
