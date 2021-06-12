package subtool;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(value = "/subtool")
public class SubTool extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.getWriter().print("yahhahkha");
		List<String> lines = Files.readAllLines(Path.of("src/main/resources/tt.txt"));
		lines.forEach(line->{
			try {
				resp.getWriter().append(line);
			} catch (IOException e) {
				e.printStackTrace();
			}
		});
	}
}
