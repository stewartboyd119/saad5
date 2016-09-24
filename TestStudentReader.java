import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class TestStudentReader {

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testReadingALine() {
		String[] line = {"9","GARY ALLEN","128 Pine Street 83866","8304231126"};
		Student student = StudentReader.readLine(line);
		org.junit.Assert.assertTrue(student.getUuid() == 9);
		assertEquals(student.getName(), "GARY ALLEN");
		assertEquals(student.getAddress(), "128 Pine Street 83866");
		assertEquals(student.getPhoneNumber(), "8304231126");
	}

	@Test
	public void testReadingAFile() {
		StudentReader studentReader = new StudentReader("students.csv");
		java.util.List<Student> studentsFromRead = studentReader.read();
		java.util.List<Student> studentsCorrect = new java.util.ArrayList<Student>();
		studentsCorrect.add(new Student(9,"GARY ALLEN","128 Pine Street 83866","8304231126"));
		studentsCorrect.add(new Student(12,"JULIE TURNER","927 6th Avenue 78553","2587799053"));
		studentsCorrect.add(new Student(14,"RENEE CARNEY","840 Main Street West 28729","8118091235"));
		studentsCorrect.add(new Student(15,"JAMES FISHER","231 Windsor Court 12288","4477500021"));
		studentsCorrect.add(new Student(16,"TRACEY WHITE","387 Canterbury Drive 49531","4952312905"));
		studentsCorrect.add(new Student(17,"CAROL TAYLOR","215 4th Avenue 27517","516479061"));
		studentsCorrect.add(new Student(20,"LILLIE LEWIS","373 Magnolia Court 55751","566944369"));
		studentsCorrect.add(new Student(21,"JEFFREY CLAYTON","600 Bridle Lane 70941","6222277693"));
		studentsCorrect.add(new Student(22,"SUE VELASQUEZ","204 Riverside Drive 72894","7543928902"));
		studentsCorrect.add(new Student(24,"DWIGHT WILCOX","981 Laurel Street 49148","7571682264"));
		assertEquals(studentsFromRead, studentsCorrect);
	}

}
