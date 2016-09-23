import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

public class TestSemester {

	@Rule
	public final ExpectedException exception = ExpectedException.none();

	@Test
	public void testFall() {
		Semester fall = Semester.Fall;
		assertTrue(fall.isEqualToString("fall"));
		assertTrue(fall.isEqualToString("   fall "));
		assertTrue(fall.isEqualToString("Fall"));
	}

	@Test
	public void testSpring() {
		Semester semester = Semester.Spring;
		assertTrue(semester.isEqualToString("Spring"));
		assertTrue(semester.isEqualToString("   Spring "));
		assertTrue(semester.isEqualToString("spring "));
	}

	@Test
	public void testSummer() {
		Semester semester = Semester.Summer;
		assertTrue(semester.isEqualToString("Summer"));
		assertTrue(semester.isEqualToString("   summer "));
		assertTrue(semester.isEqualToString("Summer"));
	}
	@Test
	public void testFallFromString() {

		assertEquals(Semester.Fall, Semester.semesterFromString("fall"));
		assertEquals(Semester.Fall, Semester.semesterFromString("   fall"));
		assertEquals(Semester.Fall, Semester.semesterFromString(" Fall  "));
	}

	@Test
	public void testSpringFromString() {

		assertEquals(Semester.Spring, Semester.semesterFromString("Spring"));
		assertEquals(Semester.Spring, Semester.semesterFromString("   spring"));
		assertEquals(Semester.Spring, Semester.semesterFromString(" Spring  "));
	}

	@Test
	public void testSummerFromString() {

		assertEquals(Semester.Summer, Semester.semesterFromString("summer"));
		assertEquals(Semester.Summer, Semester.semesterFromString("   summer"));
		assertEquals(Semester.Summer, Semester.semesterFromString(" Summer  "));
	}

	@Test
	public void testFailFromString() {
		exception.expect(IllegalArgumentException.class);
		Semester willFail = Semester.semesterFromString("dog");
	}

}
