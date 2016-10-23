import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class TestRequestReader {

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testReadingALine() {
		String[] line = {"2","3"};
		Request request = RequestReader.readLine(line);
		assertTrue(request.getStudentID() == 2);
		assertTrue(request.getCourseID() == 3);
	}

	@Test
	public void testReadingAFile() {
		RequestReader requestReader = new RequestReader("bin/CSV/requests.csv");
		java.util.List<Request> requestsFromRead = requestReader.read();
		java.util.List<Request> requestsCorrect = new java.util.ArrayList<Request>();

		requestsCorrect.add(new Request(9,13));
		requestsCorrect.add(new Request(16,29));
		requestsCorrect.add(new Request(15,29));
		requestsCorrect.add(new Request(20,13));
		requestsCorrect.add(new Request(22,4));
		requestsCorrect.add(new Request(21,13));


		assertTrue(requestsFromRead.size() == requestsCorrect.size());
		for (Integer i = 0; i < requestsFromRead.size(); i+=1) {
			System.out.println(i);
			
			assertTrue(requestsFromRead.get(i).getCourseID().equals(requestsCorrect.get(i).getCourseID()));
			assertTrue(requestsFromRead.get(i).getStudentID().equals(requestsCorrect.get(i).getStudentID()));
		}
	}

}
