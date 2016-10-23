import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.net.URISyntaxException;
import java.util.Iterator;
import java.util.NoSuchElementException;


public class CsvReader implements Iterable<String []>{
	String csvFilepath;
	BufferedReader br;
	static String csvSplitBy = ",";

	CsvReader(String csvFilepath) {
		this.csvFilepath = csvFilepath;
		this.br = CsvReader.open(csvFilepath);
	}

	public static BufferedReader open(String csvFilepath) {
		BufferedReader br = null;
        try {
            br = new BufferedReader(new FileReader(csvFilepath));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } 
        return br;
	}

	public static Boolean close(BufferedReader br) {
        if (br != null) {
            try {
                br.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return true;
        }
        return false;
	}

	@Override
	public Iterator<String[]> iterator() {
		CsvReader.close(br);
		br = CsvReader.open(csvFilepath);
		return new CsvReader.FileIterator(br);
	}
  
    public static final class FileIterator implements Iterator<String[]> {
    	private String currentLine;
    	private Integer hasNextCount = 0;
    	private Integer nextCount = 0;
    	private BufferedReader br;

    	public FileIterator(BufferedReader br) {
    		this.br = br;
    		currentLine = null;
    	}

    	public boolean hasNext() {
    		if (nextCount < hasNextCount) {
    			return true;
    		}
    		try {
    			currentLine = br.readLine();
    			hasNextCount += 1;
    		} catch (IOException e){
    			return false;
    		}
    		return currentLine != null;
    	}

    	public String[] next() {
    		if(!this.hasNext()) {
    			throw new NoSuchElementException();
    		}
    		nextCount += 1;
    		return currentLine.split(CsvReader.csvSplitBy);
    	}

    	public void remove() {
    		throw new UnsupportedOperationException();
    	}
    }

	public static void main(String[] args) throws URISyntaxException {
		// TODO Auto-generated method stub


		//URL resource = CsvReader.class.getResource("test_case_0/courses.csv");
		File newFile = new File("students.csv");
		//File newFile = Paths.get(resource.toURI()).toFile();
		CsvReader csvReader = new CsvReader(newFile.getAbsolutePath());
		  for (String[] line : csvReader) {
			  for (String item : line) {
				  System.out.println(item);
			  }
			  System.out.println("new line");
		  }
		  System.out.println("sdtew");
	}


}
