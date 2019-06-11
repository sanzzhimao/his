package servlet.doctor;

import com.fasterxml.jackson.databind.ObjectMapper;
import service.doctorservice.IMedicalService;
import service.doctorservice.MedicalService;
import service.informationservice.DoctorCrewService;
import service.informationservice.IDoctorCrewService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.List;

@WebServlet(name = "DoctorHomeServlet",urlPatterns = "/OutpatientDoctor/doctor/*")
public class DoctorHomeServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("~~~~~~~~~");
        String uri=request.getRequestURI();
        System.out.println(uri);
        String kindM=uri.substring(uri.indexOf("doctor"));
        System.out.println(kindM);
        String kind=kindM.substring(kindM.indexOf("/")+1);
        System.out.println(kind);
        if(kind.equals("find1")){
            IMedicalService ims=new MedicalService();
            try {
                List list=ims.selectMedical();
                ObjectMapper mapper=new ObjectMapper();
                String json=mapper.writeValueAsString(list);
                PrintWriter pw=response.getWriter();
                System.out.println(json);
                pw.println(json);
                pw.flush();
                pw.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
