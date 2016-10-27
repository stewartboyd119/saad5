import java.util.HashSet;
import java.util.ArrayList;
import java.util.List;
public class Course {
	private String title;
	private String description;
	private Integer id;
	private Integer additionalSeats = 0;
	private Boolean isAvailableFall;
	private Boolean isAvailableSpring;
	private Boolean isAvailableSummer;
	private HashSet<Course> prereqs;
	private List<CourseInstance> courseInstances = new ArrayList<CourseInstance>();
	

	Course(Integer id, String title, 
			Boolean isAvailableFall,
			Boolean isAvailableSpring,
			Boolean isAvailableSummer,
			HashSet<Course> prereqs){
		this.title = title;
		this.description = "";
		this.id = id;
		this.setIsAvailableFall(isAvailableFall);
		this.setIsAvailableSpring(isAvailableSpring);
		this.setIsAvailableSummer(isAvailableSummer);
		this.setPrereqs(prereqs);
	}

	Course(Integer id, String title, 
			Boolean isAvailableFall,
			Boolean isAvailableSpring,
			Boolean isAvailableSummer){
		this.title = title;
		this.description = "";
		this.id = id;
		this.setIsAvailableFall(isAvailableFall);
		this.setIsAvailableSpring(isAvailableSpring);
		this.setIsAvailableSummer(isAvailableSummer);
		this.setPrereqs(new HashSet<Course>());
	}


	public void setTitleDescriptionID(String title, String description, Integer id) {
		this.title = title;
		this.description = description;
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public String getDescription() {
		return description;
	}

	public Integer getID() {
		return id;
	}

	public Boolean getIsAvailableFall() {
		return isAvailableFall;
	}

	public void setIsAvailableFall(Boolean isAvailableFall) {
		this.isAvailableFall = isAvailableFall;
	}

	public Boolean getIsAvailableSpring() {
		return isAvailableSpring;
	}

	public void setIsAvailableSpring(Boolean isAvailableSpring) {
		this.isAvailableSpring = isAvailableSpring;
	}

	public Boolean getIsAvailableSummer() {
		return isAvailableSummer;
	}

	public void setIsAvailableSummer(Boolean isAvailableSummer) {
		this.isAvailableSummer = isAvailableSummer;
	}

	public Boolean isAvailable(Semester semester) {
		switch (semester) {
		case Fall:
			return isAvailableFall;
		case Spring:
			return isAvailableSpring;
		case Summer:
			return isAvailableSummer;
		default:
			return false;
		}
	}
	public Boolean isEqual(Course course) {
		return this.id == course.id;
	}

	public Boolean equals(Course course) {
		if (!this.id.equals(course.id) ) {
			return false;
		}
		if (!this.title.equals(course.title)) {
			return false;
		}
		if (!this.description.equals(course.description)) {
			return false;
		}
		if (this.isAvailableFall != course.isAvailableFall) {
			return false;
		}
		if (this.isAvailableSpring != course.isAvailableSpring) {
			return false;
		}
		if (this.isAvailableSummer != course.isAvailableSummer) {
			return false;
		}
		return true;
	}

	public Boolean notEquals(Course course) {
		return !this.equals(course);
	}

	public HashSet<Course> getPrereqs() {
		return prereqs;
	}

	public void setPrereqs(HashSet<Course> prereqs) {
		this.prereqs = prereqs;
	}

	public List<CourseInstance> getCourseInstances() {
		return courseInstances;
	}

	public void setCourseInstances(List<CourseInstance> courseInstances) {
		this.courseInstances = courseInstances;
	}

	public Integer getNumberOfClassInstances() {
		return courseInstances.size();
	}

	public Boolean areAvailableSeats() {
		return getNumberOfAvailableSeats() > 0;
	}


	public void addSeats(Integer number) {
		if (number > 0) {
			if (courseInstances.size() > 0){
				courseInstances.get(0).addSeats(number);
				
			} else {
				this.additionalSeats += number;
			}
		}
	}

	
	public Integer getNumberOfAvailableSeats() {
		Integer numberOfSeats = 0;
		for (CourseInstance courseInstance: courseInstances) {
			numberOfSeats += courseInstance.getNumberOfAvailableSeats();
		}
		return numberOfSeats + additionalSeats;
	}

	public CourseInstance courseInstanceWithAvailableSeats() {
		/*
		 * Returns a courseInstance with available seats or null if none
		 * are available.
		 */
		for (CourseInstance courseInstance: courseInstances) {
			if (courseInstance.getNumberOfAvailableSeats() > 0) {
				return courseInstance;
			}
		}
		return null;
	}

	public void registerStudent(Student student) {
		CourseInstance courseInstance = courseInstanceWithAvailableSeats();
		if (courseInstance == null) {
			System.out.println("No available Seats. Cant register");
		} else {
			courseInstance.registerStudent(student);
		}
	}

	public void addCourseInstance(CourseInstance courseInstance) {
		courseInstances.add(courseInstance);
	}

}
