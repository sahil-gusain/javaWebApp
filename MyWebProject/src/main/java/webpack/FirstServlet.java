package webpack;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

import com.bean.Customer;

@WebServlet("/FirstServlet")
public class FirstServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
       
    public FirstServlet() {
        super();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.sendRedirect("addCustomer.html");
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter pw = response.getWriter();
        pw.println("<h2>hello world</h2>");
        response.getWriter().append("Served at: ").append(request.getContextPath());
        
        
        
       
        
        Customer newcust = new Customer();
        
        newcust.setFirstname(request.getParameter("firstname"));
        newcust.setLastname(request.getParameter("lastname"));
        newcust.setDob(request.getParameter("dob"));
        newcust.setCountry(request.getParameter("country"));
        newcust.setCity(request.getParameter("city"));
        newcust.setGender(request.getParameter("gender"));
        
        
        String firstname = newcust.getFirstname();
        String lastname = newcust.getLastname();
        String dob = newcust.getDob();
        String city = newcust.getCity();
        String country = newcust.getCountry();
        String gender = newcust.getGender();
        
        System.out.println(firstname + " "+ lastname+ " "+ dob + " "+city+" "+country+" "+" "+gender);
        
        pw.close();
    }
}
