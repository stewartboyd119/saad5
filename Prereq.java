
public class Prereq {

	private Integer prereqID;
	private Integer courseID;

	Prereq(Integer prereqID, Integer courseID) {
		this.setPrereqID(prereqID);
		this.setCourseID(courseID);
	}

	public Integer getPrereqID() {
		return prereqID;
	}

	public void setPrereqID(Integer prereqID) {
		this.prereqID = prereqID;
	}

	public Integer getCourseID() {
		return courseID;
	}

	public void setCourseID(Integer courseID) {
		this.courseID = courseID;
	}
}
