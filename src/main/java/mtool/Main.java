package mtool;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.charset.Charset;
import java.util.Scanner;

public class Main {
	/*
	public static void main(String[] args) {
		StudentMap map = StudentMap.getMapByFilePath("src/map.csv");
		Meeting meeting = Meeting.getReportByFile("src/IT20-21-S2-ITE (2021-06-12).csv");
		// Report report = new Report(map,meeting);
		// report.printReport();
		String key = "1yUGL_WmN2prQKrHTDDteqdkKgBrNqKHznuKbumLU8FU";
		StudentMap map2 = StudentMap.getMapByString(getMapString(key));
		// System.out.println(map2);
		Report report = new Report(map2, meeting);
		report.printReport();
	}

	public static String getMapString(String gsheetKey) {
		StringBuffer buffer = new StringBuffer();
		String url = "https://docs.google.com/spreadsheets/d/" + gsheetKey + "/gviz/tq?tqx=out:csv";
		try {
			URL website = new URL(url);
			try (InputStream in = website.openStream()) {
				Scanner scan = new Scanner(in, "UTF-8");
				while (scan.hasNextLine()) {
					buffer.append(scan.nextLine().replaceAll("\"", "") + "\n");
				}
			} catch (IOException e) {
				// TODO: handle exception
				e.printStackTrace();
			}
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}
		return buffer.toString();
	}
	*/
}
