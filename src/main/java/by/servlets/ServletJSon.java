package by.servlets;

import by.DAO.DAOImple;
import by.model.EmployeeEntity;
import by.util.HibernateUtil;
import com.google.gson.Gson;
import org.hibernate.Query;
import org.hibernate.Session;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by УВД on 09.05.2017.
 */
public class ServletJSon extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      String employee=request.getParameter("po");
      request.setAttribute("employee",employee);
      String json=new Gson().toJson(employee);
        RequestDispatcher requestDispatcher=request.getRequestDispatcher("out.jsp");
        response.getWriter().write(json);
        requestDispatcher.include(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String department=request.getParameter("department");
        DAOImple daoImple=new DAOImple();
        Map<String,String> marketting=new LinkedHashMap<>();
        List<EmployeeEntity> list=daoImple.getAll();
        Map<String,String> sale=new LinkedHashMap<>();

        for(int i=0,g=1;i<list.size();i++,g++){
            if(i%2==0){
                marketting.put(String.valueOf(g),list.get(i).getFirstname()+" "+list.get(i).getLastname());
            }else {
                sale.put(String.valueOf(g),list.get(i).getFirstname()+" "+list.get(i).getLastname());
            }
        }
        String json=null;
        if(department.equals("1")){
            json=new Gson().toJson(marketting);
        }else {
            json=new Gson().toJson(sale);
        }

        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");
        response.getWriter().write(json);
    }
}
