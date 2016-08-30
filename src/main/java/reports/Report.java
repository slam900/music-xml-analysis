package reports;

public abstract class Report <T> {
	private T data;
	
	public Report(T data_) {
		data = data_;
	}
	public T getData() {
	  return data;
	}
	public abstract String toString();
}
