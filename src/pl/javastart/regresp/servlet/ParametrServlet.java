package pl.javastart.regresp.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/ParametrServlet")
public class ParametrServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
  
    public ParametrServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Map<String, String[]> parametrMap = request.getParameterMap();
		
		response.setContentType("text/html");
		response.setCharacterEncoding("UTF-8");
		
		PrintWriter writer = response.getWriter();
		
		writer.println("<html>");
		writer.println("<div>");
		writer.print("<h1>Taki tam sobie nagłówek</h1>");
		writer.println("</div>");	
		
			for (String key: parametrMap.keySet())
			{
				writer.println("<div>");
					writer.println(key);
				writer.println("</div>");	
			
				for (String value:parametrMap.get(key))
				{
					writer.println("<div>");
						writer.print("&nbsp&nbsp-&nbsp"+value);
					writer.println("</div>");
				}
			}
		writer.println("</html>");
		
		for (String key: parametrMap.keySet()) {
			System.out.println(key);
			for (String value: parametrMap.get(key))
				System.out.println(" - " + value);
		}
			
	}

}
