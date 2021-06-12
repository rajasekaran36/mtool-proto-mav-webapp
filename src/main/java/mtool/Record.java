package mtool;

public class Record {
	private Student student;
	private String gmeetNameUsed = "";
	private String arrivalTime = "00:00";
	private String lastSeen = "00:00";
	private String duration = "0";
	private String status = "AB";
	private String comment = "None";
	
	public Student getStudent() {
		return student;
	}
	public void setStudent(Student student) {
		this.student = student;
	}
	public String getGmeetNameUsed() {
		return gmeetNameUsed;
	}
	public void setGmeetNameUsed(String gmeetNameUsed) {
		this.gmeetNameUsed = gmeetNameUsed;
	}
	public String getArrivalTime() {
		return arrivalTime;
	}
	public void setArrivalTime(String arrivalTime) {
		this.arrivalTime = arrivalTime;
	}
	public String getLastSeen() {
		return lastSeen;
	}
	public void setLastSeen(String lastSeen) {
		this.lastSeen = lastSeen;
	}
	public String getDuration() {
		return duration;
	}
	public void setDuration(String duration) {
		this.duration = duration;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getComment() {
		return comment;
	}
	public void setComment(String comment) {
		this.comment = comment;
	}
	@Override
	public String toString() {
		return "Record [student=" + student + ", gmeetNameUsed=" + gmeetNameUsed + ", arrivalTime=" + arrivalTime
				+ ", lastSeen=" + lastSeen + ", duration=" + duration + ", status=" + status + ", comment=" + comment
				+ "]";
	}
	
	
}
