import java.util.ArrayList;
import java.util.List;

public class StudentReader extends GeneralReader {
	static Integer uuidIndex = 0;
	static Integer nameIndex = 1;
	static Integer addressIndex = 2;
	static Integer phoneNumberIndex = 3;
	StudentReader(String csvPath) {
		super(csvPath);
	}
	public List<Student> read() {
		CsvReader csvReader = new CsvReader(this.getCsvPath());
		List<Student> students= new ArrayList<Student>();
		for (String[] line : csvReader) {
			students.add(StudentReader.readLine(line));
		}
		return students;
	}

	static public Student readLine(String[] line) {
		Integer uuid = Integer.parseInt(line[uuidIndex].trim());
		String name = line[nameIndex].trim();
		String address = line[addressIndex].trim();
		String phoneNumber = line[phoneNumberIndex].trim();
		return new Student(name, phoneNumber, address, uuid);
	}
}
