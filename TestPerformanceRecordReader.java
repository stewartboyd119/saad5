import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class TestPerformanceRecordReader {

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void test() {
		String[] line = {"15","24","3","consistently makes good choices in all parts of the school day","A"};
		PerformanceRecord performanceRecord = PerformanceRecordReader.readLine(line);
		assertEquals(performanceRecord.getStudentID(), "15");
		assertEquals(performanceRecord.getCourseID(), "24");
		assertEquals(performanceRecord.getInstructorID(), "3");
		assertEquals(performanceRecord.getComment(), "consistently makes good choices in all parts of the school day");
		assertEquals(performanceRecord.getGrade(), Grade.A);
	}

}
