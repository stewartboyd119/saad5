import java.util.ArrayList;
import java.util.List;

public class PerformanceRecordReader extends GeneralReader{

	Integer studentIDIndex = 0;
	Integer courseIDIndex = 1;
	Integer instructorIDIndex = 2;
	Integer commentIndex = 3;
	Integer gradeIndex = 4;

	PerformanceRecordReader(String csvPath) {
		super(csvPath);
	}
	public List<PerformanceRecord> read() {
		CsvReader csvReader = new CsvReader(this.getCsvPath());
		List<PerformanceRecord> records= new ArrayList<PerformanceRecord>();
		for (String[] line : csvReader) {
			Integer studentID = Integer.parseInt(line[studentIDIndex].trim());
			Integer courseID = Integer.parseInt(line[courseIDIndex].trim());
			Integer instructorID = Integer.parseInt(line[instructorIDIndex].trim());
			String comment = line[commentIndex].trim();
			Grade grade = Grade.gradeFromString(line[gradeIndex].trim());
			records.add(new PerformanceRecord(studentID, courseID, instructorID, comment, grade));
		}
		return records;
	}
}
