import java.util.ArrayList;
import java.util.List;

public class Administrator {
	String studentsFpath = "students.csv";
	String instructorsFpath = "instructors.csv";
	String recordsFpath = "records.csv";
	String coursesFpath = "courses.csv";

	List<Student> students;
	List<Instructor> instructors;
	List<PerformanceRecord> performanceRecords;
	List<Course> courses;

	public void readAllData() {
		readStudents();
		readInstructors();
		readPerformanceRecords();
		readCourses();
	}

	public void readStudents() {
		StudentReader studentReader = new StudentReader(studentsFpath);
		students = studentReader.read();
	}

	public void readInstructors() {
		InstructorReader instructorReader = new InstructorReader(instructorsFpath);
		instructors = instructorReader.read();		
	}

	public void readPerformanceRecords() {
		PerformanceRecordReader performanceRecordReader = new PerformanceRecordReader(recordsFpath);
		performanceRecords = performanceRecordReader.read();
	}

	public void readCourses() {
		CourseReader courseReader = new CourseReader(coursesFpath);
		courses = courseReader.read();
	}

	public void clearAllData() {
		students = new ArrayList<Student>();
		instructors = new ArrayList<Instructor>();
		performanceRecords = new ArrayList<PerformanceRecord>();
		courses = new ArrayList<Course>();
	}
}
