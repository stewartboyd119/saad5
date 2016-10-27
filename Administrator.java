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

	private List<Student> students = new ArrayList<Student>();
	private List<Instructor> instructors = new ArrayList<Instructor>();
	private List<PerformanceRecord> performanceRecords = new ArrayList<PerformanceRecord>() ;
	//List<Course> courses;
	private CourseCatalogue courseCatalogue = new CourseCatalogue();
	private List<Assignment> assignments = new ArrayList<Assignment>();
	private List<CourseInstance> courseInstances = new ArrayList<CourseInstance>();
	private List<Request> requests = new ArrayList<Request>();
	private List<Prereq> prereqs = new ArrayList<Prereq>();
	private List<Request> validRequests = new ArrayList<Request>();
	private List<Request> deniedRequestsNoPrereq = new ArrayList<Request>();
	private List<Request> deniedRequestsAlreadyTaken = new ArrayList<Request>();
	private List<Request> deniedRequestsNoSeats = new ArrayList<Request>();

	public void readAllData() {
		readStudents();
		readInstructors();
		readPerformanceRecords();
		readCourses();
		readAssignments();
		readRequests();
		readPrereqs();
	}

	public void start() {
		readAllData();
		updateCourseWithPrereqs();
		createCourseInstnaces();
	}

	public void processRequest() {
		/*
		 * will grab the first item from the requests list. 
		 * Determines validty of request and puts it in appropriate proccessed
		 * request queue.
		 */
		Request request = requests.remove(0);
		try {
			Course course = this.courseCatalogue.getCourseByID(request.getCourseID());
			Student student = this.getStudentByID(request.getStudentID());
			System.out.println(canRetakeCourse(student, course));
			if (!hasPassingGradesForPrereqs(student, course)) {
				deniedRequestsNoPrereq.add(request);
			} else if (!canRetakeCourse(student, course)) {
				deniedRequestsAlreadyTaken.add(request);
			} else if (course.getNumberOfAvailableSeats().equals(0)) {
				//
				deniedRequestsNoSeats.add(request);
			} else {
				course.registerStudent(student);
				validRequests.add(request);
			}
		} catch (IDNotFound e) {
			System.out.println("Invalid request. Couldnt find either course or student id");
		}
	}

	public void updateCourseWithPrereqs() {
		for (Prereq prereq: prereqs) {
			try {
				Course course2update = this.courseCatalogue.getCourseByID(prereq.getCourseID());
				Course coursePrereq = this.courseCatalogue.getCourseByID(prereq.getPrereqID());
				course2update.getPrereqs().add(coursePrereq);
			} catch (IDNotFound e) {
				// TODO Auto-generated catch block
				//e.printStackTrace();
				System.out.println(String.format("updateCourseWithPrereqs fail. Couldnt find a course with ID = %s", prereq.getCourseID()));;
			}
		}
	}

	public Grade highestGradeInCourse(Student student, Course course) {
		//Returns null if grade not found. Otherwise returns a students
		//highest grade in course
		Grade gradeInCourse = null;
		for (PerformanceRecord performanceRecord: performanceRecords) {
			if (course.getID().equals(performanceRecord.getCourseID())) {
				if (student.getUuid().equals(performanceRecord.getStudentID())) {
					if (gradeInCourse == null) {
						gradeInCourse = performanceRecord.getGrade();
					}
					else {
						if (performanceRecord.getGrade().isHigher(gradeInCourse)) {
							gradeInCourse = performanceRecord.getGrade();
						}
					}
				}
			}
		}
		return gradeInCourse;
	}

	public Boolean hasPassingGradesForPrereqs(Student student, Course course) {
		/*
		 Returns false if student doesnt have adequate grades in prereq
		 or hasnt taken prereqs.
		 */
		for (Course prereq: course.getPrereqs()) {
			Grade grade = this.highestGradeInCourse(student, prereq);
			if (grade == null || grade.isFailing()) {
				return false;
			}
		}
		return true;
	}

	public Boolean canRetakeCourse(Student student, Course course) {
		Grade gradeInCourse = highestGradeInCourse(student, course);
		return (gradeInCourse == null || gradeInCourse.isFailing());
	}

	public Boolean hasNotTakenCourse(Student student, Course course) {
		return this.highestGradeInCourse(student, course) == null;
	}

	public Boolean hasTakenCourse(Student student, Course course) {
		return !hasNotTakenCourse(student, course);
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

	public void createCourseInstnaces() {
		for (Assignment assignment: assignments) {
			try {
				courseInstances.add(new CourseInstance(assignment, courseCatalogue.getCourses(), instructors));
			} catch (IDNotFound e) {
				// TODO Auto-generated catch block
				//e.printStackTrace();
				String.format("No Course with id = %s", assignment.getCourseID());
				System.out.println(String.format("No Course with id = %s. Cant create courseInstancee", assignment.getCourseID()));
			}
		}
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

	public Integer[] requestsDigest() {

		Integer[] output = new Integer[5];
		//readAllData();
		Integer requestsSize = requests.size();
		while (!requests.isEmpty()) {
			processRequest();
		}
		output[0] = requestsSize;
		output[1] = validRequests.size();
		output[2] = this.deniedRequestsNoPrereq.size();
		output[3] = this.deniedRequestsAlreadyTaken.size();
		output[4] = this.deniedRequestsNoSeats.size();
		return output;
	}

	public void printResults(Integer[] array) {
		for (Integer elem : array) {
			System.out.println(elem);
		}
	}

	public void printQueryResults() {
		Integer[] output = queryResults();
		for (Integer elem : output) {
			System.out.println(elem);
		}
	}

	public static void main(String[] args) {
		Administrator administrator = new Administrator();
		administrator.start();
		Integer[] output = administrator.requestsDigest();
		administrator.printResults(output);
		//administrator.printQueryResults();
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


	public List<Request> getValidRequests() {
		return validRequests;
	}


	public void setValidRequests(List<Request> validRequests) {
		this.validRequests = validRequests;
	}


	public List<Request> getDeniedRequestsNoPrereq() {
		return deniedRequestsNoPrereq;
	}


	public void setDeniedRequestsNoPrereq(List<Request> deniedRequestsNoPrereq) {
		this.deniedRequestsNoPrereq = deniedRequestsNoPrereq;
	}


	public List<Request> getDeniedRequestsAlreadyTaken() {
		return deniedRequestsAlreadyTaken;
	}


	public void setDeniedRequestsAlreadyTaken(List<Request> deniedRequestsAlreadyTaken) {
		this.deniedRequestsAlreadyTaken = deniedRequestsAlreadyTaken;
	}


	public List<Request> getDeniedRequestsNoSeats() {
		return deniedRequestsNoSeats;
	}


	public void setDeniedRequestsNoSeats(List<Request> deniedRequestsNoSeats) {
		this.deniedRequestsNoSeats = deniedRequestsNoSeats;
	}

}
