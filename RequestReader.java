	import java.util.ArrayList;
	import java.util.Arrays;
	import java.util.List;

public class RequestReader extends GeneralReader{


	static Integer studentIDIndex = 0;
	static Integer courseIDIndex = 1;

	RequestReader(String csvPath) {
		super(csvPath);
	}

	public List<Request> read() {
		CsvReader requestsReader = new CsvReader(this.getCsvPath());
		List<Request> requests= new ArrayList<Request>();
		for (String[] line : requestsReader) {
			Request request = RequestReader.readLine(line);
			requests.add(request);
		}
		return requests;
	}

	public static Request readLine(String[] line) {

		Integer studentID = Integer.parseInt(line[RequestReader.studentIDIndex].trim());
		Integer courseID = Integer.parseInt(line[RequestReader.courseIDIndex].trim());

		return new Request(studentID, courseID);		
	}
}
