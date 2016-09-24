import java.util.List;

public class Administrator {
	String studentsFpath = "students.csv";
	String instructorsFpath = "instructors.csv";
	String recordsFpath = "records.csv";
	String coursesFpath = "courses.csv";

	public void readData() {
		StudentReader studentReader = new StudentReader(studentsFpath);
		List<Student> students = studentReader.read();
		InstructorReader instructorReader = new InstructorReader(instructorsFpath);
		List<Instructor> instructors = instructorReader.read();
		PerformanceRecordReader performanceRecordReader = new PerformanceRecordReader(recordsFpath);
		List<PerformanceRecord> performanceRecords = performanceRecordReader.read();
		CourseReader courseReader = new CourseReader(coursesFpath);
		List<Course> courses = courseReader.read();
	}
}
