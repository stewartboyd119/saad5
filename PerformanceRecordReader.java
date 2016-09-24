import java.util.ArrayList;
import java.util.List;

public class PerformanceRecordReader extends GeneralReader{

	static Integer studentIDIndex = 0;
	static Integer courseIDIndex = 1;
	static Integer instructorIDIndex = 2;
	static Integer commentIndex = 3;
	static Integer gradeIndex = 4;

	PerformanceRecordReader(String csvPath) {
		super(csvPath);
	}
	public List<PerformanceRecord> read() {
		CsvReader csvReader = new CsvReader(this.getCsvPath());
		List<PerformanceRecord> records= new ArrayList<PerformanceRecord>();
		for (String[] line : csvReader) {
			records.add(readLine(line));
		}
		return records;
	}

	static public PerformanceRecord readLine(String[] line) {
		Integer studentID = Integer.parseInt(line[studentIDIndex].trim());
		Integer courseID = Integer.parseInt(line[courseIDIndex].trim());
		Integer instructorID = Integer.parseInt(line[instructorIDIndex].trim());
		String comment = line[commentIndex].trim();
		Grade grade = Grade.gradeFromString(line[gradeIndex].trim());
		return new PerformanceRecord(studentID, courseID, instructorID, comment, grade);		
	}
}
