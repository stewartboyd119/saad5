public class UniversityPerson {
	private String name;
	private String phoneNumber;
	private String address;
	private Integer uuid;

	public UniversityPerson(String name, String phoneNumber, String address, Integer uuid) {
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
	
}
