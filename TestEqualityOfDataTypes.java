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

	Instructor professor1;
	Instructor professor2;
	Instructor professor3;
	Instructor professor4;

	Instructor professor1other;

	Course course1;
	Course course2;
	Course course3;
	Course course4;
	Course course5;
	Course course6;

	Course course1other;

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
		String nameCopy = new String(name);
		String name2 = "other_name";
		String number = "7137755439";
		String numberCopy = new String(number);
		String number2 = "other7137755439";
		String address = "address";
		String addressCopy = new String("address");
		String address2 = "other_Address";
		String description = "description";
		String descriptionCopy = new String(description);
		String description2 = "other_description";
		String comment = "comment";
		String commentCopy = new String(comment);
		String comment2 = "other_comment";
		Integer id = 1111;
		Integer idCopy = new Integer(id);
		Integer id2 = 2;
		Integer courseId = 2;
		Integer proffId = 3;
		student1 = new Student(id, name, address,number);
		student2 = new Student(id, name2, address,number);
		student3 = new Student(id, name, address2,number);
		student4 = new Student(id2, name, address, number);

		student1other = new Student(idCopy, nameCopy, addressCopy,numberCopy);

		professor1 = new Instructor(id, name, address,number);
		professor2 = new Instructor(id, name2, address,number);
		professor3 = new Instructor(id, name, address2,number);
		professor4 = new Instructor(id2, name, address, number);

		professor1other = new Instructor(idCopy, nameCopy, addressCopy,numberCopy);

		course1 = new Course(id, name, true, true, true);
		course2 = new Course(id2, name, true, true, true);
		course3 = new Course(id, name, false, true, true);
		course4 = new Course(id, name, true, false, true);
		course5 = new Course(id, name, true, true, false);
		course6 = new Course(id, name2, true, true, true);

		course1other = new Course(idCopy, nameCopy, true, true, true);

		performanceRecord1 = new PerformanceRecord(id, courseId, proffId, comment, Grade.A);
		performanceRecord2 = new PerformanceRecord(id + 1, courseId, proffId, comment, Grade.A);
		performanceRecord3 = new PerformanceRecord(id, courseId + 1, proffId, comment, Grade.A);
		performanceRecord4 = new PerformanceRecord(id, courseId, proffId + 1, comment, Grade.A);
		performanceRecord5 = new PerformanceRecord(id, courseId, proffId, "notcomment", Grade.A);
		performanceRecord6 = new PerformanceRecord(id, courseId, proffId, comment, Grade.B);

		performanceRecord1other = new PerformanceRecord(idCopy, courseId, proffId, commentCopy, Grade.A);
		org.junit.Assert.assertNotEquals(name, name2);
		org.junit.Assert.assertNotEquals(number, number2);
		org.junit.Assert.assertNotEquals(address, address2);
		org.junit.Assert.assertNotEquals(description, description2);
		org.junit.Assert.assertNotEquals(comment, comment2);
		org.junit.Assert.assertTrue(id != id2);
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
