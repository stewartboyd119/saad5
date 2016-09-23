public class PerformanceRecord {
	Integer studentID;
	Integer courseID;
	Integer instructorID;
	String comment;
	Grade grade;

	PerformanceRecord(Integer studentID, Integer courseID, Integer instructorID,
					String comment, Grade grade) {
		this.studentID = studentID;
		this.courseID = courseID;
		this.instructorID = instructorID;
		this.comment = comment;
		this.grade = grade;
	}

}
