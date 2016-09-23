
public class GeneralReader {
	private String csvPath;

	GeneralReader(String csvPath) {
		this.csvPath = csvPath;
	}

	public String getCsvPath() {
		return csvPath;
	}

	public void setCsvPath(String csvPath) {
		this.csvPath = csvPath;
	}
}
