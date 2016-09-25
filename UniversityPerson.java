public class UniversityPerson {
	private String name;
	private String phoneNumber;
	private String address;
	private Integer uuid;

	public UniversityPerson(Integer uuid, String name, String address, String phoneNumber) {
		this.name = name;
		this.phoneNumber = phoneNumber;
		this.address = address;
		this.uuid = uuid;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public Integer getUuid() {
		return uuid;
	}
	public void setUuid(Integer uuid) {
		this.uuid = uuid;
	}

	public Boolean equals(UniversityPerson universityPerson) {
		if (!this.name.equals(universityPerson.name)) {
			return false;
		}
		if (!this.phoneNumber.equals(universityPerson.phoneNumber)) {
			return false;
		}
		if (!this.address.equals(universityPerson.address)) {
			return false;
		}
		if (!this.uuid.equals(universityPerson.uuid)){
			return false;
		}
		return true;
	}

	public Boolean notEquals(UniversityPerson universityPerson) {
		return !this.equals(universityPerson);
	}

}
