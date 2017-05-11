package by.DAO;

import by.model.EmployeeEntity;
import by.util.HibernateUtil;
import org.hibernate.Query;
import org.hibernate.Session;

import java.util.List;

/**
 * Created by УВД on 10.05.2017.
 */
public class DAOImple {
    public EmployeeEntity getEmployeeById(long id){
        Session session= HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        Query query=session.createQuery("from EmployeeEntity where employeeId=:id");
        query.setLong("id",id);
        EmployeeEntity employeeEntity= (EmployeeEntity) query.uniqueResult();
        session.getTransaction().commit();
        session.close();
        return employeeEntity;
    }
    public List<EmployeeEntity> getAll(){
        Session session=HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        List<EmployeeEntity> list=session.createQuery("from EmployeeEntity").list();
        session.getTransaction().commit();
        session.close();
        return list;
    }
}
