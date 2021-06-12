package mtool;
import java.util.List;

public class Student {
	private String rollNo;
	private String name;
	private List<String> gnames;
	
	public String getRollNo() {
		return rollNo;
	}
	public void setRollNo(String rollNo) {
		this.rollNo = rollNo;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public List<String> getGnames() {
		return gnames;
	}
	public void setGnames(List<String> gnames) {
		this.gnames = gnames;
	}
	@Override
	public String toString() {
		return "Student [rollNo=" + rollNo + ", name=" + name + ", gnames=" + gnames + "]";
	}
	
	
}
