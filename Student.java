public class Student extends UniversityPerson{
	private Boolean isEnrolled;

	Student(Integer uuid, String name, String address, String phoneNumber) {
		super(uuid, name, address, phoneNumber);
	}
	public Boolean getIsEnrolled() {
		return isEnrolled;
	}

	public void setIsEnrolled(Boolean isEnrolled) {
		this.isEnrolled = isEnrolled;
	}
}
