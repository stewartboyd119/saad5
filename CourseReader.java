import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CourseReader extends GeneralReader {

	static Integer courseIDIndex = 0;
	static Integer courseNameIndex = 1;
	static Integer semester1Index = 2;
	static Integer semester2Index = 3;
	static Integer semester3Index = 4;

	CourseReader(String csvPath) {
		super(csvPath);
	}

	public List<Course> read() {
		CsvReader csvReader = new CsvReader(this.getCsvPath());
		List<Course> courses= new ArrayList<Course>();
		for (String[] line : csvReader) {
			Course course = CourseReader.readLine(line);
			courses.add(course);
		}
		return courses;
	}

	public static Course readLine(String[] line) {
		Boolean isAvailableFall = false;
		Boolean isAvailableSpring = false;
		Boolean isAvailableSummer = false;
		Integer id = Integer.parseInt(line[CourseReader.courseIDIndex].trim());
		String title = line[CourseReader.courseNameIndex].trim();

		for (String semesterString : Arrays.copyOfRange(line, semester1Index, line.length)) {

			Semester semester = Semester.semesterFromString(semesterString);

			switch (semester) {
			case Fall: 
				isAvailableFall = true;
				break;
			case Spring:
				isAvailableSpring = true;
				break;
			case Summer:
				isAvailableSummer = true;
			}
		}
		
		return new Course(id, title, isAvailableFall, isAvailableSpring, isAvailableSummer);		
	}
}
