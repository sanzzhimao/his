package servlet.doctor;

import com.fasterxml.jackson.databind.ObjectMapper;
import service.doctorservice.IMedicalService;
import service.doctorservice.MedicalService;
import service.informationservice.DoctorCrewService;
import service.informationservice.IDoctorCrewService;
import vo.MedicalRecord;

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
        String uri=request.getRequestURI();
        System.out.println(uri);
        String kindM=uri.substring(uri.indexOf("doctor"));
        System.out.println(kindM);
        String kind=kindM.substring(kindM.indexOf("/")+1);
        System.out.println(kind);
        IMedicalService ims=new MedicalService();
        if(kind.equals("all")){
            try {
                List list=ims.selectMedical();
                ObjectMapper mapper=new ObjectMapper();
                String json=mapper.writeValueAsString(list);
                PrintWriter pw=response.getWriter();
                pw.println(json);
                pw.flush();
                pw.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        if(kind.equals("byid")) {
            try {
                String msg=request.getParameter("id");
                System.out.println(msg);
                int id = Integer.parseInt(msg);
                MedicalRecord mr=ims.selectMedicalByID(id);
                System.out.println(mr);
                ObjectMapper mapper=new ObjectMapper();
                String json=mapper.writeValueAsString(mr);
                PrintWriter pw=response.getWriter();
                pw.println(json);
                pw.flush();
                pw.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        if(kind.equals("submit1")){
            try {
                System.out.println("提交1");
                MedicalRecord mr=new MedicalRecord();
                mr.setReadme(request.getParameter("readme"));
                mr.setPresent(request.getParameter("present"));
                mr.setPresentTreat(request.getParameter("presenttreat"));
                mr.setHistory(request.getParameter("history"));
                mr.setAllergy(request.getParameter("allergy"));
                mr.setProposal(request.getParameter("proposal"));
                mr.setPhysique(request.getParameter("physique"));
                mr.setCareful(request.getParameter("careful"));
                mr.setRegisterID(Integer.parseInt(request.getParameter("id")));
                System.out.println(mr);
                ims.updateMedicalHome(mr);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        if(kind.equals("submit2")){
            try {
                System.out.println("提交2");
                MedicalRecord mr=new MedicalRecord();
                mr.setCheckResult(request.getParameter("checkresult"));
                mr.setDiagnosis(request.getParameter("diagnosis"));
                mr.setHandling(request.getParameter("handling"));
                mr.setRegisterID(Integer.parseInt(request.getParameter("id")));
                System.out.println(mr);
                ims.updateMedical(mr);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        //诊毕
        if(kind.equals("end")){
            System.out.println("诊毕");
            int id=Integer.parseInt(request.getParameter("id"));
            try {
                ims.updateCaseState(id);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
