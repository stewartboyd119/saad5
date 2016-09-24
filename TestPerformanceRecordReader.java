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
		assertTrue(performanceRecord.getStudentID() == 15);
		assertTrue(performanceRecord.getCourseID() == 24);
		assertTrue(performanceRecord.getInstructorID() == 3);
		assertEquals(performanceRecord.getComment(), "consistently makes good choices in all parts of the school day");
		assertEquals(performanceRecord.getGrade(), Grade.A);
	}

	@Test
	public void testReadingAFile() {
		PerformanceRecordReader performanceRecordReader = new PerformanceRecordReader("records.csv");
		java.util.List<PerformanceRecord> instructorsFromRead = performanceRecordReader.read();
		java.util.List<PerformanceRecord> performanceRecords = new java.util.ArrayList<PerformanceRecord>();

		performanceRecords.add(new PerformanceRecord(15,24,3,"consistently makes good choices in all parts of the school day",Grade.A));
		performanceRecords.add(new PerformanceRecord(9,28,3,"arrives at school each day with a smile and ready to learn",Grade.A));
		performanceRecords.add(new PerformanceRecord(22,6,3,"uses strategies such as making connections and asking questions to aid inferencing and comprehension",Grade.D));
		performanceRecords.add(new PerformanceRecord(22,4,4,"understands place value and uses it to round numbers",Grade.F));
		performanceRecords.add(new PerformanceRecord(14,29,3,"produces writing that has been a joy to read over the past few weeks",Grade.C));
		performanceRecords.add(new PerformanceRecord(16,8,3,"completes work with quality in mind",Grade.D));

		assertTrue(instructorsFromRead.size() == performanceRecords.size());
		for (Integer i = 0; i < instructorsFromRead.size(); i+=1) {
			assertTrue(instructorsFromRead.get(i).equals(performanceRecords.get(i)));
		}
	}

}
