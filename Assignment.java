
public class Assignment {

	private Integer instructorID;
	private Integer courseID;
	private Integer numberOfSeats;

	Assignment(Integer instructorID, Integer courseID, Integer numberOfSeats) {
		this.setInstructorID(instructorID);
		this.setCourseID(courseID);
		this.setNumberOfSeats(numberOfSeats);
	}

	public Integer getInstructorID() {
		return instructorID;
	}

	public void setInstructorID(Integer instructorID) {
		this.instructorID = instructorID;
	}

	public Integer getCourseID() {
		return courseID;
	}

	public void setCourseID(Integer courseID) {
		this.courseID = courseID;
	}

	public Integer getNumberOfSeats() {
		return numberOfSeats;
	}

	public void setNumberOfSeats(Integer numberOfSeats) {
		this.numberOfSeats = numberOfSeats;
	}

	public Boolean equals(Assignment assignment) {
		if (this.instructorID != assignment.getInstructorID()) {
			return false;
		}
		else if (this.courseID != assignment.getCourseID()) {
			return false;
		}
		else if (this.numberOfSeats != assignment.getNumberOfSeats()) {
			return false;
		}
		return true;
	}

	public Boolean notEquals(Assignment assignment) {
		return !this.equals(assignment);
	}
}
