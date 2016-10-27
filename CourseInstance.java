import java.util.ArrayList;
import java.util.List;

public class CourseInstance {

	private Course course;
	private Instructor instructor;
	private Integer numberOfSeats;
	private Integer numberOfAvailableSeats;

	CourseInstance(Course course, Instructor instructor, Integer numberOfSeats) {
		this.setCourse(course);
		this.setInstructor(instructor);
		this.numberOfSeats = numberOfSeats;
		this.numberOfAvailableSeats = numberOfSeats;
		course.addCourseInstance(this);
	}

	CourseInstance(Assignment assignment, List<Course> courses, List<Instructor> instructors) throws IDNotFound {

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
		this.numberOfSeats = assignment.getNumberOfSeats();
		this.numberOfAvailableSeats = numberOfSeats;
		course.addCourseInstance(this);
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

	public Integer getNumberOfAvailableSeats() {
		return numberOfAvailableSeats;
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

	public Boolean areSeatsAvailable() {
		return numberOfAvailableSeats > 0;
	}

	public void registerStudent(Student student) {
		this.numberOfAvailableSeats -= 1;
	}

}
