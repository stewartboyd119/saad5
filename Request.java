
public class Request {

	private Integer studentID;
	private Integer courseID;

	Request(Integer studentID, Integer courseID) {
		this.setStudentID(studentID);
		this.setCourseID(courseID);
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
}
