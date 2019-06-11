package servlet.information;

import service.informationservice.DiagnosisService;
import service.informationservice.IDiagnosisService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

@WebServlet(name = "DiagnosisServlet" ,urlPatterns = "/SystemInformation/test/*")
public class DiagnosisServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("~~~~~~~~~~~~~~");
        String uri=request.getRequestURI();
        System.out.println(uri);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
