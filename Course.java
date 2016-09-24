public class Course {
	private String title;
	private String description;
	private Integer id;
	private Boolean isAvailableFall;
	private Boolean isAvailableSpring;
	private Boolean isAvailableSummer;
	

	Course(String title, String description, Integer id,
			Boolean isAvailableFall,
			Boolean isAvailableSpring,
			Boolean isAvailableSummer){
		this.title = title;
		this.description = description;
		this.id = id;
		this.setIsAvailableFall(isAvailableFall);
		this.setIsAvailableSpring(isAvailableSpring);
		this.setIsAvailableSummer(isAvailableSummer);
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

	public Boolean isEqual(Course course) {
		return this.id == course.id;
	}

	public Boolean equals(Course course) {
		if (this.id != course.id ) {
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
}
