package mtool;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class StudentMap{
	String mapString;
	String mapFilePath;
	List<Student> students = new ArrayList<Student>();
	
	public static StudentMap getMapByString(String mapString) {
		StudentMap studentMap = new StudentMap();
		List<String> lines = Arrays.asList(mapString.split("\n"));
		studentMap.doMap(lines);
		return studentMap;
	}
	
	public static StudentMap getMapByFilePath(String filePath) {
		StudentMap studentMap = new StudentMap();
		List<String> lines = new ArrayList<String>();
		try {
			BufferedReader reader = new BufferedReader(new FileReader(filePath));
			while(reader.ready()) {
				lines.add(reader.readLine()); 
			}
			reader.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		studentMap.doMap(lines);
		//System.out.println("Mapp Prepared");
		return studentMap;
	}
	
	private void doMap(List<String> lines) {
		lines.forEach(line->{
			Student student = new Student();
			List<String> words = Arrays.asList(line.split(","));
			student.setRollNo(words.get(1));
			student.setName(words.get(2));
			student.setGnames(words.subList(3,words.size()));
			students.add(student);
		});
	}

	public String getMapString() {
		return mapString;
	}

	public String getMapFilePath() {
		return mapFilePath;
	}

	public List<Student> getStudents() {
		return students;
	}

	@Override
	public String toString() {
		return "StudentMap [mapString=" + mapString + ", mapFilePath=" + mapFilePath + ", students=" + students + "]";
	}
	
	
	
}
