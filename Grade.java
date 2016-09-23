
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
		return this.grade.equals(stringToCheck.trim().toLowerCase());
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
}

final class GradeString {
	static final String a = "a".trim().toLowerCase();
	static final String b = "b".trim().toLowerCase();
	static final String c = "c".trim().toLowerCase();
	static final String d = "d".trim().toLowerCase();
	static final String f = "f".trim().toLowerCase();
}