import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PrereqReader extends GeneralReader{
	static Integer prereqIDIndex = 0;
	static Integer courseIDIndex = 1;

	PrereqReader(String csvPath) {
		super(csvPath);
	}

	public List<Prereq> read() {
		CsvReader assignmentReader = new CsvReader(this.getCsvPath());
		List<Prereq> prereqs= new ArrayList<Prereq>();
		for (String[] line : assignmentReader) {
			Prereq prereq = PrereqReader.readLine(line);
			prereqs.add(prereq);
		}
		return prereqs;
	}

	public static Prereq readLine(String[] line) {

		Integer prereqID = Integer.parseInt(line[PrereqReader.prereqIDIndex].trim());
		Integer courseID = Integer.parseInt(line[PrereqReader.courseIDIndex].trim());

		return new Prereq(prereqID, courseID);		
	}
}
