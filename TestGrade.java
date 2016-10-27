import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

public class TestGrade {

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Rule
	public final ExpectedException exception = ExpectedException.none();

	@Test
	public void testA() {
		Grade a = Grade.A;
		assertTrue(a.isEqualToString("a"));
		assertTrue(a.isEqualToString("   a "));
		assertTrue(a.isEqualToString("a"));
	}

	@Test
	public void testB() {
		Grade grade = Grade.B;
		assertTrue(grade.isEqualToString("b"));
		assertTrue(grade.isEqualToString("   b "));
		assertTrue(grade.isEqualToString("b "));
	}

	@Test
	public void testC() {
		Grade grade = Grade.C;
		assertTrue(grade.isEqualToString("c"));
		assertTrue(grade.isEqualToString("   c "));
		assertTrue(grade.isEqualToString("c"));
	}
	@Test
	public void testaFromString() {

		assertEquals(Grade.A, Grade.gradeFromString("a"));
		assertEquals(Grade.A, Grade.gradeFromString("   a"));
		assertEquals(Grade.A, Grade.gradeFromString(" a  "));
	}

	@Test
	public void testbFromString() {

		assertEquals(Grade.B, Grade.gradeFromString("b"));
		assertEquals(Grade.B, Grade.gradeFromString("   b"));
		assertEquals(Grade.B, Grade.gradeFromString(" b  "));
	}

	@Test
	public void testcFromString() {

		assertEquals(Grade.C, Grade.gradeFromString("c"));
		assertEquals(Grade.C, Grade.gradeFromString("   c"));
		assertEquals(Grade.C, Grade.gradeFromString(" c  "));
	}

	@Test
	public void testdFromString() {

		assertEquals(Grade.D, Grade.gradeFromString("d"));
		assertEquals(Grade.D, Grade.gradeFromString("   d"));
		assertEquals(Grade.D, Grade.gradeFromString(" d  "));
	}

	@Test
	public void testfFromString() {

		assertEquals(Grade.F, Grade.gradeFromString("f"));
		assertEquals(Grade.F, Grade.gradeFromString("   f"));
		assertEquals(Grade.F, Grade.gradeFromString(" f  "));
	}

	@Test
	public void testFailFromString() {
		exception.expect(IllegalArgumentException.class);
		Grade willFail = Grade.gradeFromString("dog");
	}

	@Test
	public void testComparison() {
		assertTrue(Grade.A.isHigher(Grade.B));
		assertFalse(Grade.B.isHigher(Grade.B));
		assertFalse(Grade.C.isHigher(Grade.B));
	}

	@Test
	public void testFIsFailingGrade() {
		assertTrue(Grade.F.isFailing());
	}

	@Test
	public void testFIsNotPassingGrade() {
		assertFalse(Grade.F.isPassing());
	}


	@Test
	public void testABCDIsPassingGrade() {
		assertTrue(Grade.A.isPassing());
		assertTrue(Grade.B.isPassing());
		assertTrue(Grade.C.isPassing());
		assertTrue(Grade.D.isPassing());
	}
}
