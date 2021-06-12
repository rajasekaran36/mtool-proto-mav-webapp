package mtool;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Report {
	private List<Record> records = new ArrayList<Record>();
	private Meeting meeting;
	private StudentMap studentMap;

	public Report(StudentMap studentMap, Meeting meetig) {
		studentMap.getStudents().forEach(student -> {
			Record record = new Record();
			record.setStudent(student);
			records.add(record);
		});
		this.studentMap = studentMap;
		this.meeting = meetig;
		this.analize();
	}

	public Report getReport() {
		return this;
	}

	@Override
	public String toString() {
		return "Report [records=" + records + "]";
	}

	private void analize() {
		/*
		 * records.forEach(record->{ for(Meeting.Participation
		 * partcipaion:meeting.getParticipations()) {
		 * if(record.getStudent().getGnames().contains(partcipaion.getMeetName())){
		 * record.setGmeetNameUsed(partcipaion.getMeetName());
		 * record.setArrivalTime(partcipaion.getArrivalTime());
		 * record.setLastSeen(partcipaion.getLastSeen()); } else {
		 * 
		 * } } });
		 */

		meeting.getParticipations().forEach(participation -> {
			Record record = getRecordByGmeetName(participation.getMeetName());
			if (record != null) {
				record.setGmeetNameUsed(participation.getMeetName());
				record.setArrivalTime(participation.getArrivalTime());
				record.setLastSeen(participation.getLastSeen());
				record.setDuration(setDuration(participation.getArrivalTime(), participation.getLastSeen()));
				record.setStatus("P");
			} else {
				Student student = new Student();
				student.setName("Unknown");
				student.setRollNo("Unknown");
				List<String> meetnames = new ArrayList<String>();
				meetnames.add("Unknown");
				student.setGnames(meetnames);
				record = new Record();
				record.setStudent(student);
				record.setGmeetNameUsed(participation.getMeetName());
				record.setArrivalTime(participation.getArrivalTime());
				record.setLastSeen(participation.getLastSeen());
				record.setDuration(setDuration(participation.getArrivalTime(), participation.getLastSeen()));
				record.setStatus("A");
				records.add(record);
			}
		});
	}

	private Record getRecordByGmeetName(String gmeetName) {
		for (Record record : records) {
			if (record.getStudent().getGnames().contains(gmeetName))
				return record;
		}
		return null;
	}

	private String setDuration(String start, String end) {
		Long duration = 0L;
		SimpleDateFormat format = new SimpleDateFormat("HH:mm");
		try {
			Date startTime = format.parse(start);
			Date endTime = format.parse(end);
			duration = (endTime.getTime() - startTime.getTime()) / (1000 * 60);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return String.valueOf(duration);
	}

	public String getReportString() {
		StringBuffer buffer = new StringBuffer();
		records.forEach(record -> {
			buffer.append(record.getStudent().getRollNo() + ",");
			buffer.append(record.getStudent().getName() + ",");
			buffer.append(record.getGmeetNameUsed() + ",");
			buffer.append(record.getArrivalTime() + ",");
			buffer.append(record.getLastSeen() + ",");
			buffer.append(record.getDuration() + ",");
			buffer.append(record.getStatus());
			buffer.append("\n");
		});
		return buffer.toString();
	}

	public String getPresentString() {
		StringBuffer buffer = new StringBuffer();
		records.forEach(record -> {
			if (record.getStatus() == "P") {
				buffer.append(record.getStudent().getRollNo() + ",");
				buffer.append(record.getStudent().getName() + ",");
				buffer.append(record.getGmeetNameUsed() + ",");
				buffer.append(record.getArrivalTime() + ",");
				buffer.append(record.getLastSeen() + ",");
				buffer.append(record.getDuration() + ",");
				buffer.append(record.getStatus());
				buffer.append("\n");
			}
		});
		return buffer.toString();
	}

	public String getAbsentString() {
		StringBuffer buffer = new StringBuffer();
		records.forEach(record -> {
			if (record.getStatus() == "AB") {
				buffer.append(record.getStudent().getRollNo() + ",");
				buffer.append(record.getStudent().getName() + ",");
				buffer.append(record.getGmeetNameUsed() + ",");
				buffer.append(record.getArrivalTime() + ",");
				buffer.append(record.getLastSeen() + ",");
				buffer.append(record.getDuration() + ",");
				buffer.append(record.getStatus());
				buffer.append("\n");
			}
		});
		return buffer.toString();
	}
	
	public String getUnknownString() {
		StringBuffer buffer = new StringBuffer();
		records.forEach(record -> {
			if (record.getStudent().getRollNo()=="Unknown") {
				buffer.append(record.getStudent().getRollNo() + ",");
				buffer.append(record.getStudent().getName() + ",");
				buffer.append(record.getGmeetNameUsed() + ",");
				buffer.append(record.getArrivalTime() + ",");
				buffer.append(record.getLastSeen() + ",");
				buffer.append(record.getDuration() + ",");
				buffer.append(record.getStatus());
				buffer.append("\n");
			}
		});
		return buffer.toString();
	}
	public List<Record> getRecords() {
		return records;
	}
}
