import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;

class CourseCatalogue {

	private Boolean isCurrent;
	private List<Course> courses;
	private Integer id;

	public void addCourse(Course course) {
		if (!isInCatalogue(course)) {
			courses.add(course);
		}
	}

	public Boolean isInCatalogue(Course courseToCheck) {
		for (Course course : courses) {
			if (course.isEqual(courseToCheck)) {
				return true;
			}
		}
		return false;
	}

	public Boolean removeCourse(Course courseToRemove) {
		Integer courseCount = 0;
		List<Integer> indexes = new ArrayList<Integer>();
		Integer index = 0;
		for (Course course : courses) {
			if (course.isEqual(courseToRemove)) {
				indexes.add(index);
				index += 1;
			}
		}
		if (index == 0) {
			removeCoursesAtIndexes(indexes);
			return true;
		} else {
			return false;
		}
	}

	public Integer removeCoursesAtIndexes(List<Integer> indexes) {
		//Collection<Integer> indexesNoDuplicates = new HashSet<Integer>(indexes);
		List<Integer> indexesNoDuplicates = new ArrayList(new HashSet<Integer>(indexes));
		Collections.sort(indexesNoDuplicates, Collections.reverseOrder());
		Integer removalCount = 0;
		for (Integer index : indexesNoDuplicates) {
			if (index < courses.size()) {
				courses.remove(index);
				removalCount += 1;
			}
		}
		return removalCount;
	}
	//public Boolean editCourse(Course course) {
	//	
	//}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public List<Course> getCourses() {
		return courses;
	}

	public Boolean getIsCurrent() {
		return isCurrent;
	}

	public void setIsCurrent(Boolean isCurrent) {
		this.isCurrent = isCurrent;
	}


}