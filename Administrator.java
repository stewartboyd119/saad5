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


	public Integer studentsInClasses() {
		Integer count = 0;
		for (Student student : students) {
			for (PerformanceRecord record : performanceRecords) {
				if (student.getUuid().equals(record.getStudentID())) {
					count += 1;
					break;
				}
			}
		}
		return count;
	}

	public Integer studentsWithoutClasses() {
		return students.size() - studentsInClasses();
	}

	public Integer instructorsWithClasses() {
		Integer count = 0;
		for (Instructor instructor : instructors) {
			for (PerformanceRecord record : performanceRecords) {
				if (instructor.getUuid().equals(record.getInstructorID())) {
					count += 1;
					break;
				}
			}
		}
		return count;	
	}

	public Integer instructorsWithoutClasses() {
		return instructors.size() - instructorsWithClasses();
	}

	public Integer coursesWithStudents() {
		Integer count = 0;
		//java.util.Set<Integer> uniqueStudentIdsFromRecords= new java.util.HashSet<Integer>();
		//for(PerformanceRecord record : performanceRecords) {
		//	uniqueStudentIdsFromRecords.add(record.getStudentID());
		//}
		for (Course course : courses) {
			for (PerformanceRecord record : performanceRecords) {
				if (course.getID().equals(record.getCourseID())) {
					for (Student student : students) {
						if (student.getUuid().equals(record.getStudentID())) {
							count += 1;
							break;
						}
					}
					break;
				}
			}
		}
		return count;	
	}

	public Integer coursesWithoutStudents() {
		return courses.size() - coursesWithStudents();
	}

	public Integer coursesInSemester(Semester semester) {
		Integer count = 0;
		for (Course course : courses) {
			if (course.isAvailable(semester)) {
				count += 1;
			}
		}
		return count;
	}
	public Integer[] queryResults() {

		Integer[] output = new Integer[10];
		readAllData();
		output[0] = performanceRecords.size();
		output[1] = students.size();
		output[2] = studentsWithoutClasses();
		output[3] = instructors.size();
		output[4] = instructorsWithoutClasses();
		output[5] = courses.size();
		output[6] = coursesWithoutStudents();
		output[7] = coursesInSemester(Semester.Fall);
		output[8] = coursesInSemester(Semester.Spring);
		output[9] = coursesInSemester(Semester.Summer);
		return output;
	}

	public void printQueryResults() {
		Integer[] output = queryResults();
		for (Integer elem : output) {
			System.out.println(elem);
		}
	}
}
