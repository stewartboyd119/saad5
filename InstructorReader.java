import java.util.ArrayList;
import java.util.List;

public class InstructorReader extends GeneralReader{
	static Integer uuidIndex = 0;
	static Integer nameIndex = 1;
	static Integer addressIndex = 2;
	static Integer phoneNumberIndex = 3;
	InstructorReader(String csvPath) {
		super(csvPath);
	}
	public List<Instructor> read() {
		CsvReader csvReader = new CsvReader(this.getCsvPath());
		List<Instructor> instructors= new ArrayList<Instructor>();
		for (String[] line : csvReader) {
			instructors.add(InstructorReader.readLine(line));
		}
		return instructors;
	}

	public static Instructor readLine(String[] line) {
		Integer uuid = Integer.parseInt(line[uuidIndex].trim());
		String name = line[nameIndex].trim();
		String address = line[addressIndex].trim();
		String phoneNumber = line[phoneNumberIndex].trim();
		return new Instructor(name, phoneNumber, address, uuid);		
	}

	public static void main(String[] args) {
		System.out.println("sdtew");;
	}
}