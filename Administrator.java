import java.util.ArrayList;
import java.util.List;

public class Administrator {
	String studentsFpath = "students.csv";
	String instructorsFpath = "instructors.csv";
	String recordsFpath = "records.csv";
	String coursesFpath = "courses.csv";
	String assignmentsFpath = "assignments.csv";
	String requestsFpath = "requests.csv";
	String prereqsFpath = "prereqs.csv";

	private List<Student> students;
	private List<Instructor> instructors;
	private List<PerformanceRecord> performanceRecords;
	//List<Course> courses;
	private CourseCatalogue courseCatalogue;
	private List<Assignment> assignments = new ArrayList<Assignment>();
	private List<Request> requests = new ArrayList<Request>();
	private List<Prereq> prereqs = new ArrayList<Prereq>();

	public void readAllData() {
		readStudents();
		readInstructors();
		readPerformanceRecords();
		readCourses();
		readAssignments();
		readRequests();
		readPrereqs();
	}

	public void updateCourseWithPrereqs() {
		
	}

	public Instructor getInstructorByID(Integer id) throws IDNotFound {
		for (Instructor instructor : instructors) {
			if (instructor.getUuid().equals(id)) {
				return instructor;
			}
		}
		throw new IDNotFound();		
	}

	public Student getStudentByID(Integer id) throws IDNotFound {
		for (Student student: students) {
			if (student.getUuid().equals(id)) {
				return student;
			}
		}
		throw new IDNotFound();
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
		List<Course> courses = courseReader.read();
		courseCatalogue = new CourseCatalogue(courses);
	}

	public void readAssignments() {
		AssignmentReader assignmentReader = new AssignmentReader(this.assignmentsFpath);
		assignments = assignmentReader.read();
	}

	public void readPrereqs() {
		PrereqReader prereqsReader = new PrereqReader(this.prereqsFpath);
		prereqs = prereqsReader.read();
	}

	public void readRequests() {
		RequestReader requestReader = new RequestReader(this.requestsFpath);
		requests = requestReader.read();
	}

	public void clearAllData() {
		students = new ArrayList<Student>();
		instructors = new ArrayList<Instructor>();
		performanceRecords = new ArrayList<PerformanceRecord>();
		courseCatalogue.clearCourses();
		//courses = new ArrayList<Course>();
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
		for (Course course : courseCatalogue) {
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
		return courseCatalogue.numberOfCourses() - coursesWithStudents();
	}

	public Integer coursesInSemester(Semester semester) {
		Integer count = 0;
		for (Course course : courseCatalogue) {
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
		output[5] = courseCatalogue.numberOfCourses();
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

	public static void main(String[] args) {
		Administrator administrator = new Administrator();
		administrator.printQueryResults();
	}

	public List<Student> getStudents() {
		return students;
	}

	public List<Instructor> getInstructors() {
		return instructors;
	}

	public List<PerformanceRecord> getPerformanceRecords() {
		return performanceRecords;
	}

	public CourseCatalogue getCourseCatalogue() {
		return courseCatalogue;
	}

	
	public List<Assignment> getAssignments() {
		return assignments;
	}

	public List<Request> getRequests() {
		return requests;
	}

	public List<Prereq> getPrereqs() {
		return prereqs;
	}

}
