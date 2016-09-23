import java.util.ArrayList;
import java.util.List;

public class StudentReader extends GeneralReader {
	Integer uuidIndex = 0;
	Integer nameIndex = 1;
	Integer addressIndex = 2;
	Integer phoneNumberIndex = 3;
	StudentReader(String csvPath) {
		super(csvPath);
	}
	public List<Student> read() {
		CsvReader csvReader = new CsvReader(this.getCsvPath());
		List<Student> students= new ArrayList<Student>();
		for (String[] line : csvReader) {
			Integer uuid = Integer.parseInt(line[uuidIndex].trim());
			String name = line[nameIndex].trim();
			String address = line[addressIndex].trim();
			String phoneNumber = line[phoneNumberIndex].trim();
			students.add(new Student(name, phoneNumber, address, uuid));
		}
		return students;
		
	}
}
