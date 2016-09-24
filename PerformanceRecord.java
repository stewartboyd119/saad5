public class PerformanceRecord {
	private Integer studentID;
	private Integer courseID;
	private Integer instructorID;
	private String comment;
	private Grade grade;

	PerformanceRecord(Integer studentID, Integer courseID, Integer instructorID,
					String comment, Grade grade) {
		this.setStudentID(studentID);
		this.setCourseID(courseID);
		this.setInstructorID(instructorID);
		this.setComment(comment);
		this.setGrade(grade);
	}

	public Integer getStudentID() {
		return studentID;
	}

	public void setStudentID(Integer studentID) {
		this.studentID = studentID;
	}

	public Integer getCourseID() {
		return courseID;
	}

	public void setCourseID(Integer courseID) {
		this.courseID = courseID;
	}

	public Integer getInstructorID() {
		return instructorID;
	}

	public void setInstructorID(Integer instructorID) {
		this.instructorID = instructorID;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public Grade getGrade() {
		return grade;
	}

	public void setGrade(Grade grade) {
		this.grade = grade;
	}


	public Boolean equals(PerformanceRecord performanceRecord) {
		if (this.studentID != performanceRecord.studentID) {
			return false;
		}
		if (this.courseID != performanceRecord.courseID) {
			return false;
		}
		if (this.instructorID != performanceRecord.instructorID) {
			return false;
		}
		if (!this.comment.equals(performanceRecord.comment)){
			return false;
		}
		if (this.grade != performanceRecord.grade){
			return false;
		}
		return true;
	}

	public Boolean notEquals(PerformanceRecord performanceRecord) {
		return !this.equals(performanceRecord);
	}

}
