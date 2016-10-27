
public enum Grade {
	A (GradeString.a),
	B (GradeString.b),
	C (GradeString.c),
	D (GradeString.d),
	F (GradeString.f);

	private final String grade;
	Grade(String gradeString) {
		this.grade = gradeString;
	}

	public Boolean isEqualToString(String stringToCheck) {
		return this.grade.equals(stringToCheck.trim().toUpperCase());
	}

	public static Grade gradeFromString(String stringToCheck) {
		if (Grade.A.isEqualToString(stringToCheck)) {
			return Grade.A;
		}
		else if (Grade.B.isEqualToString(stringToCheck)) {
			return Grade.B;
		}
		else if (Grade.C.isEqualToString(stringToCheck)) {
			return Grade.C;
		}
		else if (Grade.D.isEqualToString(stringToCheck)) {
			return Grade.D;
		}
		else if (Grade.F.isEqualToString(stringToCheck)) {
			return Grade.F;
		}
		else {
			throw new IllegalArgumentException();
		}
	}

	public Boolean isHigher(Grade grade) {
		if (this.compareTo(grade) == -1) {
			return true;
		}
		return false;
	}

	public Boolean isFailing() {
		return this == Grade.F;
	}

	public Boolean isPassing() {
		return !this.isFailing();
	}
}

final class GradeString {
	static final String a = "A".trim().toUpperCase();
	static final String b = "B".trim().toUpperCase();
	static final String c = "C".trim().toUpperCase();
	static final String d = "D".trim().toUpperCase();
	static final String f = "F".trim().toUpperCase();
}