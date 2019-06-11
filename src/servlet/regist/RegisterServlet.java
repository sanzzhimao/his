package servlet.regist;

import com.fasterxml.jackson.databind.ObjectMapper;
import dao.registdao.RegistDao;
import org.hamcrest.Condition;
import service.registservice.RegistService;
import vo.Register;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@WebServlet("/RegisteredFee/regist/*")
public class RegisterServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //输出流
        PrintWriter pw =response.getWriter();
        String uri=request.getRequestURI();
        System.out.println(uri);
        //注册服务类；
        RegistService service =new RegistService();
        String check1=uri.substring(uri.indexOf("regist"));
        System.out.println(check1);
        String check2=check1.substring(check1.indexOf("/")+1);
        System.out.println(check2);
        ObjectMapper mapper=new ObjectMapper();
        DateFormat df =new SimpleDateFormat("yyy-MM-dd");
        mapper.setDateFormat(df);
        if (check2.equals("fir")){
            String regiseinfo=request.getParameter("name");
            String maxIn=mapper.writeValueAsString(service.MaxInvoceAndCaseNumber(regiseinfo));
            pw.println(maxIn);
        }
        if (check2.equals("sed")){
            String casenum=request.getParameter("case");
            System.out.println(casenum);
            Register regist=service.findRegisterByCaseNumber(casenum);
            System.out.println(regist);
            String string=mapper.writeValueAsString(regist);
            System.out.println(string);
            pw.println(string);
        }if (check2.equals("thr")){
            String casenum=request.getParameter("casenum");
            String visitdatestr=request.getParameter("visitdate");
            System.out.println(visitdatestr);
            List list=service.findDocCrew(java.sql.Date.valueOf(visitdatestr));
            System.out.println(list);
            String st=mapper.writeValueAsString(list);
            pw.println(st);
        }
        //

        
        

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
