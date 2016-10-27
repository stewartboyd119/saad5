import java.io.Console;
import java.util.Arrays;


public class ConsoleInterpreter {

	Console console;
	Administrator administrator;
	Boolean read = true;
	String prompt = "$main: ";
	//display-based commands: 
	String messageDisplayRequests = "display_requests";
	String messageDisplayRecords = "display_records";
	String messageDisplaySeats = "display_seats";
	//modification-based commands:
	String messageAddRecords = "add_record";
	String messageAddRecords2 = "add_records";
	String messageAddSeats = "add_seats";
	String messageCheckRequest = "check_request";
	//control-flow commands:
	String messageQuit = "quit";

	String messageMissingPrereq = "student is missing one or more prerequisites\n";
	String messageStudentHasPassed = "student has already taken the course with a grade of C or higher\n";
	String messageNoSeatsAvailable = "no remaining seats available for the course at this time\n";
	String messageRequestIsValid = "request is valid\n";
	String messageStopped = "stopping the command loop\n";

	String splitBy = ",";

	ConsoleInterpreter(Administrator administrator, Console console) {
		this.administrator = administrator;
		this.console = console;
		
	}

	void processLine(String commandLine) {
		String[] commandLineArgs = commandLine.split(splitBy);
		//console.format("this is the command line -> '%s'", commandLine);
		if (commandLine.equals(messageDisplayRequests)) {
			displayRequests();
		} else if (commandLine.equals(messageDisplayRecords))  {
			displayRecords();
		} else if (commandLine.equals(messageDisplaySeats)) {
			displaySeats();
		} else if (commandLine.startsWith(messageAddRecords) || commandLine.startsWith(messageAddRecords2)) {
			addRecords(commandLineArgs);
		} else if (commandLine.startsWith(messageAddSeats)) {
			addSeats(commandLineArgs);
		} else if (commandLine.startsWith(messageCheckRequest)) {
			checkRequest(commandLineArgs);
		} else if (commandLine.startsWith(messageQuit)) {
			read = false;
		} else {
			console.format("'%s' is not a valid command", commandLine);
		}
	}

	void displayRequests() {
		for (Request validRequest: administrator.getValidRequests()) {
			try {
				Student student = administrator.getStudentByID(validRequest.getStudentID());
				Course course = administrator.getCourseCatalogue().getCourseByID(validRequest.getCourseID());
				printRequests(student, course);
			} catch (IDNotFound e) {
				System.out.println("Print invalid StudentID or CourseID");
			}
		}
	}

	void printRequests(Student student, Course course) {
		console.format("%s, %s, %s, %s\n", student.getUuid(), student.getName(), course.getID(), course.getTitle());
	}

	void displayRecords() {
		for(PerformanceRecord performanceRecord: administrator.getPerformanceRecords()) {
			printRecords(performanceRecord);
		}
	}

	void printRecords(PerformanceRecord performanceRecord) {
		console.format("%s, %s, %s, %s, %s\n", performanceRecord.getStudentID(), performanceRecord.getCourseID(), performanceRecord.getInstructorID(), performanceRecord.getComment(), performanceRecord.getGrade().toString());
	}
	void displaySeats() {
		for (Course course: administrator.getCourseCatalogue().getCourses()) {
			printSeats(course);
		}
	}

	void printSeats(Course course) {
		console.format("%s, %s, %s\n", course.getID(), course.getTitle(), course.getNumberOfAvailableSeats());
	}
	void addRecords(String[] commandLineArgs) {
		/*
		 * add_record,15,8,2,nice job,A
		 */
		Integer numArgs = 6;
		if (commandLineArgs.length == numArgs) {
			String[] performanceRecordLine = Arrays.copyOfRange(commandLineArgs, 1, numArgs);
			administrator.getPerformanceRecords().add(PerformanceRecordReader.readLine(performanceRecordLine));
		}
	}

	void addSeats(String[] commandLineArgs) {
		/*
		 * add_seats,13,3
		 */
		int numArgs = 3;
		//---this is issue bc idk think the way add is currenlty implemneted the system will allow me to
		//---add a new student 
		
		if (commandLineArgs.length == numArgs) {
			String[] requestLine = Arrays.copyOfRange(commandLineArgs, 1, numArgs);
			Integer courseID = Integer.parseInt(requestLine[0].trim());
			Integer numberOfSeats = Integer.parseInt(requestLine[1].trim());
			try {
				Course course = administrator.getCourseCatalogue().getCourseByID(courseID);
				course.addSeats(numberOfSeats);
			} catch (IDNotFound e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}		
	}

	void checkRequest(String[] commandLineArgs) {
		/*
		 * check_request,15,29
		 */
		int numArgs = 3;
		if (commandLineArgs.length == numArgs) {
			String[] requestLine = Arrays.copyOfRange(commandLineArgs, 1, numArgs);
			Request request = RequestReader.readLine(requestLine);
			RequestStatus requestStatus = administrator.accessRequest(request);
			if (requestStatus != null) {
				switch (requestStatus) {
				case noPrereqs:
					console.format(messageMissingPrereq);
					break;
				case alreadyTaking:
					console.format(messageStudentHasPassed);
					break;
				case noSeats:
					console.format(messageNoSeatsAvailable);
					break;
				case valid:
					administrator.processValidRequest(request);
					console.format(messageRequestIsValid);
					break;
				}
			}
		}
	}

	void readLines() {
		while (read) {
			String commandLine = console.readLine(prompt);
			processLine(commandLine);
			//console.format("Crazy thing to write -> %s", commandLine);
		}
	}

	public static void main(String args[]) {
		Console console = System.console();
		Administrator administrator = new Administrator();
		administrator.start();
		Integer[] output = administrator.requestsDigest();
		administrator.printResults(output);
		
		
		
		if (console == null) {
			System.out.println("Console Not available");
		} else {
			ConsoleInterpreter consoleInterpreter = new ConsoleInterpreter(administrator, console);
			consoleInterpreter.readLines();
		}
	}
}
