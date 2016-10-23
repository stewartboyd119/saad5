import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
public class AssignmentReader extends GeneralReader{



	static Integer instructorIDIndex = 0;
	static Integer courseIDIndex = 1;
	static Integer numberOfSeatsIndex = 2;


	AssignmentReader(String csvPath) {
		super(csvPath);
	}

	public List<Assignment> read() {
		CsvReader assignmentReader = new CsvReader(this.getCsvPath());
		List<Assignment> assignments= new ArrayList<Assignment>();
		for (String[] line : assignmentReader) {
			Assignment assignment = AssignmentReader.readLine(line);
			assignments.add(assignment);
		}
		return assignments;
	}

	public static Assignment readLine(String[] line) {

		Integer instructorID = Integer.parseInt(line[AssignmentReader.instructorIDIndex].trim());
		Integer courseID = Integer.parseInt(line[AssignmentReader.courseIDIndex].trim());
		Integer numberOfSeats = Integer.parseInt(line[AssignmentReader.numberOfSeatsIndex].trim());

		return new Assignment(instructorID, courseID, numberOfSeats);		
	}

}
