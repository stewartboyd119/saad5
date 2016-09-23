public class Student extends UniversityPerson{
	private Boolean isEnrolled;

	Student(String name, String phoneNumber, String address, Integer uuid) {
		super(name, phoneNumber, address, uuid);
	}
	public Boolean getIsEnrolled() {
		return isEnrolled;
	}

	public void setIsEnrolled(Boolean isEnrolled) {
		this.isEnrolled = isEnrolled;
	}
}
