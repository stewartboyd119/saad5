import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

class CourseCatalogue implements Iterable<Course>{

	//private Boolean isCurrent;
	private List<Course> courses;
	//private Integer id;

	CourseCatalogue(List<Course> courses) { 
		this.courses = courses;
	}

	CourseCatalogue(ArrayList<Course> courses) {
		this.courses = courses;
	}

	public void addCourse(Course course) {
		if (!isInCatalogue(course)) {
			courses.add(course);
		}
	}

	public Course getCourseByID(Integer id) throws IDNotFound{
		for (Course course : courses) {
			if (course.getID().equals(id)) {
				return course;
			}
		}
		throw new IDNotFound();
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

	public void clearCourses() {
		this.courses = new ArrayList<Course>();
	}

	public Integer numberOfCourses() {
		return this.courses.size();
	}
	//public Boolean editCourse(Course course) {
	//	
	//}

	/*
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}
	*/
	public List<Course> getCourses() {
		return courses;
	}

	public void setCourses(List<Course> courses) {
		this.courses = courses;
	}
	/*
	public Boolean getIsCurrent() {
		return isCurrent;
	}

	public void setIsCurrent(Boolean isCurrent) {
		this.isCurrent = isCurrent;
	}
	*/

	@Override
	public Iterator<Course> iterator() {
		// TODO Auto-generated method stub
		return new CourseIterator(courses);
	}

	public static final class CourseIterator implements Iterator<Course> {

		private int currentIndex = 0;
		private List<Course> courses;

		CourseIterator(List<Course> courses) {
			this.courses = courses;
		}

		@Override
		public boolean hasNext() {
			// TODO Auto-generated method stub
			return courses.size() > currentIndex;
		}

		@Override
		public Course next() {
			// TODO Auto-generated method stub
			
			Course course = courses.get(currentIndex);
			currentIndex += 1;
			return course;
		}
		
	}
}