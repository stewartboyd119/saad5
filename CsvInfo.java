
public class CsvInfo {
	private int numColumns = 0;
	private int numRows = 0;
	private int numBlankRows = 0;

	public void analyzeFirstRow(String[] line) {
		numColumns = line.length;
	}

	public void analyzeRow(String[] line) {
		numRows += 1;
		notEmpty : {
			for (String elem : line) {
				if (elem.trim() != "") {
					break notEmpty;
				}
			}
			numBlankRows += 1;
		}

	}

	public void reset() {
		numColumns = 0;
		numRows = 0;
		numBlankRows = 0;
	}
}