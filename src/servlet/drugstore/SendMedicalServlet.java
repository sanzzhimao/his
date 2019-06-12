package servlet.drugstore;

import com.fasterxml.jackson.databind.ObjectMapper;
import service.drugstoreservice.SendMedicalService;
import vo.SendMedical;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@WebServlet(name = "SendMedicalServlet",urlPatterns = "/PharmacyManagement/drug/*")
public class SendMedicalServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      // response.setContentType("application/json;charset=utf-8");
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");
        String str=request.getRequestURI().substring(29);
        if (str.equals("fir")){
            System.out.println("发药1");
            String binglinum=request.getParameter("binglihao");
            String birthday=request.getParameter("date");
            SendMedicalService sendMedicalService=null;
            if(binglinum!=""){
                sendMedicalService=new SendMedicalService();
                try {
                    List<SendMedical> List=sendMedicalService.selectSendMedicalService2(binglinum);
                    ObjectMapper mapper=new ObjectMapper();
                    String json=mapper.writeValueAsString(List);
                    PrintWriter out=response.getWriter();
                    out.println(json);
                } catch (SQLException e) {
                    e.printStackTrace();
                } catch (ParseException e) {
                    e.printStackTrace();
                }finally {

                }
            }
        }
        if (str.equals("two")){
            System.out.println("发药2");
            String id=request.getParameter("ids");
            String[] ida=id.split(",");
            System.out.println(ida);
            System.out.println(ida.length);
            SendMedicalService sendMedicalService=null;
            if (ida.length!=0){
                sendMedicalService=new SendMedicalService();
                for(int i = 0; i<ida.length; i++){
                    try {
                        sendMedicalService.modifyState(Integer.parseInt(ida[i]));
                    } catch (SQLException e) {
                        e.printStackTrace();
                    }
                }
                id=null;
                ida=null;
                PrintWriter out=response.getWriter();
                out.println(1);
                System.out.println("发药回调");
            }else {
                PrintWriter out=response.getWriter();
                out.println(0);
            }

        }



    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
