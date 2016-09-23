import static org.junit.Assert.*;

import java.io.File;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.Paths;

import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class TestCsvReader {

	@Test
	public void testCsvReader() {
		URL resource = CsvReader.class.getResource("test_case_0/courses.csv");
		File newFile = null;
		String[][] courseIDs = {{"2","Computer programming","Spring"},
								{"4","Data structures","Spring"},
								{"6","Software engineering","Fall","Spring"},
								{"8","Computer architecture","Fall","Spring"},
								{"10","Operating systems","Summer"},
								{"13","Machine learning"},
								{"16","Computer security","Spring","Summer"},
								{"17","Relational databases","Spring"},
								{"19","Structured Storage","Fall","Summer"},
								{"20","Programming language pragmatics","Spring"},
								{"23","Algorithm design","Fall","Spring"},
								{"24","Web designing","Spring","Summer"},
								{"25","Artificial intelligence","Spring","Summer"},
								{"28","Computer graphics","Spring","Summer"},
								{"29","Parallel computing","Fall","Spring"}};

		newFile = openFile(resource);
		CsvReader csvReader = new CsvReader(newFile.getAbsolutePath());
		int rindex = 0;
		for (String[] line : csvReader) {
			int cindex = 0;
			for (String item : line) {
				assertEquals(courseIDs[rindex][cindex], item);
				cindex += 1;
			}
			rindex += 1;
		}
	}

	@Test
	public void testCsvReaderBadFilepath() {
		//When a bad filepath is given null is returned
		URL resource = CsvReader.class.getResource("test_case_0/fake.csv");
		org.junit.Assert.assertNull(resource);
	}

	@Test
	public void testEmptyCSV() {
		URL resource = CsvReader.class.getResource("empty.csv");
		//Stewart confirms that the filepath exists
		org.junit.Assert.assertNotNull(resource);
		File newFile = openFile(resource);
		CsvReader csvReader = new CsvReader(newFile.getAbsolutePath());
		int count = 0;
		for (String[] row : csvReader) {
			count += 1;
		}
		//This is an empty file and shouldn't iterate
		assertEquals(count, 0);
	}

	public File openFile(URL resource) {
		File newFile = null;
		try {
			newFile = Paths.get(resource.toURI()).toFile();
		} catch (URISyntaxException e) {
			//on failure raise error
			assertEquals(0, 1);
		}
		return newFile;
	}

	@Test
	public void testOpen() {
		//fail("Not yet implemented");
	}

	@Test
	public void testClose() {
		fail("Not yet implemented");
	}

	@Test
	public void testIterator() {
		fail("Not yet implemented");
	}

	@Test
	public void testMain() {
		fail("Not yet implemented");
	}

}
