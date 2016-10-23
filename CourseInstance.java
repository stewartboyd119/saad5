import java.util.ArrayList;

public class CourseInstance {

	private Course course;
	private Instructor instructor;
	private Integer numberOfSeats;

	CourseInstance(Course course, Instructor instructor, Integer numberOfSeats) {
		this.setCourse(course);
		this.setInstructor(instructor);
		this.setNumberOfSeats(numberOfSeats);
	}

	CourseInstance(Assignment assignment, ArrayList<Course> courses, ArrayList<Instructor> instructors) throws IDNotFound {

		for (Course course : courses) {
			if (course.getID() == assignment.getCourseID()) {
				this.setCourse(course);
				break;
			}
		}

		for (Instructor instructor : instructors) {
			if (instructor.getUuid() == assignment.getInstructorID()) {
				this.setInstructor(instructor);
				break;
			}
		}
		if (course == null || instructor == null) {
			throw new IDNotFound();
		}
		this.setNumberOfSeats(assignment.getNumberOfSeats());
	}

	public Course getCourse() {
		return course;
	}

	public void setCourse(Course course) {
		this.course = course;
	}

	public Instructor getInstructor() {
		return instructor;
	}

	public void setInstructor(Instructor instructor) {
		this.instructor = instructor;
	}

	public Integer getNumberOfSeats() {
		return numberOfSeats;
	}

	public void setNumberOfSeats(Integer numberOfSeats) {
		this.numberOfSeats = numberOfSeats;
	}

	public Boolean equals(CourseInstance courseInstance) {
		if (!this.course.equals(courseInstance.getCourse())) {
			return false;
		}
		if (!this.instructor.equals(courseInstance.getInstructor())) {
			return false;
		}
		if (!this.numberOfSeats.equals(courseInstance.getNumberOfSeats())) {
			return false;
		}
		return true;
	}

	public Boolean notEquals(CourseInstance courseInstance) {
		return !this.equals(courseInstance);
	}
	

}
