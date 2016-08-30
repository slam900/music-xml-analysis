package reports;

public class CountQuartersReport extends Report <Integer> {
	public CountQuartersReport(Integer data) {
		super(data);
	}

	@Override
	public String toString() {
		return "Number of quarter notes: " + getData();
	}
}
