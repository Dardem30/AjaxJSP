import by.DAO.DAOImple;
import by.model.EmployeeEntity;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.metadata.ClassMetadata;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by УВД on 10.05.2017.
 */
public class Main {
    public static void main(String[] args) {
        DAOImple daoImple=new DAOImple();
        System.out.println(daoImple.getAll());
    }
}