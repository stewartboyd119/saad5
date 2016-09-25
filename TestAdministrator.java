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
	public void testCase0() {
		administrator.studentsFpath = "test_case_0/students.csv";
		administrator.instructorsFpath = "test_case_0/instructors.csv";
		administrator.recordsFpath = "test_case_0/records.csv";
		administrator.coursesFpath = "test_case_0/courses.csv";

		Integer[] output = administrator.queryResults();
		Integer[] outputShouldBe = {6, 10, 5, 5, 3, 15, 9, 5, 12, 6};
		//for (Integer elem : output) {
		//	System.out.println(elem);
		//}
		assertTrue(Arrays.equals(outputShouldBe, output));
	}

	@Test
	public void testCase1() {
		administrator.studentsFpath = "test_case_1/students.csv";
		administrator.instructorsFpath = "test_case_1/instructors.csv";
		administrator.recordsFpath = "test_case_1/records.csv";
		administrator.coursesFpath = "test_case_1/courses.csv";

		Integer[] output = administrator.queryResults();
		Integer[] outputShouldBe = {6, 10, 4, 5, 2, 15, 10, 8, 7, 6};
		assertTrue(Arrays.equals(outputShouldBe, output));
	}
	@Test
	public void testCase2() {
		administrator.studentsFpath = "test_case_2/students.csv";
		administrator.instructorsFpath = "test_case_2/instructors.csv";
		administrator.recordsFpath = "test_case_2/records.csv";
		administrator.coursesFpath = "test_case_2/courses.csv";

		Integer[] output = administrator.queryResults();
		Integer[] outputShouldBe = {6, 10, 6, 5, 1, 15, 9, 7, 11, 4};
		assertTrue(Arrays.equals(outputShouldBe, output));
	}
	@Test
	public void testCase3() {
		administrator.studentsFpath = "test_case_3/students.csv";
		administrator.instructorsFpath = "test_case_3/instructors.csv";
		administrator.recordsFpath = "test_case_3/records.csv";
		administrator.coursesFpath = "test_case_3/courses.csv";

		Integer[] output = administrator.queryResults();
		Integer[] outputShouldBe = {6, 10, 6, 5, 2, 15, 12, 6, 12, 5};
		assertTrue(Arrays.equals(outputShouldBe, output));
	}

	@Test
	public void testCase4() {
		administrator.studentsFpath = "test_case_4/students.csv";
		administrator.instructorsFpath = "test_case_4/instructors.csv";
		administrator.recordsFpath = "test_case_4/records.csv";
		administrator.coursesFpath = "test_case_4/courses.csv";

		Integer[] output = administrator.queryResults();
		Integer[] outputShouldBe = {50, 100, 66, 40, 14, 30, 7, 12, 19, 11};
		assertTrue(Arrays.equals(outputShouldBe, output));
	}
	@Test
	public void testCase5() {
		administrator.studentsFpath = "test_case_5/students.csv";
		administrator.instructorsFpath = "test_case_5/instructors.csv";
		administrator.recordsFpath = "test_case_5/records.csv";
		administrator.coursesFpath = "test_case_5/courses.csv";

		Integer[] output = administrator.queryResults();
		Integer[] outputShouldBe = {100, 200, 125, 50, 9, 53, 6, 30, 36, 23};

		assertTrue(Arrays.equals(outputShouldBe, output));
	}

}
