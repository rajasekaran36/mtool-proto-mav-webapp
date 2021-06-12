package mtool;

import java.io.File;
import java.io.IOException;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

@WebServlet(value = "/upload")
@MultipartConfig(
fileSizeThreshold = 1024 * 1024 * 1, // 1 MB
maxFileSize = 1024 * 1024 * 10,      // 10 MB
maxRequestSize = 1024 * 1024 * 100   // 100 MB
)
public class Upload extends HttpServlet{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String uploadPath = getServletContext().getRealPath("") + File.separator + "uploads";
		File f = new File(uploadPath);
	    if(!f.exists())
	    	f.mkdir();
	    for(Part p:req.getParts()) {
	    	p.write(uploadPath+File.separator+p.getName()+".csv");
	    }
	    Part meetPart = req.getPart("meet");
	    Part mapPart = req.getPart("map");
	    
	    mapPart.write(uploadPath+File.separator+mapPart.getName()+".csv");
	    meetPart.write(uploadPath+File.separator+meetPart.getName()+".csv");
	    StringBuffer buffer = new StringBuffer();
	    Report report = process(uploadPath);
	    buffer.append("\n\nPRESENT\n"+report.getPresentString());
	    buffer.append("\n\nABSENT\n"+report.getAbsentString());
	    buffer.append("\n\nUNKNOWN\n"+report.getUnknownString());
	    
	    resp.getWriter().print(buffer.toString());
	}
	
	public Report process(String uploadPath) {
		StudentMap map = StudentMap.getMapByFilePath(uploadPath+File.separator+"map.csv");
		Meeting meeting = Meeting.getReportByFile(uploadPath+File.separator+"meet.csv");
		Report report = new Report(map, meeting);
		return report;
	}
}
