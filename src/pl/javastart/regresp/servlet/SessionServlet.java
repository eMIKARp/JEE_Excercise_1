package pl.javastart.regresp.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import pl.javastart.regresp.beans.*;

@WebServlet("/SessionServlet")

public class SessionServlet extends HttpServlet 
{
	private static final long serialVersionUID = 1L;
       
    public SessionServlet() 
    {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		HttpSession session = request.getSession(true);
		session.setMaxInactiveInterval(10);
		User user = (User) session.getAttribute("user");
		if (user == null|| (user.getFirstName() == null || user.getLastName() == null))
		{
			user = createUser(request);
			session.setAttribute("user", user);
		}
		
		sendResponse(response, user);
	}
	
	
			
	private User createUser(HttpServletRequest request)
	{
		User user = new User();
		String firstName = request.getParameter("firstname");
		String lastName = request.getParameter("lastname");
		user.setFirstName(firstName);
		user.setLastName(lastName);
		
		return user;
	}
	
	private void sendResponse(HttpServletResponse response, User user) throws IOException
	{
		PrintWriter writer = response.getWriter();
		writer.println("<html>");
			writer.println("<body>");
				writer.println("<h1>Test sesji</h1>");
				if (user.getFirstName()!= null && user.getLastName()!= null)
					writer.println("<div>Witaj " + user.getFirstName() +" "+user.getLastName()+" </div>");
				else 
					writer.println("<div>Witaj nieznajomy!</div>");
			writer.println("</body>");
		writer.println("</html>");
	}

}
