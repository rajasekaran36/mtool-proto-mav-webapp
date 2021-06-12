package mtool;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Meeting {
	private String classRoom;
	private String date;
	private String time;
	private String meetID;
	private List<Meeting.Participation> participations = new ArrayList<Meeting.Participation>();
	
	class Participation{
		private String meetName;
		private String arrivalTime;
		private String lastSeen;
		public String getMeetName() {
			return meetName;
		}
		public void setMeetName(String meetName) {
			this.meetName = meetName;
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
		
		@Override
		public String toString() {
			return "Participation [meetName=" + meetName + ", arrivalTime=" + arrivalTime + ", lastSeen=" + lastSeen
					+ "]";
		}
		
	}
	
	public static Meeting getReportByFile(String filePath) {
		Meeting meeting = new Meeting();
		List<String> lines = new ArrayList<String>();
		try {
			BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(filePath),"UTF-8"));
			while(reader.ready()) {
				lines.add(reader.readLine());
			}
			reader.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch(IOException e) {
			e.printStackTrace();
		}
		meeting.processLines(lines);
		return meeting;
	}
	
	private void processLines(List<String> lines) {
		lines = cleanUpLines(lines);
		//Line 1 Process
		this.classRoom = lines.get(0).split(",")[0];
		//Line 2 Process
		String[] line2datas = lines.get(1).split(",");
		this.date = line2datas[1];
		this.time = line2datas[3];
		this.meetID = line2datas[5];
		
		//Participation
		lines.subList(4, lines.size()-4).forEach(line->{
			
			List<String> recData = Arrays.asList(line.split(","));
			if(recData.size()>4) {
				Participation participation = new Participation();
				participation.setMeetName(recData.get(0));
				participation.setArrivalTime(recData.get(4));
				participation.setLastSeen(recData.get(5));
				participations.add(participation);
			}
		});
	}
	
	private List<String> cleanUpLines(List<String> lines){
		List<String> c_lines = new ArrayList<String>();
		for(String line:lines) {
			StringBuffer buffer = new StringBuffer();
			for(String word:line.split(",")) {
				buffer.append(word.replaceAll("\"", ""));
				buffer.append(",");
			}
			c_lines.add(buffer.toString());
		}
		return c_lines;
	}
	
	
	
	public String getClassRoom() {
		return classRoom;
	}

	public void setClassRoom(String classRoom) {
		this.classRoom = classRoom;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

	public String getMeetID() {
		return meetID;
	}

	public void setMeetID(String meetID) {
		this.meetID = meetID;
	}

	public List<Meeting.Participation> getParticipations() {
		return participations;
	}

	public void setParticipations(List<Meeting.Participation> participations) {
		this.participations = participations;
	}

	@Override
	public String toString() {
		return "Meeting [classRoom=" + classRoom + ", date=" + date + ", time=" + time + ", meetID=" + meetID
				+ ", participations=" + participations + "]";
	}
	
	
}
