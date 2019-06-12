package servlet.regist;

import com.fasterxml.jackson.databind.ObjectMapper;
import dao.informationdao.INoDrugDao;
import dao.registdao.RegistDao;
import org.hamcrest.Condition;
import service.registservice.RegistService;
import vo.Invoice;
import vo.Register;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
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
        }if (check2.equals("foth")){
           String name=request.getParameter("name");
            System.out.println(name);
            String visitdate=request.getParameter("visitdate");
            System.out.println(visitdate);
            int ss=service.findUsedQuto(name, Date.valueOf(visitdate));
            System.out.println(ss);
            pw.println(ss);
        }if (check2.equals("fith")){

            String casenum=request.getParameter("casenum");

            String realname=request.getParameter("realname");

            String gender=request.getParameter("gender");

            String idNumber=request.getParameter("idNumber");

            String birthday=request.getParameter("birthday");

            String age=request.getParameter("age");

            String homeAddress=request.getParameter("homeAddress");

            String visidate=request.getParameter("visidate");

            String noon=request.getParameter("noon");

            String deptID=request.getParameter("deptID");

            String registeLeID=request.getParameter("registLeID");
            System.out.println(registeLeID);
            String settleID=request.getParameter("settleID");
            System.out.println(settleID);
            String isBook=request.getParameter("isBook");

            String deptName=request.getParameter("deptName");
            String invoicenum=request.getParameter("invoceNum");

            String money=request.getParameter("money");

            String feetype=request.getParameter("feeType");

            String quto=request.getParameter("quto");
            Register register=new Register();
            Invoice iv=new Invoice();
            register.setCaseNumber(casenum);
            register.setRealName(realname);
            register.setGender(Integer.parseInt(gender));
            register.setIdNumber(idNumber);
            register.setUserID(1);

            register.setRegistTime(new java.util.Date());

            register.setBirthDate(Date.valueOf(birthday));

            register.setAge(Integer.parseInt(age));
            register.setAgeTpye("岁");
            register.setHomeAddress(homeAddress);

            register.setVisitDate(Date.valueOf(visidate));

            register.setNoon(noon);

            register.setDeptID(Integer.parseInt(deptID));

            register.setRegistLeID(Integer.parseInt(registeLeID));

            register.setSettLeID(Integer.parseInt(settleID));
            register.setIsBook(isBook);
            register.setDeptName(deptName);
            iv.setInvoiceNum(invoicenum);
            iv.setMoney(Double.parseDouble(money));
            System.out.println(feetype);
            iv.setFeeType(Integer.parseInt(feetype));
            iv.setState(1);
            iv.setCreationTime(new java.util.Date());
            iv.setUserID(1);

            System.out.println(register);
            System.out.println(iv);
            System.out.println(service.registered(register, iv, Integer.parseInt(quto)));

        }
        //

        
        

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
