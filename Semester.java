public enum Semester {
	
	Fall (SemesterString.fall),
	Spring (SemesterString.spring),
	Summer (SemesterString.summer);

	private final String semester;
	Semester(String semester) {
		this.semester = semester;
	}

	public Boolean isEqualToString(String stringToCheck) {
		return this.semester.equals(stringToCheck.trim().toLowerCase());
	}

	public static Semester semesterFromString(String stringToCheck) {
		if (Semester.Fall.isEqualToString(stringToCheck)) {
			return Semester.Fall;
		}
		else if (Semester.Spring.isEqualToString(stringToCheck)) {
			return Semester.Spring;
		}
		else if (Semester.Summer.isEqualToString(stringToCheck)) {
			return Semester.Summer;
		}
		else {
			throw new IllegalArgumentException();
		}
	}
}


final class SemesterString {
	static final String fall = "fall".trim().toLowerCase();
	static final String spring = "spring".trim().toLowerCase();
	static final String summer = "summer".trim().toLowerCase();
}
