package servlet.drugstore;

import com.fasterxml.jackson.databind.ObjectMapper;
import service.drugstoreservice.BackMedicalService;
import service.drugstoreservice.SendMedicalService;
import vo.SendMedical;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.List;

@WebServlet(name = "BackMedicalServlet",urlPatterns = "/PharmacyManagement/back/*")
public class BackMedicalServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");
        String str=request.getRequestURI().substring(29);
        if (str.equals("fir")){
            System.out.println("退药1");
            String binglinum=request.getParameter("binglihao");
            String birthday=request.getParameter("date");
            System.out.println(birthday);
            BackMedicalService backMedicalService =null;
            if(binglinum!=""){
                backMedicalService=new BackMedicalService();
                try {
                    List<SendMedical> List=backMedicalService.selectSendMedicalService2(binglinum);
                    System.out.println(List);
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
            System.out.println("退药2");
            String id=request.getParameter("ids");
            String[] ida=id.split(",");
            System.out.println(ida.length);
            BackMedicalService backMedicalService=null;
            if (ida.length!=0){
                backMedicalService=new BackMedicalService();
                for(int i = 0; i<ida.length; i++){
                    try {
                        backMedicalService.modifyState(Integer.parseInt(ida[i]));

                    } catch (SQLException e) {
                        e.printStackTrace();
                    }
                }
id=null;
                ida=null;
                PrintWriter out=response.getWriter();
                out.println(true);
                System.out.println("发药回调");
            }else {
                PrintWriter out=response.getWriter();
                out.println(false);
            }

        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
