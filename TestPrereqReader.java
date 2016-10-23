import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class TestPrereqReader {

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testReadingALine() {
		String[] line = {"2","3"};
		Prereq prereq = PrereqReader.readLine(line);
		assertTrue(prereq.getPrereqID() == 2);
		assertTrue(prereq.getCourseID() == 3);
	}

	@Test
	public void testReadingAFile() {
		PrereqReader prereqReader = new PrereqReader("bin/CSV/prereqs.csv");
		java.util.List<Prereq> prereqsFromRead = prereqReader.read();
		java.util.List<Prereq> prereqsCorrect = new java.util.ArrayList<Prereq>();


		prereqsCorrect.add(new Prereq(2,10));
		prereqsCorrect.add(new Prereq(4,17));
		prereqsCorrect.add(new Prereq(2,20));
		prereqsCorrect.add(new Prereq(13,25));
		prereqsCorrect.add(new Prereq(4,10));
		prereqsCorrect.add(new Prereq(4,19));
		prereqsCorrect.add(new Prereq(8,10));
		prereqsCorrect.add(new Prereq(4,23));
		prereqsCorrect.add(new Prereq(10,19));
		prereqsCorrect.add(new Prereq(8,29));
		prereqsCorrect.add(new Prereq(4,28));

		assertTrue(prereqsFromRead.size() == prereqsCorrect.size());
		for (Integer i = 0; i < prereqsFromRead.size(); i+=1) {
			System.out.println(i);
			assertTrue(prereqsFromRead.get(i).getCourseID().equals(prereqsCorrect.get(i).getCourseID()));
			assertTrue(prereqsFromRead.get(i).getPrereqID().equals(prereqsCorrect.get(i).getPrereqID()));
		}
	}

}
